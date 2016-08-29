package assignments;


import java.util.Scanner;
import java.io.*;   


public class WordGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner in = new Scanner(System.in);
		String name, city, collegeName, profession, animalType, petName;
		int age;
		
		//Prompts
		System.out.println("Enter your name: ");
		  name = in.next();
		System.out.println("Enter your age: ");
		 age = in.nextInt();
		System.out.println("Enter your city: ");
		 city = in.next();
		System.out.println("College name: ");
		 collegeName = in.next();
		System.out.println("Profession: ");
		 profession = in.next();		   
		System.out.println("Animal Type: ");
		 animalType = in.next();		 
		System.out.println("Pet Name: ");		
	     petName = in.next();
	    
	    System.out.println("There was once was a person named " + name + " who lived in " + city + "." 
	    		+ " \nAt the age of " + age + ", " + name + " went to college at " + collegeName + ". " 
	    		+ name + " graduated and went to work as a " + profession + ". " + "\nThen, " + name + " adopted a(n) "
	    		+ animalType + " named " + petName + ". They both lived happily ever after." );
	
		 
	}

}
