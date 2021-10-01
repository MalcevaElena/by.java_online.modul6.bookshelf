package by.java_online.modul6.cotService;

import by.java_online.modul6.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> searchBook(String request);
    boolean addBook(Book book);

}
