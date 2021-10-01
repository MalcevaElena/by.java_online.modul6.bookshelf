package by.java_online.modul6.main;

import by.java_online.modul6.controller.Controller;
import by.java_online.modul6.controller.CommandController;
import by.java_online.modul6.controller.EnterToConsoleCommand;
import by.java_online.modul6.controller.EnterToConsoleMenu;
import by.java_online.modul6.controller.implEnterToConsoleCommand.EnterAuthorization;
import by.java_online.modul6.controller.implEnterToConsoleCommand.EnterRegistration;
import by.java_online.modul6.controller.implEnterToConsoleMenu.EnterMenuAuthentication;
import by.java_online.modul6.view.Menu;

public class MainMenu {

    private static EnterToConsoleCommand enterCommand;
    private static Controller controller = new CommandController();

    public static void start() {
        EnterToConsoleMenu enterMenu;

        String request;
        String response;
        int responseMenu;
        int result = 0;

        Menu.menuAuthorization();
        enterMenu = new EnterMenuAuthentication();
        responseMenu = enterMenu.enterNumberMenu();

        if (responseMenu == 1) {
            enterCommand = new EnterAuthorization();
        } else {
            enterCommand = new EnterRegistration();
        }
        do {
            result = authentication(enterCommand);

            if (result == 0) {
                //menu с книгами
                System.out.println("вход в программу");
            }
        }
        while (result != 0);

    }

    public static int authentication(EnterToConsoleCommand enterCommand) {
        String request;
        String response;
        int result;

        request = enterCommand.enterData().toString();

        response = controller.doAction(request);

        result = Integer.parseInt(response.split("\\s+")[0]);

        System.out.println(response.split("\\s", 2)[1]);
        System.out.println();

        return result;
    }
}
