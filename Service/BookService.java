package CaseStudyModule2.Service;

import CaseStudyModule2.Model.Book;
import CaseStudyModule2.Repository.BookRepository;

import java.io.IOException;
import java.util.Map;

public class BookService implements IServiceBook {

    private static final BookRepository bookRepository = BookRepository.getInstance();

    public static Map<String, Book> getAllBook() {
        return bookRepository.getAllBook();
    }

    public static boolean checkOrder(Book book, int quantity) {
        return bookRepository.checkPurchaseBook(book,quantity);
    }
    @Override
    public Boolean Check(Book book) throws IOException {
        if (book == null ){
            return false;
        }
        bookRepository.addBook(book);
        return true;
    }

    @Override
    public Book find(String idBook) {
        return bookRepository.findBook(idBook);
    }
    @Override
    public void remove(String idBook) {
        bookRepository.removeBook(idBook);
    }

    @Override
    public void updateQuantity(Book book, int quantity) {
        bookRepository.updateQuantity(book,quantity);
    }


}
