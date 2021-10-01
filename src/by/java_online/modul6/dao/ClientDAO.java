package by.java_online.modul6.dao;


public interface ClientDAO {

    int verificationParam(String... param) throws DAOException;

    boolean registration(String request) throws DAOException;
}
