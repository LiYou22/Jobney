package model.question;

import java.util.List;

// class to manage all the questions under one application 
public class QuestionList  extends QuestionManager{

	private String applicationId;
	
<<<<<<< HEAD
	 public QuestionList(String applicationID, List<Question> questions) {
	        super();
	        this.applicationId = applicationID;
	        for (Question question : questions) {
	            addQuestion(question);
	        }
	    }
=======
	public QuestionList() {
		super();
	}
	
	public QuestionList(String applicationID) {
		super();
		this.applicationId = applicationID;
	}
>>>>>>> refs/heads/yulai
	
	public String getApplicationId() {
		return this.applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}
	
}
