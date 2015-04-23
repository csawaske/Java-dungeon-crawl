package game;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.*;

public class ButtonGrid {
	
	JFrame frame = new JFrame();
	public ButtonGrid(int width, int length) {
		frame.setLayout(new GridLayout(width, length));
		JButton[][] grid = new JButton[width][length];
		for (int y = 0; y < length; y++) {
			for (int x = 0; x < width; x++) {
				grid[x][y] = new JButton("(" + x + ", " + y + ")");
				frame.add(grid[x][y]);
			}
		}
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ButtonGrid(3, 3);
	}

}
