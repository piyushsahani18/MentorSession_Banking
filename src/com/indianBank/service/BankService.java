package com.indianBank.service;

import java.util.Scanner;
import com.indianBank.database.CustomerDataBase;
import com.indianBank.model.Customer;

public class BankService {

	int amount, updatedBalance;
	int accountNum;
	Scanner scanner = new Scanner(System.in);

	Customer customer1 = new Customer();
	OtpGenerator otp = new OtpGenerator();
	public CustomerDataBase database = new CustomerDataBase();

	// Initialization of the DataBase
	public void prefetchDataBase() {
		database.AddCustomerDatabase();
	}

	// Validating the Login

	public void deposit(Customer customer1) {

		System.out.println("Enter the Amount You want to Deposit");
		amount = scanner.nextInt();
		updatedBalance = customer1.getBalance() + amount;
		customer1.setBalance(updatedBalance);
		System.out.println("Amount Deposited Successfully - Your CurrentBalance is " + updatedBalance);

	}

	public void withdraw(Customer customer1) {

		if (customer1.getBalance() < 1000) {
			System.out.println("Your Account balance is Low ");

		} else {
			System.out.println("Enter the Amount You want to Withdraw");
			amount = scanner.nextInt();
			if (customer1.getBalance() > amount) {
				updatedBalance = customer1.getBalance() - amount;
				customer1.setBalance(updatedBalance);
				System.out.println("Withdraw Successful - " + "Your CurrentBalance is " + updatedBalance);
			}else System.out.println("Low Balance");
		}
	}

	public void transfer(Customer customer1) {
		Customer customertoTransfer = new Customer();
		if (customer1.getBalance() > 1000) {
			System.out.println("Enter the accountNo of customer to transfer funds");
			accountNum = scanner.nextInt();

			if (CheckCustomerInDataBase(customertoTransfer) != null) {
                Customer foundcustomer = CheckCustomerInDataBase(customertoTransfer);
				int sentOtp = otp.generateOTP();
				System.out.println(sentOtp);
				System.out.println(" Enter the Received otp");
				int receivedOtp = scanner.nextInt();

				if (sentOtp == receivedOtp) {
					System.out.println("Enter the amount to transefer");
					int amount = scanner.nextInt();
					foundcustomer.setBalance(foundcustomer.getBalance()+amount);		
				    updatedBalance = customer1.getBalance() - amount;
				    customer1.setBalance(updatedBalance);
					System.out.println("Transfer Successful - " + "Your CurrentBalance is " + updatedBalance);

				}
			}
		} else
			System.out.println("You Account Balance is less than 1000");
	}

	public void logout() {
		System.out.println("Logout- Successful - Visit Again_Indian Bank");
	}

	public Customer CheckCustomerInDataBase(Customer cusotmer) {
		// TODO Auto-generated method stub
		//Customer customer2= new Customer();
		Customer[] allCustomers = database.customers;
		allCustomers = database.getCustomerDatabase();
		for (int i = 0; i < allCustomers.length; i++) {
			if (allCustomers[i].getBankAccountNo() == accountNum)
				cusotmer = allCustomers[i];
		}
		return cusotmer;

	}
}
