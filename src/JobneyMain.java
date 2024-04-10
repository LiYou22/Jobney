import javafx.application.Application;
import javafx.stage.Stage;
import model.user.AdminUser;
import view.UserTypeSelectionView;


public class JobneyMain extends Application {
    private AdminUser adminUser;

    @Override
    public void start(Stage primaryStage) {
        adminUser = new AdminUser("admin@example.com", "adminPassword");

        UserTypeSelectionView userTypeSelectionView = new UserTypeSelectionView(primaryStage, adminUser);
    }

    public static void main(String[] args) {
        launch(args);
    }
	
}