package by.java_online.modul6.cotService;

public interface ClientService {

    boolean registration(String request) throws ServiceException;

    boolean verificationParam(String ... params) throws ServiceException;
}
