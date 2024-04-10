package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.user.AdminUser;
import model.user.RegularUser;

public class RegistrationView {
    private Stage stage;
    private AdminUser adminUser; 
    private TextField emailField = new TextField();
    private PasswordField passwordField = new PasswordField();
    private Button registerButton = new Button("Register");
    private Text feedbackText = new Text();

    public RegistrationView(Stage owner, AdminUser adminUser) {
        this.stage = new Stage();
        this.adminUser = adminUser;
        // Initialize the stage as a modal dialog
        stage.initOwner(owner);
        stage.initModality(Modality.APPLICATION_MODAL);
    }
    
    public void showRegistrationForm() {
        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10, 10, 10, 10));

        emailField.setPromptText("Enter your email");
        passwordField.setPromptText("Create a password");

        registerButton.setOnAction(e -> registerUser());

        layout.getChildren().addAll(
                new Label("Email:"),
                emailField,
                new Label("Password:"),
                passwordField,
                registerButton,
                feedbackText
        );

        Scene scene = new Scene(layout, 300, 200);
        stage.setScene(scene);
        stage.setTitle("Registration");
        stage.show();
    }

    private void registerUser() {
        String email = emailField.getText();
        String password = passwordField.getText();

        if (email.isEmpty() || password.isEmpty()) {
            feedbackText.setText("Email and password cannot be empty.");
            return;
        }

        if (adminUser.getDirectory().getUser(email) != null) {
            feedbackText.setText("A user with this email already exists.");
            return;
        }

        RegularUser newUser = new RegularUser(email, password);
        if (adminUser.getDirectory().addUser(newUser)) {
            feedbackText.setText("Registration successful.");
            // Here you could close the registration form
            // stage.close();
        } else {
            feedbackText.setText("Registration failed. Please try again.");
        }
    }
   
}
