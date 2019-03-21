package entity;

import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class EntityHandler {

	public static List<Shot> shots = new CopyOnWriteArrayList<Shot>();
	
	public static void handleEntities(long delta) {
		
		//Shots
		ListIterator<Shot> it = shots.listIterator();
		while(it.hasNext()) {
			Shot s = it.next();
			s.handleShot(delta);
			if(s.isDead(delta) || s.isDead) {
				shots.remove(s);
			}
		}
	}
}
