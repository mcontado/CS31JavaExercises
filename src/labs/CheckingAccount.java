package labs;

public class CheckingAccount extends BankAccount {
	private static double FEE = 0.15;
	
	CheckingAccount(String name, double amount) {
		super(name, amount);
		super.setAccountNumber(getAccountNumber() + "-10");
	}
	
	public boolean withdraw(double amount) {
		
		amount += FEE;
		if (super.withdraw(amount))
			return true;
		else
			return false;
		
	}

}
