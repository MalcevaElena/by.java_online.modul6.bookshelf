package by.java_online.modul6.cotService.impl;

import by.java_online.modul6.cotService.ServiceException;
import by.java_online.modul6.dao.ClientDAO;
import by.java_online.modul6.dao.DAOException;
import by.java_online.modul6.dao.DAOProvider;
import by.java_online.modul6.cotService.ClientService;


public class ClientServiceImpl implements ClientService {

    private DAOProvider provider = DAOProvider.getInstance();
    private ClientDAO clientDAO = provider.getClientDAO();

    @Override
    public boolean verificationParam(String... params) throws ServiceException {
        boolean result = false;
        int answer = 0;

        try {
            answer = clientDAO.verificationParam(params);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        if (answer == params.length) {
            result = true;
        }

        return result;
    }

    @Override
    public boolean registration(String request) throws ServiceException {
        String registrationInfo;
        boolean result;

        registrationInfo = request.split(" ", 2)[1];
        try {
            result = clientDAO.registration(registrationInfo);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return result;
    }
}
