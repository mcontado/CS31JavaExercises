package assignments;

import java.util.Scanner;

public class MonthDays {
	
	public int month;
	public int year;
	
	public MonthDays(int month, int year) {
		this.month = month;
		this.year = year;
	}
	
	public int getMonth() {
		return month;
	}


	public void setMonth(int month) {
		if (month >= 1 || month <= 12) {
			this.month = month;
		} 
		
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}
	
	public boolean monthIsValid(int month) {
		if (month < 0 || month > 12) {
			return false;
		}
		return true;
	}
	
	public int getNumberOfDays(int month, int year) {
		int days = 0;
		switch(month) {
			case 1: days = 31; break;
			case 2: days = isLeapYear() ? 29 : 28; break;
			case 3: days = 31; break;
			case 4: days = 30; break;
			case 5: days = 31; break;
			case 6: days = 30; break;
			case 7: days = 31; break;
			case 8: days = 31; break;
			case 9: days = 30; break;
			case 10: days = 31; break;
			case 11: days = 30; break;
			case 12: days = 31; break;
			default: break;
		}
		return days;
	}

	
	public boolean isLeapYear() {
		if (getYear() % 100 == 0) {
			if (getYear() % 400 == 0) {
				return true;
			} 
		} else {
			if (getYear() % 4 == 0) {
				return true;
			}
		}
		return false;
	}
	
	

	public static void main(String[] args) {
		int year = 0; int month = 0;
		Scanner in = new Scanner(System.in);
		
		do {
			System.out.println("Enter a month (1-12): ");
			month = in.nextInt();
			
			if (month <= 0 || month > 12) {
				System.out.println("Please enter between 1 to 12: ");
			} else {
				break;
			}
			
		} while (true);
		
		
		do {
			System.out.println("Enter a year: ");
			year = in.nextInt();
			
			if (year <= 0) {
				System.out.println("Please enter year greater than 0: ");
				
			} else {
				break;
			}
			
		} while (true);
		
		MonthDays md = new MonthDays(month, year);
		System.out.println(md.getNumberOfDays(month, year) + " days");
		
		
	}
	


}

