package protoGame;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class Window extends Canvas{

	private static final long serialVersionUID = -3584066526914528758L;
	
	JLabel label = new JLabel();

	public Window(int width, int height, String title, Game game) {
		JFrame frame= new JFrame(title); //the frame of the window(in built library of java)
		
		frame.setPreferredSize(new Dimension(width, height)); //dimensions of window
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		frame.setTitle("StarPath Pre-Alpha 0.8.5");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // closes program that stops the thread in the game operations
		frame.setResizable(false); 
		frame.setLocationRelativeTo(null);// sets window to middle of screen instead of top left
		frame.add(game);// adding the game class into the frame
		frame.setVisible(true); // sets to visible so you can see it
		game.start(); // runs the start method
	}
}