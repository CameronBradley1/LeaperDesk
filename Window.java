package com.LeaperGame.main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Window extends Canvas{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8255319694373975038L;
	
	public static int WIDTH , HEIGHT;

	public Window(String title, LeaperGame game) {
		
		JFrame frame  = new JFrame(title);
		
		
		//frame.setMaximumSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
		//frame.setMinimumSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds(screenSize.width / 3, screenSize.height/10,screenSize.width / 3 , screenSize.height - (screenSize.height / 10));
		WIDTH = screenSize.width / 3;
		HEIGHT = screenSize.height - (screenSize.height / 10);
		
		frame.setUndecorated(true);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setVisible(true);
		
		
		game.start();

		
	}
	
	public int getW() {
		return WIDTH;
	}
	public int getH() {
		return HEIGHT;
	}
	
}
