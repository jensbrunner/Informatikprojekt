package graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import entity.EntityHandler;
import entity.Shot;
import main.Game;
import planet.Planet;
import planet.PlanetType;
import player.Camera;
import player.Message;
import settings.Settings;
import tools.Vector2;

public class SpacePainter {

	public static void paintBackground(Graphics2D g2) {
		if(Game.player.cam.starsDone) {
			g2.setColor(Color.black);
			g2.fillRect(0, 0, 1000, 700);
			g2.setColor(Color.white);
			for(Vector2 star : Game.player.cam.stars) {
				g2.fillRect((int)Math.round(star.x-Game.player.cam.offset.x), (int)Math.round(star.y-Game.player.cam.offset.y), 2, 2);
			}
		}
	}

	public static void paintRocket(Graphics2D g2) {
		g2.setColor(Color.gray);
		Game.player.rocket.computeVertices();
		g2.fillPolygon(new int[]{(int)Math.round(Game.player.rocket.nose.x - Game.player.cam.offset.x), (int)Math.round(Game.player.rocket.backleft.x - Game.player.cam.offset.x), (int)Math.round(Game.player.rocket.backright.x - Game.player.cam.offset.x)}, new int[]{(int)Math.round(Game.player.rocket.nose.y - Game.player.cam.offset.y), (int)Math.round(Game.player.rocket.backleft.y - Game.player.cam.offset.y), (int)Math.round(Game.player.rocket.backright.y - Game.player.cam.offset.y)}, 3);
	}

	public static void paintShots(Graphics2D g2) {
		g2.setColor(Color.red);
		for(Shot s : EntityHandler.shots) {
			g2.fillOval((int)Math.round(s.pos.x-2-Game.player.cam.offset.x), (int)Math.round(s.pos.y-2-Game.player.cam.offset.y), 5, 5);
		}
	}

	public static void paintMessages(Graphics2D g2) {
		if(!Message.displayMessage.isEmpty()) {
			g2.setColor(Color.white);
			g2.setFont(new Font("Arial", Font.BOLD, 17));
			g2.drawString(Message.displayMessage, 5, Settings.screenHeight-37);
			Message.displayMessage = "";
		}
	}

	public static void paintPlanets(Graphics2D g2) {
		for(Planet p : Settings.planets) {

			if(p.type == PlanetType.DEFAULT) {
				g2.setColor(Settings.defaultColor);
			}
			if(p.type == PlanetType.MOUNTAIN) {
				g2.setColor(Settings.mountainColor);
			}
			if(p.type == PlanetType.WATER) {
				g2.setColor(Settings.waterColor);
			}

			g2.fillOval((int)Math.round(p.pos.x - (p.diameter/2) - Game.player.cam.offset.x), (int)Math.round(p.pos.y - (p.diameter/2) - Game.player.cam.offset.y), p.diameter, p.diameter);
		}
	}

}
