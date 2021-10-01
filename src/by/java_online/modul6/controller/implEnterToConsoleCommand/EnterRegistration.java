package by.java_online.modul6.controller.implEnterToConsoleCommand;

import by.java_online.modul6.controller.EnterToConsoleCommand;
import by.java_online.modul6.cotService.ClientService;
import by.java_online.modul6.cotService.ServiceException;
import by.java_online.modul6.cotService.ServiceProvider;
import by.java_online.modul6.cotService.util.Validator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EnterRegistration implements EnterToConsoleCommand {
    Validator validator = Validator.getInstance();
    ServiceProvider provider = ServiceProvider.getInstance();
    ClientService clientService = provider.getClientService();

    @Override
    public StringBuffer enterData() {
        @SuppressWarnings("resource")
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer response = new StringBuffer("Registration ");
        String validationLine;

        boolean verificationParam = false;
        boolean validationParam;

        System.out.println("Для регистрации в программе введите: ");
        System.out.println("Имя: ");
        try {
            validationLine = reader.readLine();

            while (!validator.isName(validationLine)) {
                System.out.println("Имя должно содержать только Латинские символы.\n" +
                        "Длина от 3 до 15 символов.\nПовторите ввод.");
                validationLine = reader.readLine();
            }
            response.append("name=" + validationLine + " ");

            System.out.println("E-mail: ");
            validationLine = reader.readLine();

            while (!validator.isEmail(validationLine)) {
                System.out.println("Не верный e-mail. Повторите ввод.");
                validationLine = reader.readLine();
            }
            response.append("e-mail=" + validationLine + " ");

            System.out.println("Логин: ");
            validationLine = reader.readLine();
            do {
                validationParam = validator.isLogin(validationLine);
                if (validationParam) {

                    try {
                        verificationParam = clientService.verificationParam(validationLine);
                    } catch (ServiceException e) {
                        e.printStackTrace();
                    }
                    if (verificationParam) {
                        System.out.println("Такой Логин уже существует, введите другой Логин");
                        validationParam = false;
                        validationLine = reader.readLine();
                    }
                } else {
                    System.out.println("Логин должен начинаться с Латинского символа, \n" +
                            "может содержать цифры и пробельный символ. Длина от 5 до 15 символов.\n" +
                            "Повторите ввод.");
                    validationLine = reader.readLine();
                }
            }
            while (!validationParam);

            response.append("login=" + validationLine + " ");

            System.out.println("Пароль: ");
            validationLine = reader.readLine();

            while (!validator.isPassword(validationLine)) {
                System.out.println("Пароль должен содержать хотя бы одну цифру, \n" +
                        "один символ в нижнем и верхнем регистре,один спец.символ [@#$%^&+=]\n" +
                        " и не содержать пробелов. Длина пароля от 8 до 20 символов.\nПовторите ввод.");
                validationLine = reader.readLine();
            }
            response.append("password=" + validationLine + " ");

            System.out.println("Тип пользователя: Администратор или Пользователь:");
            validationLine = reader.readLine();

            while (!validator.isRole(validationLine)) {
                System.out.println("Не верный тип пользователя.\n" +
                        "Введите: Администратор или Пользователь.");
                validationLine = reader.readLine();
            }
            response.append("role=" + validationLine);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }
}
