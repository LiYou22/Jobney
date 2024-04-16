package model.user;

import model.company.CompanyCatalog;

public class AdminUser extends User{
	
	private static AdminUser administrator = new AdminUser("example@csye.com", "123456");
    private RegularUserDirectory userDirectory;
    private CompanyCatalog companyCatalog;

    public AdminUser(String email, String password) {
        super(email, password);
        this.userDirectory = new RegularUserDirectory();
        this.companyCatalog = new CompanyCatalog();
    }

    public boolean isAdminCredentials(String email, String password) {
        return this.getEmail().equals(email) && this.getPassword().equals(password);
    }
    
    public static AdminUser getAdministrator() {
        return administrator;
    }
    
    public RegularUserDirectory getUserDirectory() {
        return userDirectory;
    }
    
    public CompanyCatalog getCompanyCatalog() {
    	return companyCatalog;
    }
}
