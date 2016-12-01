package assignment6;

import javax.swing.*; //Needed for swing classes
import java.awt.*; // Needed for BorderLayout class
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class JoesAutomotive extends JFrame {

	private RoutineServicesPanel routineServicesPanel;
	private NonRoutineServicesPanel nonRoutineServicesPanel;

	private JPanel buttonPanel;
	private JButton buttonCalculate;
	private JButton buttonExit;

	public JoesAutomotive() {
		// Display the title
		setTitle("Joe's Automotive");

		// specify action for the close button
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create border layout
		setLayout(new BorderLayout());

		// create the custom panels;
		routineServicesPanel = new RoutineServicesPanel();
		nonRoutineServicesPanel = new NonRoutineServicesPanel();
		
		//Create the button panel
		buildButtonPanel();

		// Add the services to the content pane
		add(routineServicesPanel, BorderLayout.NORTH);

		// add the non-routine services to the bottom of the content pane
		add(nonRoutineServicesPanel, BorderLayout.CENTER);
		
		// add the button panel to the bottom most part
		add(buttonPanel, BorderLayout.SOUTH);

		// pack the contents of the window and display it
		pack();
		setVisible(true);
	}

	private void buildButtonPanel() {
		// Create a panel for buttons
		buttonPanel = new JPanel();

		// Create the buttons
		buttonCalculate = new JButton("Calculate Charges");
		buttonExit = new JButton("Exit");

		// Add the buttons to the button panle
		buttonPanel.add(buttonCalculate);
		buttonPanel.add(buttonExit);
		
		buttonCalculate.addActionListener(new CalcButtonListener());
		buttonExit.addActionListener(new ExitButtonListener());
		
		buttonPanel.add(buttonCalculate);
		buttonPanel.add(buttonExit);
		

	}

	// handles the calculate button
	private class CalcButtonListener implements ActionListener {
		DecimalFormat df = new DecimalFormat("#,###,##0.00");
		double subTotal = 0.0;

		@Override
		public void actionPerformed(ActionEvent e) {
			subTotal = routineServicesPanel.getRoutineServicesCost()
					+ nonRoutineServicesPanel.getNonRoutineServicesCost();

			// Display the charges
			JOptionPane.showMessageDialog(null, "Total Charges: " + df.format(subTotal));

		}

	}

	/**
	 * Private inner class that handles the event when the user clicks the Exit
	 * button.
	 */
	private class ExitButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

	public static void main(String args[]) {
		new JoesAutomotive();
	}

}
