package assignments;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;


public class SlotMachineSimulation {
	
	public static void main(String[] args) {
		
		System.out.println("=== Welcome to Slot Machine ===");
		
		Scanner in = new Scanner(System.in);
		String[] item = {"Cherries", "Oranges", "Plums", "Bells", "Melons", "Bars"};
		
		HashMap<String, Integer> itemMap = new HashMap<String, Integer>();
		int lower = 0;
		int upper = item.length;
		
		double amount = 0;

		double totalMoneyIn = 0;
		String choice = null;
		
		do {
			itemMap.clear();
			int maxRoll = 3;
			
			//checks if there is still remaining money
			if (amount <= 0) {
				System.out.println("Enter the amount of money: ");
				amount = in.nextInt();
				totalMoneyIn += amount;
			}
			
			while (maxRoll > 0) {
				int random = (int) (Math.random() * (upper - lower)) + lower;
				
				if (itemMap.containsKey(item[random])) {
					itemMap.put(item[random], itemMap.get(item[random]) + 1);
				} else {
					itemMap.put(item[random], 1);
				}
				maxRoll--;
			}
			
			//iterate through the map entry
			for (Map.Entry<String, Integer> entry : itemMap.entrySet()) {
			    System.out.println(entry.getKey() + ": " + entry.getValue());
			}
			//
			Map.Entry<String, Integer> maxEntry = null;
			
			for (Map.Entry<String, Integer> entry: itemMap.entrySet()) {
				if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
					maxEntry = entry;
				}
			}
			
			if (maxEntry.getValue() == 2) {
				amount = (amount * 2);
			} else if (maxEntry.getValue() == 3) {
				amount = (amount * 3);
			} else {
				amount = 0;
			}
			
			
			System.out.println("Total amount money entered: " + totalMoneyIn);
			System.out.println("You've won: " + amount);
			
			System.out.println("Do you still want to play? (Y/N): ");
			choice = in.next();
			
			if (choice.equalsIgnoreCase("n")) {
				System.out.println("Program Exiting. Goodbye!");
				break;
			} 
			
		} while (true);
				
	}

}
