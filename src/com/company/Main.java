package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner nick = new Scanner(System.in);
        System.out.println("Enter Customer Name: ");
        String customerName = nick.nextLine();
        int accountNumber = (int) (Math.random()*100000000);
	    BankAccount details = new BankAccount(customerName,accountNumber);
	    details.showMenu();
    }
}

class BankAccount
{
    int balance;
    int previousTransaction;
    String  customerName;
    int accountNumber;

    BankAccount(String cName, int accNum)
    {
//        this.balance = balance;
//        this.previousTransaction = previousTransaction;
        customerName = cName;
        accountNumber = accNum;
    }

    void deposit(int amount)
    {
        if(amount > 0)
        {
            balance += amount;
            previousTransaction = amount;
            System.out.println("Rs. " + amount + " has been Deposited in your A/C " + accountNumber);
        }
        else
            System.out.println("Negative amount cannot be deposit.");
    }
    void withdraw(int amount)
    {
        if(amount > 0)
        {
            balance -= amount;
            previousTransaction = -amount;
            System.out.println("Rs. " + amount + " has been Withdraw from your A/C " + accountNumber);
        }
        else
            System.out.println("Negative amount cannot be withdraw.");
    }
    void showPreviousTransaction()
    {
        if(previousTransaction > 0)
            System.out.println("You have deposited an amount of " + previousTransaction);
        else if(previousTransaction < 0)
            System.out.println("You have withdraw an amount of " + Math.abs(previousTransaction));
        else
            System.out.println("No Transaction Occured.");
    }
    void showMenu()
    {
        Scanner nick = new Scanner(System.in);
        System.out.println("-------------------------------------------------------------");
        System.out.println("Welcome " + customerName);
        System.out.println("Your Bank Account Number is " + accountNumber);
        System.out.println();
        System.out.println("Press A to Check Balance.");
        System.out.println("Press B to Deposit.");
        System.out.println("Press C to Withdraw.");
        System.out.println("Press D to See Previous Transaction.");
        System.out.println("Press E to Exit.");
        String option;

        do {
            System.out.println("=============================================================================");
            System.out.println("Enter an option.");
            option = nick.next();
            System.out.println("=============================================================================");
            System.out.println();

            switch (option)
            {
                case "A":
                    System.out.println("-----------------------------------------------------------");
                    System.out.println("Balance: " + balance);
                    System.out.println("-----------------------------------------------------------");
                    System.out.println();
                    break;
                case "B":
                    System.out.println("-----------------------------------------------------------");
                    System.out.println("Enter Amount to Deposit");
                    System.out.println("-----------------------------------------------------------");
                    int amount1 = nick.nextInt();
                    deposit(amount1);
                    System.out.println();
                    break;
                case "C":
                    System.out.println("-----------------------------------------------------------");
                    System.out.println("Enter Amount to Withdraw");
                    System.out.println("-----------------------------------------------------------");
                    int amount2 = nick.nextInt();
                    withdraw(amount2);
                    System.out.println();
                    break;
                case "D":
                    System.out.println("-----------------------------------------------------------");
                    showPreviousTransaction();
                    System.out.println("-----------------------------------------------------------");
                    System.out.println();
                    break;
                case "E":
                    System.out.println("************************************************************");
                    break;
                default:
                    System.out.println("Invalid Option! Please enter again.");
                    break;
            }
        }while (!option.equals("E"));
        System.out.println("Thank You for using our services.");
    }


}
