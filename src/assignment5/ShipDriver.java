package assignment5;

public class ShipDriver {

	public static void main(String[] args) {
		//Ship ship = new Ship();
		Ship[] ships = new Ship[3];
		ships[0] = new Ship("First Ship", "2000");
		ships[1] = new Ship("Second Ship", "2001");
		ships[2] = new Ship("Third Ship", "2002");
		//Print ship
		for (int i=0; i< ships.length; i++) {
			System.out.println(ships[i].toString());
		}
		
		System.out.println();
		//CRUISE SHIP
		CruiseShip[] cs = new CruiseShip[3];
		cs[0] = new CruiseShip("First Cruise Ship", 100);
		cs[1] = new CruiseShip("Second Cruise Ship", 200);
		cs[2] = new CruiseShip("Third Cruise Ship", 300);
		//Print CRUISE SHIP
		for (int i=0; i< cs.length; i++) {
			System.out.println(cs[i].toString());
		}
		
		System.out.println();
		//CARGO SHIP
		CargoShip[] cargo = new CargoShip[3];
		cargo[0] = new CargoShip("First Cargo Ship", 1000);
		cargo[1] = new CargoShip("Second Cargo Ship", 2000);
		cargo[2] = new CargoShip("Third Cargo Ship", 3000);
		//Print Cargo Ship
		for (int i=0; i< cargo.length; i++) {
			System.out.println(cargo[i].toString());
		}

	}

}
