package model.application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.enums.INDUSTRY;

public class ApplicationList {
	private List<Application> applications;

    public ApplicationList() {
        this.applications = new ArrayList<>();
    }

    public List<Application> getApplicationList() {
        return applications;
    }

    public void addApplication(Application application) {
        applications.add(application);
    }

    public void updateApplication(Application application) {
        // Logic to update an application in the list
    }

    public void deleteApplication(Application application) {
        applications.remove(application);
    }
    
    public Application findApplicationByName(String name) {
        for (Application app : applications) {
            if (app.getAssociatedJob().getJobName().equals(name)) {
                return app;
            }
        }
        return null; 
    }

    // Method stubs are added below. They need to be implemented as per the specific logic.
    public int countTotalApplications() { return applications.size(); }

    public List<Application> listApplicationByIndustry(INDUSTRY industry) {
    	return null;
    }

}
