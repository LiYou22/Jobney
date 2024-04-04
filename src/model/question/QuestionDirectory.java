package model.question;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// class to manage all questions under one user
public class QuestionDirectory extends QuestionManager {
	
	public static int count;
    protected List<Question> allQuestionList;
	
	public QuestionDirectory() {
		super();
	}
       
   	// list question by frequency in descending order
   	public List<Question> sortQuestionByFrequency(){
   		Collections.sort(allQuestionList, new Comparator<Question>() {
   			public int compare(Question q1, Question q2) {
   				return Integer.compare(q1.getFrequency(), q2.getFrequency());
   			}
   		});
   		return allQuestionList;
   	}
}
