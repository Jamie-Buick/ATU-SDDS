package ie.atu.sw;

public interface IDCard {

	// Represents the entire card
	
	public void setEmployeeDetails(EmployeeDetails employee);		// Set employee details onto card
	EmployeeDetails getEmployee();				// Get employee details from card
	
	public void setCompanyDetails(CompanyDetails company);
	CompanyDetails getCompany();
	
}
