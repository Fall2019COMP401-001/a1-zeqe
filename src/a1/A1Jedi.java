package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		
		// Read in the item count and create arrays to hold information for each item.
		int itemCount = scan.nextInt();
		
		String[] itemNames = new String[itemCount];
		double[] itemPrices = new double[itemCount];
		
		// Read in the item information.
		for(int i = 0;i < itemCount;i++) {
			itemNames[i] = scan.next();
			itemPrices[i] = scan.nextDouble();
		}
		
		// Read in the customer count and create arrays to hold information for each one.
		int customerCount = scan.nextInt();
		
		String[] customerFirstNames = new String[customerCount];
		String[] customerLastNames = new String[customerCount];
		
		// Create arrays to keep track of how many of each item was purchased,
		// and by how many people.
		int[] itemsCustomersBought = new int[itemCount];
		int[] itemsTotalBought = new int[itemCount];
		
		for(int i = 0;i < customerCount;i++) {
			// Read in information for each customer
			customerFirstNames[i] = scan.next();
			customerLastNames[i] = scan.next();
			
			// For each item the customer bought, find the quantity and name.
			int itemsBought = scan.nextInt();
			
			for(int j = 0;j < itemsBought;j++) {
				int itemQuantity = scan.nextInt();
				String itemName = scan.next();
				
				// Use the item name to find its index in the item arrays.
				// If it is found, add one to the number of customers that purchased
				// that item, and then add the quantity of items purchased by
				// the customer to the total number of items purchased.
				for(int k = 0;k < itemCount;k++) {
					if(itemNames[k].equals(itemName)) {
						itemsCustomersBought[k]++;
						itemsTotalBought[k] += itemQuantity;
					}
				}
			}
		}
		
		// Done parsing input, close scanner.
		scan.close();
		
		// Print out the results.
		for(int i = 0;i < itemCount;i++) {
			if(itemsCustomersBought[i] > 0) {
				System.out.println("No customers bought " + itemNames[i]);
			}else {
				System.out.println(itemsCustomersBought[i] + " customers bought " +
						itemsTotalBought[i] + " " + itemNames[i]);
			}
		}
	}
}
