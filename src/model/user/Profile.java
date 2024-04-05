package model.user;

import java.awt.Image;
import java.util.Date;

public class Profile {
	
	private String userName;
	private Image avatar;
	private Date registerDate;

    public Profile(String userName, Image avatar) {
        this.userName = userName;
        this.avatar = avatar;
        this.registerDate = new Date(); 
    }

    public void updateUserName(String userName) {
        this.userName = userName;
    }

    public void updateAvatar(Image avatar) {
        this.avatar = avatar;
    }

    public String getUserName() {
        return userName;
    }

    public Image getAvatar() {
        return avatar;
    }

    public Date getRegisterDate() {
        return registerDate;
    }
}
