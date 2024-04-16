package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.application.Application;
import model.connection.Connection;
import model.connection.ConnectionList;
import model.question.Question;
import model.question.QuestionList;

public class ManageLinkedinAndQuestionsController {
	
	Application currentApplication;
	
    @FXML
    private Button btn_add_linkedin;

    @FXML
    private Button btn_add_questions;
    
    @FXML
    private TextField name;

    @FXML
    private TextField linkedin_link;

    @FXML
    private ListView<Connection> linkedinListView;
    
    private ObservableList<Connection> observableConnectionList;
    
    private ConnectionList connectionList;

    @FXML
    private TextField question;

    @FXML
    private ListView<Question> questionListView;

    @FXML
    private TextField response;
    
    private QuestionList questionList;
    
    private ObservableList<Question> observableQuestionList;
    
    
    // constructor
    public ManageLinkedinAndQuestionsController(Application application){
        this.currentApplication = application;
        
        // Assume getConnections() and getQuestions() methods exist in Application
        this.observableConnectionList = FXCollections.observableArrayList(application.getConnectionList().getConnectionList());
        this.observableQuestionList = FXCollections.observableArrayList(application.getQuestionList().getQuestions());
    }
    
    public void initialize() {
        linkedinListView.setItems(observableConnectionList);
        questionListView.setItems(observableQuestionList);
    }

    @FXML
    void addLinkedin(ActionEvent event) {
        String nameText = name.getText();
        Connection newConnection = new Connection(nameText); // Assuming this constructor is properly defined
        observableConnectionList.add(newConnection);
        currentApplication.getConnectionList().addConnection(newConnection);
    }

    @FXML
    void addQuestion(ActionEvent event) {
        String questionText = question.getText();
        Question newQuestion = new Question(questionText);
        
        if (!response.getText().isEmpty()) {
            newQuestion.addAnswer(response.getText());
            newQuestion.addFrequency();
        }
        
        observableQuestionList.add(newQuestion);
        currentApplication.getQuestionList().addQuestion(newQuestion);
        
        question.clear();
        response.clear();
    }

}
