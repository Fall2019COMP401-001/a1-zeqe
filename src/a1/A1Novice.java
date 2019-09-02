package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		
		// Read in the customer count
		int customerCount = scan.nextInt();
		
		// Create arrays to hold the first names, last names, and total purchased
		// of the customers.
		String[] customersFirstNames = new String[customerCount];
		String[] customersLastNames = new String[customerCount];
		double[] customersTotalPurchased = new double[customerCount];
		
		for(int i = 0;i < customerCount;i++) {
			// Read in information for each customer.
			customersFirstNames[i] = scan.next();
			customersLastNames[i] = scan.next();
			
			// Go through each item each customer has purchased
			// and add the cost of those items to the total sum
			// purchased by the customer.
			int itemsBought = scan.nextInt();
			
			for(int j = 0;j < itemsBought;j++) {
				int itemQuantity = scan.nextInt();
				String itemName = scan.next(); // This is read purely to avoid scanner order errors.
				double itemPrice = scan.nextDouble();
				
				customersTotalPurchased[i] += itemQuantity * itemPrice;
			}
		}
		
		// Print out information gathered from each customer.
		for(int i = 0;i < customerCount;i++) {
			System.out.println(customersFirstNames[i].charAt(0) + ". " +
					customersLastNames[i] + ": " +
					String.format("%.2f",customersTotalPurchased[i]));
		}
	}
}
