package controller;
import model.utilities.FxmlLoader;

import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class DashboardController {

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

    @FXML
    void btnApplicationClicked(ActionEvent event) {
    	System.out.println("Switching to Application page!");
    	URL fileUrl = getClass().getResource("/view/ApplicationUI.fxml");
    	FxmlLoader obejct = new FxmlLoader();
    	Pane view = obejct.getPage(fileUrl);
    	mainPane.getChildren().setAll(view);
    }

    @FXML
    void btnCompaniesClicked(ActionEvent event) {

    }

    @FXML
    void btnOverviewClicked(ActionEvent event) {
    	System.out.println("Switching to Overview page!");
    	URL fileUrl = getClass().getResource("/view/DashboardUI.fxml");
    	FxmlLoader obejct = new FxmlLoader();
    	Pane view = obejct.getPage(fileUrl);
    	mainPane.getChildren().setAll(view);
    }

    @FXML
    void btnQuestionsClicked(ActionEvent event) {

    }

    @FXML
    void btnSettingsClicked(ActionEvent event) {

    }

    @FXML
    void click(MouseEvent event) {

    }

}
