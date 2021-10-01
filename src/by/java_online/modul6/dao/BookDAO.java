package by.java_online.modul6.dao;


import by.java_online.modul6.entity.Book;

import java.util.List;

public interface BookDAO {

    List<String> searchBook(String request) throws DAOException;
    boolean addBook(Book book);

}
