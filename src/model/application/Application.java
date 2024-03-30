package model.application;

import java.util.Date;
import java.util.List;

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

}
