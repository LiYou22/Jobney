package controller;

import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import model.application.Application;
import model.enums.APPLICATIONSTATUS;
import model.user.RegularUser;

public class OverviewController {
	
	private RegularUser user;
	private HBox hbox;


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
    private Label num_applications;

    @FXML
    private Label num_companies;

    @FXML
    private Label num_interviews;
    
    @FXML
    private Label num_offers;

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
    private Label username;

    @FXML
    void click(MouseEvent event) {
    	
    	

    }
    
    public OverviewController(RegularUser user, HBox hbox) {
    	this.user = user;
    	this.hbox = hbox;
    }

    
    @FXML
    private void initialize() {
    	username.setText(user.getProfile().getUserName());
    	List<Application> appList = showApplications();
    	
    	if (appList.size() >= 4) {    	
    		Application app1 = appList.get(0);
	    	Application app2 = appList.get(1);
	    	Application app3 = appList.get(2);
	    	Application app4 = appList.get(3);
	    	
	        job_title1.setText(app1.getJobName());
	        job_title2.setText(app2.getJobName());
	        job_title3.setText(app3.getJobName());
	        job_title4.setText(app4.getJobName());
	        
	        company1_name.setText(app1.getCompanyName());
	        company2_name.setText(app2.getCompanyName());
	        company3_name.setText(app3.getCompanyName());
	        company4_name.setText(app4.getCompanyName());	
    	}
    	
    	
    	// get statics
        num_applications.setText(String.valueOf(user.getApplicationList().getSize()));;
        num_companies.setText(String.valueOf(user.getCompanyList().getSize()));;
        num_interviews.setText(String.valueOf(user.getApplicationList().getApplicationsByStatus(APPLICATIONSTATUS.INTERVIEW).size()));;
        num_offers.setText(String.valueOf(user.getApplicationList().getApplicationsByStatus(APPLICATIONSTATUS.GETOFFER).size()));;

    }
    
    // get the applications that close to the deadline
    private List<Application> showApplications() {
    	
    	List<Application> list = user.getApplicationList().getApplicationsByStatus(APPLICATIONSTATUS.TOAPPLY);
    	user.getApplicationList().sortApplicationsByCreatedDate(list);
    	
    	return list;
    	

    }
    
    

    
    

}
