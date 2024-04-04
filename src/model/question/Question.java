package model.question;

public class Question {
      private String qID;
      private String q;
      private String a;
      int frequency;
      
      public Question(String qID, String q) {
    	  this.qID = qID;
    	  this.q = q;
    	  this.frequency = 0;
      }
	
	  public String getQuestionID() {
		  return qID;
	  }
     
	  public String getQuestion() {
		  return q;
	  }
	  
	  public void setQuestion(String q) {
		  this.q = q;
	  }
	  
	  public String getAnswer() {
		  return a;
	  }
	  
	  public void setAnswer(String a) {
		  this.a = a;
	  }
	  
	  public int getFrequency() {
		  return frequency;
	  }
	  
	  public void addFrequency() {
		  frequency++;
	  }
}

