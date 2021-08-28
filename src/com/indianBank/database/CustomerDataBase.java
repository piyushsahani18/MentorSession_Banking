package com.indianBank.database;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import com.indianBank.model.Customer;

public class CustomerDataBase {

	Customer customer = new Customer();
	public Customer customers[] = new Customer[7];

	public void AddCustomerDatabase() {

		// list of Customer :)
		customers[0] = new Customer(1234, "mike99", 10000);
		customers[1] = new Customer(2345, "mickey77", 12000);
		customers[2] = new Customer(3456, "simple22", 15000);
		customers[3] = new Customer(5678, "jimmy", 8000);
		customers[4] = new Customer(6789, "1234", 60000);
		customers[5] = new Customer(7891, "2345", 5000);
		customers[6] = new Customer(8912, "easypeasy", 20000);
		
	}

	
	   public Customer[] getCustomerDatabase() { 
		   return customers;
	      
	  
	 }
	

	// File to Store the transaction details
	public void maintainCustomerDetails() throws FileNotFoundException {
		// Creating a File object that represents the disk file.
		PrintStream o = new PrintStream(
				new File("C:\\Users\\piyus\\eclipse-workspace\\greatlearnigmentorSession\\IndianBank_BankingSystem.txt"));
		// Store current System.out before assigning a new value
		PrintStream console = System.out;
		// Assign o to output stream
		System.setOut(o);
		console.close();
	}

}
