package itis.Models;

public class AccountData {

    String username;
    String password;

    public AccountData(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public AccountData(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
