//Name: Sydney Varner
//PantherID:002-527-007
//Due Date: June 23
//=======================================
import java.util.*;

// This program generates the taxes due for each user (for a random number of users between 0 and 15)
public class IncomeTax {
	public static double generateTax(double income) {
		double tax = 0;
		double overAmount = 0;
		
		//If a person's income is less than $750 their tax is 1% of their income
		if(income < 750) {
			tax = 0.1 * income;
		}
		//If a person's income is between $750 and $2500 (not including $2500), their tax is $7.5
		else if (income >= 750 && income < 2500) {
			//For any amount over 750, 2% of the amount over is added to their tax
			if (income > 750) {
				overAmount = income - 750;
				overAmount = overAmount * 0.02;
				tax = 7.5 + overAmount;
			} else {
				tax = 7.5;
			}
		}
		//If a person's income is between $2500 and $5000 (not including $5000), their tax is $82.5
		else if (income >= 2500 && income < 5000) {
			//For any amount over $2500, 4% of the amount over is added to their tax
			if (income > 2500) {
				overAmount = income - 2500;
				overAmount = overAmount * 0.04;
				tax = 82.5 + overAmount;
			} else {
				tax = 82.5;
			}
		}
		//If a person's income is between $5000 and $8000 (not including $8000), their tax is $142.50
		else if (income >= 5000 && income < 8000 ) {
			//For any amount over $5000, 5% of the amount over is added to their tax
			if ( income > 5000) {
				overAmount = income - 5000;
				overAmount = overAmount * 0.05;
				tax = 142.50 + overAmount;
			} else {
				tax = 142.50;
			}
		}
		else {
			//If a person's income is $8000 their tax is $230.0
			//For any amount over $8000, 6% of the amount over is added to $230.0
			if (income > 8000) {
				overAmount = income - 8000;
				overAmount = overAmount * 0.06;
				tax = 230.00 + overAmount;
			} else {
				tax = 230.00;
			}
		}
		/*I added this calculation to round the tax to two decimal places.
		 * It makes the first two decimals part of the whole number and rounds the number.
		 * Then, the last two numbers of the whole number become decimals.
		 */
		tax =  Math.round(tax * 100.0) / 100.0;
		return tax;
	}
	
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		Random rand = new Random();
		double income = 0;
		double userTax = 0;
		double maxTaxValue = 0;
		// The number of people is a random number between 1 and 15
		int numPeople = rand.nextInt(15) + 1;
		//I create an array that will hold all the values of the taxes due
		double[] taxValues = new double[numPeople];
		for(int i = 1; i<= numPeople; i++) {
			System.out.print("Please enter your amount of taxable income: ");
			income = console.nextDouble();
			System.out.println("PERSON " + i );
			userTax = generateTax(income);
			//Each of the user's tax values are added to the array
			taxValues[i-1] = userTax;
			System.out.println("Tax value: $" + userTax);
			//I determine the highest tax value
			if ( userTax > maxTaxValue) {
				maxTaxValue = userTax;
			}
		}
		
		System.out.println("\nPeople with the max tax value of $" + maxTaxValue + ":");
		//The loop goes through each value in the array (which has all the user's values)
		for (int i=0; i<numPeople; i++) {
			//If the value is greater or equal than the max tax values, then the person is listed as having the most taxes due
			if(taxValues[i] >= maxTaxValue) {
				System.out.println("PERSON " + (i+1));
			}
		}
	}
	
}