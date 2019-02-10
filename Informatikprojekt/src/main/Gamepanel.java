package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;

import javax.swing.JPanel;

import listeners.KeyListener;
import listeners.MouseListener;
import listeners.MouseWheelListener;
import player.Camera;
import tools.Tools;
import tools.Vector2;

public class Gamepanel extends JPanel{
	
	public Gamepanel() {
		addKeyListener(new KeyListener());
		addMouseWheelListener(new MouseWheelListener());
		addMouseListener(new MouseListener());
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		//background
		g.setColor(Color.black);
		g.fillRect(0, 0, 1000, 700);
		
		//draw rocket
		g.setColor(Color.white);
		Game.rocket.computeVertices();
		Vector2 nose = (new Vector2(Game.rocket.nose[0], Game.rocket.nose[1]).subtract(Camera.offset));
		Vector2 left = (new Vector2(Game.rocket.backleft[0], Game.rocket.backleft[1]).subtract(Camera.offset));
		Vector2 right = (new Vector2(Game.rocket.backright[0], Game.rocket.backright[1]).subtract(Camera.offset));
		g2.fillPolygon(new int[]{(int)(nose.x), (int)(left.x), (int)(right.x)}, new int[]{(int)(nose.y), (int)(left.y), (int)(right.y)}, 3);
		
		g.dispose();
		g2.dispose();
	}
}
