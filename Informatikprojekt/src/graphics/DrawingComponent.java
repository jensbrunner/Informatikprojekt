package graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JComponent;

import listeners.KeyListener;
import listeners.MouseListener;
import listeners.MouseMotionListener;
import listeners.MouseWheelListener;
import main.Game;
import settings.Settings;

public class DrawingComponent extends JComponent{

	public DrawingComponent() {
		setBounds(0, 0, Settings.screenWidth, Settings.screenHeight);
		setLayout(null);
		
		addKeyListener(new KeyListener());
		addMouseWheelListener(new MouseWheelListener());
		addMouseListener(new MouseListener());
		addMouseMotionListener(new MouseMotionListener());
		
		setFocusable(true);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
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
