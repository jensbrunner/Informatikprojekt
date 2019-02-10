package player;

import main.Game;
import tools.Tools;

public class Controls {

	public static boolean left = false, right = false, forward = false, back = false, any = false;
	
	public static void handleControls() {
		if(left) {
			Game.rocket.angle-=3;
		}
		if(right) {
			Game.rocket.angle+=3;
		}
		if(forward) {
			Game.rocket.xVel+=Math.cos(Tools.toRads(Game.rocket.angle))*2;
			Game.rocket.yVel+=Math.sin(Tools.toRads(Game.rocket.angle))*2;
		}
		if(back) {
			Game.rocket.xVel-=Math.cos(Tools.toRads(Game.rocket.angle))*1;
			Game.rocket.yVel-=Math.sin(Tools.toRads(Game.rocket.angle))*1;
		}
		if(forward || back) {
			any = true;
		}else {
			any = false;
		}
	}
}
