package com.LeaperGame.main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Timer;
import java.util.TimerTask;

public class Coins extends GameObject{


	private Handler handler;
	private int speed, a;
	private Timer timer1;
	
	
	public Coins(int x, int y, ID id, Handler handler, int speed) {
		super(x, y, id);
		this.handler = handler;
		this.speed = speed;
		

	}

	
	public void tick() {
		x = LeaperGame.clamp(x, 0, LeaperGame.WIDTH);
		y += speed;
		collision();
	}
	
	public void collision() {
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject1 = handler.object.get(i);
			if (tempObject1.getID() == ID.Player) {
				if(getBounds().intersects(tempObject1.getBounds())) {
					 setY(LeaperGame.HEIGHT + 100);
				}
			}
			if (tempObject1.getID() == ID.Score) {
				if(getBounds().intersects(tempObject1.getBounds())) {
					handler.removeObject(this);
				}
			}
			
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillOval(x, y, 12, 12);
		
	}

	public Rectangle getBounds() {
		return new Rectangle(x,y,12,12);
	}


	

}
