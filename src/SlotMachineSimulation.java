package assignments;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;


public class SlotMachineSimulation {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] item = {"Cherries", "Oranges", "Plums", "Bells", "Melons", "Bars"};
		List<String> itemPickedList = new ArrayList<String>();
		int lower = 0;
		int upper = item.length;
		int maxRoll = 3;
		int amount = 0;
		int countMatch = 0;
		
		System.out.println("Enter the amount of money: ");
		amount = in.nextInt();
		
		while (maxRoll > 0) {
			int random = (int) (Math.random() * (upper - lower)) + lower;
			itemPickedList.add(item[random]);
			maxRoll--;
		}
		
		
		
		
		for (int i=0; i<itemPickedList.size(); i++) {
			System.out.println(itemPickedList.get(i));
		}
		
		
		//System.out.println(item[random]);

	}

}
