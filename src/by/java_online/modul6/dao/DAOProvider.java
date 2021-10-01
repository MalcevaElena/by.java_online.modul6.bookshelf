package by.java_online.modul6.dao;

import by.java_online.modul6.dao.impl.FileBookDAOImpl;
import by.java_online.modul6.dao.impl.FileClientDAOImpl;

public final class DAOProvider {

    private ClientDAO clientDAO;
    private BookDAO bookDAO;
    private static DAOProvider instance;

    private DAOProvider() {
        clientDAO = new FileClientDAOImpl();
        bookDAO = new FileBookDAOImpl();
    }

    public static DAOProvider getInstance() {
        if (instance == null) {
            instance = new DAOProvider();
        }
        return instance;
    }

    public ClientDAO getClientDAO() {
        return clientDAO;
    }

    public BookDAO getBookDAO() {
        return bookDAO;
    }
}
