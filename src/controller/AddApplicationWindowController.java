package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.application.Application;
import model.company.Company;
import model.enums.APPLICATIONSTATUS;
import model.job.Job;

public class AddApplicationWindowController {

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnSave;

    @FXML
    private ComboBox<String> statusComboBox;
    
    @FXML
    private TextField jobNameField;

    @FXML
    private TextField companyNameField;

    @FXML
    private DatePicker dateAppliedPicker; 
    
    @FXML
    private TextField jobLinkField;
    
    @FXML
    private Button btn_close_window;
    
    
    private ObservableList<Application> applications;
    
    public void initialize() {
        ObservableList<String> statusOptions = FXCollections.observableArrayList(
            "TOAPPLY", "DORESEARCH", "APPLIED", "SENTLINKEDIN", "INTERVIEW", "REJECTED", "GETOFFER"
        );
        statusComboBox.setItems(statusOptions);
        
        btnCancel.setOnAction(e -> cancel(e));
        btnSave.setOnAction(e -> save(e));
    }
    
    @FXML
    public void cancel(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    	System.out.println("clicking cancel");
    	
    }
    
    
    @FXML
    public void save(ActionEvent event) {
    	System.out.println("clicking save");

    	String jobName = jobNameField.getText();
    	String companyName = companyNameField.getText();
    	String status = statusComboBox.getValue();
    	LocalDate dateApplied = dateAppliedPicker.getValue();
    	String jobLink = jobLinkField.getText();
    	
    	//create a company object
    	Company company = new Company(companyName);
    	
    	//create a job object
    	Job job = new Job(jobName, company,jobLink);
    	
    	//create application object
    	Application application = new Application(job);
//    	application.setDateApplied(Date.from(dateApplied.atStartOfDay(ZoneId.systemDefault()).toInstant()));
//        application.setStatus(APPLICATIONSTATUS.valueOf(status));
    	
    	
       // close the window after saving
    	Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
        
        
    }
}
