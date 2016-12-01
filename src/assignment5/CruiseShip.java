package assignment5;

public class CruiseShip extends Ship{
	private int maxNumPassengers;
	

	CruiseShip(String name, String year) {
		super(name, year);
		// TODO Auto-generated constructor stub
	}
	
	CruiseShip(String name, int maxPassenger) {
		super(name);
		this.maxNumPassengers = maxPassenger;
	}


	public int getMaxNumPassengers() {
		return maxNumPassengers;
	}


	public void setMaxNumPassengers(int maxNumPassengers) {
		this.maxNumPassengers = maxNumPassengers;
	}


	@Override
	public String toString() {
		return "CruiseShip name[" + this.getName() + " [maxNumPassengers=" + maxNumPassengers + "]";
	}
	
	

}
