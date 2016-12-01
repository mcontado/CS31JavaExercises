package finalproject;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class SchedulerGui extends JFrame implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6683495940483588568L;
	
	
	final int WINDOW_WIDTH = 1000; // Window width in pixels
	final int WINDOW_HEIGHT = 800; // Window height in pixels
	
	private TopPanel topPanel;
	private CenterPanel centerPanel;
	
	private JPanel buttonPanel;
	private JButton buttonStore;
	private JButton buttonRestore;
	private JLabel labelFileName;
	private JTextField textFileName;
	
	public SchedulerGui() {
		// Display the title
		setTitle("Class Scheduler");
		
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		// specify action for the close button
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create border layout
		setLayout(new BorderLayout());

		// create the custom panels;
		topPanel = new TopPanel();
		centerPanel = new CenterPanel(15,7);
		
		//Create the button panel
		buildButtonPanel();

		// Add the services to the content pane
		add(topPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		
		// add the button panel to the bottom most part
		add(buttonPanel, BorderLayout.SOUTH);

		//pack();
		setVisible(true);
	}
	
	private void buildButtonPanel() {
		// Create a panel for buttons
		buttonPanel = new JPanel();

		// Create the buttons
		buttonStore = new JButton("Store");
		buttonRestore = new JButton("Restore");
		
		labelFileName = new JLabel("Filename:");
		textFileName = new JTextField(10);

		// Add the buttons to the button panel
		buttonPanel.add(buttonStore);
		buttonPanel.add(buttonRestore);
		buttonPanel.add(labelFileName);
		buttonPanel.add(textFileName);
		
		buttonStore.addActionListener(new StoreButtonListener());
		buttonRestore.addActionListener(new RestoreButtonListener());


	}
	
	
	private class StoreButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				SerializationUtil.serialize(SchedulerGui.class, textFileName.toString());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	private class RestoreButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				SerializationUtil.deserialize(textFileName.toString());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public static void main(String args[]) {
		new SchedulerGui();
	}
}
