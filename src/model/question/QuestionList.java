package model.question;

import java.util.List;

// class to manage all the questions under one application 
public class QuestionList  extends QuestionManager{

	private String applicationId;
	
	 public QuestionList(String applicationID, List<Question> questions) {
	        super();
	        this.applicationId = applicationID;
	        for (Question question : questions) {
	            addQuestion(question);
	        }
	    }
	
	public String getApplicationId() {
		return this.applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}
	
}
