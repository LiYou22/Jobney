import controller.LoginController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.user.RegularUser;
import view.LoginView;


public class JobneyMain extends Application {

    @Override
    public void start(Stage primaryStage) {
        RegularUser user = new RegularUser("userId", "user@email.com", "password", null, null, null);
        LoginView view = new LoginView(primaryStage);
        new LoginController(view, user);
    }

    public static void main(String[] args) {
        launch(args);
    }
	
}