package model.application;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import model.enums.APPLICATIONSTATUS;
import model.enums.RATE;
import model.job.Job;

public class Application {
	
	final String prefix = "application-";
	private static int nextId = 1;
	private String jobName;
	private String companyName;
    private String applicationId;
    private Date dateAdded;
    private Date dateApplied;
    private Job associatedJob; 
    private RATE rate; 
    private Date applyDeadline;
    private APPLICATIONSTATUS status;
    private List<StatusChange> statusChangeHistory; 

    public Application(Job associatedJob) {
        this.associatedJob = associatedJob;
        this.applicationId = prefix + nextId;
        this.dateAdded = new Date(); // set the date added to the current date
        nextId++;
    }

    public Application(String jobName, String companyName, Date dateApplied, APPLICATIONSTATUS status) {
        this.jobName = jobName;
        this.companyName = companyName;
        this.dateApplied = dateApplied;
        this.status = status;
        this.applicationId = prefix + nextId;
        this.dateAdded = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
        nextId++;
    }
    
	public Job getAssociatedJob() {
		return this.associatedJob;
	}
	
	public String getCompanyName() {
		return this.associatedJob.getAssociatedCompany().getCompanyName();
	}
	
	public String getApplicationId() {
		return this.applicationId;
	}

	public RATE getRate() {
		return this.rate;
	}
	
	public Date getApplyDeadline() {
		return this.applyDeadline;
	}
	
	public APPLICATIONSTATUS getStatus() {
		return this.status;
	}
	
	public List<StatusChange> getStatusChangeHistory(){
	 return this.statusChangeHistory;
	}
	
	 public Date getDateAdded() {
        return this.dateAdded;
    }

	 public Date getDateApplied() {
        return this.dateApplied;
    }

    public void setDateApplied(Date dateApplied) {
        this.dateApplied = dateApplied;
    }
    
    public void setStatus(APPLICATIONSTATUS status) {
        this.status = status;
    }
    

}
