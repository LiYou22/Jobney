package view;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;

public class LoginView {
	private TextField emailField = new TextField();
    private PasswordField passwordField = new PasswordField();
    private Button loginButton = new Button("Login");
    private Text feedbackText = new Text();

    public LoginView(Stage stage) {
        VBox layout = new VBox(10);
        layout.getChildren().addAll(
                new Label("Email:"), emailField,
                new Label("Password:"), passwordField,
                loginButton, feedbackText
        );

        stage.setScene(new Scene(layout, 300, 200));
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

    public void setFeedbackText(String message) {
        feedbackText.setText(message);
    }
}
