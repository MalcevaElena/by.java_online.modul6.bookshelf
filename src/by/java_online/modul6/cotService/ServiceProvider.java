package by.java_online.modul6.cotService;

import by.java_online.modul6.cotService.impl.ClientServiceImpl;

public class ServiceProvider {

    private ClientService clientService;
    private static ServiceProvider instance;

    private ServiceProvider(){
        clientService = new ClientServiceImpl();
    }

    public static ServiceProvider getInstance(){
        if (instance==null){
            instance=new ServiceProvider();
        }
        return instance;
    }

    public ClientService getClientService() {
        return clientService;
    }
}
