package tools;

import main.Game;
import player.Camera;
import settings.Settings;

public class Tools {

	public static double toRads(double degrees) {
		return 2*Math.PI*degrees/360;
	}
	
	/*public static Vector2 applyTransform(Vector2 vec, Vector2 center) {
		return ((vec.subtract(center)).scale(Game.player.cam.zoomFactor)).add(center);
	}*/
	
	public static long handleDelta(long delta) {
		if(delta < Settings.minFrameTime) {
			try {
				Thread.sleep(Settings.minFrameTime-(delta));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return Settings.minFrameTime;
		}
		return delta;
	}
}
