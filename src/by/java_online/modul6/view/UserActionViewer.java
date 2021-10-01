package by.java_online.modul6.view;

public class UserActionViewer {
//интерфейс и синглтон
    public String authorizationAnswer(boolean result, String login){
        String response;
        if (result) {
            response = "0 Добрый день, "+ login;
        }
        else {
            response = "1 Неверный логин и пароль";
        }
        return response;
    }

    public String registrationAnswer(boolean result){
        String response;
        if (result) {
            response = "0 Регистрация прошла успешна";
        }
        else {
            response = "1 Error";
        }
        return response;
    }
}
