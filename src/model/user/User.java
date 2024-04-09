package model.user;

public abstract class User {
    private String email;
    private String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean isValidUser(String email, String password) {
        return this.getEmail().equals(email) && this.getPassword().equals(password);
    }

}
