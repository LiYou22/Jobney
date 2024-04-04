package model.question;

import java.util.List;

// class to manage all the questions under one application 
public class QuestionList  extends QuestionManager{

	private int applicationId;
	
	public QuestionList(int applicationID) {
		super();
		this.applicationId = applicationID;
	}
	
	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}
	
}
