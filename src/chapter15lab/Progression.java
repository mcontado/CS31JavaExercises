package chapter15lab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Progression {
	
	public static int geometricRecursive(int input) {
		//base case
		if (input == 0)
			return 1;
		
		//recursive case
		return input * geometricRecursive(input-1);	
	}
	
	public static int geometricIterative(int input) {
		int result = 1;
		
		for (int i=1; i<=input; i++) {
			result *= i;
		}
		return result;
	}
	
	public static double harmonicRecursive(int input) {
		//base case
		if (input == 1)
			return 1;
		
		//recursive case
		return ((double)1/input) * harmonicRecursive(input - 1);	
	}
	
	public static double harmonicIterative(int input) {
		double result = 1;
		
		for (int i=1; i<=input; i++) {
			result /= i;
		}
		return result;
	}

	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("#.#####");
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("This program will calculate the geometric and ");
		System.out.println("harmonic progression for the number you enter.");
		System.out.print("Enter an integer that is greater than or equal to 1: ");

		int input = keyboard.nextInt();
		
		int geomAnswer = geometricRecursive (input);
		double harmAnswer = harmonicRecursive (input);
	
		System.out.println("\nUsing recursion:");
		System.out.println("The geometric progression of " + input + " is " + geomAnswer);
		System.out.println("The harmonic progression of " + input + " is " + df.format(harmAnswer));

		geomAnswer = geometricIterative(input);
		harmAnswer = harmonicIterative(input);

		System.out.println("\nUsing iteration:");
		System.out.println("The geometric progression of " + input + " is " + geomAnswer);
		System.out.println("The harmonic progression of " + input + " is " + df.format(harmAnswer));
	}
}