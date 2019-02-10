package tools;

public class Vector2 {

	public double x;
	public double y;
	
	public Vector2(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Vector2 add(Vector2 vec) {
		return new Vector2(x+vec.x, y+vec.y);
	}
	
	public Vector2 subtract(Vector2 vec) {
		return new Vector2(x-vec.x, y-vec.y);
	}
	
	public Vector2 scale(double scale) {
		double mag = Math.sqrt(x*x+y*y);
		return new Vector2((scale/mag)*x, (scale/mag)*y);
	}
}
