package model.user;

import model.company.*;

public class AdminUser extends User{
	private RegularUserDirectory users;
    private CompanyCatalog companies;

    public AdminUser(String userId, String email, String password, RegularUserDirectory users, CompanyCatalog companies) {
        super(userId, email, password);
        this.users = users;
        this.companies = companies;
    }

    @Override
    public boolean isValidUser(String email, String password) {
        return true;
    }

    public RegularUserDirectory getUsers() {
        return users;
    }

    public CompanyCatalog getCompanies() {
        return companies;
    }

}
