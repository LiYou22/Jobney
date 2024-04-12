package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.application.Application;
import model.application.ApplicationList;
import model.user.RegularUser;

public class ApplicationController {
	
	private RegularUser user;

	
	@FXML
    private TextField search_bar;
	@FXML
    private Button btn_search;
	@FXML
    private Button btn_addApplication;
	@FXML
	private TableView<Application> application_table;
	@FXML
	private TableColumn<Application,String> JobPositionColumn;
	@FXML
	private TableColumn<Application,String> companyColumn;
	@FXML
	private TableColumn<Application,String> StatusColumn;
	@FXML
	private TableColumn<Application,String> DateAppliedColumn;
	@FXML
	private TableColumn<Application,String> DateAddedColumn;
	@FXML
	private TableColumn<Application,String> RateColumn;
	
		
	public ApplicationController(RegularUser user) {
    	this.user = user;
	}

	public void initialize() {
		
		JobPositionColumn.setCellValueFactory(new PropertyValueFactory<>("jobName"));
		// actual property name in Application Class
		companyColumn.setCellValueFactory(new PropertyValueFactory<>("companyName")); 
        StatusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        DateAddedColumn.setCellValueFactory(new PropertyValueFactory<>("dateAdded"));
        DateAppliedColumn.setCellValueFactory(new PropertyValueFactory<>("dateApplied"));
        RateColumn.setCellValueFactory(new PropertyValueFactory<>("rate"));
		
        // Get the existing data
        ObservableList<Application> data = FXCollections.observableArrayList(ApplicationList.getApplicationList());

        // Populate the TableView
        application_table.setItems(data);
        
        btn_search.setOnAction(e -> search(e));
        btn_addApplication.setOnAction(e -> addApplication(e));        
        
	}
	
	public void search(ActionEvent event) {
		
		String searchfield = search_bar.getText();
		List<Application> results = new ArrayList();
		
		for(Application app: ApplicationList.getApplicationList()) { // made static method and attribute
			if(app.getAssociatedJob().getJobName().equalsIgnoreCase(searchfield)) {
				results.add(app);
			}
			
		}
		if (results.isEmpty()) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Search Result");
			alert.setHeaderText(null);
			alert.setContentText("No applications found for the job: " + searchfield);
			
			alert.showAndWait();
		} else {
			application_table.setItems(FXCollections.observableArrayList(results));
		}
	}
	
	public void addApplication(ActionEvent event) {             

	    try {

	        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/ApplicationPopWindow.fxml")); 
	        Parent root1 = fxmlLoader.load();
	        Stage stage = new Stage();
	        stage.initStyle(StageStyle.TRANSPARENT);
	        stage.setTitle("Add a Job");
	        Scene scene = new Scene(root1);

	        stage.setScene(scene);
	        stage.show();
	      
	    } catch (IOException e) {
	        System.out.println("Can't load new window");
	        e.printStackTrace();
	    }
	}

	
}
