package inventory;

import java.util.ArrayList;
import java.util.Iterator;

import main.Game;
import player.Player;
import settings.Settings;

public class Inventory {

	public ArrayList<Slot> slots = new ArrayList<Slot>();
	public Slot held;

	public Inventory() {
		for(int i = 0; i < Settings.inventorySlots; i++) {
			slots.add(new Slot(i));
		}
		
		held = slots.get(0);
	}

	public void addItem(int id, int amount) {
				
		//add to first empty or appropriate slot
		Iterator<Slot> it = slots.iterator();
		while(it.hasNext()) {
			Slot s = it.next();
			if(s.isEmpty()) {
				s.id = id;
				s.amount = amount;
				Game.inventory.slotButtons.get(s.slotID).setText(Item.itemNames.get(id) + " x" + s.amount);
				break;
				
			}else if(s.id == id) {
				s.amount += amount;
				Game.inventory.slotButtons.get(s.slotID).setText(Item.itemNames.get(id) + " x" + s.amount);
				break;
				
			}
		}
	}
	
	public void removeItem(int id, int amount) {
		
		//remove from first appropriate slot
		Iterator<Slot> it = slots.iterator();
		while(it.hasNext()) {
			Slot s = it.next();
			if(s.id == id) {
				s.amount -= amount;
				Game.inventory.slotButtons.get(s.slotID).setText(Item.itemNames.get(id) + " x" + s.amount);
				break;
			}
		}
	}
	
	public void removeItemHeld(int id, int amount) {
		if(held.id == id && held.amount > 0) {
			held.amount -= 1;
			if(held.amount == 0) {
				Game.inventory.slotButtons.get(held.slotID).setText("");
			}else {
				Game.inventory.slotButtons.get(held.slotID).setText(Item.itemNames.get(id) + " x" + held.amount);
			}
			
		}
	}

}
