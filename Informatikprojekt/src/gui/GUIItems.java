package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComponent;

import main.Game;
import main.GameState;

public class GUIItems {

	public JButton takeOffButton;
	public ArrayList<JComponent> active = new ArrayList<JComponent>();
	
	public GUIItems() {
		
		takeOffButton = new JButton();
		takeOffButton.setText("Take Off");
		takeOffButton.setBounds(10, 10, 100, 20);
		takeOffButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Game.switchState(GameState.SPACE, Game.player.curPlanet);
			}
		});
	}
	
	public void addItem(JComponent item) {
		Game.frame.add(item);
		active.add(item);
	}
	
	public void removeItem(JComponent item) {
		Game.frame.remove(item);
		active.remove(item);
	}
	
	public void removeAllItems() {
		Iterator<JComponent> iterator = active.iterator();
		while(iterator.hasNext()) {
			Game.frame.remove(iterator.next());
		}
	}
}
