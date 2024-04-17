package model.user;

import java.util.ArrayList;


public abstract class User {
	

    private String email;
    private String password;
    private Profile profile;
    private ArrayList<String> passwrodHistory;

    public User(String email, String password) {
    	this.passwrodHistory = new ArrayList<>();
        this.email = email;
        this.password = password;
        this.profile = new Profile(email);
    	passwrodHistory.add(password);
    }
    
    public Profile getProfile() {
    	return profile;
    }
    
    public void setProfile(Profile p) {
        this.profile = p;
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
    
    public void changePassword(String newPassword) {
    	if(isValidPassword(newPassword)) {
    		setPassword(newPassword);
        	passwrodHistory.add(newPassword);
    	} else {
    		
    	}
    }
    
    public ArrayList<String> getPasswordHistory(){
    	return this.passwrodHistory;
    }

    public boolean isValidUser(String email, String password) {
        return this.getEmail().equals(email) && this.getPassword().equals(password);
    }
    
    public boolean isValidPassword(String newPassword) {
    	if(passwrodHistory.contains(newPassword)) {
    		return false;
    	}
    	return true;
    }
    
  
    


    

}
