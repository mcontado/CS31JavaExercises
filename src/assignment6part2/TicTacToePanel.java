package assignment6part2;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TicTacToePanel extends JPanel{
	
	private final int LABEL_FONTSIZE = 80; // Label's font size
	
	
	private JLabel labelRow1Col1;
	private JLabel labelRow1Col2;
	private JLabel labelRow1Col3;
	
	private JLabel labelRow2Col1;
	private JLabel labelRow2Col2;
	private JLabel labelRow2Col3;
	
	private JLabel labelRow3Col1;
	private JLabel labelRow3Col2;
	private JLabel labelRow3Col3;
	
	public TicTacToePanel() {
		
		// Sets a Grid with 7 rows and 1 column
		setLayout(new GridLayout(3, 3));
		
		labelRow1Col1 = new JLabel("1");
		labelRow1Col2 = new JLabel("2");
		labelRow1Col3 = new JLabel("3");
		labelRow2Col1 = new JLabel("4");
		labelRow2Col2 = new JLabel("5");
		labelRow2Col3 = new JLabel("6");
		labelRow3Col1 = new JLabel("7");
		labelRow3Col2 = new JLabel("8");
		labelRow3Col3 = new JLabel("9");
		
		labelRow1Col1.setFont(new Font("Serif", Font.BOLD, LABEL_FONTSIZE));
		labelRow1Col2.setFont(new Font("Serif", Font.BOLD, LABEL_FONTSIZE));
		labelRow1Col3.setFont(new Font("Serif", Font.BOLD, LABEL_FONTSIZE));
		labelRow2Col1.setFont(new Font("Serif", Font.BOLD, LABEL_FONTSIZE));
		labelRow2Col2.setFont(new Font("Serif", Font.BOLD, LABEL_FONTSIZE));
		labelRow2Col3.setFont(new Font("Serif", Font.BOLD, LABEL_FONTSIZE));
		labelRow3Col1.setFont(new Font("Serif", Font.BOLD, LABEL_FONTSIZE));
		labelRow3Col2.setFont(new Font("Serif", Font.BOLD, LABEL_FONTSIZE));
		labelRow3Col3.setFont(new Font("Serif", Font.BOLD, LABEL_FONTSIZE));
		
		add(labelRow1Col1);
		add(labelRow1Col2);
		add(labelRow1Col3);
		add(labelRow2Col1);
		add(labelRow2Col2);
		add(labelRow2Col3);
		add(labelRow3Col1);
		add(labelRow3Col2);
		add(labelRow3Col3);
	}

}
