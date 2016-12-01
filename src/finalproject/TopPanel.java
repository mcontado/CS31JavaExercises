package finalproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TopPanel extends JPanel {
	// Create JLabels
	public JLabel labelStatus;
	public JLabel labelCurrentStatus;
	public JLabel labelSchedule;

	// Create two radio buttons.
	public JRadioButton radioSchedule;
	public JRadioButton radioUnschedule;

	// create combo boxes
	public JComboBox profNameBox;
	public JComboBox courseNameBox;
	public JComboBox colorNameBox;

	String selectedProfName = "";
	String selectedCourseName = "";
	String selectedColorName = "";
	// for radio button selection
	boolean isSchedule = false;

	String[] professorNames = { "Select Professor Name", "Professor Schatz", "Professor Komanetsky", "Professor Pentcheva" };
	String[] courseName = { "Select Course", "CS1", "CS2", "CS16", "CS21", "CS7" };
	String[] colorNames = { "Select Color", "Red", "Blue", "Yellow", "Cyan", "Magenta" };

	public TopPanel() {
		// Sets a Grid with 7 rows and 1 column
		setLayout(new GridLayout(7, 1));

		// Create the JLabels
		labelStatus = new JLabel("Status:");
		labelCurrentStatus = new JLabel("");
		labelSchedule = new JLabel("");

		// Create two radio buttons.
		radioSchedule = new JRadioButton("Schedule", true);
		radioUnschedule = new JRadioButton("Unschedule");

		// Create a ButtonGroup object.
		ButtonGroup group = new ButtonGroup();
		// Add the radio buttons to the ButtonGroup object.
		group.add(radioSchedule);
		group.add(radioUnschedule);
		
		// Add action listeners to the radio buttons
		radioSchedule.addActionListener(new RadioActionListener());
		radioUnschedule.addActionListener(new RadioActionListener());

		// create combo boxes
		profNameBox = new JComboBox(professorNames);
		courseNameBox = new JComboBox(courseName);
		colorNameBox = new JComboBox(colorNames);

		// Register an action listener for each combo box
		profNameBox.addActionListener(new ComboBoxListener());
		courseNameBox.addActionListener(new ComboBoxListener());
		colorNameBox.addActionListener(new ComboBoxListener());

		// Add a border around the panel
		setBorder(BorderFactory.createTitledBorder("ROOM 2400"));

		add(radioSchedule);
		add(radioUnschedule);

		// add the combo boxes into the content pane
		add(profNameBox);
		add(courseNameBox);
		add(colorNameBox);
		add(labelCurrentStatus);

	}

	private class ComboBoxListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// Get the selected coffee.
			selectedProfName = (String) profNameBox.getSelectedItem();
			selectedCourseName = (String) courseNameBox.getSelectedItem();
			selectedColorName = (String) colorNameBox.getSelectedItem();

			labelCurrentStatus.setText(selectedProfName + "," + selectedCourseName + "," + selectedColorName);
		}
	}

	
	
	private class RadioActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == radioSchedule) {
				isSchedule = true;
			} else if (e.getSource() == radioUnschedule){
				isSchedule = false;
			}
			
			System.out.println("Schedule: " + isSchedule);
		}
		
		
	}
	public String getSelectedProfName() {
		return selectedProfName;
	}

	public String getSelectedCourseName() {
		return selectedCourseName;
	}

	public String getSelectedColorName() {
		return selectedColorName;
	}

	public String getLabelSchedule() {
		return selectedProfName + "\n" + selectedCourseName;
	}
}
