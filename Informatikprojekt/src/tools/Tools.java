package tools;

import main.Game;
import player.Camera;

public class Tools {

	public static double toRads(double degrees) {
		return 2*Math.PI*degrees/360;
	}
	
	public static Vector2 applyTransform(Vector2 vec, Vector2 center) {
		return ((vec.subtract(center)).scale(Camera.zoomFactor)).add(center);
	}
}
