package gui;

import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import inventory.InventoryHandler;
import inventory.Item;
import main.Game;
import settings.Settings;

public class CraftingWindow extends JFrame{

	public CraftingWindow() {
		super("Crafting");
		setSize(400, 400);
		setLayout(null);
		setFocusable(true);
		setResizable(false);
		this.setLocation(Game.frame.getLocation().x + Settings.screenWidth, Game.frame.getLocation().y+Game.inventory.getSize().height);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setVisible(false);

		JButton healButton = new JButton("Bandage");
		healButton.setToolTipText("Effect: Fully heals you. | Cost: 2 Leather & 1 Gold");
		healButton.setBounds(10, 10, 150, 20);
		healButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(InventoryHandler.hasItemAmount(Item.GOLD, 1) && InventoryHandler.hasItemAmount(Item.LEATHER, 2)) {
					Game.player.inv.removeItem(Item.GOLD, 1);
					Game.player.inv.removeItem(Item.LEATHER, 2);
					Game.player.health = 100;
					System.out.println("Healed");
				}
			}
		});
		
		JButton chargeButton = new JButton("Weapon Charge");
		chargeButton.setToolTipText("Effect: Recharges your gun. | Cost: 1 Exotium");
		chargeButton.setBounds(10, 40, 150, 20);
		chargeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(InventoryHandler.hasItemAmount(Item.EXOTIUM, 1)) {
					Game.player.inv.removeItem(Item.EXOTIUM, 1);
					Game.player.charge = 50;
					System.out.println("Recharged");
				}
			}
		});
		
		add(healButton);
		add(chargeButton);
	}
	
}
