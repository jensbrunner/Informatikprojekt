package player;

import controls.SpaceControls;
import settings.Settings;
import tools.Tools;
import tools.Vector2;

public class RocketPlayer {

	public double angle;
	public Vector2 pos, vel;
	public boolean inertdamp;
	
	public Vector2 nose = new Vector2(0, 0);
	public Vector2 backleft = new Vector2(0, 0);
	public Vector2 backright = new Vector2(0, 0);
	
	public RocketPlayer(Vector2 pos) {
		this.pos = new Vector2(pos.x,pos.y);
		vel = new Vector2(0,0);
		angle = 0.0;
		inertdamp = false;
	}
	
	public void computeVertices() {
		nose.x = pos.x+Math.cos(Tools.toRads(angle))*Settings.rocketFrontLength;
		nose.y = pos.y+Math.sin(Tools.toRads(angle))*Settings.rocketFrontLength;
		backleft.x = pos.x+Math.cos(Tools.toRads(angle+Settings.rocketCornerAngle))*Settings.rocketSideLength;
		backleft.y = pos.y+Math.sin(Tools.toRads(angle+Settings.rocketCornerAngle))*Settings.rocketSideLength;
		backright.x = pos.x+Math.cos(Tools.toRads(angle-Settings.rocketCornerAngle))*Settings.rocketSideLength;
		backright.y = pos.y+Math.sin(Tools.toRads(angle-Settings.rocketCornerAngle))*Settings.rocketSideLength;
	}
	
	public void handlePhysics(long delta) {
		delta = delta== 0 ? 1 : delta;
		
		//inertial dampeners, every second 150m/s
		handleDampeners(delta);
		
		pos.x+=vel.x*(delta/1000.0);
		pos.y+=vel.y*(delta/1000.0);
	}
	
	public void handleDampeners(long delta) {
		if(inertdamp && !SpaceControls.any) {
			double toDampen = (delta/1000.0)*Settings.dampenerSpeed;
			//Vector2 oldVel = new Vector2(xVel, yVel);
			Vector2 newVel = vel.scale(vel.mag()*((vel.mag()-toDampen)/vel.mag()));
			if(newVel.mag() <= (delta/1000.0)*Settings.dampenerSpeed) {
				newVel = new Vector2(0,0);
			}
			vel = newVel;
		}
	}
}
