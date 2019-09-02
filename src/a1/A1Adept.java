package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		
		// Read in item count and create arrays to hold information for each item.
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
		double[] customerAmountSpent = new double[customerCount];
		
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
				// If it is found, utilize the item price to add the total sum of
				// the items to the total amount spent by the customer.
				for(int k = 0;k < itemCount;k++) {
					if(itemNames[k].equals(itemName)) {
						customerAmountSpent[i] += itemQuantity * itemPrices[k];
					}
				}
			}
		}
		
		// Use helper functions to find the customers that spent the most and the least,
		// and to figure out the average amount spent.
		int leastSpent = smallestValueIndex(customerAmountSpent);
		int mostSpent = largestValueIndex(customerAmountSpent);
		double averageSpent = average(customerAmountSpent);
		
		// Print out the results.
		System.out.println("Biggest: " + customerFirstNames[mostSpent] + " " +
				customerLastNames[mostSpent] + "(" +
				String.format("%.2f",customerAmountSpent[mostSpent]) + ")");
		
		System.out.println("Smallest: " + customerFirstNames[leastSpent] + " " +
				customerLastNames[leastSpent] + "(" +
				String.format("%.2f",customerAmountSpent[leastSpent]) + ")");
		
		System.out.println("Average: " + String.format("%.2f",averageSpent));
	}
	
	/*average
	 * Calculates the average of an array of doubles.
	 * 
	 * Input: array of double values
	 * Output: average of the values as a double
	 * 
	 * Preconditions: values array must not be null
	 */
	
	static double average(double[] values) {
		double average = 0.0;
		
		for(int i = 0;i < values.length;i++) {
			average += values[i];
		}
		
		return average / values.length;
	}
	
	/*smallestValueIndex
	 * Finds the index of the smallest value in an array of doubles.
	 * 
	 * Input: array of double values
	 * Output: the index of the smallest value as an int
	 * 
	 * Preconditions: values array must not be null
	 */
	
	static int smallestValueIndex(double[] values) {
		int smallestValueIndex = 0;
		
		for(int i = 0;i < values.length;i++) {
			if(values[i] < values[smallestValueIndex]) {
				smallestValueIndex = i;
			}
		}
		
		return smallestValueIndex;
	}
	
	/*largestValueIndex
	 * Finds the index of the largest value in an array of doubles.
	 * 
	 * Input: array of double values
	 * Output: the index of the largest value as an int
	 * 
	 * Preconditions: values array must not be null
	 */
	
	static int largestValueIndex(double[] values) {
		int largestValueIndex = 0;
		
		for(int i = 0;i < values.length;i++) {
			if(values[i] > values[largestValueIndex]) {
				largestValueIndex = i;
			}
		}
		
		return largestValueIndex;
	}
}
