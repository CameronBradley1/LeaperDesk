package com.LeaperGame.main;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Timer;
import java.util.TimerTask;

import com.LeaperGame.main.LeaperGame.state;

public class Score extends GameObject{

	private int t;
	
	private Handler handler;
	private LeaperGame game;
	private spawn spawn;
	
	
	public Score(int x, int y, ID id, Handler handler, LeaperGame game, spawn spawn) {
		super(x, y, id);
		this.handler = handler;
		this.game = game;
		this.spawn = spawn;
		setScoreBool(false);
		
	}

	
	public void tick() {
		level = getLevel();
		
		
		if (getScoreBool() == false && game.gameState == state.Game) {
			t += 1; 
			for (int a = 0; a < handler.object.size(); a++) {
				GameObject tempObject2 = handler.object.get(a);
				if (tempObject2.getID() == ID.Platform && tempObject2.getY() > LeaperGame.HEIGHT + 100) {
					handler.removeObject(tempObject2);
				}
				if (tempObject2.getID() == ID.Coins && tempObject2.getY() > LeaperGame.HEIGHT + 100) {
					handler.removeObject(tempObject2);
				}
			}
			
		}
		else if (getScoreBool() == true){
			Save.setScore(t);
			Save.setMode(game.getMode());
			game.gameState = state.Menu;
			
			
			
			setScoreBool(false);
			t = 0;
			spawn.setTimer(true);
			level = 0;
			for (int i = 0; i < handler.object.size(); i++) {
				GameObject tempObject = handler.object.get(i);
				if (tempObject.getID() == ID.PlatformStart) {
				handler.removeObject(tempObject);
				}
				if (tempObject.getID() == ID.Platform) {
					handler.removeObject(tempObject);
				}
			}
			
		}
		
		

	}
	
	public void collision() {
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if (tempObject.getID() == ID.Player) {
				if (getBounds().intersects(tempObject.getBounds())){
					
					//setScoreBool(true);
					//System.out.println("test");
				}
			}
		}
	}

	@Override
	public void render(Graphics g) {
		if (game.getMode() == 1) {
			g.setColor(Color.BLACK);
			g.setFont(new Font("Tahoma", Font.BOLD, 20));
			g.drawString("Score: " + Integer.toString(t), 0, 20);
			g.drawString("Highscore: " + Save.getHighScore(), 0, 40);

			g.drawString("Level:\n" + level, LeaperGame.WIDTH - 100, 20);
			g.drawString("Coins: " + Save.getCoins(), 0, 60);
		}
		else {
			g.setColor(Color.WHITE);
			g.setFont(new Font("Tahoma", Font.BOLD, 20));
			g.drawString("Score: " + Integer.toString(t), 0, 20);
			g.drawString("Highscore: " + Save.getHighScore(), 0, 40);

			g.drawString("Level:\n" + level, LeaperGame.WIDTH - 100, 20);
			g.drawString("Coins: " + Save.getCoins(), 0,60);
		}
	
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(0,LeaperGame.HEIGHT - 10,LeaperGame.WIDTH + 100,500);
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getLevel() {
		return level; 
	}
	
}
