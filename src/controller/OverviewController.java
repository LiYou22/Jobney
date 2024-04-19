package controller;

import java.net.URL;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import model.application.Application;
import model.application.CalendarActivity;
import model.enums.APPLICATIONSTATUS;
import model.user.RegularUser;


public class OverviewController implements Initializable {
	
	private RegularUser user;
	private HBox hbox;
	
    ZonedDateTime dateFocus;
    ZonedDateTime today;
    
    @FXML
    private Text year;

    @FXML
    private Text month;

    @FXML
    private FlowPane calendar;

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

    
    public void initialize(URL url, ResourceBundle resourceBundle) {
    	
        dateFocus = ZonedDateTime.now();
        today = ZonedDateTime.now();
        drawCalendar();
        
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
        num_interviews.setText(String.valueOf(user.getApplicationList().countApplicationsByStatus(APPLICATIONSTATUS.INTERVIEW).size()));;
        num_offers.setText(String.valueOf(user.getApplicationList().countApplicationsByStatus(APPLICATIONSTATUS.GETOFFER).size()));;

    }
    
    @FXML
    void backOneMonth(ActionEvent event) {
        dateFocus = dateFocus.minusMonths(1);
        calendar.getChildren().clear();
        drawCalendar();
    }

    @FXML
    void forwardOneMonth(ActionEvent event) {
        dateFocus = dateFocus.plusMonths(1);
        calendar.getChildren().clear();
        drawCalendar();
    }


    private void drawCalendar(){
        year.setText(String.valueOf(dateFocus.getYear()));
        month.setText(String.valueOf(dateFocus.getMonth()));

        double calendarWidth = calendar.getPrefWidth();
        double calendarHeight = calendar.getPrefHeight();
        double strokeWidth = 0.5;
        double spacingH = calendar.getHgap();
        double spacingV = calendar.getVgap();

        //List of activities for a given month
        Map<Integer, List<CalendarActivity>> calendarActivityMap = getCalendarActivitiesMonth(dateFocus);

        int monthMaxDate = dateFocus.getMonth().maxLength();
        //Check for leap year
        if(dateFocus.getYear() % 4 != 0 && monthMaxDate == 29){
            monthMaxDate = 28;
        }
        int dateOffset = ZonedDateTime.of(dateFocus.getYear(), dateFocus.getMonthValue(), 1,0,0,0,0,dateFocus.getZone()).getDayOfWeek().getValue();

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
            	
                StackPane stackPane = new StackPane();
                Rectangle rectangle = new Rectangle();
                
                rectangle.setFill(Color.TRANSPARENT);
                
                double rectangleWidth =(calendarWidth/7) - strokeWidth - spacingH;
                rectangle.setWidth(rectangleWidth);
                double rectangleHeight = (calendarHeight/6) - strokeWidth - spacingV;
                rectangle.setHeight(rectangleHeight);
                
                stackPane.getChildren().add(rectangle);

                int calculatedDate = (j+1)+(7*i);
                
                if(calculatedDate > dateOffset){
                    int currentDate = calculatedDate - dateOffset;
                    if(currentDate <= monthMaxDate){
                        Text date = new Text(String.valueOf(currentDate));
                        Font font = new Font(9); 
                        date.setFont(font);
                        
                        double textTranslationY = - (rectangleHeight / 2) * 0.2;
                        date.setTranslateY(textTranslationY);

                        // get the list of calendar activites for this date
                        List<CalendarActivity> calendarActivities = calendarActivityMap.get(currentDate);
                        
                        if(currentDate <= monthMaxDate && calendarActivities != null && !calendarActivities.isEmpty()){
                            // Create a circle if there's an application
                            Circle circle = new Circle();
                            circle.setRadius(Math.min(calendarWidth, calendarHeight) / 15);  // Adjust size as needed
                            circle.setFill(Color.web("#FFBB36"));
                            stackPane.getChildren().add(circle);
                        }

                        stackPane.getChildren().add(date);
                        calendar.getChildren().add(stackPane);

}
                }
            }
        }
    }

    private Map<Integer, List<CalendarActivity>> createCalendarMap(List<CalendarActivity> calendarActivities) {
    	
        Map<Integer, List<CalendarActivity>> calendarActivityMap = new HashMap<>();

        for (CalendarActivity activity: calendarActivities) {
            int activityDate = activity.getDate().getDayOfMonth();
            if(!calendarActivityMap.containsKey(activityDate)){
                calendarActivityMap.put(activityDate, List.of(activity));
            } else {
                List<CalendarActivity> OldListByDate = calendarActivityMap.get(activityDate);

                List<CalendarActivity> newList = new ArrayList<>(OldListByDate);
                newList.add(activity);
                calendarActivityMap.put(activityDate, newList);
            }
        }
        return  calendarActivityMap;
    }
    
    private Map<Integer, List<CalendarActivity>> getCalendarActivitiesMonth(ZonedDateTime dateFocus) {
        
        List<CalendarActivity> calendarActivities = new ArrayList<>();
        
        // loop over applications to get their created date
        List<Application> app = user.getApplicationList().getApplicationList();
        
        for(Application a: app) {
            Date date = a.getDateCreated();
            ZonedDateTime time = date.toInstant().atZone(ZoneId.systemDefault()); // convert Date to ZonedDateTime

            // Check if the application was created in the same month and year as dateFocus
            if (time.getMonthValue() == dateFocus.getMonthValue() && time.getYear() == dateFocus.getYear()) {
                calendarActivities.add(new CalendarActivity(time));
            }
        }

       return createCalendarMap(calendarActivities);
    }

    
    
    // get the applications that close to the deadline
    private List<Application> showApplications() {
    	
    	List<Application> list = user.getApplicationList().getApplicationsByStatus(APPLICATIONSTATUS.TOAPPLY);
    	user.getApplicationList().sortApplicationsByCreatedDate(list);
    	
    	return list;
    	

    }
    
    

    
    

}
