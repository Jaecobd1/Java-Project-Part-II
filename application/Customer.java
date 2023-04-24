package application;
import java.util.ArrayList;
public class Customer {
	String customerID, firstName, lastName, Address, phoneNumber;
	ArrayList<Account> accounts = new ArrayList<Account>();
	
	
	public Customer(String customerID, String firstName, String lastName, 
			String Address, String phoneNumber) {
		this.customerID = customerID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.Address = Address;
		this.phoneNumber = phoneNumber;
	}
	
	public String getCustomerID() {
		return this.customerID;
	}
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	public String getAddress() {
		return this.Address;
	}
	
	public void getCustomerInfo() {
		System.out.println( this.firstName + " " + this.lastName 
				+ "\nCustomerID: " + this.customerID 
				+ "\nAddress: " + this.Address
			+ "\nPhone Number: " + this.phoneNumber);
	}
	public ArrayList<Account> getAccounts() {
		return this.accounts;
	}
	public void addAccount(Account account) {
		accounts.add(account);
	}
	public String toString() {
		return (this.firstName + " " + this.lastName);
	}
	public String getFirstName() {
		return this.firstName;
	}
	
}
