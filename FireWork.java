package com.LeaperGame.main;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class FireWork extends GameObject {
	private Handler handler;
	private LeaperGame game;
	
	private float alpha = 1;
	
	private int WIDTH, HEIGHT, VelX, VelY, color;
	private float life;
	
	//life = 0.01 to 0.1

	public FireWork(int color, int x, int y, ID id, int WIDTH, int HEIGHT, Handler handler, float life, int VelX, int VelY, LeaperGame game) {
		super(x, y, id);
	this.WIDTH = WIDTH;
	this.HEIGHT = HEIGHT;
	this.handler = handler;
	this.life = life;
	this.VelX = VelX;
	this.VelY = VelY;
	this.game = game;
	this.color = color;
}


public void tick() {
	x += VelX;
	y += VelY;
	
	if (alpha > life) {
		alpha -= life - 0.01f;
	}
	else handler.removeObject(this);
}

private Composite makeTransparent(float alpha) {
	int type = AlphaComposite.SRC_OVER;
	return(AlphaComposite.getInstance(type,alpha));
}

public void render(Graphics g) {
	Graphics2D g2D = (Graphics2D) g;
	g2D.setComposite(makeTransparent(alpha));

	
	if (game.getMode() == 1) {
		if (color == 0) {
			g.setColor(Color.orange);
		}
		else if (color == 1) {
			g.setColor(Color.GREEN);
		}
		else if (color == 2) {
			g.setColor(Color.pink);
		}
		else {
			g.setColor(Color.red);
		}
	}
	else {
		if (color == 0) {
			g.setColor(Color.cyan);
		}
		else if (color == 1) {
			g.setColor(Color.GREEN);
		}
		else if (color == 2) {
			g.setColor(Color.pink);
		}
		else {
			g.setColor(Color.orange);
		}
		
		
	}
	g2D.fillRect(x,y,WIDTH,HEIGHT);
	g2D.setComposite(makeTransparent(1));
	
}



public Rectangle getBounds() {
	return null;
}

}
