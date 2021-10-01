package by.java_online.modul6.dao.impl;


import by.java_online.modul6.dao.ClientDAO;
import by.java_online.modul6.dao.DAOException;
import by.java_online.modul6.entity.UserInfo;

import java.io.*;
import java.util.List;

public class FileClientDAOImpl implements ClientDAO {
    private static final String CLIENT_SOURCE = "C:\\Документы и фото\\Обучение Java\\IdeaProjects\\Java15\\modul6\\modul6\\source\\AuthenticationData.txt";

    @Override
    public int verificationParam(String... params) throws DAOException {

        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(CLIENT_SOURCE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (String tmp : params) {
                    if (line.contains(tmp)) {
                        count++;
                    }
                }
            }

        } catch (FileNotFoundException e) {
            throw new DAOException(e);
        } catch (IOException e) {
            throw new DAOException(e);
        }

        return count;
    }

    @Override
    public boolean registration(String request) throws DAOException {
        /*
        открыть файл
        проверить есть ли в файле такой логин
        записать в файл
        закрыть файл
                */

        boolean result = false;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CLIENT_SOURCE, true))) {
            writer.write(request);
            writer.append("\n");

        } catch (IOException e) {
            throw new DAOException(e);
        }

        return true;
    }

}
