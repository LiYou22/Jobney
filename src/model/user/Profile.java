package model.user;

import javafx.scene.image.Image;

public class Profile {
	
	private String userName;
	private Image avatar;

    
    // this is for testing, can be deleted after we've done
    public Profile(String userName) {
        this.userName = userName;
        this.avatar = new Image("/images/avatar.png"); // default avatar

    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAvatar(Image avatar) {
        this.avatar = avatar;
    }

    public String getUserName() {
        return userName;
    }

    public Image getAvatar() {
        return this.avatar;
    }


}
