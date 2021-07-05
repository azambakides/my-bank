package com.mybank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.mybank.account.AbstractAccount;
import com.mybank.account.CheckingAccount;
import com.mybank.account.InsufficientFundsException;
import com.mybank.account.SavingsAccount;

public class MusicalChairs {
	
	public static class AccountBalanceComparator implements Comparator<AbstractAccount> {

		@Override
		public int compare(AbstractAccount account1, AbstractAccount account2) {
			// Compare returns a negative number if account1 should be listed before account2
			// A positive number, if account 2 should be listed before account1
			// Returns 0, if they are considered the same
			if (account1.getBalance() > account2.getBalance()) {
				return -1;
			} else if (account1.getBalance() < account2.getBalance()) {
				return 1;
			} else {
				return 0;
			}
		}
	}

	public static void play() throws InsufficientFundsException {

		CheckingAccount one = new CheckingAccount("customer one", "customer one account", 100.0, "c1");
		SavingsAccount two = new SavingsAccount("saver two", "saver's savings account", 100.0, "s2");
		CheckingAccount three = new CheckingAccount("customer three", "customer three's account", 100.0, "c3");
		SavingsAccount four = new SavingsAccount("saver four", "saver four's savings account", 100.0, "s4");
		CheckingAccount five = new CheckingAccount("customer five", "customer five's account", 100.0, "c5");

		List<AbstractAccount> allAccounts = Arrays.asList(one, two, three, four, five);
		for (int amount = 1; amount < 1000; amount++) {
			int i = amount % 5;
			int j = (i + 1) % 5;
			AbstractAccount fromAccount = allAccounts.get(i);
			AbstractAccount toAccount = allAccounts.get(j);

			// transfer moniez!!!
			Double amountTransferred = fromAccount.transfer(toAccount, amount);
			// check if transfer worked, if not, break out of loop
			if (amountTransferred == null) {
				break;
			}
		}
		// print all balances at the end of the game
		// hint: System.out.println("Account one balance: " + one.getBalance());
		System.out.println("Account one balance is: " + one.getBalance());
		System.out.println("Account two balance is: " + two.getBalance());
		System.out.println("Account three balance is: " + three.getBalance());
		System.out.println("Account four balance is: " + four.getBalance());
		System.out.println("Account five balance: " + five.getBalance());
	}

	public static void playWithCollections() {

		System.out.println("Inside new play method!");

		// Generate 5 bank accounts, mix of checking and savings accounts
		// Different balances to start with
		List<AbstractAccount> accountsList = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			// create new account with a balance
			String customer = "Customer " + i;
			String accountName = "Account " + i;
			String accountNumber = String.valueOf(i);

			int balance = (i + 1) * 100;
			AbstractAccount thisAccount;
			if (i % 2 == 0) {
				// Checking
				thisAccount = new CheckingAccount(customer, accountName, balance, accountNumber);
			} else {
				// Savings
				thisAccount = new SavingsAccount(customer, accountName, balance, accountNumber);
			}
			// Add that account to a collection (list)
			accountsList.add(thisAccount);
		}

		System.out.println(accountsList);

		// Keep transferring money
		for (int amount = 1; amount < 2000; amount++) {
			int i = amount % 5;
			int j = (i + 1) % 5;
			AbstractAccount fromAccount = accountsList.get(i);
			AbstractAccount toAccount = accountsList.get(j);

			// Transfer moniez!!!
			try {
				fromAccount.transfer(toAccount, amount);
			} catch (InsufficientFundsException e) {
				break;
			}
		}

		// Print winners / losers. Just print all accounts
		for (AbstractAccount account : accountsList) {
			System.out.println(account.getAccountName() + " - balance : " + account.getBalance());
		}
	}

	public static void playWithSet() {
		System.out.println("Inside play with set:");

		// Generate 5 bank accounts, mix of checking and savings accounts
		// Different balances to start with
		List<AbstractAccount> accountsList = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			// create new account with a balance
			String customer = "Customer " + i;
			String accountName = "Account " + i;
			String accountNumber = String.valueOf(i);

			int balance = (i + 1) * 100;
			AbstractAccount thisAccount;
			if (i % 2 == 0) {
				// Checking
				thisAccount = new CheckingAccount(customer, accountName, balance, accountNumber);
			} else {
				// Savings
				thisAccount = new SavingsAccount(customer, accountName, balance, accountNumber);
			}
			// Add that account to a collection (List)
			accountsList.add(thisAccount);
			// Add it again
			accountsList.add(thisAccount);
		}

		System.out.println(accountsList);

		// Find the unique set inside accounts list
		Set<AbstractAccount> uniqueAccounts = new HashSet<>(accountsList);

		System.out.println("Unique accounts: " + uniqueAccounts);
	}

	public static void playWithMap() {
		System.out.println("Play with Map:");

		// Generate 5 bank accounts, mix of checking and savings accounts
		// Different balances to start with
		// Chuck them into a map with their account number as key
		Map<String, AbstractAccount> accountsMap = new HashMap<>();

		for (int i = 0; i < 5; i++) {
			// create new account with a balance
			String customer = "Customer " + i;
			String accountName = "Account " + i;
			String accountNumber = "#" + i;

			int balance = (i + 1) * 100;
			AbstractAccount thisAccount;
			if (i % 2 == 0) {
				// Checking
				thisAccount = new CheckingAccount(customer, accountName, balance, accountNumber);
			} else {
				// Savings
				thisAccount = new SavingsAccount(customer, accountName, balance, accountNumber);
			}
			// Add that account to a collection (Map)
			accountsMap.put(accountNumber, thisAccount);
		}

		System.out.println(accountsMap);

		// We can fetch the keys
		accountsMap.keySet();

		// or a list of all the values
		accountsMap.values();

	}

	public static void playWithSorting() {
		
		System.out.println("Inside pLay with sorting:");

		// Different balances to start with
		List<AbstractAccount> accountsList = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			// create new account with a balance
			String customer = "Customer " + i;
			String accountName = "Account " + i;
			String accountNumber = String.valueOf(i);

			int balance = (i + 1) * 100;
			AbstractAccount thisAccount;
			if (i % 2 == 0) {
				// Checking
				thisAccount = new CheckingAccount(customer, accountName, balance, accountNumber);
			} else {
				// Savings
				thisAccount = new SavingsAccount(customer, accountName, balance, accountNumber);
			}
			// Add that account to a collection (list)
			accountsList.add(thisAccount);
		}

		System.out.println(accountsList);
		
		// Sort the list by the balance
		accountsList.sort(new AccountBalanceComparator());
		System.out.println("Sorted by highest balance first: " + accountsList);
		
		//TreeSet
		//will remove duplicates
		Set<AbstractAccount> sortedSet = new TreeSet<>(new AccountBalanceComparator());
		sortedSet.addAll(accountsList);
		System.out.println("Sorted with a TreeSet: " + sortedSet);
	}
}
