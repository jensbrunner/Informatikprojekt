package inventory;

import javax.swing.JButton;

public class Slot {

	public int slotID, id = -1, amount = 0;
	
	public Slot(int slotID) {
		this.slotID = slotID;
	}
	
	public boolean isEmpty() {
		return id == -1;
	}
}
