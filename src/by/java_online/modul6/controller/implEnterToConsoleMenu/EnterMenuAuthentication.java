package by.java_online.modul6.controller.implEnterToConsoleMenu;

import by.java_online.modul6.controller.EnterToConsoleMenu;
import by.java_online.modul6.cotService.util.Validator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EnterMenuAuthentication implements EnterToConsoleMenu {

    Validator validator = Validator.getInstance();

    @Override
    public int enterNumberMenu() {
        int number = 0;

        @SuppressWarnings("resource")
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        do {
            try  {
                number = Integer.parseInt(reader.readLine());

                if (number < 1 || number > 2) {
                    System.out.println("Вы ввели не верную команду. Повторите ввод.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        while (number < 1 || number > 2);

        return number;
    }
}
