package com.LeaperGame.main;
import java.util.Random;

import com.LeaperGame.main.LeaperGame.state;

public class spawn {
	
	private Handler handler;
	private Random r = new Random();
	private LeaperGame game;
	private int second, second2, chance;
	private int speed, WIDTH;
	private boolean stop;
	
	public spawn(Handler handler, int  WIDTH, LeaperGame game) {
		this.handler = handler;
		this.WIDTH = WIDTH;
		this.game = game;
		speed = 2;
		
		 
		
	}
	
	public void tick() {
		
		if(Save.getSelectB() == true && second % 2 == 0) {
			int randomX = (int) (Math.random() * 2 + 1);
			int randomC = (int) (Math.random() * 3 + 0);
			int randomh = (int) (Math.random() * LeaperGame.HEIGHT + 10);
			int locationx; 
			int randomS = (int) (Math.random() * 8 + (-8));
			if (randomX == 2) {
				locationx = LeaperGame.WIDTH;
				handler.addObject(new FireWork(randomC, locationx, randomh, ID.FireWork, 12,12,handler,.01f,-8,randomS,game));
			}
			else {
				locationx = 0;
				handler.addObject(new FireWork(randomC, locationx, randomh, ID.FireWork, 12,12,handler,.01f,8,randomS,game));
			}
			

		}
		
		if (second >= 82 && Save.getSelectF() == true) {
			int randomx = (int) (Math.random() * LeaperGame.WIDTH + 10);
			int randomh = (int) (Math.random() * LeaperGame.HEIGHT + 10);
			int randomC = (int) (Math.random() * 3 + 0);

			handler.addObject(new FireWork(randomC,randomx, randomh, ID.FireWork, 12,12,handler,.05f,5,5,game));
			handler.addObject(new FireWork(randomC,randomx, randomh, ID.FireWork, 12,12,handler,.05f,5,-5,game));
			handler.addObject(new FireWork(randomC,randomx, randomh, ID.FireWork, 12,12,handler,.05f,-5,5,game));
			handler.addObject(new FireWork(randomC,randomx, randomh, ID.FireWork, 12,12,handler,.05f,-5,-5,game));
		}
		if (second >= 160 && Save.getSelectF() == true) {
			int randomx = (int) (Math.random() * LeaperGame.WIDTH + 10);
			int randomh = (int) (Math.random() * LeaperGame.HEIGHT + 10);
			int randomC = (int) (Math.random() * 3 + 0);
			handler.addObject(new FireWork(randomC,randomx, randomh, ID.FireWork, 12,12,handler,.05f,5,5,game));
			handler.addObject(new FireWork(randomC,randomx, randomh, ID.FireWork, 12,12,handler,.05f,5,-5,game));
			handler.addObject(new FireWork(randomC,randomx, randomh, ID.FireWork, 12,12,handler,.05f,-5,5,game));
			handler.addObject(new FireWork(randomC,randomx, randomh, ID.FireWork, 12,12,handler,.05f,-5,-5,game));
		}
		if (Save.getSelectF() == true || Save.getSelectB() == true) {
			for (int i = 0; i < handler.object.size(); i++) {
				GameObject tempObject = handler.object.get(i);
				if (tempObject.getID() == ID.FireWork) {
					if (tempObject.getLife() <= -.5) {
						handler.removeObject(tempObject);
					}
				}
			}	
		}
		
		if (second == 0 && game.gameState == state.Game) {
			handler.addObject(new PlatformStart(LeaperGame.WIDTH / 2 - 20, LeaperGame.HEIGHT / 2 + 100, ID.PlatformStart, handler, game));
		}
		
		if(game.gameState == state.Menu) {
			speed = 10;
		}
		
		chance = (int) (Math.random() * 100 + 0);
		if (second % 2 == 1 && chance > 90) {
			handler.addObject(new Powerup(r.nextInt(WIDTH), 0, ID.Powerup, handler, speed, game));
		}
		chance = (int) (Math.random() * 100 + 0);
		
		if (second % 2 == 0 && chance > 95) {
			handler.addObject(new Coins(r.nextInt(WIDTH), 0, ID.Coins, handler, speed));
		}
		
		for (int a = 0; a < handler.object.size(); a++) {
			GameObject tempObject = handler.object.get(a);
			if (tempObject.getID() == ID.Score) {
				if (tempObject.getScoreBool() == true) {
					this.setTimer(true);
				}
			}
		}
		if (second % 4 == 0 && second < 12) {
			int WidthMin = (int) (Math.random() * WIDTH + (WIDTH / 2) + 10);
			speed = 2;
			for (int i = 0; i < 2; i++) {
				handler.addObject(new Platform(r.nextInt(WIDTH - (WIDTH / 2) - 100), 0,ID.Platform, speed, handler, game));
				handler.addObject(new Platform(WidthMin, 0,ID.Platform, speed, handler, game));
				for (int a = 0; a < handler.object.size(); a++) {
					GameObject tempObject = handler.object.get(a);
					if (tempObject.getID() == ID.Player) {
						tempObject.setT(150);
					}
				}
			}
		}
		if (second % 4 == 0 && second >= 12 && second < 80) {
			speed = 2;
			for (int i = 0; i < 3; i++) {
				handler.addObject(new Platform(r.nextInt(WIDTH), 0,ID.Platform, speed, handler, game));
				for (int a = 0; a < handler.object.size(); a++) {
					GameObject tempObject = handler.object.get(a);
					if (tempObject.getID() == ID.Player) {
						tempObject.setT(150);
					}
					if (tempObject.getID() == ID.Platform) {
					}
				}
			}
		}
		
		if (second == 82) {
			speed = 3;
			for (int i = 0; i < 3; i++) {
				handler.addObject(new Platform(r.nextInt(WIDTH), 0,ID.Platform, speed, handler, game));
				for (int a = 0; a < handler.object.size(); a++) {
					GameObject tempObject = handler.object.get(a);
					if (tempObject.getID() == ID.Player) {
						tempObject.setT(160);
					}
				}
			}
		}
		
		if (second % 4 == 0 && second >= 84 && second < 160) {
			speed = 3;
			for (int i = 0; i < 3; i++) {
				handler.addObject(new Platform(r.nextInt(WIDTH), 0,ID.Platform, speed, handler, game));
				for (int a = 0; a < handler.object.size(); a++) {
					GameObject tempObject = handler.object.get(a);
					if (tempObject.getID() == ID.Player) {
						tempObject.setT(160);

					}
				}
			}
		}
		if(second % 2 == 0 && second >= 160) {
			speed = 4;
			for (int i = 0; i < 3; i++) {
				handler.addObject(new Platform(r.nextInt(WIDTH), 0,ID.Platform, speed, handler, game));
				for (int a = 0; a < handler.object.size(); a++) {
					GameObject tempObject = handler.object.get(a);
					if (tempObject.getID() == ID.Player) {
						tempObject.setT(120);

					}
				}
			}
		}
	}
	
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		this.second = second;
	}
	public void setTimer(boolean stop) {
		this.stop = stop;
	}
	public boolean getTimer() {
		return stop;
	}
	public void sett2(int second2) {
		this.second2 = second2;
	}
}
