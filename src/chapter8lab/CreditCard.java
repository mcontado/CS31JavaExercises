package chapter8lab;

public class CreditCard {
	private Money balance;
	private Money creditLimit;
	private Person owner;
	
	//Constructor creates a credit card for the Person parameter
	// with an approved credit limit of the Money parameter
	// and sets the balance to a money amount of zero.
	public CreditCard(Person newCardHolder, Money limit) {
		owner = newCardHolder;
		balance = new Money(0);
		creditLimit = new Money(limit);
	}
	
	//Accessor method returns the balance
	public Money getBalance() {
		return new Money(balance);
	}
	
	//Accessor method returns the credit limit
	public Money getCreditLimit() {
		return new Money(creditLimit);
	}

	//Accessor method returns information about the owner
	public String getPersonals() {
		return owner.toString();
	}
	
	//Method to make a charge to the credit card, if the credit limit will not be exceeded
	public void charge(Money amount) {
		Money temp = new Money(balance.add(amount));
		if (temp.compareTo(creditLimit) > 0) {
			System.out.println("Exceeds credit limit");
		} else {
			balance = temp;
			System.out.println("Charge: " + amount);
		}
	}
	
	//Method to make payment to the credit card
	public void payment(Money amount) {
		balance = balance.subtract(amount);
		System.out.println("Payment: " + amount);
	}
	
	
	
	

}
