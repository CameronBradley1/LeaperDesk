package com.LeaperGame.main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Timer;
import java.util.TimerTask;

public class Powerup extends GameObject{

	private Handler handler;
	private LeaperGame game;
	private int speed;
	private int a = 0;
	private Timer timer = new Timer();
	private int gotY; 
	
	
	public Powerup(int x, int y, ID id, Handler handler, int speed, LeaperGame game) {
		super(x, y, id);
		this.handler = handler;
		this.speed = speed;
		this.game = game;
		

	}

	public void tick() {
		x = LeaperGame.clamp(x, 0, LeaperGame.WIDTH);
		y += speed;
		collision();
	}
	
	public void collision() {
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if (tempObject.getID() == ID.Player) {
				if(getBounds().intersects(tempObject.getBounds())) {
					this.setX(LeaperGame.HEIGHT + 100);
				}
			}
			if (tempObject.getID() == ID.Score) {
				if(getBounds().intersects(tempObject.getBounds())) {
					handler.removeObject(this);
				}
			}
			
		}
	}

	public void render(Graphics g) {
		if (game.getMode() == 1) {
			g.setColor(Color.blue);
			g.fillOval(x, y, 12, 12);
		}
		
		else {
			g.setColor(Color.red);
			g.fillOval(x, y, 12, 12);
		}
	}
	
	public void setX(int x) {
		this.x = x;
	}

	public Rectangle getBounds() {
		return new Rectangle(x,y,12,12);
	}

	

}
