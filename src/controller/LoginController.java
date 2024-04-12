package controller;

import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.company.Company;
import model.enums.INDUSTRY;
import model.job.Job;
import model.user.AdminUser;
import model.user.Profile;
import model.user.RegularUser;
import model.application.*;


public class LoginController {
    @FXML
    private Button btn_signin;
    @FXML
    private Label btn_signup;
    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    
    // Initialize User Directory and Admin User
    AdminUser administrator = AdminUser.getInstance();
    

	@FXML
	public void initialize() {
	    
	    // Initialize a test user
	    RegularUser testUser = new RegularUser("user@gmail.com", "1111");
	    administrator.getUserDirectory().addUser(testUser);
	    
	    // create user profile
	    Profile profile1 = new Profile("Bruno");
	    testUser.setAssociatedProfile(profile1);
	    
	    // create a company
	    Company com1 = new Company(INDUSTRY.FINTECH,"PayPal");
	    administrator.getCompanyCatalog().addCompany(com1);
	    
	    // create a job under the company
	    Job job1 = new Job(com1, "Software Engineer Intern", "https://paypal.eightfold.ai/careers?Codes=W-LINKEDIN&domain=paypal.com&query=R0111038&sort_by=relevance");
	    
	    // create an application using the job
	    Application app1 = new Application(job1);
	    
	    // add application to the user
	    testUser.getApplicationList().addApplication(app1);
	    
	    // for testing 
	    System.out.print("user directory: \n" + administrator.getUserDirectory());
	    System.out.print("compay catalog: \n" + administrator.getCompanyCatalog());

	    
		// set up UI components
    	btn_signin.setOnAction(e -> login());
        btn_signup.setOnMouseClicked(e -> openRegistrationForm());
	}

    
    private void login() {
    	
        String userEmail = email.getText();
        String userPassword = password.getText();
        
        try {
            RegularUser user = administrator.getUserDirectory().getUser(userEmail);
            if (user != null && user.isValidUser(userEmail, userPassword)) {
            	showAlert("Login Succeed", "User login successful!");
                loadDashboardView(user);
            } else {
                showAlert("Login Failed", "Login failed. Please check your credentials.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void openRegistrationForm() {
    	
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/SignUpUI.fxml"));
            loader.setController(new SignUpController());
            Parent registrationForm = loader.load();

            Stage stage = (Stage) btn_signup.getScene().getWindow();

            stage.setScene(new Scene(registrationForm));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void loadDashboardView(RegularUser user) throws IOException {
    	
    	try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/DashBoardUI.fxml"));
            loader.setController(new DashboardController(user));
            Parent dashboard = loader.load();
            
            Stage stage = (Stage) btn_signin.getScene().getWindow();
            stage.setScene(new Scene(dashboard));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error: Unable to load the Dashboard view.");
        }
    }
    
    private void showAlert(String title, String content) {
    	
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}



