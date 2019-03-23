package inventory;

import main.Game;

public class InventoryHandler {

	public static boolean hasItemAmount(int id, int amount) {
		for(Slot s : Game.player.inv.slots) {
			if(s.id == id && s.amount >= amount) {
				return true;
			}
		}
		return false;
	}
}
