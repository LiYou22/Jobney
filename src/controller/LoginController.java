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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.user.AdminUser;
import model.user.RegularUser;


public class LoginController {
    @FXML
    private Button btn_signin;
    @FXML
    private Label btn_signup;
    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    

	@FXML
	public void initialize() {
    	btn_signin.setOnAction(e -> login());
        btn_signup.setOnMouseClicked(e -> openRegistrationForm());
	}

    
    private void login() {
    	AdminUser administrator = AdminUser.getInstance();
        String userEmail = email.getText();
        String userPassword = password.getText();
        
        if (administrator.isValidUser(userEmail, userPassword)) {
            // Handle admin login
            // Redirect to admin dashboard 
            System.out.println("Admin login successful!");
        } else {
            // Attempt to log in as a regular user
            RegularUser user = administrator.getDirectory().getUser(userEmail);
            if (user != null && user.isValidUser(userEmail, userPassword)) {
                // Login successful for a regular user
                System.out.println("User login successful!");
                // Redirect to user dashboard or enable user-specific features
            } else {
                // Login failed
                System.out.println("Login failed. Please check your credentials.");
            }
        }
    }
    

    private void openRegistrationForm() {
        
        try {
            // Load the registration form FXML
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/SignUpUI.fxml"));
            fxmlLoader.setController(new SignUpController());
            Parent registrationForm = fxmlLoader.load();

            // Get the current stage (window) from a component
            Stage currentStage = (Stage) btn_signup.getScene().getWindow();

            // Set the scene of the current stage to the registration form
            currentStage.setScene(new Scene(registrationForm));
            currentStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception, maybe log it or show an error message
        }
    }
}



