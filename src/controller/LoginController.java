package controller;

import model.user.RegularUser;
import view.LoginView;

public class LoginController {
	private LoginView view;
    private RegularUser user; // Assuming you are dealing with RegularUser

    public LoginController(LoginView view, RegularUser user) {
        this.view = view;
        this.user = user;
        initController();
    }

    private void initController() {
        view.getLoginButton().setOnAction(e -> login());
    }

    private void login() {
        String email = view.getEmailField().getText();
        String password = view.getPasswordField().getText();
        if (user.isValidUser(email, password)) {
            view.setFeedbackText("Login successful!");
        } else {
            view.setFeedbackText("Login failed. Invalid username or password.");
        }
    }

}
