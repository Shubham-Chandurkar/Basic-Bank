package core_java_exercises;

import java.util.Scanner;

public class MainBank {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("**************************************************");
		System.out.println("**               Welcome to MY Bank             **");
		System.out.println("**************************************************\n\n");

		// creating object of BankService class
		BankServices obj = new BankServices();
		obj.services();

	}

}

class BankServices {

	long CurrentBalance = 10000;
	boolean ZeroCheck = true;
	boolean AmountCheck = true;
	Scanner sc = new Scanner(System.in);

	public void services() throws InterruptedException {
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println("Enter service number: " + "\n 1. Check Balance" + "\n 2. Deposit" + "\n 3. Withdraw"
				+ "\n 4. Transfer" + "\n 5. Exit");
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::");
		int choice = sc.nextInt();

		// choice of service
		switch (choice) {
		case 1:
			checkBalance();
			break;
		case 2:
			deposit();
			break;
		case 3:
			withdraw();
			break;
		case 4:
			transfer();
			break;
		case 5:
			System.out.println("------- Thank you -------");
			break;
		default:
			System.out.println(" Please enter valid input \n");
			break;
		}
	}

	// checking balance
	public void checkBalance() throws InterruptedException {
		System.out.println("\n || Current Balance: " + CurrentBalance + "||\n");
		services();
	}

	// deposit money
	public void deposit() throws InterruptedException {
		System.out.println(" Please Enter Amount: ");
		long depositAmount = sc.nextInt();
		nonZeroCheck(depositAmount);
		if (ZeroCheck) {
			CurrentBalance += depositAmount;
			loading();
			System.out.println(" \n\n || Amount is credited Successfully. || \n");
			services();
		} else {
			System.out.println(" Please enter valid amount \n");
			services();
		}
	}

	// withdraw money
	public void withdraw() throws InterruptedException {
		System.out.println(" Please Enter Amount: ");
		long withdrawAmount = sc.nextInt();
		nonZeroCheck(withdrawAmount);
		if (ZeroCheck) {
			validAmountCheck(withdrawAmount);
			if (AmountCheck) {
				CurrentBalance -= withdrawAmount;
				loading();
				System.out.println(" \n\n || Amount is debited Successfully. || \n");
				services();
			} else {
				System.out.println(" Sorry! Your have low balance \n");
				services();
			}

		} else {
			System.out.println(" Please enter valid amount \n");
			services();
		}
	}

	// transfer money to other
	public void transfer() throws InterruptedException {
		System.out.println(" Enter Reciver Acount number");
		int ReciverAccountNumber = sc.nextInt();
		System.out.println(" Enter Transfer Amount: ");
		int TransferAmount = sc.nextInt();
		nonZeroCheck(TransferAmount);
		if (ZeroCheck) {
			validAmountCheck(TransferAmount);
			if (AmountCheck) {
				CurrentBalance -= TransferAmount;
				loading();
				System.out.println(
						" \n\n|| Amount is Transfered to " + ReciverAccountNumber + " Account Successfully. || \n");
				services();
			} else {
				System.out.println("\n Sorry! Your have low balance \n");
				services();

			}
		} else {
			System.out.println(" Please enter valid amount \n");
			services();
		}

	}

	// entered value must be greater than zero
	public void nonZeroCheck(long a) {
		if (a > 0) {
			ZeroCheck = true;
		} else {
			ZeroCheck = false;
		}
	}

	// checking is account having the requested amount or not
	public void validAmountCheck(long a) {
		long temp = CurrentBalance - a;
		if (temp > 0) {
			AmountCheck = true;
		} else {
			AmountCheck = false;
		}
	}

	// loading effect method
	public void loading() throws InterruptedException {
		System.out.print("\n Please wait");
		for (int i = 0; i <= 10; i++) {
			System.out.print(".");
			Thread.sleep(500);
		}
	}

}
