package com.LeaperGame.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.LeaperGame.main.LeaperGame.state;

public class Custom extends MouseAdapter implements ImageObserver{

	private LeaperGame game;
	private Handler handler; 
	
	public Custom(LeaperGame game, Handler handler) {
		this.game = game;
		this.handler = handler;
		
		
		
		
		
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		//Light/darkmode
		if (mouseOver(mx,my, (int) (LeaperGame.WIDTH / 6), LeaperGame.HEIGHT / 12,LeaperGame.WIDTH / 8 ,LeaperGame.HEIGHT / 8) && game.getMode() == 1 && game.gameState == state.Custom) {
			game.setMode(2);
		}
		else if (game.getMode() == 2 && mouseOver(mx,my, (int) (LeaperGame.WIDTH / 6), LeaperGame.HEIGHT / 12,LeaperGame.WIDTH / 8 ,LeaperGame.HEIGHT / 8) && game.gameState == state.Custom) {
			game.setMode(1);
		}
		//back
		if (mouseOver(mx,my,LeaperGame.WIDTH / 8,LeaperGame.HEIGHT / 4, (int) (LeaperGame.WIDTH / 6),LeaperGame.HEIGHT / 12) && game.gameState == state.Custom){
			game.gameState = state.Menu;
			
		}
		//Buying Rocket
		if (mouseOver(mx,my,(int) (LeaperGame.WIDTH / 1.5), (int) (LeaperGame.HEIGHT / 3.6),30,30) && game.gameState == state.Custom) {
			if (Save.getCoins() >= 20 && Save.getBuyP() == false) {
				Save.setBuyP(true);
				Save.setCoins(-20);
				Save.setSelectP(true);
			}
			else if(Save.getBuyP() == true) {
				if (Save.getSelectP() == true) {
					Save.setSelectP(false);
				}
				else {
					Save.setSelectP(true);
				}
			}
		}
		
		if (mouseOver(mx,my,(int) (LeaperGame.WIDTH / 1.8), (int) (LeaperGame.HEIGHT / 1.5), LeaperGame.WIDTH / 3, LeaperGame.HEIGHT / 5) && game.gameState == state.Custom) {
			if (Save.getCoins() >= 20 && Save.getBuyF() == false) {
				Save.setBuyF(true);
				Save.setCoins(-20);
				Save.setSelectF(true);
				
			}
			else if (Save.getBuyF() == true) {
				if (Save.getSelectF() == true) {
					Save.setSelectF(false);
				}
				else {
					Save.setSelectF(true);
				}
			}
		}
		if (mouseOver(mx,my,LeaperGame.WIDTH / 8, (int) (LeaperGame.HEIGHT / 1.5), LeaperGame.WIDTH / 3, LeaperGame.HEIGHT / 5)) {
			if (Save.getBuyB() == false && Save.getCoins() >= 20) {
				Save.setBuyB(true);
				Save.setCoins(-20);
				Save.setSelectB(true);
			}
			else if(Save.getBuyB() == true) {
				if (Save.getSelectB() == true){
					Save.setSelectB(false);
				}
				else {
					Save.setSelectB(true);
				}
			}
		}
		
		
	}
	
