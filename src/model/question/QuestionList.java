package model.question;

import java.util.ArrayList;
import java.util.List;

public class QuestionList {

	private List<Question> questionList;
	
	public QuestionList() {
		this.questionList = new ArrayList<>();
	}
	
	public List<Question> getQuestionList(){
		return questionList;
	}
	
	public void addQuestion(Question q) {
		questionList.add(q);
	}
	
	public void updateQuestion(String qID, String newQuestion, String newAnswer) {
		Question q = findQuestionByID(qID);
		if(q != null) {
			q.setAnswer(newAnswer);;
			q.setQuestion(newQuestion);
		}
	}
	
	public void deleteQuestion(String qID) {
		Question q = findQuestionByID(qID);
        if (q != null) {
            questionList.remove(q);
        }
	}
	
	public Question findQuestionByID(String qID) {
        for (Question q : questionList) {
            if (q.getQuestionID().equals(qID)) {
                return q;
            }
        }
        return null; // Question not found
    }
	
}
