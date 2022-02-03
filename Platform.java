package com.LeaperGame.main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Platform extends GameObject{

	private Handler handler;
	private LeaperGame game;
	
	
	public Platform(int x, int y, ID id, int VelY, Handler handler, LeaperGame game) {
		super(x, y, id);
		this.VelY = VelY;
		this.handler = handler;
		this.game = game;
		
		
		
		
	}

	public Rectangle getBounds() {
		return new Rectangle(x-1,y-1,(int) (LeaperGame.WIDTH / 9.6),5);
	}
	
	public void tick() {
		y += VelY;
		
		VelY = getVelY();
		
		
		
		//collision();
		
	}
	public void collision() {
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if (tempObject.getID() == ID.Score) {
				if(getBounds().intersects(tempObject.getBounds())) {
					setX(LeaperGame.WIDTH + 100);
					//handler.removeObject(this);
				}
			}
			
		}
	}

	public void render(Graphics g) {
		if (game.getMode() == 1) {
			g.setColor(Color.BLACK);
			g.fillRect(x, y, (int) (LeaperGame.WIDTH / 9.6), 5);
		}
		else {
			g.setColor(Color.WHITE);
			g.fillRect(x, y, (int) (LeaperGame.WIDTH / 9.6), 5);
		}
		
	}
	
	public void render2(Graphics g) {
	
	}

	
	
	
}
