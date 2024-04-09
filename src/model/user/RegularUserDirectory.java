package model.user;

import java.util.HashMap;
import java.util.Map;

public class RegularUserDirectory {
	
    private Map<String, RegularUser> users = new HashMap<>();

    public boolean addUser(RegularUser user) {
        if (users.containsKey(user.getEmail())) {
            return false; 
        }
        users.put(user.getEmail(), user);
        return true;
    }

    public RegularUser getUser(String email) {
        return users.get(email);
    }

}
