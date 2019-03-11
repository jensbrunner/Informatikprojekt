package settings;

import java.awt.Color;
import java.util.ArrayList;

import main.GameState;
import planet.Planet;
import tools.Vector2;

public class Settings {

	public static Vector2 startPos = new Vector2(0,0);
	public static int screenWidth = 1000;
	public static int screenHeight = 700;
	public static double minFrameTime = 1000.0/100.0;
	public static double rocketFrontLength = 20;
	public static double rocketSideLength = 10;
	public static double rocketCornerAngle = 120;
	public static int totalStars = 30000;
	public static double dampenerSpeed = 300;
	public static int shotsPerSec = 10;
	public static int shotLife = 10000;
	public static GameState startState = GameState.SPACE;
	public static ArrayList<Planet> planets = new ArrayList<Planet>();
	public static Color defaultColor = new Color(0,102,51);
	public static Color mountainColor = new Color(160,160,160);
	public static Color waterColor = new Color(0,0,255);
	public static Color playerColor = Color.GRAY;
	public static Color skyColor = new Color(135,206,250);
	public static int playerWidth = 14;
	public static int playerHeight = 40;
	public static int playerWalkSpeed = 1000;
	public static int playerJumpSpeed = 250;
	public static int planetWidth = 1000;
	public static int planetHeight = 100;
	public static int blockSize = 20;
	public static double planetGravAcc = 500;
}
