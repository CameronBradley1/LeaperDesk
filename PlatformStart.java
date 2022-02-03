package com.LeaperGame.main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class PlatformStart extends GameObject {

	Handler handler;
	private LeaperGame game;
	int l;
	
	public PlatformStart(int x, int y, ID id, Handler handler, LeaperGame game) {
		super(x, y, id);
		this.handler = handler;
		this.game = game;
	}

	public void tick() {
		
		
		
		collision();
	}

	public void collision() {
		
		/*for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if (tempObject.getID() == ID.Player) {
				if (getBounds().intersects(tempObject.getBounds())){
					tempObject.setl(true);
				}
				
			}
			
			
		}
		*/
	}
	
	public void render(Graphics g) {
		if (game.getMode() == 1) {
			g.setColor(Color.black);
			g.fillRect(x, y, 40, 5);	
		}
		
		else {
			g.setColor(Color.white);
			g.fillRect(x, y, 40, 5);
		}
	}

	public Rectangle getBounds() {
		return new Rectangle(x,y,40,5);
	}

	

}
