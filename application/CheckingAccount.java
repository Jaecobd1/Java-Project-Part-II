package application;
public class CheckingAccount extends Account {
	int transactionCount;
	public CheckingAccount(Customer customer, double balance) {
		super(customer, balance);
		this.transactionCount = 0;
	}
	
	public void monthlyUpdates() {
		this.transactionCount = 0;
	}
	public void deposit(double amount) {
		transaction();
		this.balance = this.balance + amount;
		
	}
	public void withdraw(double amount) {
		if(this.balance > amount) {
			transaction();
			this.balance = this.balance - amount;
		}else {
			System.out.println("Could not complete withdraw,"
					+ "\nwithdraw limit: " + this.balance);
		}
	}
	private void transaction() {
		// Increase Transaction count
		this.transactionCount++;
		// Check if transactionCount is larger than 2
		if(this.transactionCount > 2) {
			// $3 charge
			this.balance = this.balance - 3;
		}
	}
	public String getAccountType() {
		return "Checking";
	}
}
