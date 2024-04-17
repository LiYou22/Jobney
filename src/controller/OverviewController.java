package controller;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import model.user.RegularUser;

public class OverviewController {
	
	private RegularUser user;
	private HBox hbox;

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
    private Text company1_name;

    @FXML
    private Text company2_name;

    @FXML
    private Text company3_name;

    @FXML
    private Text company4_name;

    @FXML
    private Text job_title1;

    @FXML
    private Text job_title2;

    @FXML
    private Text job_title3;

    @FXML
    private Text job_title4;

    @FXML
    private Pane middle_pane;

    @FXML
    private Pane pane;

    @FXML
    private Pane right_side_pane;

    @FXML
    private HBox root_hbox;

    @FXML
    private Pane statics_pane;

    @FXML
    private Pane statics_pane1;

    @FXML
    private Pane statics_pane11;

    @FXML
    private Pane statics_pane2;

    @FXML
    void click(MouseEvent event) {
    	
    	

    }
    
    public OverviewController(RegularUser user, HBox hbox) {
    	this.user = user;
    	this.hbox = hbox;
    }

}
