package CaseStudyModule2.Controller;

import CaseStudyModule2.Model.Book;
import CaseStudyModule2.Model.Order;
import CaseStudyModule2.Repository.BookRepository;
import CaseStudyModule2.Service.BookService;
import CaseStudyModule2.View.MenuView;

import java.io.IOException;
import java.util.Map;

public class Main{
    public static void main(String[] args) {
        BookRepository.getInstance();
        BookService bookService = new BookService();
        MenuView menuView = new MenuView();
        int choice;
        Book book;
        boolean isConfirm;
        boolean result;
        String inputIdBook;
        boolean exit = false;
        while(!exit){
            choice = menuView.viewEmployment();
            switch (choice) {
                case 1: {
                    try {
                        book = menuView.viewAddBook();
                        result = bookService.Check(book);
                        menuView.viewMessage(result);

                        break;
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                case 2:{
                    inputIdBook = menuView.inputIdBook();
                    book = bookService.find(inputIdBook);
                    if (book == null){
                        menuView.viewMessage(false);
                    } else {
                       isConfirm = menuView.confirm();
                        if(isConfirm) {
                            bookService.remove(book.getIdImportBook());
                            menuView.viewMessage(true);
                        }
                    }
                    break;
                }
                case 3: {
                    Map<String, Book> allBooks = BookService.getAllBook();
                    menuView.displayAllBooks(allBooks);
                    break;
                }
                case 4: {
                    inputIdBook = menuView.inputIdBook();
                    book = bookService.find(inputIdBook);
                    menuView.displayBookById(book);
                    break;
                }
                case 5: {
                    Order orderBook = menuView.viewOrder();
                    book = bookService.find(orderBook.getIdBookOrder());
                    if (BookService.checkOrder(book, orderBook.getQuantity())){
                        isConfirm = menuView.confirm();
                        if (isConfirm){
                            bookService.updateQuantity(book,orderBook.getQuantity());
                        }
                    }
                    break;
                }
                case 6: {
                    exit = true;
                    break;
                }
            }
        }
    }
}

