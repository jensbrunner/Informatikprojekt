package collision;

import tools.Vector2;

public class AABB {

	public Vector2 pos;
	public int height, width;
	
	public AABB(Vector2 pos, int height, int width) {
		this.pos = new Vector2(pos.x, pos.y);
		this.height = height;
		this.width = width;
	}
	
	public boolean collides(AABB other) {
		Vector2 midA = new Vector2(pos.x + width/2, pos.y + height/2);
		Vector2 midB = new Vector2(other.pos.x + other.width/2, other.pos.y + other.height/2);
		
		if(Math.abs(midA.x-midB.x) < width/2 + other.width/2 && Math.abs(midA.y-midB.y) < height/2 + other.height/2){
			return true;
		}
		return false;
	}
	
	public Vector2 getCollisionData(AABB other) {
		Vector2 midA = new Vector2(pos.x + width/2, pos.y + height/2);
		Vector2 midB = new Vector2(other.pos.x + other.width/2, other.pos.y + other.height/2);
		
		double diffX = midA.x-midB.x;
		double diffY = midA.y-midB.y;
		
		int signX = diffX > 0 ? 1 : -1;
		int signY = diffY > 0 ? 1 : -1;
		
		double intersectX = signX * (Math.abs(diffX) - width/2 - other.width/2);
		double intersectY = signY * (Math.abs(diffY) - height/2 - other.height/2);
	
		return new Vector2(intersectX, intersectY);
	}
}
