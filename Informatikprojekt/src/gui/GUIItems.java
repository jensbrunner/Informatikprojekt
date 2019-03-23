package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComponent;

import main.Game;
import main.GameState;
import settings.Settings;

public class GUIItems {

	public JButton takeOffButton, inventoryButton, restartButton, craftingButton;
	public ArrayList<JComponent> active = new ArrayList<JComponent>();
	
	public GUIItems() {
		
		takeOffButton = new JButton();
		takeOffButton.setText("Take Off");
		takeOffButton.setFocusable(false);
		takeOffButton.setBounds(10, 10, Settings.buttonWidth, Settings.buttonHeight);
		takeOffButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Game.switchState(GameState.SPACE, Game.player.curPlanet);
			}
		});
		
		inventoryButton = new JButton();
		inventoryButton.setText("Inventory");
		inventoryButton.setFocusable(false);
		inventoryButton.setBounds(10, 35, Settings.buttonWidth, Settings.buttonHeight);
		inventoryButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Game.inventory.setVisible(!Game.inventory.isVisible());
			}
		});
		
		craftingButton = new JButton();
		craftingButton.setText("Crafting");
		craftingButton.setFocusable(false);
		craftingButton.setBounds(10, 60, Settings.buttonWidth, Settings.buttonHeight);
		craftingButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Game.crafting.setVisible(!Game.crafting.isVisible());
			}
		});
		
		restartButton = new JButton();
		restartButton.setText("Close");
		restartButton.setFocusable(false);
		restartButton.setBounds(380, 450, 300, 100);
		restartButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
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
