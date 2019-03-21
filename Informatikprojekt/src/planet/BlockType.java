package planet;

import java.util.ArrayList;

public class BlockType {

	public static final ArrayList<Integer> solids = new ArrayList<Integer>() {
		{
			add(BlockType.DIRT);
			add(BlockType.ROCK);
			add(BlockType.GOLD);
			add(BlockType.EXOTIUM);
		}
	};
	
	public static final ArrayList<Integer> fluids = new ArrayList<Integer>() {
		{
			add(BlockType.WATER);
		}
	};
	
	public static final int AIR = 0,
							DIRT = 1,
							WATER = 2,
							ROCK = 3,
							GOLD = 4,
							EXOTIUM = 5;
}
