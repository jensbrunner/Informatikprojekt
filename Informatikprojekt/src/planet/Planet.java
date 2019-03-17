package planet;

import settings.Settings;
import tools.Vector2;

public class Planet {

	public Vector2 pos;
	public int diameter;
	public int sizeX, sizeY;
	public int type;
	
	public int[][] map;
	
	public Planet(Vector2 pos, int diameter, int type) {
		this.pos = new Vector2(pos.x, pos.y);
		this.diameter = diameter;
		sizeX = (int)(diameter*2);
		sizeY = Settings.planetHeight;
		this.type = type;
		this.map = new int[sizeX][sizeY];
	}
	
	
}
