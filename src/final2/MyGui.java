package final2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.Serializable;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class MyGui extends JFrame {

	final int WINDOW_WIDTH = 1000; // Window width in pixels
	final int WINDOW_HEIGHT = 800; // Window height in pixels

	static int idxProf = 0;
	static int idxCourse = 0;
	static int idxColor = 0;
	
	private JPanel topPanel;
	private JPanel buttonPanel;
	private JPanel centerPanel;

	private JButton buttonStore;
	private JButton buttonRestore;
	private JLabel labelFileName;
	private JTextField textFileName;

	// Create two radio buttons.
	public JRadioButton radioSchedule;
	public JRadioButton radioUnschedule;
	// for radio button selection
	static boolean isScheduled = true;

	// Create JLabels
	public JLabel labelStatus;
	public static JLabel labelCurrentStatus;


	// create combo boxes
	public JComboBox profNameBox;
	public JComboBox courseNameBox;
	public JComboBox colorNameBox;

	static String selectedProfName = "";
	static String selectedCourseName = "";
	static String selectedColorName = "";
	
	String[] professorNames = { "Select Professor Name", "Mr Schatz", "Mr Komanetsky",
			"Ms P" };
	String[] courseName = { "Select Course", "CS1", "CS2", "CS16", "CS21", "CS7" };
	String[] colorNames = { "Select Color", "RED", "BLUE", "YELLOW", "CYAN", "MAGENTA" };

	public static final String COMBO_CHANGED_PROF = "Combo Changed Prof";
	public static final String COMBO_CHANGED_COURSE = "Combo Changed Course";
	public static final String COMBO_CHANGED_COLOR = "Combo Changed Color";

	String oldValueProf = "";
	String oldValueCourse = "";
	String oldValueColor = "";
	
	static JLabel labelText = new JLabel("SCHED",JLabel.CENTER); 

	public MyGui() {
		// Display the title
		setTitle("Class Scheduler");

		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		// specify action for the close button
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create border layout
		setLayout(new BorderLayout());

		// Build the Top panel
		buildTopPanel();
		buildBottomPanel();
		buildCenterPanel();

		// Add the services to the content pane
		add(topPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		setVisible(true);
	}

	private void buildTopPanel() {
		// Create a panel for buttons
		topPanel = new JPanel();

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

		topPanel.add(radioSchedule);
		topPanel.add(radioUnschedule);

		// add the combo boxes into the content pane
		topPanel.add(profNameBox);
		topPanel.add(courseNameBox);
		topPanel.add(colorNameBox);
	}

	private void buildBottomPanel() {
		// Create a panel for buttons
		buttonPanel = new JPanel();

		// Create the buttons
		buttonStore = new JButton("Store");
		buttonRestore = new JButton("Restore");

		labelStatus = new JLabel("Status:");
		labelCurrentStatus = new JLabel("");
		
		labelFileName = new JLabel("Filename:");
		textFileName = new JTextField(10);

		// Add the buttons to the button panel
		buttonPanel.add(buttonStore);
		buttonPanel.add(buttonRestore);
		buttonPanel.add(labelFileName);
		buttonPanel.add(textFileName);
		
		buttonPanel.add(labelStatus);
		buttonPanel.add(labelCurrentStatus);

	}

	private void buildCenterPanel() {

		JLabel labelDayTime = new JLabel("Day/Time");
		JLabel labelMON = new JLabel("MON");
		JLabel labelTUE = new JLabel("TUE");
		JLabel labelWED = new JLabel("WED");
		JLabel labelTHU = new JLabel("THU");
		JLabel labelFRI = new JLabel("FRI");
		JLabel labelSAT = new JLabel("SAT");

		JLabel label0800 = new JLabel("08:00 - 09:00");
		JLabel label0900 = new JLabel("09:00 - 10:00");
		JLabel label1000 = new JLabel("10:00 - 11:00");
		JLabel label1100 = new JLabel("11:00 - 12:00");
		JLabel label1200 = new JLabel("12:00 - 13:00");
		JLabel label1300 = new JLabel("13:00 - 14:00");
		JLabel label1400 = new JLabel("14:00 - 15:00");
		JLabel label1500 = new JLabel("15:00 - 16:00");
		JLabel label1600 = new JLabel("16:00 - 17:00");
		JLabel label1700 = new JLabel("17:00 - 18:00");
		JLabel label1800 = new JLabel("18:00 - 19:00");
		JLabel label1900 = new JLabel("19:00 - 20:00");
		JLabel label2000 = new JLabel("20:00 - 21:00");
		JLabel label2100 = new JLabel("21:00 - 22:00");

		int row = 15;
		int col = 7;
		centerPanel = new JPanel();

		centerPanel.setLayout(new GridLayout(row, col));

		centerPanel.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				JPanel pan = new JPanel();

				pan.setEnabled(true);
				pan.setBackground(Color.WHITE);
				pan.setPreferredSize(new Dimension(3, 3));
				pan.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				// an exception to not click the top row and most left column
				// headers
				if (i != 0 && j != 0) {
					pan.addMouseListener(new BoxListener()); // add a mouse
																// listener to
																// make the
																// panels
																// clickable
				}
				// set names for each panel for later use
				pan.setName("PANEL_" + i + "_" + j);
				centerPanel.add(pan);

				if (i == 0) {
					// adding labels to the first row
					if (j == 0) {
						pan.add(labelDayTime);
					} else if (j == 1) {
						pan.add(labelMON);
					} else if (j == 2) {
						pan.add(labelTUE);
					} else if (j == 3) {
						pan.add(labelWED);
					} else if (j == 4) {
						pan.add(labelTHU);
					} else if (j == 5) {
						pan.add(labelFRI);
					} else if (j == 6) {
						pan.add(labelSAT);
					}
				}
				// adding labels to the first column
				if (j == 0) {
					if (i == 1) {
						pan.add(label0800);
					} else if (i == 2) {
						pan.add(label0900);
					} else if (i == 3) {
						pan.add(label1000);
					} else if (i == 4) {
						pan.add(label1100);
					} else if (i == 5) {
						pan.add(label1200);
					} else if (i == 6) {
						pan.add(label1300);
					} else if (i == 7) {
						pan.add(label1400);
					} else if (i == 8) {
						pan.add(label1500);
					} else if (i == 9) {
						pan.add(label1600);
					} else if (i == 10) {
						pan.add(label1700);
					} else if (i == 11) {
						pan.add(label1800);
					} else if (i == 12) {
						pan.add(label1900);
					} else if (i == 13) {
						pan.add(label2000);
					} else if (i == 14) {
						pan.add(label2100);
					}
				}

			}

		}
	}

	private class RadioActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == radioSchedule) {
				isScheduled = true;
			} else if (e.getSource() == radioUnschedule) {
				isScheduled = false;
			}

			System.out.println("Schedule: " + isScheduled);
		}

	}

	private class ComboBoxListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			selectedProfName = profNameBox.getSelectedItem().toString();
			selectedCourseName = courseNameBox.getSelectedItem().toString();
			selectedColorName = colorNameBox.getSelectedItem().toString();
			
			idxProf = profNameBox.getSelectedIndex();
			idxCourse = courseNameBox.getSelectedIndex();
			idxColor = colorNameBox.getSelectedIndex();

			firePropertyChange(COMBO_CHANGED_PROF, oldValueProf, selectedProfName);
			firePropertyChange(COMBO_CHANGED_COURSE, oldValueCourse, selectedCourseName);
			firePropertyChange(COMBO_CHANGED_COLOR, oldValueColor, selectedColorName);

			oldValueProf = selectedProfName;
			oldValueCourse = selectedCourseName;
			oldValueColor = selectedColorName;

			
		}
	}
	
	//Class that defines what happens when a panel is clicked
    public static class BoxListener extends MouseAdapter
    {
    	
		public void mouseClicked(MouseEvent me)
    	{	
			
    		// get the reference to the box that was clicked
              JPanel clickedBox =(JPanel)me.getSource(); 
              
              //if scheduled
              if (isScheduled) {
            	  
            	  // update the current status when the grid was clicked
            	  if (idxProf == 0 || idxCourse == 0 || idxColor == 0) {
            		  labelCurrentStatus.setText("Fill up ProfName/CourseName/Color combo box.");
            	  } else {
            		  labelText.setText(selectedProfName + "_" + selectedCourseName);
            		  if (selectedColorName.equals("RED")) {
                    	  clickedBox.setBackground(Color.RED);
                      } else if (selectedColorName.equals("BLUE")) {
                    	  clickedBox.setBackground(Color.BLUE);
                      } else if (selectedColorName.equals("CYAN")) {
                    	  clickedBox.setBackground(Color.CYAN);
                      } else if (selectedColorName.equals("YELLOW")) {
                    	  clickedBox.setBackground(Color.YELLOW);
                      } else if (selectedColorName.equals("MAGENTA")) {
                    	  clickedBox.setBackground(Color.MAGENTA);
                      }
            		  labelCurrentStatus.setText("");
                      clickedBox.add(labelText);
            		  
            	  }
            	  
            	  
            	  
              }
              // not scheduled 
              else {
            	  clickedBox.setBackground(Color.WHITE);
            	  clickedBox.remove(labelText);
              }
             
           
              System.out.println("store PROF: " + selectedProfName);
  			  System.out.println("store COURSE: " + selectedCourseName);
  			  System.out.println("store COLOR: " + selectedColorName);
  			  System.out.println("Scheduled? : " + isScheduled);
             
        }
    }

	public static void main(String args[]) {
		new MyGui();
	}
}
