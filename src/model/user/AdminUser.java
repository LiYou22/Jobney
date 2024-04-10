package model.user;

import model.company.*;

public class AdminUser extends User{
    private RegularUserDirectory directory;

    public AdminUser(String email, String password) {
        super(email, password);
        this.directory = new RegularUserDirectory();
    }

    public boolean isAdminCredentials(String email, String password) {
        return this.getEmail().equals(email) && this.getPassword().equals(password);
    }

    public RegularUserDirectory getDirectory() {
        return directory;
    }
}
