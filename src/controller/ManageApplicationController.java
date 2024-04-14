package controller;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import model.application.Application;
import model.enums.APPLICATIONSTATUS;
import model.enums.INDUSTRY;
import model.note.Note;

public class ManageApplicationController {
	
	private Application currentApplication;

    @FXML
    private Button apply_link;

    @FXML
    private Button btn_add_note;
    

    @FXML
    private Button btn_save_note;

    @FXML
    private ComboBox<String> btn_status;
    
    @FXML
    private Button btn_back;

    @FXML
    private Label company_name;

    @FXML
    private CheckBox connect_checkbox;

    @FXML
    private CheckBox do_research_checkbox;

    @FXML
    private Label job_title;

    @FXML
    private TextField note_title;

    @FXML
    private TextArea note_content;
    

    @FXML
    private ListView<String> note_list;

    @FXML
    private HBox note_pane;

    @FXML
    private ProgressBar progress_bar;

    @FXML
    private Label progress_label;

    @FXML
    private ImageView rate;

    @FXML
    private Button btn_cover_letter;

    @FXML
    private Button btn_resume;

    @FXML
    private CheckBox submit_checkbox;

    @FXML
    private CheckBox tailor_resume_checkbox;

    @FXML
    private CheckBox tailore_cover_checkbox;
    

    
    // constructor
    public ManageApplicationController(Application application){
        this.currentApplication = application;

    }


	public void initialize() {
		
		String job = currentApplication.getJobName();
		String company = currentApplication.getCompanyName();
		APPLICATIONSTATUS currentStatus = currentApplication.getStatus();
		List<String> notelist = currentApplication.getNoteList().getNoteTitleList();

		
		System.out.println("notelist: " + notelist);

		// set up the items in the combo box
		ArrayList<String> statusList = Arrays.stream(APPLICATIONSTATUS.values())
	            .map(Enum::name)
	            .collect(Collectors.toCollection(ArrayList::new));
		
		// display all data on the page
		job_title.setText(job);
		company_name.setText(company);
		
		// display the current status
		btn_status.setItems(FXCollections.observableArrayList(statusList));
		String status = currentStatus.name();
		btn_status.setValue(status);

		// display current progress, by default is 0%(1 checkbox = 20%)
		progress_bar.setProgress(0.0);
		double value = 0.0;
		NumberFormat percentFormat = NumberFormat.getPercentInstance();
		String default_percent = percentFormat.format(value);
		progress_label.setText(default_percent);
		
		// create a listener for checkbox selection changes
		ChangeListener<Boolean> listener = (obs, oldVal, newVal) -> {
			double progress = 0;
			if(do_research_checkbox.isSelected()) progress += 0.2; 
			if(tailor_resume_checkbox.isSelected()) progress += 0.2;
			if(tailore_cover_checkbox.isSelected()) progress += 0.2;
			if(submit_checkbox.isSelected()) progress += 0.2;
			if(connect_checkbox.isSelected()) progress += 0.2;
			
			progress_bar.setProgress(progress);
			String percent = percentFormat.format(progress);
			progress_label.setText(percent);
		};
		
		// assign the listener to each checkbox
		do_research_checkbox.selectedProperty().addListener(listener);
		tailor_resume_checkbox.selectedProperty().addListener(listener);
		tailore_cover_checkbox.selectedProperty().addListener(listener);
		submit_checkbox.selectedProperty().addListener(listener);	
		connect_checkbox.selectedProperty().addListener(listener);
		
    	
    	ObservableList<String> notes = FXCollections.observableArrayList(notelist);
    	
//    	note_list.setItems(notes);
        
	}
	

    @FXML
    void ChangeStatus(ActionEvent event) {
    	String newStatus = btn_status.getSelectionModel().getSelectedItem();
    	currentApplication.setStatus(APPLICATIONSTATUS.valueOf(newStatus));
    	System.out.println("change status to " + newStatus);
    }

    @FXML
    void GoBack(ActionEvent event) {
    	// go back to application table


    }
    

    @FXML
    void saveNote(ActionEvent event) {
    	
    	// fetch the info
    	String title = note_title.getText();
    	String content = note_content.getText();
    	
    	Note newNote = new Note(title, content);
    	currentApplication.getNoteList().addNote(newNote);
    	
    	updateNoteList();

    }
    
    public void updateNoteList() {
    	// update the note list
    	
    	System.out.println("update note list");

    }
   

    @FXML
    void addCoverLetter(ActionEvent event) {

    }

    @FXML
    void addNewNote(ActionEvent event) {

    }

    @FXML
    void addResume(ActionEvent event) {

    }

    @FXML
    void openApplyLink(ActionEvent event) throws IOException, URISyntaxException {
    	System.out.println("link clicked!");
		String applyLink = currentApplication.getAssociatedJob().getJobLink();

    	Desktop.getDesktop().browse(new URI(applyLink));
    }


}
