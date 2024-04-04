package model.company;

import java.util.ArrayList;
import java.util.List;

public class CompanyCatalog {
	private List<Company> companies;

    public CompanyCatalog() {
        this.companies = new ArrayList<>();
    }

    public void addCompany(Company company) {
        companies.add(company);
    }

    public Company findCompanyByName(String name) {
        for (Company company : companies) {
            if (company.getCompanyName().equals(name)) {
                return company;
            }
        }
        return null; 
    }

    public void updateCompany(Company company) {
       
    }

    public void deleteCompany(Company company) {
        companies.remove(company);
    }

    public int countCompany() {
        return companies.size();
    }

//    public int countApplicationByCompany(String companyName) {
//    	
//    }


}
