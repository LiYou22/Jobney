package model.application.ApplicationList;

public class RegularUser extends User {
	private Profile userProfile;
 	private CompanyList companyList;
    private ApplicationList applicationList;
    private QuestionDirectory questionList;

    public RegularUser(String userId, String email, String password, Profile userProfile, CompanyList companyList, ApplicationList applicationList) {
        super(userId, email, password);
        this.userProfile = userProfile;
        this.companyList = companyList;
        this.applicationList = applicationList;
        // The question list could be initialized here or be set via a setter method.
        this.questionList = new QuestDirectory(); 
    }

    @Override
    public boolean isValidUser(String email, String password) {
        // Implement validation logic specific to RegularUser, if different from User
        return this.getEmail().equals(email) && this.getPassword().equals(password);
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

    public QuestDirectory getQuestionList() {
        return questionList;
    }

}
