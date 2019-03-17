package gui;

import javax.swing.JFrame;

import listeners.InvKeyListener;
import main.Game;
import settings.Settings;

public class InventoryWindow extends JFrame{

	public InventoryWindow() {
		super("Inventory");
		setSize(400, 400);
		setLayout(null);
		
		addKeyListener(new InvKeyListener());
		
		setFocusable(true);
		setResizable(false);
		this.setLocation(Game.frame.getLocation().x + Settings.screenWidth, Game.frame.getLocation().y);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setVisible(false);
	}
	
}
