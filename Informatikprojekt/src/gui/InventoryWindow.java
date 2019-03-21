package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import listeners.InvKeyListener;
import main.Game;
import settings.Settings;

public class InventoryWindow extends JFrame{

	public ArrayList<JButton> slotButtons = new ArrayList<JButton>();

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

		JButton slot1 = new JButton();
		slot1.setBounds(120, 10, 150, 30);
		slot1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Game.player.inv.held = Game.player.inv.slots.get(0);
			}
			
		});
		
		JButton slot2 = new JButton();
		slot2.setBounds(120, 60, 150, 30);
		slot2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Game.player.inv.held = Game.player.inv.slots.get(1);
			}
			
		});

		JButton slot3 = new JButton();
		slot3.setBounds(120,110, 150, 30);
		slot3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Game.player.inv.held = Game.player.inv.slots.get(2);
			}
			
		});

		JButton slot4 = new JButton();
		slot4.setBounds(120, 160, 150, 30);
		slot4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Game.player.inv.held = Game.player.inv.slots.get(3);
			}
			
		});

		JButton slot5 = new JButton();
		slot5.setBounds(120, 210, 150, 30);
		slot5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Game.player.inv.held = Game.player.inv.slots.get(5);
			}
			
		});

		slotButtons.add(slot1);
		slotButtons.add(slot2);
		slotButtons.add(slot3);
		slotButtons.add(slot4);
		slotButtons.add(slot5);

		for(JButton b : slotButtons) {
			add(b);
		}
	}
}
