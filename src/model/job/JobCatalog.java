package model.job;

import java.util.ArrayList;
import java.util.List;


public class JobCatalog {
	
	private List<Job> jobs;

    public JobCatalog() {
        this.jobs = new ArrayList<>();
    }

    public void addJob(Job job) {
        jobs.add(job);
    }

    public void updateJob(Job updatedJob) {
    	for(int i = 0 ; i < jobs.size(); i++) {
    		Job job = jobs.get(i);
    		if(job.getJobId() == updatedJob.getJobId()) {
    			job.setJobName(updatedJob.getJobName());
    			job.setAssociatedCompany(updatedJob.getAssociatedCompany());
    			job.setJobLink(updatedJob.getJobLink());
    		}
    	}
    }

    public void deleteJob(Job job) {
        jobs.remove(job);
    }

    public Job findJobByName(String name) {
        for (Job job : jobs) {
            if (job.getJobName().equals(name)) {
                return job;
            }
        }
        return null; 
    }

    public List<Job> getJobs() {
        return new ArrayList<>(jobs);

    }
}
