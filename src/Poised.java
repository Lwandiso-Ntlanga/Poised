import java.util.Scanner;
import java.util.Date;

public class Poised {

	public static void main(String[] args) {
		
		//project attributes
		int projectNumber; 
		int erfNumber;
		String projectName = " "; 
		String buildingType; 
		String projectAddress; 
		String projectDeadline;
		double projectFee;
		double amountPaid;
		
		//architect attributes
		String architectName; 
		String architectEmail; 
		String architectAddress;
		int architectTelephoneNumber;
		
		//contractor attributes
		String contractorName;
		String contractorEmail;
		String contractorAddress;
		int contractorTelephoneNumber;
		
		//customer attributes
		String customerName;
		String customerSurname;
		String customerEmail;
		String customerAddress;
		int customerTelephoneNumber;
		
		Scanner input = new Scanner(System.in);
		
		//customer details
		System.out.println("---Fill in customer details---\n");
		System.out.println("Customer first name: ");
		customerName = input.nextLine();
		
		System.out.println("Customer surname: ");
		customerSurname = input.nextLine();
		
		System.out.println("Customer email: ");
		customerEmail = input.nextLine();
		
		System.out.println("Customer Address: ");
		customerAddress = input.nextLine();
		
		System.out.println("Customer Telephone: ");
		customerTelephoneNumber = input.nextInt();
		
		//add customer contact details
		Person customerObject = new Person(customerName, customerEmail, customerAddress, customerTelephoneNumber);
		
		//project details
		System.out.println("---Fill in the project details---\n");		
		System.out.println("Project numebr: ");
		projectNumber = input.nextInt();
		input.nextLine();
		
		System.out.println("Project name: ");
		projectName = input.nextLine();
		
		System.out.println("Building type(House, Apartment, Store etc): ");
		buildingType = input.nextLine();
		
		System.out.println("Project address: ");
		projectAddress = input.nextLine();
		
		System.out.println("ERF number: ");
		erfNumber = input.nextInt();
		
		System.out.println("Project Fee: ");
		projectFee = input.nextDouble();
		
		System.out.println("Deposit amount: ");
		amountPaid = input.nextDouble();
		input.nextLine();
		
		System.out.println("Project deadline date(dd/mm/yyyy): ");
		projectDeadline = input.nextLine();
		
		//add project details
		Project projectObject = new Project(projectNumber, projectName, buildingType, projectAddress, erfNumber, projectFee, amountPaid, projectDeadline, customerSurname);		
		
		//architect contact details
		System.out.println("---Fill in architect details---\n");
		System.out.println("Architect full name: ");
		architectName = input.nextLine();
		
		System.out.println("Architect email: ");
		architectEmail = input.nextLine();
		
		System.out.println("Architect address: ");
		architectAddress = input.nextLine();
		
		System.out.println("Architect telephone: ");
		architectTelephoneNumber = input.nextInt();
		input.nextLine();
		
		//add architect contact details
		Person architectObject = new Person(architectName, architectEmail, architectAddress, architectTelephoneNumber);
		
		//contractor contact details
		System.out.println("---Fill in contractor details---\n");
		System.out.println("Contractor full name: ");
		contractorName = input.nextLine();
		
		System.out.println("Contractor email: ");
		contractorEmail = input.nextLine();
		
		System.out.println("Contractor address: ");
		contractorAddress = input.nextLine();
		
		System.out.println("Contractor telephone: ");
		contractorTelephoneNumber = input.nextInt();		
		
		//add contractor contact details
		Person contractorObject = new Person(contractorName, contractorEmail, contractorAddress, contractorTelephoneNumber);
		
		//update info
		char update;
		char choice;
		char complete = 'n';
		
		do {
			//asks the user if they want to make changes, loops until they select no
			System.out.println("\nDo you want to update the project info?(y/n): ");
			update = input.next().charAt(0);
			
			//if user wants to make changes.
			if(Character.toLowerCase(update) == 'y') {
				
				System.out.println("\nEnter what you would like to update(d- deadline, f- fee paid, c- contractor's contacts).");
				choice = input.next().charAt(0);
				
				//changes the deadline
				if(Character.toLowerCase(choice) == 'd') {
					projectObject.updateDeadline();
				}
				
				//changes the project fee paid
				else if(Character.toLowerCase(choice) == 'f') {
					projectObject.updateFee();
				}
				
				//changes the contractor's contact details
				else if(Character.toLowerCase(choice) == 'c') {
					contractorObject.displayContactDetails();
					contractorObject.updateContactDetails();
				}
				
				//if input is not d, f or c.
				else {
					System.out.println("Invalid entry.");
				}
			}
			
			//changes the control value to n to exit loop. Not anymore!!!!!
			else if(Character.toLowerCase(update) == 'n') {
				update = 'n';
			}
			
			//if input is not y or n
			else {
				System.out.println("Invalid entry.");
			}
			
			System.out.println("\nFinalise project (i- get invoice, d- to display project details, b- go back, e- end program): ");
			choice = input.next().charAt(0);
			
			//gets the invoice
			if(choice == 'i') {
				Date completeDate = new Date();
				//checks if fee is paid before creating invoice
				if(projectObject.getFee() == 0) {
					//if the customer paid their amount then no invoice will be generated
					System.out.println("\nInvoice not available, No outstanding amount, finalised on " + completeDate);
				}
				
				//invoice customer contact details with outstanding amount
				else if(projectObject.getFee() != 0) {
					customerObject.displayContactDetails();
					System.out.println("\nThe outstanding amount is: R" + projectObject.getFee());
				}
			}
			
			//displays all project information
			else if(choice == 'd') {
				System.out.println("\n---Customer details---");
				customerObject.displayContactDetails();
				
				System.out.println("\n\n---Architect details---");
				architectObject.displayContactDetails();
				
				System.out.println("\n\n---Contractor details---");
				contractorObject.displayContactDetails();
				
				System.out.println("\n\n---Project details---");
				projectObject.displayProjectDetails();
			}
			
			//ends the loop thus also ending the program
			else if(choice == 'e') {
				complete = 'y';
				System.out.println("\n---Program ended---");
			}
			
		//if project isn't done 
		}while(Character.toLowerCase(complete) == 'n');

		input.close();
	}

}
