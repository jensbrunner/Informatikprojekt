package player;

import settings.Settings;
import tools.Tools;

public class RocketPlayer {

	public double xVel, yVel, xPos, yPos, angle;
	
	public int[] nose;
	public int[] backleft;
	public int[] backright;
	
	public RocketPlayer() {
		xVel = 0.0;
		yVel = 0.0;
		xPos = 0.0;
		yPos = 0.0;
		angle = 0.0;
	}
	
	public void computeVertices() {
		nose = new int[]{(int)(xPos+Math.cos(Tools.toRads(angle))*Settings.rocketFrontLength), (int)(yPos+Math.sin(Tools.toRads(angle))*Settings.rocketFrontLength)};
		backleft = new int[]{(int)( xPos+Math.cos(Tools.toRads(angle+Settings.rocketCornerAngle))*Settings.rocketSideLength), (int)( yPos+Math.sin(Tools.toRads(angle+Settings.rocketCornerAngle))*Settings.rocketSideLength)};
		backright = new int[]{(int)( xPos+Math.cos(Tools.toRads(angle-Settings.rocketCornerAngle))*Settings.rocketSideLength), (int)( yPos+Math.sin(Tools.toRads(angle-Settings.rocketCornerAngle))*Settings.rocketSideLength)};
	}
	
	public void handlePhysics(long deltaT) {
		deltaT = deltaT== 0 ? 1 : deltaT;
		xPos+=xVel*(deltaT/1000.0);
		yPos+=yVel*(deltaT/1000.0);
	}
}
