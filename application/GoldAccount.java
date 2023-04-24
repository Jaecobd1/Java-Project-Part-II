package application;
public class GoldAccount extends Account {
	public GoldAccount(Customer customer, double balance) {
		super(customer, balance);
		
	}
	
	// Compound Interests at 5%;
	public void monthlyUpdates() {
		this.balance = this.balance + this.balance * 0.05;
	}
	public String getAccountType() {
		return "Gold";
	}
}
