package assignments;

public class FuelGauge {
	private int gallons;

	public int getGallons() {
		return gallons;
	}
	
	public void setGallons(int gallons) {
		this.gallons = gallons;
	}
	
	public void reportCurrentFuel() {
		System.out.println("Current Amount of fuel in gallons: " + getGallons());
	}

	public void incrementAmountOfGallon() {
		// 15 gallons is the max unit 
		if (getGallons() < 15) {
			gallons++;
		}
	}
	
	public void decrementAmountOfGallon() {
		// 15 gallons is the max unit 
		if (getGallons() > 0) {
			gallons--;
		}
	}

}
