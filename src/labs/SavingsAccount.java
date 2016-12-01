package labs;

public class SavingsAccount extends BankAccount{
	//annual interest rate 2.5%
	private double rate = .025;
	private int savingsNumber = 0;
	private String accountNumber;
	
	//normal parameterized constructor
	SavingsAccount(String name, double amount) { 
		super(name, amount);
		accountNumber = super.getAccountNumber() + "-" + savingsNumber;
		//super.setAccountNumber(getAccountNumber() + "-" + savingsNumber);
	}
	
	//copy constructor
	SavingsAccount(SavingsAccount account, double amount) {
		//call the copy constructor of the super class
		super(account, amount);
		//assign savingsNumber to be one more than the savings number of the original savings account.
		savingsNumber = savingsNumber+1;
		// assign the accountNumber to be the accountNumber of the superclass concatenated with the hypen 
		// and the savingsNumber of the new account.
		accountNumber = super.getAccountNumber() + "-" + savingsNumber;
	}

	//calculate one month's worth of interest on the balance and deposit it into the account.
	void postInterest() {
		double interest = (getBalance() * rate) / 12;
		setBalance(getBalance() + interest); 
	}
	
	public String getAccountNumber() {
		return this.accountNumber;
	}
}
