package model.user;

import java.util.Date;

import model.application.ApplicationList;
import model.company.CompanyList;
import model.question.QuestionDirectory;
import model.question.QuestionList;

public abstract class User {
	
	final String prefix = "user-";
	private static int nextId = 1;
    private String userId;
	
	private Profile associatedProfile;
    private String email;
    private String password;
	private Date registerDate;
	
	private CompanyList myCompanyList;
	private ApplicationList myApplicationList;
	private QuestionDirectory myQuestionDirectory;


    public User(String email, String password) {
        this.email = email;
        this.password = password;
        this.registerDate = new Date(); 
        this.userId = prefix + nextId;
        nextId++;
        this.myApplicationList = new ApplicationList();
        this.myCompanyList = new CompanyList();
        this.myQuestionDirectory = new QuestionDirectory();
    }
    
    public CompanyList getCompanyList() {
    	return myCompanyList;
    }
    
    public ApplicationList getApplicationList() {
    	return myApplicationList;
    }
    
    public QuestionDirectory getQuestionDirectory() {
    	return myQuestionDirectory;
    }
    
	public String getUserId() {
		return this.userId;
	}
    
    public Profile getAssociatedProfile() {
    	return associatedProfile;
    }
    
    public void setAssociatedProfile(Profile profile) {
    	this.associatedProfile = profile;
    }

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Date getRegisterDate() {
        return registerDate;
    }

    public boolean isValidUser(String email, String password) {
        return this.getEmail().equals(email) && this.getPassword().equals(password);
    }
    
    @Override
    public String toString() {
        return "UserID: " + userId + 
            "\nPassword: " + password +
            "\nRegisterDate: " + registerDate;
    }

    

}
