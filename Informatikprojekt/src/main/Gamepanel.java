package main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;

import javax.swing.JPanel;

import graphics.GraphicsGameStateHandler;
import listeners.KeyListener;
import listeners.MouseListener;
import listeners.MouseWheelListener;

public class Gamepanel extends JPanel{
		
	public Gamepanel() {
		addKeyListener(new KeyListener());
		addMouseWheelListener(new MouseWheelListener());
		addMouseListener(new MouseListener());
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		setDoubleBuffered(true);
	}
	
	public void paint(Graphics g) {
		
		//prepare graphics object and rendering hints
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
				
		GraphicsGameStateHandler.handleState(g2);
		
		g.dispose();
		g2.dispose();
	}
}