	public void mouseReleased() {
		
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
	
	public  void tick(){
		
	}
	
	public void render(Graphics g){
		
		
		
		if (game.getMode() == 1) {
			Graphics2D g2D = (Graphics2D) g;
			g.setColor(Color.BLACK);
			g.setFont(new Font("Tahoma", Font.BOLD, 15));
			g.fillRect(LeaperGame.WIDTH / 8, LeaperGame.HEIGHT / 8, (int) (LeaperGame.WIDTH / 6), LeaperGame.HEIGHT / 12);
			
			g.drawString("BACK", (int) (LeaperGame.WIDTH / 6.5), (int) (LeaperGame.HEIGHT / 3.3));
			g.drawRect(LeaperGame.WIDTH / 8, LeaperGame.HEIGHT / 4, (int) (LeaperGame.WIDTH / 6), LeaperGame.HEIGHT / 12);
			g.drawString("PLAYER", (int) (LeaperGame.WIDTH / 1.5), (int) (LeaperGame.HEIGHT / 3.8));
			if (Save.getBuyP() == false) {
				g.drawString("20 Coins", (int) (LeaperGame.WIDTH / 1.5), (int) (LeaperGame.HEIGHT / 2.8));
			}
			
			if (Save.getSelectB() == true) {
				g.setColor(Color.green);
			}
			g.drawRect(LeaperGame.WIDTH / 8, (int) (LeaperGame.HEIGHT / 1.5), LeaperGame.WIDTH / 3, LeaperGame.HEIGHT / 5);
			g.setColor(Color.black);
			g.drawString("Shooting Stars", (int) (LeaperGame.WIDTH / 5.5), (int) (LeaperGame.HEIGHT / 1.3));
			if (Save.getBuyB() == false) {
				g.drawString("20 Coins", (int) (LeaperGame.WIDTH / 5.5), (int) (LeaperGame.HEIGHT / 1.2));
			}
			
			if (Save.getSelectF() == true) {
				g.setColor(Color.green);
			}
			g.drawRect((int) (LeaperGame.WIDTH / 1.8), (int) (LeaperGame.HEIGHT / 1.5), LeaperGame.WIDTH / 3, LeaperGame.HEIGHT / 5);
			g.setColor(Color.black);
			if(Save.getBuyF() == false) {
				g.drawString("20 Coins", (int) (LeaperGame.WIDTH / 1.55), (int) (LeaperGame.HEIGHT / 1.2));
			}
			g.drawString("FireWorks", (int) (LeaperGame.WIDTH / 1.55), (int) (LeaperGame.HEIGHT / 1.3));

			
			try {
				g.drawImage(game.getRocket(), (int) (LeaperGame.WIDTH / 1.5), (int) (LeaperGame.HEIGHT / 3.6), this);
				
			} catch (IOException e) {
			}

			
			
			g.setColor(Color.white);
			g.setFont(new Font("Tahoma", Font.BOLD, 13));
			g.drawString("Dark Mode", (int) (LeaperGame.WIDTH / 7.8), (int) (LeaperGame.HEIGHT / 5.8));		
			
			if (Save.getSelectP() == true) {
				g.setColor(Color.black);
				g.fillRect((int) (LeaperGame.WIDTH / 1.2028),(int) (LeaperGame.HEIGHT / 3.51), 12, 12);
				g.setColor(Color.green);
				g.fillRect((int) (LeaperGame.WIDTH / 1.2),(int) (LeaperGame.HEIGHT / 3.5), 10, 10);		
			}

		}
		else {
			Graphics2D g2D = (Graphics2D) g;
			g.setColor(Color.WHITE);
			g.setFont(new Font("Tahoma", Font.BOLD, 15));
			g.fillRect(LeaperGame.WIDTH / 8, LeaperGame.HEIGHT / 8, (int) (LeaperGame.WIDTH / 6), LeaperGame.HEIGHT / 12);
		
			g.drawString("BACK", (int) (LeaperGame.WIDTH / 6.5), (int) (LeaperGame.HEIGHT / 3.3));
			g.drawRect(LeaperGame.WIDTH / 8, LeaperGame.HEIGHT / 4, (int) (LeaperGame.WIDTH / 6), LeaperGame.HEIGHT / 12);
			g.drawString("PLAYER", (int) (LeaperGame.WIDTH / 1.5), (int) (LeaperGame.HEIGHT / 3.8));
			if (Save.getBuyP() == false) {
				g.drawString("20 Coins", (int) (LeaperGame.WIDTH / 1.5), (int) (LeaperGame.HEIGHT / 2.8));
			}
			
			if (Save.getSelectB() == true) {
				g.setColor(Color.green);
			}
			g.drawRect(LeaperGame.WIDTH / 8, (int) (LeaperGame.HEIGHT / 1.5), LeaperGame.WIDTH / 3, LeaperGame.HEIGHT / 5);
			g.setColor(Color.WHITE); 
			g.drawString("Shooting Stars", (int) (LeaperGame.WIDTH / 5.5), (int) (LeaperGame.HEIGHT / 1.3));
			if (Save.getBuyB() == false) {
				g.drawString("20 Coins", (int) (LeaperGame.WIDTH / 5.5), (int) (LeaperGame.HEIGHT / 1.2));
			}
			
			if (Save.getSelectF() == true) {
				g.setColor(Color.green);
			}
			g.drawRect((int) (LeaperGame.WIDTH / 1.8), (int) (LeaperGame.HEIGHT / 1.5), LeaperGame.WIDTH / 3, LeaperGame.HEIGHT / 5);
			g.setColor(Color.white);
			if(Save.getBuyF() == false) {
				g.drawString("20 Coins", (int) (LeaperGame.WIDTH / 1.55), (int) (LeaperGame.HEIGHT / 1.2));
			}

			g.drawString("FireWorks", (int) (LeaperGame.WIDTH / 1.55), (int) (LeaperGame.HEIGHT / 1.3));


			try {
				g.drawImage(game.getRocket(), (int) (LeaperGame.WIDTH / 1.5), (int) (LeaperGame.HEIGHT / 3.6), this);

				
			} catch (IOException e) {
			}
			
			
			g.setColor(Color.BLACK);
			g.setFont(new Font("Tahoma", Font.BOLD, 13));
			g.drawString("Light Mode", (int) (LeaperGame.WIDTH / 7.8), (int) (LeaperGame.HEIGHT / 5.8));
			
			if (Save.getSelectP() == true) {
				g.setColor(Color.GREEN);
				g.fillRect((int) (LeaperGame.WIDTH / 1.2),(int) (LeaperGame.HEIGHT / 3.5), 10, 10);		
			}
			
		}
		
	
	
		
	}

	@Override
	public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		return false;
	}
}
