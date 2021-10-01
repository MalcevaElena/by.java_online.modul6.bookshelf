package by.java_online.modul6.controller.implCommand;

import by.java_online.modul6.controller.Command;
import by.java_online.modul6.cotService.ClientService;
import by.java_online.modul6.cotService.ServiceException;
import by.java_online.modul6.cotService.ServiceProvider;
import by.java_online.modul6.view.UserActionViewer;

public class Registration implements Command {

    UserActionViewer userActionViewer = new UserActionViewer();

    @Override
    public String execute(String request) {
        ServiceProvider provider = ServiceProvider.getInstance();
        ClientService clientService = provider.getClientService();

        boolean answer = false;
        try {
            answer = clientService.registration(request);
        } catch (ServiceException e) {
            // ошибка регистрации
            e.printStackTrace();
        }

        String result = userActionViewer.registrationAnswer(answer);

//передаем данные для записи в файл

        return result;
    }
}
