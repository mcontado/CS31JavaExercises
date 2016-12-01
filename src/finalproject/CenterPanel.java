package finalproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CenterPanel extends JPanel {

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
	
	static JLabel labelText = new JLabel("SCHEDULED",JLabel.CENTER); 
	
	JLabel toDisplay = new JLabel("");
	
	public CenterPanel(int row, int col) {
		
		setLayout(new GridLayout(row, col));
		setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				JPanel pan = new JPanel();
				
				pan.setEnabled(true);
				pan.setBackground(Color.WHITE);
				pan.setPreferredSize(new Dimension(3, 3));
				pan.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				// an exception to not click the top row and most left column headers
				if (i != 0 && j != 0) {
					pan.addMouseListener(new BoxListener()); // add a mouse listener to make the panels clickable
				}
				// set names for each panel for later use
				pan.setName("PANEL_" + i + "_" + j);
				add(pan);
				
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
				//adding labels to the first column
				if (j == 0) {
					if (i == 1) {
						pan.add(label0800);
					}else if (i == 2) {
						pan.add(label0900);
					}else if (i == 3) {
						pan.add(label1000);
					}else if (i == 4) {
						pan.add(label1100);
					}else if (i == 5) {
						pan.add(label1200);
					}else if (i == 6) {
						pan.add(label1300);
					}else if (i == 7) {
						pan.add(label1400);
					}else if (i == 8) {
						pan.add(label1500);
					}else if (i == 9) {
						pan.add(label1600);
					}else if (i == 10) {
						pan.add(label1700);
					}else if (i == 11) {
						pan.add(label1800);
					}else if (i == 12) {
						pan.add(label1900);
					}else if (i == 13) {
						pan.add(label2000);
					}else if (i == 14) {
						pan.add(label2100);
					}
				}
			}
			
		}
	}
	
	//Class that defines what happens when a panel is clicked
    public static class BoxListener extends MouseAdapter
    {
    	public void mouseClicked(MouseEvent me)
    	{	
    		// get the reference to the box that was clicked
              JPanel clickedBox =(JPanel)me.getSource(); 
              clickedBox.setBackground(Color.RED);
              clickedBox.setForeground(Color.BLACK);
           
             
              
        }
    }

}
