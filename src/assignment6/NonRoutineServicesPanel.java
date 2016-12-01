package assignment6;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class NonRoutineServicesPanel extends JPanel {
	private JLabel labelPartsCharges;
	private JLabel labelHoursLabor;
	private JTextField tfPartsCharges;
	private JTextField tfHoursLabor;

	public NonRoutineServicesPanel() {
		// Row=2, Col=2
		setLayout(new GridLayout(2, 2));

		labelPartsCharges = new JLabel("Parts Charges");
		labelHoursLabor = new JLabel("Hours of Labor");
		// 10 characters wide
		tfPartsCharges = new JTextField(10);
		tfHoursLabor = new JTextField(10);

		// Add a border around the panel
		setBorder(BorderFactory.createTitledBorder("Noroutine Services"));

		// add to the panel
		add(labelPartsCharges);
		add(tfPartsCharges);
		add(labelHoursLabor);
		add(tfHoursLabor);

	}

	public double getNonRoutineServicesCost() {
		
		double serviceCost = 0.0;
		double perHourLabor = 20.00;
		// to get the parts charges and input hours and parse as Double value
		double partsCharges = Double.parseDouble(tfPartsCharges.getText());
		double inputHours = Double.parseDouble(tfHoursLabor.getText());
		
		serviceCost += partsCharges + (inputHours * perHourLabor);
		
		return serviceCost;

	}
}
