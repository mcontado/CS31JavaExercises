package assignments;

public class Odometer {
	private int mileage;
	private int MAX_MILES = 999999;

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	
	public void reportMileage() {
		System.out.println("Current car mileage: " + getMileage());
	}
	
	public void incrementMileage() {
		// MAX_MILES is the max unit 
		if (getMileage() <= MAX_MILES) {
			mileage++;
		} else {
			mileage = 0;
		}
	}
	
	public void decreaseFuel(FuelGauge fuel) {
		//Cars fuel economy is 24 miles per gallon
		if (mileage % 24 == 0) {
			fuel.decrementAmountOfGallon();
		}
		
	}
	
	
}
