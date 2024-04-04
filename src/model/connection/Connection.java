package model.connection;

import java.util.Date;

import model.enums.CONNECTSTATUS;

public class Connection {
     private String connectionID;
     private String firstName;
     private String lastName;
     private Date connectDate;
     private CONNECTSTATUS status;
     
     public Connection(String connectionID, String firstName, String lastName) {
    	 this.connectionID = connectionID;
    	 this.firstName = firstName;
    	 this.lastName = lastName;
    	 this.connectDate = new Date(); //default to current date
    	 this.status = CONNECTSTATUS.SENTFOLLOWUPEMAIL; // default???
     }
     
     public String getConnectionID() {
    	 return connectionID;
     }
   
     public void setConnectionID(String connectionID) {
    	 this.connectionID = connectionID;
     }
     
     public String getFirstName() {
    	 return firstName;
     }
     
     public void setFirstName(String firstName) {
    	 this.firstName = firstName;
     }
     
     public String getLastName() {
    	 return lastName;
     }
     
     public void setLastName(String lastName) {
    	 this.lastName = lastName;
     } 
     
     public CONNECTSTATUS getStatus() {
    	 return status;
     }
     
     public void setCONNECTSTATUS(CONNECTSTATUS status) {
    	 this.status = status;
     }
     
     public void updateStatus(CONNECTSTATUS status) {
    	 this.status = newStatus;
     }
     
     
}
