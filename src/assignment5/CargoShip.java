package assignment5;

public class CargoShip extends Ship {

	private int cargoCapacity;
	
	
	CargoShip(String name, String year) {
		super(name, year);
		// TODO Auto-generated constructor stub
	}

	CargoShip(String name, int capacity) {
		super(name);
		this.cargoCapacity = capacity;
	}

	public int getCargoCapacity() {
		return cargoCapacity;
	}


	public void setCargoCapacity(int cargoCapacity) {
		this.cargoCapacity = cargoCapacity;
	}


	@Override
	public String toString() {
		return "CargoShip name[" + this.getName() + " [cargoCapacity=" + cargoCapacity + "]";
	}
	
	

}
