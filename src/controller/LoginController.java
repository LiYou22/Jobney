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
	    Company com2 = new Company(INDUSTRY.TECH,"Google");
	    Company com3 = new Company(INDUSTRY.TECH,"Apple");
	    Company com4 = new Company(INDUSTRY.EDUCATION,"SYMPLICITY CORPORATION");
	    administrator.getCompanyCatalog().addCompany(com1);
	    administrator.getCompanyCatalog().addCompany(com2);
	    administrator.getCompanyCatalog().addCompany(com3);
	    administrator.getCompanyCatalog().addCompany(com4);
	    
	    // create a job under the company
	    Job job1 = new Job(com1, "Software Engineer Intern", "https://paypal.eightfold.ai/careers?Codes=W-LINKEDIN&domain=paypal.com&query=R0111038&sort_by=relevance");
	    Job job2 = new Job(com2, "Software Engineering Intern, People with Disabilities 2024", "https://www.google.com/about/careers/applications/jobs/results/133383757286515398-software-engineering-intern-people-with-disabilities-2024");
	    Job job3 = new Job(com3, "AIML - Software Engineering Internship - Multiple Party Computation, MLPT", "https://jobs.apple.com/en-us/details/200519066/aiml-software-engineering-internship-multiple-party-computation-mlpt?team=STDNT");
	    Job job4 = new Job(com4, "Software Development Intern", "https://builtin.com/job/software-development-intern/110908");
	    
	    // create an application using the job
	    Application app1 = new Application(job1);
	    Application app2 = new Application(job2);
	    Application app3 = new Application(job3);
	    Application app4 = new Application(job4);
	    
	    // add application to the user
	    testUser.getApplicationList().addApplication(app1);
	    testUser.getApplicationList().addApplication(app2);
	    testUser.getApplicationList().addApplication(app3);
	    testUser.getApplicationList().addApplication(app4);

	    testUser.getCompanyList().addCompany(com1);
	    testUser.getCompanyList().addCompany(com2);
	    testUser.getCompanyList().addCompany(com3);
	    testUser.getCompanyList().addCompany(com4);

	    
	    // for testing 
	    System.out.print("---> user directory: \n" + administrator.getUserDirectory());
	    System.out.print("---> compay catalog: \n" + administrator.getCompanyCatalog());

	    
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



