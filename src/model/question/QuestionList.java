package model.question;

import java.util.List;

// class to manage all the questions under one application 
public class QuestionList  extends QuestionManager{

	private String applicationId;
	
	public QuestionList(String applicationID) {
		super();
		this.applicationId = applicationID;
	}
	
	public String getApplicationId() {
		return this.applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}
	
}
