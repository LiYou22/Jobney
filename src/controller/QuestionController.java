package controller;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import model.question.Question;
import model.question.QuestionList;
import model.user.RegularUser;

public class QuestionController {

	    private RegularUser user;
	    @FXML
	    private Button btn_search;
	    @FXML
	    private TextField questionIdField;
	    @FXML
	    private ScrollPane questionList;
   
	    public QuestionController(RegularUser user) {
	    	this.user = user;
		}
	    
	    @FXML
	    public void initialize() {
	        btn_search.setOnAction(e -> searchQuestion(e));
	        VBox vbox = new VBox();
	        vbox.setSpacing(10);
	        for (Question question : QuestionList.getQuestions()) { // replace with your actual QuestionList instance
	            Label questionLabel = new Label(question.getQuestion());
	            questionLabel.setFont(new Font(20));
	            vbox.getChildren().add(questionLabel);
	        }
	        questionList.setContent(vbox);
	    }
	    
	    @FXML
	    void searchQuestion(ActionEvent event) {
       
        String searchfield = questionIdField.getText();
        Set<Question> results = new HashSet<>();
        
//        //test
//        List<Question> questions = QuestionList.getQuestions();
//        System.out.println("Number of questions: " + questions.size());
//        
//        //test 2 
//        for(Question question: QuestionList.getQuestions()) {
//            System.out.println("Question ID: " + question.getQuestionID());
//            if(question.getQuestionID().contains(searchfield)) {
//                results.add(question);
//            }
//        }
        
        for(Question question: QuestionList.getQuestions()) { // replace with your actual QuestionList instance
            if(question.getQuestionID().contains(searchfield)) {
                results.add(question);
            }
        }

        if (results.isEmpty()) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Search Result");
            alert.setHeaderText(null);
            alert.setContentText("No question found with the ID: " + searchfield);

            alert.showAndWait();
        } else {
            // Create a VBox to hold the question
            VBox vbox = new VBox();

            // Create a UI element for each question and add it to the VBox
            for (Question question : results) {
                Label questionLabel = new Label(question.getQuestion());
                questionLabel.setFont(new Font(20)); 
                vbox.getChildren().add(questionLabel);
            }

            // Set the VBox as the content of your ScrollPane
            questionList.setContent(vbox); // replace with your actual ScrollPane's ID
        }
        
	    }

	}

