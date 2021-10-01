package by.java_online.modul6.controller;

import by.java_online.modul6.controller.implCommand.Authorization;
import by.java_online.modul6.controller.implCommand.Registration;

import java.util.HashMap;
import java.util.Map;

public final class CommandProvider {
    private Map<String, Command> commands;
    private static CommandProvider instance = null;

    private CommandProvider() {
        commands = new HashMap<String, Command>();
        commands.put("Authorization", new Authorization());
        commands.put("Registration", new Registration());
    }

    public static CommandProvider getInstance() {
        if (instance == null) {
            instance = new CommandProvider();
        }
        return instance;
    }

    public Command getCommands(String commandName) {
        Command command;
        command = commands.get(commandName);

        return command;
    }

    public Map<String, Command> getCommands() {
        return commands;
    }
}
