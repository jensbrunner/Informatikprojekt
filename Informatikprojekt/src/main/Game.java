package main;

import javax.swing.JFrame;

import behaviour.BehaviourGameStateHandler;
import controls.SpaceControls;
import controls.TerrainControls;
import entity.EntityHandler;
import graphics.DrawingComponent;
import gui.GUIHandler;
import gui.GUIItems;
import gui.InventoryWindow;
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

	public static JFrame frame;
	public static InventoryWindow inventory;
	public static DrawingComponent draw;
	public static GUIItems gui;
	public static boolean running = false;
	public static GameState state = Settings.startState;
	public static Player player;
	
	public static void prepare() {
		
		Game.player = new Player();
		gui = new GUIItems();
		
		if(Game.state == GameState.SPACE) {
			LoadingHandler.loadSpace();
		}
		if(Game.state == GameState.TERRAIN) {
			LoadingHandler.loadTerrain(Game.player.curPlanet);
		}
		
		Game.draw = new DrawingComponent();
		Game.frame.add(Game.draw);
		Game.draw.requestFocus();
	}
	
	public static void run() {
		running = true;		
		
		long then = System.currentTimeMillis();
		
		while(running) {
			long now = System.currentTimeMillis();
			long delta = now-then;
			//System.out.println(delta);
			delta = Tools.handleDelta(delta);
			then = System.currentTimeMillis();
			
			BehaviourGameStateHandler.handleState(delta);
			
			draw.repaint();
		}
	}
	
	public static void switchState(GameState targetState, Planet p) {
		
		//from space to planet
		if(Game.state == GameState.SPACE && targetState == GameState.TERRAIN) {
			LoadingHandler.loadTerrain(p);
			Game.state = targetState;
			
		}
		
		//from planet to space 
		else if(Game.state == GameState.TERRAIN && targetState == GameState.SPACE) {
			LoadingHandler.loadSpace();
			Game.player.rocket.pos = new Vector2(p.pos.x, p.pos.y + p.diameter/1.8);
			Game.player.cam.center(Game.player.rocket.pos);
			Game.state = targetState;
			
		}
		
		SpaceControls.resetControls();
		TerrainControls.resetControls();
		GUIHandler.doGUI();
	}
}
