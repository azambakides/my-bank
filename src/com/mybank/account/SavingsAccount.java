package com.mybank.account;

public class SavingsAccount extends AbstractAccount {

	public SavingsAccount(String customer, String accountName, double balance,
			String accountNumber) {
		super(customer, accountName, balance, accountNumber);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Double deposit(double amount) throws IllegalArgumentException {
		// Validate amount is good
		checkAmountIsPositveElseThrow(amount);

		return super.deposit(amount);

	}
	
	@Override
	public Double withdraw(double amount) {
        throw new UnsupportedOperationException("Cannot withdraw from a savings accounts.");       
    }

	
	@Override
	public Double transfer(AbstractAccount toAccount, double amount) throws InsufficientFundsException {
	    // validate amount is good
	    checkAmountIsPositveElseThrow(amount);
	    checkForSufficientFundsElseThrow(amount);
		
		return super.transfer(toAccount, amount);		
	}
}