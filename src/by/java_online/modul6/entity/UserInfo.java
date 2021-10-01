package by.java_online.modul6.entity;

public class UserInfo {
    private Role userRole;
    private String name;
    private String login;
    private String password;
    private String e_mail;

    public UserInfo() {
    }

    public UserInfo(Role userRole,String name,String e_mail, String login, String password) {
        this.userRole = userRole;
        this.name = name;
        this.login = login;
        this.password = password;
        this.e_mail = e_mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public Role getUserRole() {
        return userRole;
    }

    public void setUserRole(Role userRole) {
        this.userRole = userRole;
    }
}
