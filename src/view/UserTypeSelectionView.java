package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import controller.LoginController;
import model.user.*;

public class UserTypeSelectionView {
	boolean isAdmin;
	
	public UserTypeSelectionView(Stage stage, AdminUser adminUser) {
        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);

        Button adminLoginButton = new Button("Admin Login");
        Button userLoginButton = new Button("User Login");
        Button newUserButton = new Button("New User Registration");

        adminLoginButton.setOnAction(e -> {
        	isAdmin = true;
            LoginView loginView = new LoginView(stage);
            new LoginController(loginView, adminUser, isAdmin); 
            loginView.showStage();
        });

        userLoginButton.setOnAction(e -> {
        	isAdmin = false;
            LoginView loginView = new LoginView(stage);
            LoginController loginController = new LoginController(loginView, adminUser, isAdmin);
            loginView.showStage();
        });
        
        newUserButton.setOnAction(e -> {
            // Pass adminUser so the RegistrationView has access to add a new regular user
            RegistrationView registrationView = new RegistrationView(stage, adminUser);
            registrationView.showRegistrationForm();
        });

        layout.getChildren().addAll(adminLoginButton, userLoginButton, newUserButton);

        Scene scene = new Scene(layout, 300, 150);
        stage.setScene(scene);
        stage.setTitle("User Type Selection");
        stage.show();
    }
}




