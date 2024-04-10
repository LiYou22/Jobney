package controller;


import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.user.AdminUser;
import model.user.RegularUser;

public class SignUpController {

    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField password1; 
    @FXML
    private Button btn_signup;
    @FXML
    private Label btn_signin; 


    @FXML
    private void initialize() {
    	btn_signup.setOnAction(e -> handleSignUp());
        btn_signin.setOnMouseClicked(e -> goToLoginView());
    }

    @FXML
    private void handleSignUp() {
    	String userEmail = email.getText();
    	String userPassword = password.getText();
    	String confirmPassword = password1.getText();

	    if (userEmail.isEmpty() || userPassword.isEmpty() || confirmPassword.isEmpty()) {
	        showAlert("Error", "All fields must be filled out.");
	        return;
	    }

	    if (!userPassword.equals(confirmPassword)) {
	        showAlert("Error", "Passwords do not match.");
	        return;
	    }

	    RegularUser newUser = new RegularUser(userEmail, userPassword); 
	    AdminUser admin = AdminUser.getInstance();
	    boolean success = admin.getDirectory().addUser(newUser); 

	    if (success) {
	        showAlert("Success", "Account created successfully. Please log in.");
	        goToLoginView();
	    } else {
	        showAlert("Error", "An account could not be created. Please try again.");
	    }
    

        showAlert("Success", "Account created successfully. Please log in.");
        goToLoginView();
    }
        
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void goToLoginView() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/LoginUI.fxml"));
            Parent loginForm = fxmlLoader.load();
            Stage currentStage = (Stage) email.getScene().getWindow(); 
            currentStage.setScene(new Scene(loginForm));
            currentStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Unable to load the login view.");
        }
    }
}
