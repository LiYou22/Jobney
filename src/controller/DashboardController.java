package controller;
import model.user.RegularUser;
import javafx.scene.Node;

import model.utilities.FxmlLoader;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DashboardController {
	
	private RegularUser user;

    @FXML
    private ImageView avatar;

    @FXML
    private ImageView btn;

    @FXML
    private Pane btn_1day_left;

    @FXML
    private Pane btn_2day_left;

    @FXML
    private Pane btn_3day_left;

    @FXML
    private Pane btn_4day_left;

    @FXML
    private Button btn_application;

    @FXML
    private Button btn_companies;
    
    @FXML
    private Button btn_log_out;

    @FXML
    private Button btn_overview;

    @FXML
    private Button btn_questions;

    @FXML
    private Button btn_settings;

    @FXML
    private Text company1_name;

    @FXML
    private Text company2_name;

    @FXML
    private Text company3_name;

    @FXML
    private Text company4_name;

    @FXML
    private ImageView icon_application;

    @FXML
    private ImageView icon_companies;
    
    @FXML
    private ImageView icon_log_out;

    @FXML
    private ImageView icon_overview;

    @FXML
    private ImageView icon_question;

    @FXML
    private ImageView icon_settings;

    @FXML
    private Text job_title1;

    @FXML
    private Text job_title2;

    @FXML
    private Text job_title3;

    @FXML
    private Text job_title4;

    @FXML
    private ImageView logo;
    
    @FXML
    private Pane mainPane;
    
    @FXML
    private Pane middle_pane;

    @FXML
    private Pane right_side_pane;

    @FXML
    private HBox root;

    @FXML
    private AnchorPane side_anchor_pane;

    @FXML
    private Pane statics_pane;

    @FXML
    private Pane statics_pane1;

    @FXML
    private Pane statics_pane11;

    @FXML
    private Pane statics_pane2;
    
    
    public DashboardController(RegularUser user) {
    	this.user = user;
    }
    
    public Pane getMainPane() {
    	return mainPane;
    }

    @FXML
    void btnApplicationClicked(ActionEvent event) {
    	System.out.println("Switching to Application page!");
    	
        try {
            URL fileUrl = getClass().getResource("/view/ApplicationUI.fxml");
            FXMLLoader loader = new FXMLLoader(fileUrl);
            ApplicationController appController = new ApplicationController(user, this);  
            loader.setController(appController);
            Pane view = loader.load();
            mainPane.getChildren().setAll(view);

        } catch (IOException ex) {
            System.out.println("Error: Unable to load the Application view.");
            ex.printStackTrace();
        }
        
    }
    

    @FXML
    void btnCompaniesClicked(ActionEvent event) {
        System.out.println("Switching to Companies page!");
    	
        try {
            URL fileUrl = getClass().getResource("/view/CompanyUI.fxml");
            FXMLLoader loader = new FXMLLoader(fileUrl);
            CompanyController companyController = new CompanyController(user);  
            loader.setController(companyController);
            Pane view = loader.load();
            mainPane.getChildren().setAll(view);

        } catch (IOException ex) {
            System.out.println("Error: Unable to load the Company view.");
            ex.printStackTrace();
        }
    	
    }

    @FXML
    void btnOverviewClicked(ActionEvent event) {
    	System.out.println("Switching to Overview page!");
//    	URL fileUrl = getClass().getResource("/view/DashboardUI.fxml");
//    	FxmlLoader obejct = new FxmlLoader();
//    	Pane view = obejct.getPage(fileUrl);
//    	mainPane.getChildren().setAll(view);
    }

    @FXML
    void btnQuestionsClicked(ActionEvent event) {
        System.out.println("Switching to Questions page!");

        try {
            URL fileUrl = getClass().getResource("/view/QuestionUI.fxml");
            FXMLLoader loader = new FXMLLoader(fileUrl);
            QuestionController questionsController = new QuestionController(user);  
            loader.setController(questionsController);
            Pane view = loader.load();
            mainPane.getChildren().setAll(view);

        } catch (IOException ex) {
            System.out.println("Error: Unable to load the Questions view.");
            ex.printStackTrace();
        }
    }

    @FXML
    void btnSettingsClicked(ActionEvent event) {
//    	System.out.println("Switching to Settings page!");
//
//        try {
//            URL fileUrl = getClass().getResource("/view/SettingsUI.fxml");
//            FXMLLoader loader = new FXMLLoader(fileUrl);
//            SettingsController settingsController = new SettingsController(user);  
//            loader.setController(settingsController);
//            Pane view = loader.load();
//            mainPane.getChildren().setAll(view);
//
//        } catch (IOException ex) {
//            System.out.println("Error: Unable to load the Settings view.");
//            ex.printStackTrace();
//        }
    }

    @FXML
    void click(MouseEvent event) {

    }
    
    @FXML
    void btnLogOutClicked(ActionEvent event) {
    	System.out.println("Logging out!");
        try {
		    FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/LoginUI.fxml")); 
		    loader.setController(new LoginController());
		    Parent loginView = loader.load();
		    
		    Stage stage = (Stage) btn_log_out.getScene().getWindow(); 
		    stage.setScene(new Scene(loginView));
		    stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error: Unable to load the login view.");
        }

    }
    


    
}
