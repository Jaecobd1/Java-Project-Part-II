package application;

abstract class Account {
	static int accountNumberCount;
	private int accountNumber;
	public double balance;
	private Customer customer;
	public Account(Customer customer, double balance) {
		this.accountNumber = accountNumberCount + 1;
		this.customer = customer;
		accountNumberCount++;
		this.balance = balance;
	
		
	}
	
	public double getBalance() {
		return this.balance;
	}
	public void deposit(double amount) {
		this.balance = this.balance + amount;
	}
	public void withdraw(double amount) {
		this.balance = this.balance - amount;
	}
	public int getAccountNumber() {
		return this.accountNumber;
	}
	public Customer getCustomer() {
		return this.customer;
	}
	public void monthlyUpdates() {
		// Placeholder for main.java
		// Real updates within specific accounts
	}
	public void getAccountInfo() {
		
		System.out.println("Account#: " + this.accountNumber 
				+ "\nbalance: $" + this.balance + "\nCustomer: " 
				+ this.customer);
		
	}
	
	public void removeAccount(Account account) {
		this.customer.accounts.remove(account);
	}
	abstract String getAccountType();
	
	
}
