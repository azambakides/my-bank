package com.mybank.account;

public class CheckingAccount extends AbstractAccount {

	
	//Generate constructors using fields
	public CheckingAccount(String customer, String accountName, double balance,
			String accountNumber) {
		super(customer, accountName, balance, accountNumber);
	}
	
	//Methods
	@Override
	public Double deposit(double amount) throws IllegalArgumentException {
		//Validate amount is good
		checkAmountIsPositveElseThrow(amount);
		
		return super.deposit(amount);
		
	}
	
	// returns the amount after withdrawing, if successful. Otherwise null
	@Override
	public Double withdraw(double amount) throws InsufficientFundsException {
		// Validate amount is good
		checkAmountIsPositveElseThrow(amount);
		// Validate that we have the funds
		checkForSufficientFundsElseThrow(amount);
		
		return super.withdraw(amount);
}
	
	@Override
	public Double transfer(AbstractAccount toAccount, double amount) throws InsufficientFundsException {
		//Validate the amount is good
		checkAmountIsPositveElseThrow(amount);
		checkForSufficientFundsElseThrow(amount);
		
		return super.transfer(toAccount, amount);
		}
	}
