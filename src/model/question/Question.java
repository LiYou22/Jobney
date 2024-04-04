package model.question;

import java.util.ArrayList;

public class Question {
	
	  private static int nextId = 1;
      private int qID;
      private String q;
      private ArrayList<String> alist;  // one question might have multiple answers
      private int frequency;
      
      public Question(String q) {
    	  this.qID = nextId++;
    	  this.q = q;
    	  this.alist = new ArrayList<>();
    	  this.frequency = 0;
      }
	
	  public int getQuestionID() {
		  return qID;
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

