package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginView {

    private TextField emailField = new TextField();
    private PasswordField passwordField = new PasswordField();
    private Button loginButton = new Button("Login");
    private Button registerButton = new Button("Register");
    private Text feedbackText = new Text();
    
    private Stage stage;  // Hold the stage reference to open registration form

    public LoginView(Stage stage) {
        this.stage = stage;  // Assign the stage reference

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10, 10, 10, 10));

        emailField.setPromptText("Enter your email");
        passwordField.setPromptText("Enter your password");

        // Adding a layout for buttons
        HBox buttonLayout = new HBox(10);
        buttonLayout.setAlignment(Pos.CENTER);
        buttonLayout.getChildren().addAll(loginButton, registerButton);

        layout.getChildren().addAll(
                new Label("Email:"),
                emailField,
                new Label("Password:"),
                passwordField,
                buttonLayout,
                feedbackText
        );

        Scene scene = new Scene(layout, 300, 200);
        stage.setScene(scene);
        stage.setTitle("Login");
    }
    
    public void showStage() {
        stage.show();
    }

    public TextField getEmailField() {
        return emailField;
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }

    public Button getLoginButton() {
        return loginButton;
    }

    public Button getRegisterButton() {
        return registerButton;
    }

    public void setFeedbackText(String message) {
        feedbackText.setText(message);
    }

    public Stage getStage() {
        return stage;
    }
}
