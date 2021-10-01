package by.java_online.modul6.dao.impl;


import by.java_online.modul6.dao.BookDAO;
import by.java_online.modul6.dao.DAOException;
import by.java_online.modul6.entity.Book;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileBookDAOImpl implements BookDAO {
    private static final String BOOKS_SOURCE = "Sourse/BookCatalog.txt";

    @Override
    public List<String> searchBook(String request) throws DAOException {

        List <String> allBooks;
        List <String> searchBook;

        Pattern pattern;
        Matcher matcher;

        searchBook = new ArrayList<String>();
        pattern = Pattern.compile(request);

       allBooks = readFileBook();

        for (String book:allBooks) {
            matcher=pattern.matcher(book);
            while (matcher.find()){
                searchBook.add(book);
            }
        }
        return searchBook;
    }

    @Override
    public boolean addBook(Book book) {

        /*
        открыть файл
        высчитать айди
        сформировать строчку из бук
        записать строчку в файл
        если все ок вернуть тру
         */
        return false;
    }

    public List <String> readFileBook() throws DAOException {
        List<String> listBook = new ArrayList<String>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(BOOKS_SOURCE))) {
            String line;
            do {
                line = bufferedReader.readLine();
                if (line != null) {
                    listBook.add(line);
                }
            }
            while (line != null);

        } catch (FileNotFoundException e) {
            throw new DAOException(e);
        } catch (IOException e) {
            throw new DAOException(e);
        }

        return listBook;
    }
}