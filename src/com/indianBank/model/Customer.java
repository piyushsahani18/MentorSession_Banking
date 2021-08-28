package com.indianBank.model;

public class Customer {

	private int BankAccountNo;
	private String password;
	private int Balance;

	// Default Constructor
	public Customer() {
		super();
	}

	public int getBalance() {
		return Balance;
	}

	public void setBalance(int balance) {
		Balance = balance;
	}

	// Constructor with Fields
	public Customer(int bankAccountNo, String password, int balance) {
		super();
		BankAccountNo = bankAccountNo;
		this.password = password;
		Balance = balance;
	}
	

	public Customer(int bankAccountNo, String password) {
		BankAccountNo = bankAccountNo;
		this.password = password;
	}

	// Getters and Setters
	public int getBankAccountNo() {
		return BankAccountNo;
	}




	public void setBankAccountNo(int bankAccountNo) {
		BankAccountNo = bankAccountNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
