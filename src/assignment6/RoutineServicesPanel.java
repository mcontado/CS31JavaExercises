package assignment6;

import javax.swing.*;
import java.awt.*;

public class RoutineServicesPanel extends JPanel {
	public final double OIL_CHANGE = 26.00;
	public final double LUBE_JOB = 18.00;
	public final double RADIATOR = 30.00;
	public final double TRANSMISSION = 80.00;
	public final double INSPECTION = 15.00;
	public final double MUFFLER = 100.00;
	public final double TIRE_ROTATION = 20.00;

	private JCheckBox cbOilChange;
	private JCheckBox cbLubeJob;
	private JCheckBox cbRadiator;
	private JCheckBox cbTransmission;
	private JCheckBox cbInspection;
	private JCheckBox cbMuffler;
	private JCheckBox cbTireRotation;

	public RoutineServicesPanel() {
		// Sets a Grid with 7 rows and 1 column
		setLayout(new GridLayout(7, 1));

		// Create the checkboxes
		cbOilChange = new JCheckBox("Oil Change ($26.00)");
		cbLubeJob = new JCheckBox("Lube Job ($18.00)");
		cbRadiator = new JCheckBox("Radiator Flush ($30.00)");
		cbTransmission = new JCheckBox("Transmission Flush ($80.00)");
		cbInspection = new JCheckBox("Inspection ($15.00)");
		cbMuffler = new JCheckBox("Muffler Replacement ($100.00)");
		cbTireRotation = new JCheckBox("Tire Rotation ($20.00)");

		// Add a border around the panel
		setBorder(BorderFactory.createTitledBorder("Routine Services"));
		
		//Add checkboxes to the panel
		add(cbOilChange);
		add(cbLubeJob);
		add(cbRadiator);
		add(cbTransmission);
		add(cbInspection);
		add(cbMuffler);
		add(cbTireRotation);
	}
	
	/*
	 * getRoutineServicesCost method
	 * @return the cost of the selected service
	 * */
	public double getRoutineServicesCost() {
		double serviceCost = 0.0;
		
		if (cbOilChange.isSelected()) 
			serviceCost += OIL_CHANGE;
		if (cbLubeJob.isSelected()) 
			serviceCost += LUBE_JOB;
		if (cbRadiator.isSelected()) 
			serviceCost += RADIATOR;
		if (cbTransmission.isSelected()) 
			serviceCost += TRANSMISSION;
		if (cbInspection.isSelected()) 
			serviceCost += INSPECTION;
		if (cbMuffler.isSelected()) 
			serviceCost += MUFFLER;
		if (cbTireRotation.isSelected()) 
			serviceCost += TIRE_ROTATION;
		
		
		return serviceCost;
		
		
	}

}
