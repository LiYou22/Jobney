package model.utilities;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public interface HashHelper {
	
	String salt = createSalt();
	
    // salt is random data that is used as an additional input to hash password
    static String createSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }
	
    // hash a password
    public static String hashPassword(String passwordToHash) {
    	
        String generatedPassword = null;
        
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt.getBytes("UTF-8"));
            byte[] bytes = md.digest(passwordToHash.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } 
        catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        } 
        catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return generatedPassword;
    }

    // validate the entered password
//    public static boolean isPasswordValid(String enteredPwd, String storedHash){
//        String hashedEnteredPwd = hashPassword(enteredPwd);
//        return hashedEnteredPwd.equals(storedHash);
//    }

}
