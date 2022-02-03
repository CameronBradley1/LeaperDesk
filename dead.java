package com.LeaperGame.main;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class dead extends GameObject{

	private Handler handler;
	private LeaperGame game;
	
	private float alpha = 1;
	
	private int WIDTH, HEIGHT, VelX, VelY;
	private float life;
	
	//life = 0.01 to 0.1
	
	public dead(int x, int y, ID id, int WIDTH, int HEIGHT,int VelX,int VelY, float life, Handler handler, LeaperGame game) {
		super(x, y, id);
		this.WIDTH = WIDTH;
		this.HEIGHT = HEIGHT;
		this.handler = handler;
		this.life = life;
		this.VelX = VelX;
		this.VelY = VelY;
		this.game = game;
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
		if (game.getMode() == 1) {
			Graphics2D g2D = (Graphics2D) g;
			g2D.setComposite(makeTransparent(alpha));
			
			g2D.setColor(Color.black);
			g2D.fillRect(x,y,WIDTH,HEIGHT);
			
			g2D.setComposite(makeTransparent(1));	
		}
		else {
			Graphics2D g2D = (Graphics2D) g;
			g2D.setComposite(makeTransparent(alpha));
			
			g2D.setColor(Color.white);
			g2D.fillRect(x,y,WIDTH,HEIGHT);
			
			g2D.setComposite(makeTransparent(1));
		}
		
	}



	public Rectangle getBounds() {
		return null;
	}



}
