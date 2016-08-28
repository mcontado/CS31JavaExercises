package assignments;


import java.util.Scanner;

public class BodyMassIndex {

	public static void main(String[] args) {
		double weight = 0, height = 0;
		double bmi = 0;
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter your weight in pounds : ");
		weight = in.nextInt();
		System.out.println("Enter your height in inches: ");
		height = in.nextInt();
		
		bmi = (weight * 703) / (height * height);
		
		System.out.println("BMI : " + bmi);
		
		if (bmi >= 18.5 && bmi <= 25) {
			System.out.println("You are optimal");
		} else if (bmi < 18.5) {
			System.out.println("You are underweight");			
		} else {
			System.out.println("You are overweight");			
		}
		

	}

}
