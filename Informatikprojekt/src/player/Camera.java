package player;

import java.util.ArrayList;

import main.Game;
import settings.Settings;
import tools.Vector2;

public class Camera {

	public static Vector2 offset = new Vector2(-500, -350);
	public static double zoomFactor = 1;
	public static ArrayList<Vector2> stars = new ArrayList();
	
	public static void handleCamera(RocketPlayer p, long deltaT) {
		handleScroll(p, deltaT);
	}
	
	public static void handleScroll(RocketPlayer p, long deltaT) {
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
	
	public static void makeBackground() {
		if(stars.isEmpty()) {
			
			//populate the map with stars
			for(int i = 0; i < Settings.totalStars; i++) {
				stars.add(new Vector2((Math.random() > 0.5 ? -1 : 1)*Math.random()*10000, (Math.random() > 0.5 ? -1 : 1)*Math.random()*10000));
			}
		}
	}
}
