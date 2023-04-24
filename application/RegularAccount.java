package application;
public class RegularAccount extends Account {
	public RegularAccount(Customer customer, double balance) {
		super(customer, balance);
	}
	
	public void monthlyUpdates() {
		// Charge Interest and charge $10 a month
		this.balance = this.balance + this.balance * 0.06;
		this.balance = this.balance - 10;
	}
	
	public void withdraw(int amount) {
		if(this.balance > amount) {
			this.balance = this.balance - amount;
			
		}else {
			System.out.println("Could not complete withdraw,"
					+ "\nwithdraw limit: " + this.balance);
		}
	}
	
	public String getAccountType() {
		return "Regular";
	}
	
	
}
