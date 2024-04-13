package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.application.Application;

public class ManageLinkedinAndQuestionsController {
	
	Application currentApplication;
	
    @FXML
    private Button btn_add_linkedin;

    @FXML
    private Button btn_add_questions;

    @FXML
    private TextField linkedin_link;

    @FXML
    private ListView<?> linkedin_list;

    @FXML
    private TextField name;

    @FXML
    private TextField question;

    @FXML
    private ListView<?> question_list;

    @FXML
    private TextField response;

    @FXML
    void addLinkedin(ActionEvent event) {

    }

    @FXML
    void addQuestion(ActionEvent event) {

    }
    
    // constructor
    public ManageLinkedinAndQuestionsController(Application application){
    	this.currentApplication = application;
    }

}
