package main;

import javax.swing.JFrame;

import player.RocketPlayer;

public class Main {

	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setBounds(0,0,1000,700);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Game");
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Game.gamepanel = new Gamepanel();
		frame.add(Game.gamepanel);
		
		//setup player
		Game.rocket = new RocketPlayer();
		
		//begin game loop
		Game.run();	
	}

}
