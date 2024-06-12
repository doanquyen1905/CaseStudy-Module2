package CaseStudyModule2.Service;

import CaseStudyModule2.Model.Book;

import java.io.IOException;

public interface IService <T>{
    Boolean Check (T t) throws IOException;
    T find(String idBook);
    void remove(String idBook);
    void updateQuantity(Book book, int quantity);
}
