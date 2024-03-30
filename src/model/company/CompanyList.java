package model.company;

import java.util.ArrayList;
import java.util.List;

public class CompanyList {
	private List<Company> companies;

    public CompanyList() {
        this.companies = new ArrayList<>();
    }

    public void addCompany(Company company) {
        companies.add(company);
    }

    public void updateCompany(Company company) {

    }

    public void deleteCompany(Company company) {
        companies.remove(company);
    }

    public int countCompany() {
        return companies.size();
    }

    public int countApplicationByCompany(String companyName) {
        return 0;
    }

    // Additional helper methods could include:
    public Company findCompanyByName(String name) {
        for (Company company : companies) {
            if (company.getCompanyName().equals(name)) {
                return company;
            }
        }
        return null;
    }

    public List<Company> getCompanies() {
        return new ArrayList<>(companies); 
    }
	
}
