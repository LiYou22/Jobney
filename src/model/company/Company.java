package model.company;

public class Company {
    private String companyId;
    private String companyName;
    private INDUSTRY industry;
    private String website;
    private JobCatalog jobList; 
    
    public Company(String companyId, INDUSTRY industry, String companyName, String website) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.industry = industry;
        this.website = website;
        this.jobList = new JobCatalog(); // Initialize JobCatalog for the company
    }

    public JobCatalog getJobCatalog() {
        return jobList;
    }
    
    public String getCompanyName() {
    	return this.companyName;
    }


}
