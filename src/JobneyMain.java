import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.user.AdminUser;
import view.UserTypeSelectionView;


public class JobneyMain extends Application {
    
	private AdminUser adminUser;

    @Override
    public void start(Stage primaryStage) {
    	
//        adminUser = new AdminUser("admin@example.com", "adminPassword");
//
//        UserTypeSelectionView userTypeSelectionView = new UserTypeSelectionView(primaryStage, adminUser);
    	
    	try {
    		
    		Parent root = FXMLLoader.load(getClass().getResource("view/DashboardUI.fxml"));
    		Scene scene = new Scene(root, 1260, 870);
			primaryStage.setScene(scene);
			primaryStage.show();
			
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }

    public static void main(String[] args) {
        launch(args);
    }
	
}