package edu.cs544.eafinal.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.dom4j.Branch;
import org.springframework.beans.factory.annotation.Autowired;

import edu.cs544.eafinal.domain.Transaction;
import edu.cs544.eafinal.domain.User;
import edu.cs544.eafinal.service.TransactionService;
import edu.cs544.eafinal.service.UserService;
import edu.cs544.eafinal.serviceImpl.TransactionServiceImpl;
import edu.cs544.eafinal.serviceImpl.UserServiceImpl;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		UserService userService = new UserServiceImpl();

		TransactionService transactionService = new TransactionServiceImpl();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int index = 3;
		// User user = new User();
		System.out.println("Welcome to the Bank of Fairfield!!");

		System.out.println("Please select the appropiate number" + "\n" + "1 \t To Create New User" + "\n"
				+ "2 \t To View User By AccountNumber" + "\n" + "3 \t To View All Users" + "\n" + "4 \t To Update User"
				+ "\n" + "5 \t To Delete User");

		System.out.println();
		System.out.print("Enter your choice :   ");

		try {

			index = Integer.parseInt(br.readLine());

			// br.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		switch (index) {

		case 1: {
			System.out.println("You have selected to create new User!!");

			User addUser = new User();
			System.out.println("Enter First Name : ");
			addUser.setFirstName(br.readLine());
			System.out.println("Enter Last Name : ");
			addUser.setLastName(br.readLine());
			System.out.println("Enter Age : ");
			addUser.setAge(Integer.parseInt(br.readLine()));
			System.out.println("Enter Email  : ");
			addUser.setEmail(br.readLine());
			System.out.println("Enter Member Number : ");
			addUser.setMemberNumber(Integer.parseInt(br.readLine()));
			User addedUser = userService.addUser(addUser);
			System.out
					.println("New User Added with name : " + addedUser.getFirstName() + " " + addedUser.getLastName());
			break;
		}
		case 2: {
			System.out.println("You have selected To View User By AccountNumber!!");
			User user = userService.getUser(1L);
			System.out.println("User name : " + user.getFirstName());
			break;

		}
		case 3: {
			System.out.println("You have selected To View all Users!!");
			// Get all users:
			List<User> users = userService.getAll();
			for (User newUser : users) {
				System.out.println("User name : " + newUser.getFirstName());
			}
			break;
		}
		case 4: {
			System.out.println("You have selected to update User !!");
			break;
		}
		case 5: {
			System.out.println("You have selected to delete user!!");

			// This is to delete a user
			User deleteUser = new User();
			userService.deleteUser(3L);
			break;
		}
		default:
			System.out.println("Your entered a wrong choice !!");
			System.out.println("Please enter the appropiate choice !!");

		}
		/* End of User Section!!! */
		/* Transaction Section Begins */

		System.out.println("Please select the appropiate number" + "\n" + "1 \t To Add New Transaction" + "\n"
				+ "2 \t To View Transactions By AccountNumber" + "\n" + "3 \t To View All Transactions" + "\n"
				+ "4 \t To Update Transaction" + "\n" + "5 \t To Delete Transaction");

		System.out.println();
		System.out.print("Enter your choice :   ");

		try {

			index = Integer.parseInt(br.readLine());

			// br.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		switch (index) {

		case 1: {
			System.out.println("You have selected to create new Transaction!!");

			Transaction addTransaction = new Transaction();
			System.out.println("Enter Account Number : ");
			addTransaction.setAccountNumber(br.readLine());
			System.out.println("Enter Transaction Amount : ");
			addTransaction.setTransactionAmount(Integer.parseInt(br.readLine()));
			 java.util.Date date = new java.util.Date();
			 System.out.println("Date in date1 is : "+ date);
			addTransaction.setDate(date);
			Transaction addedTransaction = transactionService.addTransaction(addTransaction);
			System.out.println("New Transaction Added  : " + "Transaction Amount :" + addedTransaction.getTransactionAmount() + "\t"
					+ "Transaction ID : "+
					addedTransaction.getId());
			break;
		}
		case 2: {
			System.out.println("You have selected To View Transaction By AccountNumber!!");
			Transaction transaction = transactionService.getTransaction(1L);
			System.out.println("Transaction is : " + transaction.getTransactionAmount() + "\t" + transaction.getDate());
			break;
		}
		case 3: {
			System.out.println("You have selected To View all Users!!");
			// Get all users:
			List<Transaction> transactions = transactionService.getAll();
			for (Transaction newTransction : transactions) {
				System.out.println(
						"Transaction is : " + newTransction.getTransactionAmount() + "\t" + newTransction.getDate());
			}
			break;
		}
		case 4: {
			System.out.println("You have selected to update User !!");
			break;
		}
		case 5: {
			System.out.println("You have selected to delete user!!");

			// This is to delete a user
			User deleteUser = new User();
			userService.deleteUser(3L);
			break;
		}
		default:
			System.out.println("Your entered a wrong choice !!");
			System.out.println("Please enter the appropiate choice !!");

		}

	}

}
