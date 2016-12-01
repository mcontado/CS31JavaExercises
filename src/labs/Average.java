package labs;

import java.util.Arrays;
import java.util.Scanner;

public class Average {
	double[] data;
	double mean;
	
	Average() {
		Scanner in = new Scanner(System.in);
		//initialize the integer of data
		this.data = new double[5];
		
		for (int i=0; i<data.length; i++) {
			System.out.println("Enter a number: ");
			data[i] = in.nextInt();
		}
	}
	
	/*
	  calculateMean – this is a method that uses a for loop to access each score in
	the array and add it to a running total. The total divided by the number of scores
	(use the length of the array), and the result is stored into mean.
	 * */
	
	public double  calculateMean() {
		double total = 0;
		
		for (int i=0; i<data.length; i++) {
			total += data[i];
		}
		this.mean = total / data.length;
		
		return mean;
	}

	/*
	 * toString— returns a String containing data in descending order and the mean
	 * */
	public String toString() {
		
		StringBuffer sb = new StringBuffer();
		for (int i=0; i<data.length; i++) {
			sb.append(data[i]);
			sb.append(" ");
		}
		sb.append("\n");
		sb.append(calculateMean());

		return sb.toString();

	}

	
	/* selectionSort—this method uses the selection sort algorithm to rearrange
	the data set from highest to lowest.
	*/
	
	//sorts the data descending order
	public void selectionSort() {
		
		for (int i=0; i<data.length-1; i++) {
			int maxIndex = i;
			
			for (int j=i+1; j<data.length; j++) {
				if (data[j] > data[maxIndex]) {
					maxIndex = j;
				}
			}
			
			int minValue = (int) data[maxIndex];
			data[maxIndex] = data[i];
			data[i] = minValue;
			
		}
		

	}

	
	
	

}
