package model.application;

import java.util.Date;
import java.util.List;

import model.enums.APPLICATIONSTATUS;
import model.enums.RATE;
import model.job.Job;

public class Application {
	
	final String prefix = "application-";
	private static int nextId = 1;
    private String applicationId;
    
    private Job associatedJob; 
	private Date createDate;
    private RATE rate; 
    private Date applyDeadline;
    private APPLICATIONSTATUS status;
    private List<StatusChange> statusChangeHistory; 

    public Application(Job associatedJob) {
        this.associatedJob = associatedJob;
        this.applicationId = prefix + nextId;
        nextId++;
        this.createDate = new Date();
        this.status = APPLICATIONSTATUS.TOAPPLY;
        this.rate = RATE.ZERO;
    }

	public Job getAssociatedJob() {
		return this.associatedJob;
	}
	
	public String getApplicationId() {
		return this.applicationId;
	}
	
	public void setApplyDeadline(Date date) {
		this.applyDeadline = date;
	}
	
	public void setRate(RATE rate) {
		this.rate = rate;
	}
	


}
