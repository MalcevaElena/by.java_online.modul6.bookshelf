package by.java_online.modul6.controller;

public class CommandController implements Controller {

    CommandProvider commandProvider = CommandProvider.getInstance();

    @Override
    public String doAction(String request) {
        // получили логин
        String commandName;
        Command command;

        commandName = request.split("\\s+")[0];
        //выделили название команды
        command = commandProvider.getCommands(commandName);
        //запросили команду

        String response = " ";
        response = command.execute(request); // результат авторизации (добро пожаловать или не верный лог)
        // в команду передали введеную строку
        return response;
    }
}
