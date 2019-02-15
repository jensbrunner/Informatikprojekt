package planet;

import settings.Settings;
import tools.Vector2;

public class Planet {

	public Vector2 pos;
	public int diameter;
	public PlanetType type;
	
	public int[][] map;
	
	public Planet(Vector2 pos, int diameter, PlanetType type) {
		this.pos = new Vector2(pos.x, pos.y);
		this.diameter = diameter;
		this.type = type;
		this.map = new int[Settings.planetWidth][Settings.planetHeight];
	}
	
}
