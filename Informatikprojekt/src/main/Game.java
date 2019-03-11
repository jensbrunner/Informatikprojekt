package main;

import behaviour.BehaviourGameStateHandler;
import controls.SpaceControls;
import entity.EntityHandler;
import planet.Planet;
import planet.PlanetType;
import player.Camera;
import player.Message;
import player.Player;
import player.RocketPlayer;
import settings.Settings;
import tools.Tools;
import tools.Vector2;

public class Game {

	public static Gamepanel gamepanel;
	public static boolean running = false;
	public static GameState state = Settings.startState;
	public static Player player;
	
	public static void prepare() {
		
		Game.player = new Player();
		
		if(Game.state == GameState.SPACE) {
			LoadingHandler.loadSpace();
		}
		if(Game.state == GameState.TERRAIN) {
			LoadingHandler.loadTerrain(Game.player.curPlanet);
		}
	}
	
	public static void run() {
		running = true;		
		
		long then = System.currentTimeMillis();
		
		while(running) {
			long now = System.currentTimeMillis();
			long delta = now-then;
			System.out.println(delta);
			delta = Tools.handleDelta(delta);
			then = System.currentTimeMillis();
			
			BehaviourGameStateHandler.handleState(delta);
			
			gamepanel.repaint();
		}
	}
	
	public static void switchState(GameState targetState, Planet p) {
		Game.state = GameState.TERRAIN;
		LoadingHandler.loadTerrain(p); //TODO: How long to wait, etc
		//Game.state = targetState;
	}
}
