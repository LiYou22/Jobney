import model.application.Application;
import model.company.Company;
import model.enums.INDUSTRY;
import model.job.Job;
import model.note.Note;
import model.question.Question;
import model.question.QuestionList;
import model.user.*;

public class Initializer {

    public static void initializeData(AdminUser administrator) {
    	

	    // Initialize a test user
	    RegularUser testUser = new RegularUser("user@gmail.com", "1111");
	    administrator.getUserDirectory().addUser(testUser);
	    
	    // create user profile
	    Profile profile1 = new Profile("Bruno");
	    testUser.setAssociatedProfile(profile1);
	    
	    // create a company
	    Company com1 = new Company(INDUSTRY.FINTECH,"PayPal");
	    Company com2 = new Company(INDUSTRY.TECH,"Google");
	    Company com3 = new Company(INDUSTRY.TECH,"Apple");
	    Company com4 = new Company(INDUSTRY.EDUCATION,"SYMPLICITY CORPORATION");
	    administrator.getCompanyCatalog().addCompany(com1);
	    administrator.getCompanyCatalog().addCompany(com2);
	    administrator.getCompanyCatalog().addCompany(com3);
	    administrator.getCompanyCatalog().addCompany(com4);
	    
	    // create a job under the company
	    Job job1 = new Job(com1, "Software Engineer Intern", "https://paypal.eightfold.ai/careers?Codes=W-LINKEDIN&domain=paypal.com&query=R0111038&sort_by=relevance");
	    Job job2 = new Job(com2, "Software Engineering Intern, People with Disabilities 2024", "https://www.google.com/about/careers/applications/jobs/results/133383757286515398-software-engineering-intern-people-with-disabilities-2024");
	    Job job3 = new Job(com3, "AIML - Software Engineering Internship - Multiple Party Computation, MLPT", "https://jobs.apple.com/en-us/details/200519066/aiml-software-engineering-internship-multiple-party-computation-mlpt?team=STDNT");
	    Job job4 = new Job(com4, "Software Development Intern", "https://builtin.com/job/software-development-intern/110908");
	    // Create additional jobs and applications for the first company
	    Job job5 = new Job(com1, "Software Engineer", "https://paypal.eightfold.ai/careers?Codes=W-LINKEDIN&domain=paypal.com&query=R0111039&sort_by=relevance");
	    Job job6 = new Job(com1, "Data Scientist Intern", "https://paypal.eightfold.ai/careers?Codes=W-LINKEDIN&domain=paypal.com&query=R0111040&sort_by=relevance");
	    
	    // create an application using the job
	    Application app1 = new Application(job1, testUser);
	    Application app2 = new Application(job2, testUser);
	    Application app3 = new Application(job3, testUser);
	    Application app4 = new Application(job4, testUser);
	    Application app5 = new Application(job5, testUser);
	    Application app6 = new Application(job6, testUser);
	    
	    // create notes under one application
	    Note note1 = new Note("company info", "PayPal is a global online payment system that serves as an electronic alternative to traditional paper methods such as checks, money orders, and cash transactions. Founded in 1998 in the United States and initially a subsidiary of eBay, it was spun off into its own company in 2015. Today, PayPal operates in more than 200 countries, allowing customers to send, receive, and hold funds in 25 currencies worldwide. The company's payment solution simplifies online transactions between businesses and consumers, providing secure and convenient digital payment options. PayPal continuously innovates its technology platform to reduce fraud risks and make online shopping easier, safer, and more user-friendly");
	    Note note2 = new Note("job keywords", "detail oriented, React, Robotics experience is a plus");
	    Note note3 = new Note("insights", "aligsn with my interest, but lack of some skills that mentioned in the job descriptioin.");
	    
//	    app1.getNoteList().addNote(note1);
//	    app1.getNoteList().addNote(note2);
//	    app1.getNoteList().addNote(note3);
	    
	    // add application to the user
	    testUser.getApplicationList().addApplication(app1);
	    testUser.getApplicationList().addApplication(app2);
	    testUser.getApplicationList().addApplication(app3);
	    testUser.getApplicationList().addApplication(app4);
	    testUser.getApplicationList().addApplication(app5);
	    testUser.getApplicationList().addApplication(app6);

	    testUser.getCompanyList().addCompany(com1);
	    testUser.getCompanyList().addCompany(com2);
	    testUser.getCompanyList().addCompany(com3);
	    testUser.getCompanyList().addCompany(com4);

	    //add application to company
	    com1.addApplication(app1);
	    com1.addApplication(app5);
	    com1.addApplication(app6);
	    com2.addApplication(app2);
	    com3.addApplication(app3);
	    com4.addApplication(app4);
	   
	 // Create some questions
	    Question question1 = new Question("What are the job responsibilities?");
	    question1.addAnswer("Design, develop, and test software");
	    question1.addAnswer("Collaborate with cross-functional teams");
	    question1.addFrequency();

	    Question question2 = new Question("What are the required qualifications?");
	    question2.addAnswer("Bachelor's degree in Computer Science or related field");
	    question2.addAnswer("Experience with Java and Python");
	    question2.addFrequency();

	    Question question3 = new Question("What is the application process?");
	    question3.addAnswer("Submit resume and cover letter");
	    question3.addAnswer("Complete online coding test");
	    question3.addFrequency();
	    
	    

	    // Create a question list and associate it with an application
//	    List<Question> questions = Arrays.asList(question1, question2, question3);
//	    QuestionList questionList = new QuestionList("application-1", questions);
//	    questionList.addQuestion(question1);
//	    questionList.addQuestion(question2);
//	    questionList.addQuestion(question3);
	    
	    QuestionList ql1 = app1.getQuestionList();
	    ql1.addQuestion(question1);
	    ql1.addQuestion(question2);
	    ql1.addQuestion(question3);
	    
	    
	    
	    
	    // for testing 
	    System.out.print("---> user directory: \n" + administrator.getUserDirectory());
	    System.out.print("---> compay catalog: \n" + administrator.getCompanyCatalog());

    
    
    }
}