package com.LeaperGame.main;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	int t = 0;
	int x = 0;
	boolean l;
	
	
	private Handler handler;
	
	public KeyInput(Handler handler) {
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		

		
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if (tempObject.getID() == ID.Player) {
				if (key == KeyEvent.VK_SPACE || key == KeyEvent.VK_UP && tempObject.getPowerup() == false) {
					t = tempObject.getT();
					tempObject.setVelY(tempObject.getVelY());
				}
				if (key == KeyEvent.VK_RIGHT ) {
					x = 20;
					tempObject.setVelX(10);
					
				}
				if (key == KeyEvent.VK_LEFT ) {
					x = 20;
					tempObject.setVelX(-10);
				}
			}
		}
	
		
	}

	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		//for if players were more than 1
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if (tempObject.getID() == ID.Player) {
				if (key == KeyEvent.VK_SPACE || key == KeyEvent.VK_UP) {
					
					if (tempObject.getl() == true) {
						for (int a = 0; a < handler.object.size(); a++) {
							GameObject tempObject1 = handler.object.get(a);
							if (tempObject1.getID() == ID.PlatformStart) {
								tempObject1.setY(LeaperGame.HEIGHT + 1);
							}
						}
						tempObject.setVelY(tempObject.getVelY() - t);
						tempObject.setl(false);
						tempObject.setFire(true);
						
					}
					

				}
				if (key == KeyEvent.VK_RIGHT) {
					tempObject.setVelX(0);
					
				}
				if (key == KeyEvent.VK_LEFT) {
					tempObject.setVelX(0);
					
				}
				
			}
			
		}
		
		
		if (key == KeyEvent.VK_ESCAPE) System.exit(0);
	}
	
}
