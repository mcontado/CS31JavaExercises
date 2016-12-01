package assignment6part2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.LineBorder;


public class TicTacToeSimulator extends JFrame {
	
	final int WINDOW_WIDTH = 300;
	final int WINDOW_HEIGHT = 300;
		
	//Button New Game and exit
	private JButton buttonNewGame; 
	private JButton buttonExit; 

	private JPanel buttonPanel;
	public JPanel ticTacToePanel;
	
	private TicTacToePanel tPanel;
	
	public TicTacToeSimulator() {
		setTitle("Tic Tac Toe Simulator");
		
		// Set the size of this window.
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		// specify action for the close button
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create border layout 
		setLayout(new BorderLayout());
		
		ticTacToePanel = new JPanel();
		
		tPanel = new TicTacToePanel();
		
		
		ticTacToePanel.setLayout(new GridLayout(3, 3));
		
		// build the button panel
		buildButtonPanel();
		
		//add(ticTacToePanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		
		setVisible(true);
		
	}
	
	private void buildButtonPanel() {
		//setLayout(new GridLayout(1, 2));
		
		// Create a panel for buttons
		buttonPanel = new JPanel();

		// Create the buttons
		buttonNewGame = new JButton("New Game");
		buttonExit = new JButton("Exit");

		// Add the buttons to the button panel
		buttonPanel.add(buttonNewGame);
		buttonPanel.add(buttonExit);
		
		buttonNewGame.addActionListener(new NewGameButtonListener());
		buttonExit.addActionListener(new ExitButtonListener());

		
	}
	
	/**
	 * Private inner class that handles the event when the user clicks the New Game
	 * button.
	 * 
	 * One approach in designing this application is to use a two-dimensional int array to simulate
the game board in memory. When the user clicks the New Game button, the application
should step through the array, storing a random number in the range of 0 through 1 in each
element. The number 0 represents the letter O, and the number 1 represents the letter X. The
JLabel components should then be updated to display the game board. The application should
display a message indicating whether player X won, player Y won, or the game was a tie.
	 */
	private class NewGameButtonListener implements ActionListener {
		
		int row = 3;
		int col = 3;
		int[][] array = new int[row][col];
		JLabel[][] grid= new JLabel[row][col];
		JLabel label1 = new JLabel("X");
		
		@Override
		public void actionPerformed(ActionEvent e) {
		
			for (int i=0; i<row; i++) {
				for (int j=0; j<col; j++) {
					array[i][j] = randInt(0, 1);
					//System.out.println("array[" +i+ "][" +j+ "]:" + array[i][j]);
					// 0 = O
					if (array[i][j] == 0) {
						grid[i][j] = new JLabel("O");
						
					} else {
						// 1 = X
						grid[i][j] = new JLabel("X");
					}
					
					System.out.println("grid[" + i+ "][" +j+ "]:" + grid[i][j].getText());
					//grid[i][j].setBorder(new LineBorder(Color.BLACK));
					//grid[i][j].setOpaque(true);
					//grid[i][j].setFont(new Font("Serif", Font.BOLD, 80));
					ticTacToePanel.add(grid[i][j]);
					
					
				} // end inner loop
			} // end outer loop
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
	
	/**
	 * Returns a psuedo-random number between min and max, inclusive.
	 * The difference between min and max can be at most
	 * <code>Integer.MAX_VALUE - 1</code>.
	 *
	 * @param min Minimim value
	 * @param max Maximim value.  Must be greater than min.
	 * @return Integer between min and max, inclusive.
	 * @see java.util.Random#nextInt(int)
	 */
	public static int randInt(int min, int max) {

	    // Usually this can be a field rather than a method variable
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	public static void main(String args[]) {
		new TicTacToeSimulator();
		
	}
	
}
