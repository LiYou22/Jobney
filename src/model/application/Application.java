package model.application;

import java.util.Date;
import java.util.List;

import model.enums.APPLICATIONSTATUS;
import model.enums.RATE;
import model.job.Job;

public class Application {
    private String applicationId;
    private Job associatedJob; 
    private RATE rate; 
    private Date applyDeadline;
    private APPLICATIONSTATUS status;
    private List<StatusChange> statusChangeHistory; 

    public Application(Job associatedJob) {
        this.associatedJob = associatedJob;
    }

	public Job getAssociatedJob() {
		// TODO Auto-generated method stub
		return null;
	}

}
