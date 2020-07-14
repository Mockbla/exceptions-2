package applications;

import java.util.Scanner;

import entities.Account;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Enter account data ");
			System.out.print("Number: ");
			int number = sc.nextInt();
			System.out.print("Holder: ");
			String holder = sc.next();
			System.out.print("Initial balance: ");
			double d = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			double withdrawLimit = sc.nextDouble();
			Account acc = new Account(number, holder, d, withdrawLimit);

			System.out.print("Enter ammount for withdraw: ");
			Double amount = sc.nextDouble();
			if (acc.getBalance() < amount) {
				System.out.println("Error: Balance is lower than withdraw value");
				System.exit(0);
			} else if (amount > acc.getWithdrawLimit()) {
				System.out.println("Error: withdraw value is higher than the withdraw limit");
				System.exit(0);
			} else {

				acc.withdraw(amount);
				System.out.println("New balance " + String.format("%.2f", acc.getBalance()));

			}

		} catch (java.util.InputMismatchException e) {
			System.out.println("Error in the type of imputed data");

		} finally {
			sc.close();
		}
	}
}