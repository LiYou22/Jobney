package model.user;

import model.company.*;

public class AdminUser extends User{
	
	private RegularUserDirectory users;
    private CompanyCatalog companies;

    public AdminUser(String email, String password, RegularUserDirectory users, CompanyCatalog companies) {
        super(email, password);
        this.users = users;
        this.companies = companies;
    }

    @Override
    public boolean isValidUser(String email, String password) {
    	return this.getEmail().equals(email) && this.getPassword().equals(password);
    }

    private String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	private String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	public RegularUserDirectory getUsers() {
        return users;
    }

    public CompanyCatalog getCompanies() {
        return companies;
    }

}
