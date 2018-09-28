// =======================================
// File: SavingsAccount.java
// =======================================
// Programmer: Jennifer King
// Date: 09/20/2018
// Class: CIS 228F | M 3:30PM
// =======================================

import java.text.*;
import java.text.DecimalFormat;

public class SavingsAccount 
{
	static double annualInterestRate;
	double savingsBalance;
	
	public SavingsAccount(double savings, double rate)
	{
			savingsBalance = savings;
			annualInterestRate = rate;
	}
	
	public void calculateMonthlyInterest()
	{
		savingsBalance = savingsBalance + ((savingsBalance * annualInterestRate)/12);
	}
	
	public static void modifyInterestRate(double newRate)
	{
		annualInterestRate = newRate;
	}
	
	public static void main(String[] args)
	{
		SavingsAccount saver1 = new SavingsAccount(2000, 0.04);
		SavingsAccount saver2 = new SavingsAccount(3000, 0.04);
		
		int counter = 0;
		
		NumberFormat df = DecimalFormat.getInstance();
		df.setMaximumFractionDigits(2);
		df.setMinimumFractionDigits(2);
		
		System.out.println("Monthly balances for one year at .04");
		
		System.out.println("Balances:");
		System.out.println("\t\tSaver 1\t\tSaver 2");
		System.out.println("Base:\t\t$" + df.format(saver1.savingsBalance) + "\t$" + df.format(saver2.savingsBalance));
	
		for(counter = 0; counter <= 11; counter++)
		{
			saver1.calculateMonthlyInterest();
			saver2.calculateMonthlyInterest();
			
			System.out.println("Month " + (counter+1) + ":\t$" + df.format(saver1.savingsBalance) + "\t$" + df.format(saver2.savingsBalance));
		}
		
		SavingsAccount.modifyInterestRate(.05);
		saver1.calculateMonthlyInterest();
		saver2.calculateMonthlyInterest();
		
		System.out.println("\nAfter setting interest rate to .05 and calculating monthly interest");
		System.out.println("Balances:");
		System.out.println("Saver 1\t\tSaver 2");
		System.out.println("$" + df.format(saver1.savingsBalance) + "\t$" + df.format(saver2.savingsBalance));
		
	}
}
