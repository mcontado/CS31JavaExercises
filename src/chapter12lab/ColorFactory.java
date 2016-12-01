package chapter12lab;

import javax.swing.*; //Needed for swing classes
import java.awt.*;    // Needed for BorderLayout class
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ColorFactory extends JFrame {
	final int WINDOW_WIDTH = 500;
	final int WINDOW_HEIGHT = 300;
	
	private JButton redButton; 
	private JButton orangeButton; 
	private JButton yellowButton;
	
	private JRadioButton greenRadio;
	private JRadioButton blueRadio;
	private JRadioButton cyanRadio;
	
	//private JPanel panel;
	private JPanel topPanel;
	private JPanel bottomPanel;
	
	private JLabel messageLabel;
	
	//Default Constructor
	public ColorFactory() {
		//a. Set the title of the window to Color Factory.
		setTitle("Color Factory");
		
		//b. Set the size of the window using the constants.
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		//c. Specify what happens when the close button is clicked.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//d. Get the content pane of the JFrame and set the layout manager to border layout.
		setLayout(new BorderLayout());
		
		//panel = new JPanel();
	
//		e. Call the method to build the top panel (to be written as directed below).
		buildTopPanel();
		
//		f. Add the panel to the north part of the content pane.
		add(topPanel, BorderLayout.NORTH);
		
//		g. Call the method to build the bottom panel (to be written as directed below).
		buildBottomPanel();
		
//		h. Add this panel to the south part of the content pane.
		add(bottomPanel, BorderLayout.SOUTH);
		
//		i. Create a label that contains the message “Top buttons change the panel color and
//		bottom radio buttons change the text color.”
		messageLabel = new JLabel("Top buttons change the panel color and bottom radio buttons change the text color");
		
//		j. Add this label to the center part of the content pane.
		add(messageLabel, BorderLayout.CENTER);
		
		// Display the window.
		setVisible(true);
		
	}
	
	// Write a private method that builds the top panel as follows
	private void buildTopPanel() {
		
		//a. Create a panel that contains three buttons, red, orange, and yellow.
		redButton = new JButton("Red");
		orangeButton = new JButton("Orange"); 
		yellowButton = new JButton("Yellow");
		
		topPanel = new JPanel();
		topPanel.add(redButton);
		topPanel.add(orangeButton);
		topPanel.add(yellowButton);
		
		//b. Use flow layout for the panel and set the background to be white.
		topPanel.setBackground(Color.white);

		//c. The buttons should be labeled with the color name and also appear in that color.
		redButton.setBackground(Color.red);
		redButton.setOpaque(true);
		redButton.setBorderPainted(false);
		
		orangeButton.setBackground(Color.orange);
		orangeButton.setOpaque(true);
		orangeButton.setBorderPainted(false);
		
		yellowButton.setBackground(Color.yellow);
		yellowButton.setOpaque(true);
		yellowButton.setBorderPainted(false);
		
//		d. Set the action command of each button to be the first letter of the color name.
		redButton.setActionCommand("R");
		orangeButton.setActionCommand("O");
		yellowButton.setActionCommand("Y");

		//e. Add button listener that implements action listener for each button.
		redButton.addActionListener(new ButtonListener());
		orangeButton.addActionListener(new ButtonListener());
		yellowButton.addActionListener(new ButtonListener());
		
		setVisible(true);
		 
	}
	
//	2. Create a bottom panel in the same way as the top panel above, but use radio buttons with the colors green, blue, and cyan.

	private void buildBottomPanel() {
		
		//a. Create a panel that contains three buttons, red, orange, and yellow.
		greenRadio = new JRadioButton("Green", true);
		blueRadio = new JRadioButton("Blue");
		cyanRadio = new JRadioButton("Cyan");
		
		ButtonGroup group = new ButtonGroup();
		
		group.add(greenRadio);
		group.add(blueRadio);
		group.add(cyanRadio);
		
		bottomPanel = new JPanel();
		bottomPanel.add(greenRadio);
		bottomPanel.add(blueRadio);
		bottomPanel.add(cyanRadio);
		
		//b. Use flow layout for the panel and set the background to be white.
		bottomPanel.setBackground(Color.white);
		
		//c. The buttons should be labeled with the color name and also appear in that color.
		greenRadio.setForeground(Color.green);
		blueRadio.setForeground(Color.blue);
		cyanRadio.setForeground(Color.cyan);
		
//		d. Set the action command of each button to be the first letter of the color name.
		greenRadio.setActionCommand("R");
		blueRadio.setActionCommand("O");
		cyanRadio.setActionCommand("Y");

		//e. Add button listener that implements action listener for each radio button.
		greenRadio.addActionListener(new RadioButtonListener());
		blueRadio.addActionListener(new RadioButtonListener());
		cyanRadio.addActionListener(new RadioButtonListener());
		
		setVisible(true);
		 
	}
	
	private class ButtonListener implements ActionListener  {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == redButton) {
				messageLabel.setBackground(Color.red);
				messageLabel.setOpaque(true);
				
			} else if (e.getSource() == orangeButton) {
				messageLabel.setBackground(Color.orange);
				messageLabel.setOpaque(true);
			} else {
				messageLabel.setBackground(Color.yellow);
				messageLabel.setOpaque(true);
			}
			
		}
	
	}
	
	private class RadioButtonListener implements ActionListener  {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == greenRadio) {
				messageLabel.setForeground(Color.green);
			} else if (e.getSource() == blueRadio) {
				messageLabel.setForeground(Color.blue);
			} else {
				messageLabel.setForeground(Color.cyan);
			}
			
		}
	
	}
	
	public static void main(String args[]) {
		new ColorFactory();
	}
	
	
}
