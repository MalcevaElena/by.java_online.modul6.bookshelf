package by.java_online.modul6.controller.implCommand;

import by.java_online.modul6.controller.Command;
import by.java_online.modul6.cotService.ServiceException;
import by.java_online.modul6.cotService.ClientService;
import by.java_online.modul6.cotService.ServiceProvider;
import by.java_online.modul6.view.UserActionViewer;


public class Authorization implements Command {

    UserActionViewer userActionViewer = new UserActionViewer();

    @Override
    public String execute(String request) {
        ServiceProvider provider = ServiceProvider.getInstance();
        ClientService clientService = provider.getClientService();

        String[] params;
        boolean answer = false;
        String result;

        params = request.split(" ");

        String login = params[1];
        String password = params[2];

        try {
            answer = clientService.verificationParam(login, password);
        }catch (ServiceException e){
            e.printStackTrace();
        }

        result = userActionViewer.authorizationAnswer(answer, login);

        return result;
    }
}