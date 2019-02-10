package player;

import main.Game;
import tools.Vector2;

public class Camera {

	public static Vector2 offset = new Vector2(-500, -350);
	public static double zoomFactor = 1;
	
	public static void handleCamera(RocketPlayer p, long deltaT) {
		deltaT = deltaT== 0 ? 1 : deltaT;
		if(p.xPos-offset.x > 800 && p.xVel>0) {
			offset.x+=(deltaT/1000.0)*p.xVel;
		}
		if(p.xPos-offset.x < 200 && p.xVel<0) {
			offset.x+=(deltaT/1000.0)*p.xVel;
		}
		if(p.yPos-offset.y > 600 && p.yVel>0) {
			offset.y+=(deltaT/1000.0)*p.yVel;
		}
		if(p.yPos-offset.y < 100 && p.yVel<0) {
			offset.y+=(deltaT/1000.0)*p.yVel;
		}
	}
}
