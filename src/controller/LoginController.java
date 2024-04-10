package controller;

import model.user.*;
import view.LoginView;
import view.RegistrationView;

public class LoginController {
	private LoginView view;
    private AdminUser adminstrator;
    private boolean isAdmin;
    private RegularUserDirectory directory; // The directory to validate regular users

    public LoginController(LoginView view, AdminUser adminstrator, boolean isAdmin) {
        this.view = view;
        this.adminstrator = adminstrator;
        this.isAdmin = isAdmin;
        initController();
    }
    
    private void initController() {
        view.getLoginButton().setOnAction(e -> login());
        view.getRegisterButton().setOnAction(e -> {
            RegistrationView registrationView = new RegistrationView(view.getStage(), adminstrator);
            registrationView.showRegistrationForm(); // Call the appropriate method to display the form
        });
    }

    private void login() {
        String email = view.getEmailField().getText();
        String password = view.getPasswordField().getText();
        
        // Handle Administrator login
        if (isAdmin) {
            if (adminstrator.isValidUser(email, password)) {
                view.setFeedbackText("Admin login successful!");
            } else {
                view.setFeedbackText("Admin login failed. Invalid credentials.");
            }
        } else {
            // Handle regular user login
            RegularUser attemptingUser = adminstrator.getDirectory().getUser(email);
            if (attemptingUser != null && attemptingUser.isValidUser(email, password)) {
                view.setFeedbackText("User login successful!");
                // Additional regular user login success logic
            } else {
                view.setFeedbackText("User login failed. Invalid credentials.");
            }
        } 
    }
}

