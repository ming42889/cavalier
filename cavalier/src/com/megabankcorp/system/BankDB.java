package com.megabankcorp.system;

import com.megabankcorp.records.Account;
public abstract class BankDB {
	abstract void deposit(Account a, long amount);
	abstract void withdraw(Account a, long amount);
	abstract int checkBalance(Account a);
	
	void transfer(Account from, Account to, long amount){
		withdraw(from, amount);
		deposit(to, amount);
	}

}
