import java.util.Scanner;

public class Project {
	//project attributes
	int projectNumber; 
	int erfNumber;
	String projectName; 
	String buildingType; 
	String projectAddress; 
	String projectDeadline;
	double projectFee;
	double amountPaid;
	double totalFee;
	double totalPaid;
	String output;
	
	//customer attributes
	String customerSurname;
	
	Scanner input = new Scanner(System.in);
	
	public Project(int projectNumberP, String projectNameP, String buildingTypeP, String projectAddressP, int erfNumberP, double projectFeeP, double amountPaidP, String projectDeadlineP, String customerSurnameP) {
		projectNumber = projectNumberP;
		this.erfNumber = erfNumberP;		
		this.buildingType = buildingTypeP;
		this.projectAddress = projectAddressP;
		this.projectDeadline = projectDeadlineP;
		this.projectFee = projectFeeP;
		this.totalFee = projectFee;
		this.totalPaid = amountPaidP;
		this.totalFee -= amountPaidP;
		this.customerSurname = customerSurnameP;
		
		if(projectNameP.equals(" ")) {
			this.projectName = buildingTypeP + " " + customerSurnameP;
		}
		else {
			this.projectName = projectNameP;
		}		
	}
	//sets new deadline
	public void updateDeadline() {
		System.out.println("Enter the new date(dd/mm/yyyy): ");
		this.projectDeadline = input.nextLine();
	}
	
	public void updateFee() {
		System.out.println("\n---Update payment---");		
		
		if(totalFee != 0) {
			System.out.println("Outstanding amount: R" + totalFee);
			
			//customer makes payment to outstanding fee
			System.out.println("Enter payment amount: ");			
			this.amountPaid = input.nextDouble();
			this.totalPaid += amountPaid;
			this.totalFee -= amountPaid;
		}
		//if customer paid amount in full.
		if(totalFee == 0){
			System.out.println("Project Fee fully paid.");
		}
	}
	
	public double getFee() {
		return totalFee;
	}
	
	public void displayProjectDetails() {
		output = "Project number: " + projectNumber;
		output += "\nProject name: " + projectName;
		output += "\nBuilding Type: " + buildingType;
		output += "\nProject address: " + projectAddress;
		output += "\nERF number: " + erfNumber;
		output += "\nProject fee: R" + projectFee;
		output += "\nAmount paid: R" + totalPaid;
		output += "\nProject deadline: " + projectDeadline;
		
		System.out.println(output);
		
	}
}
