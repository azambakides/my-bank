package com.mybank.account;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CheckingAccountTest {
	// Class under test
	CheckingAccount account;
	
	@BeforeEach
	void setup() {
		this.account = new CheckingAccount(
				"customer 1",
				"test account",
				0,
				"test account number"
				);
	}
	
	@Test
	void deposit__amount_greater_than_zero__works() {
		// Try with good amount (greater than zero)
		double amount = 42.0;
		
		// Do the actual test
		account.deposit(amount);
		
		// Get the actual balance 
		double balance = account.getBalance();
		
		// Check it did work
		assertEquals(amount, balance);

	}
	
	@Test
	void deposit__amount_less_than_zero__throws() {
		// Bad amount
		double amount =-1.0;
		
		// Do it
		assertThrows(IllegalArgumentException.class, () -> {
			account.deposit(amount);
		});
	}
	
	@Test
	void deposit__amount_equal_to_zero__throws() {
		// Another bad amount
		double amount = 0.0;
		
		//Do it
		assertThrows(IllegalArgumentException.class, () -> {
			account.deposit(amount);
		});
	}
}
