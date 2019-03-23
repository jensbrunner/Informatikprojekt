package settings;

import java.awt.Color;
import java.util.ArrayList;

import main.GameState;
import planet.Planet;
import tools.Vector2;

public class Settings {

	public static Vector2 startPos = new Vector2(0,0);
	public static int screenWidth = 1000, screenHeight = 700;
	public static double minFrameTime = 1000.0/300.0;
	public static double rocketFrontLength = 20, rocketSideLength = 10, rocketCornerAngle = 120;
	public static int totalStars = 30000;
	public static double dampenerSpeed = 300;
	public static int shotsPerSec = 10, shotLife = 10000;
	public static GameState startState = GameState.SPACE;
	public static int numberOfPlanets = 700;
	public static ArrayList<Planet> planets = new ArrayList<Planet>();
	public static Color defaultColor = new Color(0,102,51);
	public static Color mountainColor = new Color(160,160,160);
	public static Color waterColor = new Color(0,0,255);
	public static Color playerColor = Color.GRAY;
	public static Color skyColor = new Color(135,206,250);
	public static Color goldColor = new Color(255,215,0);
	public static Color exotiumColor = new Color(128, 0, 128);
	public static int playerWidth = 14, playerHeight = 38;
	public static int playerWalkSpeed = 300, playerJumpSpeed = 380;
	public static int planetHeight = 100;
	public static int blockSize = 20;
	public static double planetGravAcc = 1000;
	public static double fluidAcc = 1500;
	public static int buttonHeight = 20, buttonWidth = 100;
	public static double lockOnDistance = 300, hitDistance = 30;
	public static int enemyWalkSpeed = 200, enemyRunSpeed = 300, enemyJumpSpeed = 200;
	public static int enemyCount = 10;
	public static int enemySize = 17;
	public static int enemyHealth = 50;
	public static int enemyDamage = 10;
	public static long enemyBehaviourTime = 2000;
	public static Color enemyColor = Color.red;
	public static long playerDamageCooldown = 500;
	public static int inventorySlots = 5;
	public static int terrainShotsPerSec = 3;
	public static int terrainShotSpeed = 250000;
	public static int shotSpeed = 200000;
	public static double playerReach = 250;
	public static Vector2 playerOffset = new Vector2(Settings.playerWidth/2, -Settings.playerHeight/2);
	public static int shotDamage = 10;
	public static long destroyWait = 100;
}
