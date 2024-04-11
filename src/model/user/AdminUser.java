package model.user;


public class AdminUser extends User{
	
	private static AdminUser instance = new AdminUser("example@csye.com", "123456");
    private RegularUserDirectory directory;

    public AdminUser(String email, String password) {
        super(email, password);
        this.directory = new RegularUserDirectory();
    }

    public boolean isAdminCredentials(String email, String password) {
        return this.getEmail().equals(email) && this.getPassword().equals(password);
    }
    
    public static AdminUser getInstance() {
        return instance;
    }
    
    public RegularUserDirectory getDirectory() {
        return directory;
    }
}
