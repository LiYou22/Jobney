package model.user;

import java.awt.Image;
import java.util.Date;

public class Profile {
	
	private String userName;
	private Image avatar;

    public Profile(String userName, Image avatar) {
        this.userName = userName;
        this.avatar = avatar;
    }
    
    // this is for testing, can be deleted after we've done
    public Profile(String userName) {
        this.userName = userName;
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
        return avatar;
    }


}
