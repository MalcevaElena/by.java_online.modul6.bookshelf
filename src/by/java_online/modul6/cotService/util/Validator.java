package by.java_online.modul6.cotService.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private static Validator instance = null;

    private Validator(){}

    public static Validator getInstance() {
        if (instance == null){
            instance = new Validator();
        }
        return instance;
    }

    /*
     * Login:
     * Length from 5 to 15 characters.
     * Must start with a Latin character.
     * Сan contain numbers and a space character.
     */
    public boolean isLogin(String request) {

        Pattern pattern = Pattern.compile("^[a-zA-z](\\w{4,14})$");
        Matcher matcher = pattern.matcher(request);

        return matcher.matches();
    }

    /*
     * Password:
     * Length from 8 to 20 characters.
     * a digit must occur at least once
     * a lower case letter must occur at least once
     * an upper case letter must occur at least once
     * a special character [@#$%^&+=] must occur at least once
     * no whitespace allowed in the entire string
     */

    public boolean isPassword(String request) {

        Pattern pattern = Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}");
        Matcher matcher = pattern.matcher(request);

        return matcher.matches();
    }

    /*
     * Name:
     * Length from 3 to 15 characters.
     * Must start with a Latin character.
     * Сan only contain Latin characters.
     */
    public boolean isName(String request) {

        Pattern pattern = Pattern.compile("(^[a-zA-z])([a-zA-z]{2,14})$");
        Matcher matcher = pattern.matcher(request);

        return matcher.matches();
    }

    /*
     * E-mail:
     * Must start with any character other than a space and "@".
     * The "@" symbol can be followed by any character except a space and "@".
     * The "." symbol can only be followed by lowercase Latin characters.
     */
    public boolean isEmail(String request) {

        Pattern pattern = Pattern.compile("([.[^@\\s]]+)@([.[^@\\s]]+)\\.([a-z]+)");
        Matcher matcher = pattern.matcher(request);

        return matcher.matches();
    }

    public boolean isRole(String request) {

        if (request.equalsIgnoreCase("Администратор")) return true;
        if (request.equalsIgnoreCase("Пользователь")) return true;

        return false;
    }



}
