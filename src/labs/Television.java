package labs;

//The purpose of this program is to model a Television
// Maria Contado 8/31/2016

public class Television {

	/*The manufacturer attribute will hold the brand name. This
	cannot change once the television is created, so will be a named constant. */
	private String MANUFACTURER;
	
	/*The screenSize attribute will hold the size of the television screen.
	This cannot change once the television has been created so will be a named
	constant. */
	private int SCREEN_SIZE;
	
	/* The powerOn attribute will hold the value true if the power is on, and false if the power is off.*/
	private boolean powerOn;
	
	/* The channel attribute will hold the value of the station that the television is showing */
	private int channel;
	
	/* The volume attribute will hold a number value representing the loudness (0 being no sound). */
	private int volume;
	
	/* This constructor sets the default params */
	Television(String manufacturer, int screensize) {
		this.MANUFACTURER = manufacturer;
		this.SCREEN_SIZE = screensize;
		this.powerOn = false;
		this.volume = 20;
		this.channel = 2;
	}
	
		
	public String getManufacturer() {
		return MANUFACTURER;
	}

	public int getScreenSize() {
		return SCREEN_SIZE;
	}

	public int getChannel() {
		return channel;
	}

	public int getVolume() {
		return volume;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	/* changes the state from true to false and vice versa*/
	public void power() {
		if (powerOn) 
			powerOn = !powerOn;
		else 
			powerOn = !(!powerOn);
	}
	
	/* Increases the volume */
	public void increaseVolume() {
		this.volume = getVolume() + 1;
	}
	
	/* Decreases the volume */
	public void decreaseVolume() {
		this.volume = getVolume() - 1;
	}

}
