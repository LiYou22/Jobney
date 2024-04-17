package controller;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import model.user.RegularUser;

public class BaseLayoutController {
	
	RegularUser user;
	
   @FXML
    private Pane contentPane;

    @FXML
    private ImageView avatar_icon;

    @FXML
    private StackPane stackPane;
    
    public BaseLayoutController(RegularUser user){
    	this.user = user;
    }
    
    @FXML
    public void initialize() {
        // Load your image and set it to ImageView.
        Image image = user.getProfile().getAvatar();
        avatar_icon.setImage(image);
    }
    
    public void updateAvatar() {

    }
    
    public Pane getContentPane() {
    	return this.contentPane;
    }

}
