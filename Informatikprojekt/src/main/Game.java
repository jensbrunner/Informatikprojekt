package main;

import player.Camera;
import player.Controls;
import player.RocketPlayer;
import settings.Settings;

public class Game {

	public static Gamepanel gamepanel;
	public static boolean running = false;
	public static RocketPlayer rocket;
	
	public static void run() {
		running = true;
		long then = System.currentTimeMillis();
		
		while(running) {
			long now = System.currentTimeMillis();
			long delta = now-then;
			if(delta < Settings.minFrameTime) {
				try {
					Thread.sleep(Settings.minFrameTime-(delta));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			then = System.currentTimeMillis();
			
			//camera
			Camera.handleCamera(Game.rocket, delta);
			
			//handle Controls
			Controls.handleControls();
			
			//physics
			Game.rocket.handlePhysics(delta);
			
			gamepanel.repaint();
		}	
	}
}
