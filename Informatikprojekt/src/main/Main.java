package main;

import javax.swing.JFrame;

import gui.InventoryWindow;
import settings.Settings;

public class Main {

	public static void main(String[] args) {
		Game.frame = new JFrame("Game");
		Game.frame.setSize(Settings.screenWidth,Settings.screenHeight);
		Game.frame.setLayout(null);
		Game.frame.setResizable(false);
		Game.frame.setLocationRelativeTo(null);
		Game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Game.frame.setVisible(true);
		
		Game.inventory = new InventoryWindow();
		
		//prepare game
		Game.prepare();
		
		//begin game loop
		Game.run();
		
		//if this is ever reached, the game terminates
		System.exit(0);
	}
}
