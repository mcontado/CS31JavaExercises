package assignments;

public class FuelOdometerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FuelGauge fg = new FuelGauge();
		Odometer o = new Odometer();
		
		for (int i=0; i<15; i++) {
			fg.incrementAmountOfGallon();
		}
		
		
		System.out.println("Starting Gallons :" +fg.getGallons());
		System.out.println("Starting Mileage :" + o.getMileage());
		
		for (int i=0; i<480 ; i++) {
			o.incrementMileage();
			o.decreaseFuel(fg);
			System.out.println("Current Gallons: " + fg.getGallons());
			System.out.println("Current Mileage: " + o.getMileage());
			
		}
		

	}

}
