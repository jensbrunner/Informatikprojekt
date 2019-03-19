package graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class GameoverPainter {

	public static void paintBackground(Graphics2D g2) {
		g2.setColor(Color.black);
		g2.fillRect(0, 0, 1000, 700);
	}
	
	public static void paintText(Graphics2D g2) {
		g2.setColor(Color.white);
		g2.setFont(new Font("Arial", Font.BOLD, 40));
		g2.drawString("Game Over", 420, 350);
	}
	
}
