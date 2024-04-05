package model.question;

import java.util.ArrayList;

import model.utilities.BaseId;

public class Question extends BaseId{
	
	  final String prefix = "question-";
	  private static int nextId = 1;
      private String qId;
      
      private String q;
      private ArrayList<String> alist;  // one question might have multiple answers
      private int frequency;
      
      // question id format: question-1, question-2, etc.
      protected void generateId(String prefix) {
    	  this.qId = prefix + nextId;
      }
      
      public Question(String q) {
   	      generateId(prefix);
    	  this.q = q;
    	  this.alist = new ArrayList<>();
    	  this.frequency = 0;
      }
	
	  public String getQuestionID() {
		  return qId;
	  }
     
	  public String getQuestion() {
		  return q;
	  }
	  
	  public void setQuestion(String q) {
		  this.q = q;
	  }
	  
	  public ArrayList<String> getAnswerList() {
		  return alist;
	  }
	  
	  public void addAnswer(String a) {
		  alist.add(a);
	  }
	  
	  public void updateAnswer(String oldAnswer, String newAnswer) {
		  int index = alist.indexOf(oldAnswer);
		  alist.set(index, newAnswer);
	  }
	  
	  
	  public int getFrequency() {
		  return frequency;
	  }
	  
	  // when adding an answer, increase the frequency
	  public void addFrequency() {
		  frequency++;
	  }
}

