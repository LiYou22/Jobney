package model.question;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class QuestionDirectory {
       private List<Question> questionList;
       
       public QuestionDirectory(List<Question> questionList) {
    	   this.questionList = questionList;
       }
       
       public List<Question> getAllQuestions(){
    	   return questionList;
       }
	
       public void addQuestion(Question question) {
    	   questionList.add(question);
       }
       
       public void updateQuestion(String qID, String newQuestion, String newAnswer) {
    	   for(Question q : questionList) {
    		   if(q.getQuestionID().equals(qID)) {
    			   q.setQuestion(newQuestion);
    			   q.setAnswer(newAnswer);
    			   break;
    		   }
    	   }
       }
       
       public void deleteQuestion(String qID) {
    	   questionList.removeIf(q -> q.getQuestionID().equals(qID));
       }
       
       public Question searchQuestionByName(String questionName) {
    	   for (Question q: questionList) {
    		   if(q.getQuestion().equalsIgnoreCase(questionName)) {
    			   return q;
    		   }
    	   }
    	   return null;
       }
       
       public void sortQuestionByFrequency() {
    	   Collections.sort(questionList, Comparator.comparingInt(Question::getFrequency).reversed()l));
       }
       
       public int countQuestions() {
           return questionList.size();
       }
}
