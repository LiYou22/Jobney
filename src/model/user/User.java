package model.user;

public abstract class User {
	private String userId;
    private String email;
    private String password;

    public User(String userId, String email, String password) {
        this.userId = userId;
        this.email = email;
        this.password = password;
    }

    public abstract boolean isValidUser(String email, String password);

    public boolean isMatch(String userId) {
        return this.userId.equals(userId);
    }

    public void updatePassword(String newPassword) {
        this.password = newPassword;
    }

    public void updateEmail(String newEmail) {
        this.email = newEmail;
    }

}
