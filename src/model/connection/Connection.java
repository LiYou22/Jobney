package model.connection;

import java.util.Date;
import model.enums.CONNECTSTATUS;
import model.company.Company;

public class Connection {
	
	 final String prefix = "connection-";
	 private static int nextId = 1;
     private String connectionId;
     
     private String firstName;
     private String lastName;
     private Date connectDate;
     private CONNECTSTATUS status;
     
     public Connection(String firstName, String lastName) {
    	 this.connectionId = prefix + nextId;
    	 this.firstName = firstName;
    	 this.lastName = lastName;
    	 this.connectDate = new Date(); //default to current date
    	 this.status = CONNECTSTATUS.SENTFOLLOWUPEMAIL; // default???
    	 nextId++;
     }
     
     public String getConnectionId() {
    	 return connectionId;
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
     
     public void updateStatus(CONNECTSTATUS newStatus) {
    	 this.status = newStatus;
     }

	public Company getCompany() {
		// TODO Auto-generated method stub
		return null;
	}
     
     
}
