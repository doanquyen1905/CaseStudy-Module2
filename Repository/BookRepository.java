package CaseStudyModule2.Repository;

import CaseStudyModule2.Model.Book;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class BookRepository {
    private final Map<String, Book> books;
    private static final String SRC_DATABOOKREPOSITORY = "C:\\Users\\quyen\\IdeaProjects\\module_2\\src\\CaseStudyModule2\\dataBookRepository.csv";
    private static BookRepository instance;

    private BookRepository() {
        books = new HashMap<>();
        loadBooksFromCSV();
    }

    private void loadBooksFromCSV() {
        try (BufferedReader reader = new BufferedReader(new FileReader(SRC_DATABOOKREPOSITORY))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String idBook = parts[0];
                    String nameBook = parts[1];
                    String authorBook = parts[2];
                    double priceBook = Double.parseDouble(parts[3]);
                    int quantityBook = Integer.parseInt(parts[4]);
                    Book book = new Book(idBook, nameBook, authorBook, priceBook, quantityBook);
                    books.put(idBook, book);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized BookRepository getInstance() {
        if (instance == null) {
            instance = new BookRepository();
        }
        return instance;
    }

    public void addBook(Book book) {
        if (books.containsKey(book.getIdImportBook())) {
            Book existingBook = books.get(book.getIdImportBook());
            existingBook.setQuantity(existingBook.getQuantity() + book.getQuantity());
        } else {
            books.put(book.getIdImportBook(), book);
        }
        saveBooksToCSV();
    }
    private void saveBooksToCSV() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SRC_DATABOOKREPOSITORY))) {
            for (Book book : books.values()) {
                String line = String.format("%s,%s,%s,%.2f,%d",
                        book.getIdImportBook(), book.getNameImportBook(), book.getAuthorImportBook(), book.getPriceImportBook(), book.getQuantity());
                writer.write(line);
                writer.newLine();
            }
        }
        catch (FileNotFoundException e){
            System.out.println("khong tim thay file");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Book findBook(String idBook) {
        return books.get(idBook);
    }

    public void removeBook(String idBook) {
        Book removedBook = books.remove(idBook);
        if (removedBook != null) {
            saveBooksToCSV();
        }
    }
    public Map<String, Book> getAllBook() {
        return books;
    }

    public String toString(Book book) {
        return book.getIdImportBook()+ "\t" +
                book.getNameImportBook()+ "\t" +
                book.getAuthorImportBook() + "\t"+
                book.getPriceImportBook() + "\t"+
                book.getQuantity();
    }

    public boolean checkPurchaseBook(Book book, int quantity) {
        if (book != null) {
            if (book.getQuantity() >= quantity) {
                return true;
            } else {
                System.out.println("Không đủ số lượng sách trong kho.");
                return false;
            }
        } else {
            System.out.println("Không tìm thấy sách với ID được cung cấp.");
            return false;
        }
    }

    public void updateQuantity(Book book,int quantity) {
        book.setQuantity(book.getQuantity() - quantity);
        saveBooksToCSV();
    }
}
