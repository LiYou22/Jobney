package model.question;

import java.util.ArrayList;
import java.util.List;

public class QuestionManager {
	
		protected int count = 0;
	    protected List<Question> questionlist;
	    
	    public QuestionManager() {
	        this.questionlist = new ArrayList<>();
	    }

	    public List<Question> getQuestions() {
	        return questionlist;
	    }

	    public void addQuestion(Question q) {
	    	questionlist.add(q);
	    	count++;
	    }

	    public Question searchQuestionByID(int qID) {
	        for (Question q : questionlist) {
	            if (q.getQuestionID() == qID) {
	                return q;
	            }
	        }
	        return null;
	    }

	    public void deleteQuestion(int qID) {
	        Question q = searchQuestionByID(qID);
	        if (q != null) {
	        	questionlist.remove(q);
	        }
	    }

	    public void updateAnswer(int qID, String oldAnswer, String newAnswer) {
	        Question q = searchQuestionByID(qID);
	        if(q != null) {
	            q.updateAnswer(oldAnswer, newAnswer);
	        }
	    }
	    
       public int getCount() {
    	   return count;
       }
	
	

}
