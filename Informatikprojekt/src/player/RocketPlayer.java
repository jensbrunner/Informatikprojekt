package player;

import settings.Settings;
import tools.Tools;
import tools.Vector2;

public class RocketPlayer {

	public double xVel, yVel, xPos, yPos, angle;
	public boolean inertdamp;
	public int[] nose;
	public int[] backleft;
	public int[] backright;
	
	public RocketPlayer() {
		xVel = 0.0;
		yVel = 0.0;
		xPos = 0.0;
		yPos = 0.0;
		angle = 0.0;
		inertdamp = true;
	}
	
	public void computeVertices() {
		nose = new int[]{(int)(xPos+Math.cos(Tools.toRads(angle))*Settings.rocketFrontLength), (int)(yPos+Math.sin(Tools.toRads(angle))*Settings.rocketFrontLength)};
		backleft = new int[]{(int)( xPos+Math.cos(Tools.toRads(angle+Settings.rocketCornerAngle))*Settings.rocketSideLength), (int)( yPos+Math.sin(Tools.toRads(angle+Settings.rocketCornerAngle))*Settings.rocketSideLength)};
		backright = new int[]{(int)( xPos+Math.cos(Tools.toRads(angle-Settings.rocketCornerAngle))*Settings.rocketSideLength), (int)( yPos+Math.sin(Tools.toRads(angle-Settings.rocketCornerAngle))*Settings.rocketSideLength)};
	}
	
	public void handlePhysics(long deltaT) {
		deltaT = deltaT== 0 ? 1 : deltaT;
		
		//inertial dampeners, every second 150m/s
		if(inertdamp && !Controls.any) {
			double toDampen = (deltaT/1000.0)*Settings.dampenerSpeed;
			Vector2 oldVel = new Vector2(xVel, yVel);
			Vector2 newVel = oldVel.scale(oldVel.mag()*((oldVel.mag()-toDampen)/oldVel.mag()));
			if(newVel.mag() <= (deltaT/1000.0)*Settings.dampenerSpeed) {
				newVel = Vector2.zero;
			}
			//System.out.println(oldVel.mag());
			xVel = newVel.x;
			yVel = newVel.y;
		}
		
		xPos+=xVel*(deltaT/1000.0);
		yPos+=yVel*(deltaT/1000.0);
	}
}
