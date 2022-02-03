package com.LeaperGame.main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import com.LeaperGame.main.LeaperGame.state;


public class Player extends GameObject implements ImageObserver{
	
	private Handler handler;
	private boolean touchPowerup = false;
	private int oldVY, a;
	
	
	private LeaperGame game;
	
	public Player(int x, int y, ID id, Handler handler, LeaperGame game) {
		super(x, y, id);
		this.handler = handler;
		this.game = game; 
		
		VelY = 5;
		VelYStandard = 5;
		VelX = 0;
		
		
	
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,30,30);
	}
	
	public void tick() {
		y += VelY; 
		x += VelX;
		
		VelY = getVelY();
		
		
		if (l == true) {
			setl(true);
		}
		
		if (VelY < VelYStandard && touchPowerup == false) {
			setVelY((int) (VelY / 2));
			if (VelY == 0) {
				setFire(false);
				while(VelY < getVelYStandard()) {
					setVelY((int) (VelY + (getVelYStandard() / 2)));
				} 
			}
		}
		
		if (x <= -20 || x >= LeaperGame.WIDTH - 10) {
			VelX *= -1;
		}
		
		
		
		x = LeaperGame.clamp(x, -20, LeaperGame.WIDTH - 10);
		y = LeaperGame.clamp(y, 0, LeaperGame.HEIGHT- 30);
		
		if (y >= LeaperGame.HEIGHT - 10) {
			VelY = 0;
			setY(LeaperGame.HEIGHT - 10);
			setScoreBool(true);
		}
		
		collision();

		
		
	}
	
	private void collision() {
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if (tempObject.getID() == ID.Platform) {
				if (getBounds().intersects(tempObject.getBounds())) {
					for (int a = 0; a < handler.object.size(); a++) {
						GameObject tempObject1 = handler.object.get(a);
						if (tempObject1.getID() == ID.Score) {
							if (getVelYStandard() == 5) {
								tempObject1.setLevel(1);
								
							}
							else if (getVelYStandard() == 6) {
								tempObject1.setLevel(2);
							}
							else if (getVelYStandard() == 7) {
								tempObject1.setLevel(3);
							}
						}
					}
					//collision code	
					if (y > tempObject.getY() - 25) {
						VelYStandard = tempObject.getVelY() + 3;
						VelY = VelYStandard;
						setFire(false);
					}
					if (y <= tempObject.getY() - 25) {
						VelY = tempObject.getVelY();
						VelYStandard = tempObject.getVelY() + 3;
						l = true;
						setFire(false);
						y = tempObject.getY() - 28;
					}
					if (x > tempObject.getX() + 25 && y >= tempObject.getY() - 20) {
						VelX = 0;
						setFire(false);
					}
					if (x < tempObject.getX() +25 && y > tempObject.getY() - 20) {
						VelX = 0; 
						setFire(false);
					}
					
				}
				if (y >= LeaperGame.HEIGHT + 10) {
					tempObject.setVelY(0);
				}
			}
			if (tempObject.getID() == ID.PlatformStart) {
				if (getBounds().intersects(tempObject.getBounds())) {
					if (y <= tempObject.getY()) {
						VelY = 0;
						l = true;
					}
				
				}
			}
			if (tempObject.getID() == ID.Score) {
				if (getBounds().intersects(tempObject.getBounds())) {
					tempObject.setScoreBool(true);
					handler.removeObject(this);
					handler.addObject(new dead(getX(), getY(), ID.dead,30,30,0,0,0.05f,handler, game));
					handler.addObject(new dead(getX() + 30, getY(), ID.dead,10,10,5,5,0.05f,handler, game));
					handler.addObject(new dead(getX() + 30, getY()+ 30, ID.dead,10,10,5,-5,0.05f,handler, game));
					handler.addObject(new dead(getX(), getY(), ID.dead,10,10,-5,5,0.05f,handler, game));
					handler.addObject(new dead(getX(), getY() + 30, ID.dead,10,10,-5,-5,0.05f,handler, game));
					
				

				}
			}
			if (tempObject.getID() == ID.Coins) {
				if (getBounds().intersects(tempObject.getBounds())) {
					Save.setCoins(1);
					tempObject.setY(LeaperGame.HEIGHT + 100);
				}
			}
			if (tempObject.getID() == ID.Powerup ) {
				if (getBounds().intersects(tempObject.getBounds())){
					tempObject.setY(LeaperGame.HEIGHT + 100);
					touchPowerup = true;
					oldVY = getVelY();
					setFire(true);
					Timer timer = new Timer();
					TimerTask timerTask = new TimerTask() {
						public void run() {
							a++;
							setVelY(-1);	
							
							if(a == 30) {
								touchPowerup = false;
								setVelY(oldVY);
								
								l = true;
								a = 0;
								timer.cancel();
								
							}
						}
					};
					timer.scheduleAtFixedRate(timerTask, 0, 100);
				}
			}
		}
	}

	
	
	public void render(Graphics g) {
		if (getFire() == true && Save.getSelectP() == true) {
			try {
				g.drawImage(game.getFire(),x,y+30, this);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		if (game.getMode() == 1 && Save.getSelectP() == true) {
			try {
				g.drawImage(game.getRocket(),x,y, this);
			} catch (IOException e) {
				e.printStackTrace();
			}		}
		else if (game.getMode() == 2 && Save.getSelectP() == true){
			try {
				g.drawImage(game.getRocket(),x,y, this);
			} catch (IOException e) {
				e.printStackTrace();
			}		}
		
		
		if (game.getMode() == 1 && Save.getSelectP() == false) {
			g.setColor(Color.BLACK);
			g.fillRect(x, y, 30, 30);
			
			g.setColor(Color.WHITE);
			g.fillRect(x+2, y+2, 26, 26);		
		}
		else if (game.getMode() == 2 && Save.getSelectP() == false){
			g.setColor(Color.WHITE);
			g.fillRect(x, y, 30, 30);
			
			g.setColor(Color.BLACK);
			g.fillRect(x+2, y+2, 26, 26);
		}
	}
	
	


	public boolean getPowerup() {
		return touchPowerup;
	}

	@Override
	public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
