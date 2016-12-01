package assignments;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class WorldSeriesWinners4B {
	

	public static void main(String[] args) throws IOException {
		URL path = WorldSeriesWinners4B.class.getResource("WorldSeriesWinners.txt");
		File f = new File(path.getFile());
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		ArrayList<String> winnersList = new ArrayList<>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		String sCurrentLine;
		String userInput;
		int totalCount = 0;
		
		while ((sCurrentLine = br.readLine()) != null) {
			winnersList.add(sCurrentLine);
		}
		
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter name of the team : ");
		userInput = in.nextLine();
		
		for (int i=0; i<winnersList.size(); i++) {
			if (userInput.equals(winnersList.get(i))) {
				totalCount++;
			}
		}
		System.out.println("Total Count: "  + totalCount);
		

	}

}
