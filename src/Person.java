import java.util.Scanner;

public class Person {
	//attributes
	String name;	
	String email; 
	String address;
	int telephoneNumber;	
	String output;
	
	Scanner input = new Scanner(System.in);
	
	//constructor 
	public Person(String name, String email, String address, int telephoneNumber) {
		this.name = name; 
		this.email = email; 
		this.address = address;
		this.telephoneNumber = telephoneNumber;
	}
	
	//update contractor's contact details
	public void updateContactDetails() {
		System.out.println("Edit contact details. \n");
		
		System.out.println("Email: ");
		this.email = input.nextLine();
		
		System.out.println("Telephone: ");
		this.telephoneNumber = input.nextInt();
	}
	
	//
	public void displayContactDetails() {
		output = "Name: " + name;
		output += "\nEmail: " + email;
		output += "\nAddress: " + address;
		output += "\nTelephone: " + telephoneNumber;
		
		System.out.print(output);
	}
}
