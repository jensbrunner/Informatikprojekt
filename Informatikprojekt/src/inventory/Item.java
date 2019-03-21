package inventory;

import java.util.ArrayList;

public class Item {

	public static ArrayList<String> itemNames = new ArrayList<String>() {
		{
		add("Dirt");
		add("Stone");
		add("Leather");
		add("Gold");
		add("Exotium");
		}
	};
	
	public static final int
			DIRT = 0,
			STONE = 1,
			LEATHER = 2,
			GOLD = 3,
			EXOTIUM = 4;
}
