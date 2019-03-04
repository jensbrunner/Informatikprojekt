package main;

import javax.swing.JFrame;

import player.RocketPlayer;
import settings.Settings;

public class Main {

	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setBounds(0,0,Settings.screenWidth,Settings.screenHeight);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Game");
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Game.gamepanel = new Gamepanel();
		frame.add(Game.gamepanel);
		
		//prepare game
		Game.prepare();
		
		//begin game loop
		Game.run();
		
		//if this is ever reached, the game terminates
		System.exit(0);
	}
}
