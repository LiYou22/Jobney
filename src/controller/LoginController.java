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
        
        try {
            if (administrator.isValidUser(userEmail, userPassword)) {
                // Need to redirect to admin dashboard 
                showAlert("Welcome Administrator", "Admin login successful!");
            } else {
                RegularUser user = administrator.getDirectory().getUser(userEmail);
                if (user != null && user.isValidUser(userEmail, userPassword)) {
                	showAlert("Login Succeed", "User login successful!");
                    loadDashboardView(user);
                } else {
                    showAlert("Login Failed", "Login failed. Please check your credentials.");
                }
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



