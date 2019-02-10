package tools;

public class Vector2 {

	public double x;
	public double y;
	
	public static Vector2 zero = new Vector2(0.0, 0.0);
	
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
	
	public double mag() {
		return Math.sqrt(x*x+y*y);
	}
	
	public Vector2 scale(double scale) {
		double mag = this.mag();
		if(mag == 0) return new Vector2(0.0, 0.0);
		return new Vector2((scale/mag)*x, (scale/mag)*y);
	}
}
