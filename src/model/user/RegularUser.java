package model.user;

import model.application.ApplicationList;
import model.company.CompanyList;
import model.question.QuestionDirectory;

public class RegularUser extends User {
	
	// user id format: user-1, user-2, etc.
	final String prefix = "user-";
	private static int nextId = 1;
	private String userId;
	
	private Profile userProfile;
 	private CompanyList companyList;
    private ApplicationList applicationList;
    private QuestionDirectory questionList;
    
    
    public RegularUser(String userId, String email, String password, Profile userProfile, CompanyList companyList, ApplicationList applicationList) {
    	super(email, password);
    	userId = prefix + nextId;
        this.userProfile = userProfile;
        this.companyList = companyList;
        this.applicationList = applicationList;
        // The question list could be initialized here or be set via a setter method.
        this.questionList = new QuestionDirectory(); 
        nextId++;
    }

    @Override
    public boolean isValidUser(String email, String password) {
        // Implement validation logic specific to RegularUser, if different from User
        return this.getEmail().equals(email) && this.getPassword().equals(password);
    }
    
    public String getUserId() {
    	return this.userId;
    }

    private Object getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	private Object getEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	public Profile getUserProfile() {
        return userProfile;
    }

    public CompanyList getCompanyList() {
        return companyList;
    }

    public ApplicationList getApplicationList() {
        return applicationList;
    }

//    public QuestDirectory getQuestionList() {
//        return questionList;
//    }

}
