package com.LeaperGame.main;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.Thread.State;

import com.LeaperGame.main.LeaperGame.state;





public class Menu extends MouseAdapter{

	private LeaperGame game;
	private spawn spawn;
	private Handler handler;
	
	public Menu(LeaperGame game, Handler handler, spawn spawn){
		this.game = game;
		this.handler = handler; 
		this.spawn = spawn;
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		if(mouseOver(mx,my,  LeaperGame.WIDTH / 2.68, LeaperGame.HEIGHT / 2.6,  LeaperGame.WIDTH / 4, LeaperGame.HEIGHT / 12) && game.gameState == state.Menu) {
			game.gameState = state.Game;
			handler.addObject(new Player(LeaperGame.WIDTH / 2 - 15, LeaperGame.HEIGHT / 2 - 15,ID.Player, handler, game));
			handler.addObject(new Score(0, 0, ID.Score, handler, game, spawn));
			game.startGame();
		}
		if(mouseOver(mx,my,  LeaperGame.WIDTH / 2.68, LeaperGame.HEIGHT / 2,  LeaperGame.WIDTH / 4, LeaperGame.HEIGHT / 12) && game.gameState == state.Menu) {
			game.gameState = state.Custom;
			
		}
		if(mouseOver(mx,my,  LeaperGame.WIDTH / 2.68, LeaperGame.HEIGHT / 1.6,  LeaperGame.WIDTH / 4, LeaperGame.HEIGHT / 12) && game.gameState == state.Menu) {
		System.exit(0);
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	private boolean mouseOver(int mx, int my ,double x, double y, int width, int height) {
		if (mx > x && mx < x + width) {
			if (my > y && my < y + height) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
		
	}
	
	public void render(Graphics g) {
		if (game.gameState == state.Menu  && game.getMode() == 1) {
			g.setColor(Color.BLACK);

		}
		else if (game.gameState == state.Menu && game.getMode() == 2) {
			g.setColor(Color.WHITE);

		}
		g.setFont(new Font("ARIAL", 1, 20));
		g.drawString("MENU", (int) (LeaperGame.WIDTH * 0.43), (int) (LeaperGame.HEIGHT / 2.95));
		g.setFont(new Font("ARIAL", 1, 40));

		g.drawString("LEAPER", (int) (LeaperGame.WIDTH * 0.31), (int) (LeaperGame.HEIGHT / 6));

		g.setFont(new Font("ARIAL", 1, 15));
		
		
		g.drawRect((int) (LeaperGame.WIDTH / 2.68), (int) (LeaperGame.HEIGHT / 2.6), LeaperGame.WIDTH / 4, LeaperGame.HEIGHT / 12);
		g.drawString("PLAY", (int) (LeaperGame.WIDTH * 0.45), (int) (LeaperGame.HEIGHT / 2.3));

		
		g.drawRect((int) (LeaperGame.WIDTH / 2.68), LeaperGame.HEIGHT / 2, LeaperGame.WIDTH / 4, LeaperGame.HEIGHT / 12);
		g.drawString("CUSTOM", (int) (LeaperGame.WIDTH * 0.43), (int) (LeaperGame.HEIGHT / 1.81));

		g.drawRect((int) (LeaperGame.WIDTH / 2.68), (int) (LeaperGame.HEIGHT / 1.6), LeaperGame.WIDTH / 4, LeaperGame.HEIGHT / 12);
		g.drawString("EXIT", (int) (LeaperGame.WIDTH * 0.45), (int) (LeaperGame.HEIGHT / 1.48));
		
	}
	
	
	public void tick() {
		
	}
}
