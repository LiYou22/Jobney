package model.application;

import java.text.SimpleDateFormat;
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
//	private String jobName;
//	private String companyName;
    private String applicationId;
    private Date dateAdded;
    private String dateApplied;
    private Job associatedJob; 
    private RATE rate; 
    private Date applyDeadline;
    private APPLICATIONSTATUS status;
    private List<StatusChange> statusChangeHistory; 

    public Application(Job associatedJob) {
        this.associatedJob = associatedJob;
        this.applicationId = prefix + nextId;
        this.dateAdded = new Date();
        this.status = APPLICATIONSTATUS.TOAPPLY;
        this.dateApplied = "N/A";
        nextId++;
    }
    
    public Application(Job associatedJob, APPLICATIONSTATUS status, String dateApplied) {
        this.associatedJob = associatedJob;
        this.applicationId = prefix + nextId;
        this.dateAdded = new Date();
        this.status = status;
        this.dateApplied = dateApplied;
        nextId++;
    }

//    public Application(String jobName, String companyName, Date dateApplied, APPLICATIONSTATUS status) {
//        this.jobName = jobName;
//        this.companyName = companyName;
//        this.dateApplied = dateApplied;
//        this.status = status;
//        this.applicationId = prefix + nextId;
//        this.dateAdded = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
//        nextId++;
//    }
    
	public String getJobName() {
		return this.associatedJob.getJobName();
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
	
	 public String getDateAdded() {
	    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy");
        return formatter.format(this.dateAdded);
    }

	 public String getDateApplied() {
        return this.dateApplied;
    }

    public void setDateApplied() {
    	Date date = new Date();
	    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy");
        this.dateApplied = formatter.format(date);
    }
    
    public void setStatus(APPLICATIONSTATUS status) {
        this.status = status;
    }
    

}
