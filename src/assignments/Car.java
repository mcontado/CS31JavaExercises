package assignments;

public class Car {
	
	private int yearModel;
	private String make;
	private int speed;
	
	public Car(int yearModel, String make) {
		this.yearModel = yearModel;
		this.make = make;
		this.speed = 0;
	}
	
	public int getYearModel() {
		return yearModel;
	}

	public void setYearModel(int yearModel) {
		this.yearModel = yearModel;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void accelerate() {
		setSpeed(getSpeed() + 5);
	}
	
	public void brake() {
		setSpeed(getSpeed() - 5);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car myCar = new Car(2016, "Honda");
		myCar.accelerate();
		System.out.println("Current Speed : " + myCar.getSpeed());
		myCar.accelerate();
		System.out.println("Current Speed : " + myCar.getSpeed());
		myCar.accelerate();
		System.out.println("Current Speed : " + myCar.getSpeed());
		myCar.accelerate();
		System.out.println("Current Speed : " + myCar.getSpeed());
		myCar.accelerate();
		System.out.println("Current Speed : " + myCar.getSpeed());
		
		myCar.brake();
		System.out.println("Current Speed : " + myCar.getSpeed());
		myCar.brake();
		System.out.println("Current Speed : " + myCar.getSpeed());
		myCar.brake();
		System.out.println("Current Speed : " + myCar.getSpeed());
		myCar.brake();
		System.out.println("Current Speed : " + myCar.getSpeed());
		myCar.brake();
		System.out.println("Current Speed : " + myCar.getSpeed());
		
		
	}

}
