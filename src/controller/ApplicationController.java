package controller;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class ApplicationController {
	@FXML
    private TextField search;
	@FXML
    private Button btn_search;
	@FXML
    private Button btn_addApplication;
	@FXML
    private TextField jobPosition;
	@FXML
    private TextField link;
	@FXML
	private TableView<Application> tableView;
	@FXML
	private TableColumn<Application,String> JobPositionColumn;
	@FXML
	private TableColumn<Application,String> companyColumn;
	@FXML
	private TableColumn<Application,String> StatusColumn;
	@FXML
	private TableColumn<Application,String> DateAddedColumn;
	@FXML
	private TableColumn<Application,String> DateAppliedColumn;
	@FXML
	private TableColumn<Application,String> RateColumn;
	
	@FXML
	public void initialize() {
		JobPositionColumn.setCellValueFactory(new PropertyValueFactory<>("companyName"));
		// actual property name in Application Class
		companyColumn.setCellValueFactory(new PropertyValueFactory<>("companyName")); 
        StatusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        DateAddedColumn.setCellValueFactory(new PropertyValueFactory<>("dateAdded"));
        DateAppliedColumn.setCellValueFactory(new PropertyValueFactory<>("dateApplied"));
        RateColumn.setCellValueFactory(new PropertyValueFactory<>("rate"));
		
        // Get the existing data
        ObservableList<Application> data = FXCollections.observableArrayList(ApplicationList.getApplicationList());

        // Populate the TableView
        tableView.setItems(data);
	}
	
	public void search() {
		String searchfield = search.getText();
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
			tableView.setItems(FXCollections.observableArrayList(results));
		}
	}
	
	public void addApplication() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ApplicationPopWindow.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.initStyle(StageStyle.TRANSPARENT);
			stage.setTitle("Add a Job");
			stage.setScene(new Scene(root1));
			stage.show();
		} catch (Exception e) {
			System.out.println("Can't load new window");
		}
	}
	
}
