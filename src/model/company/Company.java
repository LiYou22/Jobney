package model.company;

import model.enums.INDUSTRY;
import model.job.JobCatalog;

public class Company {
	
	final String prefix = "company-";
	private static int nextId = 1;
    private String companyId;
    
    private String companyName;
    private INDUSTRY industry;
    private JobCatalog jobList; 
    
    public Company(INDUSTRY industry, String companyName) {
        this.companyId = prefix + nextId;
        this.companyName = companyName;
        this.industry = industry;
        this.jobList = new JobCatalog();
        nextId++;
    }
    
    public String getCompanyId() {
    	return this.companyId;
    }

    public JobCatalog getJobCatalog() {
        return jobList;
    }
    
    public String getCompanyName() {
    	return this.companyName;
    }


}
