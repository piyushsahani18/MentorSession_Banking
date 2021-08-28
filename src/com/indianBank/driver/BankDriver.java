package com.indianBank.driver;

import java.util.Scanner;
import com.indianBank.model.Customer;
import com.indianBank.service.BankService;

public class BankDriver {

	public static void main(String[] args) {

		BankService bankservice = new BankService();
		bankservice.prefetchDataBase();
		bankservice.database.getCustomerDatabase();
		Customer allCustomers[] = bankservice.database.customers;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int option = 0;
		// Input from Console

		System.out.println("======Welocome to the Indian Bank - Banking Always======");

		System.out.println("Enter your Account Number");
		int accountNumber = scanner.nextInt();
		System.out.println("Enter your Account Password");
		String pass = scanner.next();
		// int balance = customer.getBalance();
		Customer loggedInCustomer = new Customer(accountNumber, pass, 0);

		for (int i = 0; i < allCustomers.length; i++) {
			System.out.println(allCustomers[i].getBankAccountNo() + " " + allCustomers[i].getPassword() + " "
					+ allCustomers[i].getBalance());
		}

		if (validateCustomer(loggedInCustomer, allCustomers) != null) {
			loggedInCustomer = validateCustomer(loggedInCustomer, allCustomers);

			System.out.println("Enter 1 for Deposit");
			System.out.println("Enter 2 for Withdraw");
			System.out.println("Enter 3 for Transfer");
			System.out.println("Enter 4 for Logout");
			System.out.println("------------------------");
			do {
				System.out.println("\nEnter the Operation you want to Perform \n");
				option = scanner.nextInt();
				switch (option) {
				case 1:
					bankservice.deposit(loggedInCustomer);
					break;

				case 2:
					bankservice.withdraw(loggedInCustomer);
					break;

				case 3:
					bankservice.transfer(loggedInCustomer);
					break;

				case 4:
					bankservice.logout();
					break;

				case 5:

				default:
					System.out.println("Invalid Entry: Kindly provide Correct Input");
					break;
				}
			} while (option != 4);
		} else
			System.out.println("Invalid  login Credentials");

		// Just to Verify Transactions....

		System.out.println("\n\nCurrent DataBase \n");
		for (int i = 0; i < allCustomers.length; i++) {
			System.out.println(allCustomers[i].getBankAccountNo() + " " + allCustomers[i].getBalance());
		}

	}

	static Customer validateCustomer(Customer customer, Customer[] allCustomers) {
		// boolean result = false;
		Customer customerFound = null;
		for (int i = 0; i < allCustomers.length; i++) {
			if (allCustomers[i].getBankAccountNo() == customer.getBankAccountNo()
					&& allCustomers[i].getPassword().equals(customer.getPassword())) {
				// result= true;
				customerFound = allCustomers[i];
				break;
			}
		}
		return customerFound;

	}

}
