package by.java_online.modul6.controller.implEnterToConsoleCommand;

import by.java_online.modul6.controller.EnterToConsoleCommand;
import by.java_online.modul6.cotService.util.Validator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EnterAuthorization implements EnterToConsoleCommand {
    Validator validator = Validator.getInstance();

    @Override
    public StringBuffer enterData() {
        StringBuffer response = new StringBuffer("Authorization ");
        String validationLine;

        @SuppressWarnings("resource")
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Для входа в программу введите");
        System.out.println("Логин: ");

        try {
            validationLine = reader.readLine();

            while (!validator.isLogin(validationLine)) {
                System.out.println("Логин должен начинаться с латинского символа. \n" +
                        "Может содержать цифры и пробельный символ. Длина от 5 до 15 символов.\n" +
                        "Повторите ввод.");
                validationLine = reader.readLine();
            }
            response.append("login=" + validationLine + " ");

            System.out.println("Пароль: ");
            validationLine = reader.readLine();

            while (!validator.isPassword(validationLine)) {
                System.out.println("Пароль должен содержать хотя бы одну цифру, " +
                        "один символ в нижнем и верхнем регистре,\nодин спец.символ [@#$%^&+=]," +
                        " и не содержать пробелов. Длина пароля от 8 до 20 символов.\nПовторите ввод.");
                validationLine = reader.readLine();
            }
            response.append("password=" + validationLine);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }
}
