package com.LeaperGame.main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.LeaperGame.main.LeaperGame.state;

public class TouchScreen implements MouseListener{
	int t;
	Handler handler;
	LeaperGame game;
	int x;
	int y;
	
	public TouchScreen(Handler handler, LeaperGame game) {
		this.handler = handler;
		this.game = game;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		x = arg0.getX();
		y = arg0.getY();
		
		
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if (tempObject.getID() == ID.Player && game.gameState == state.Game) {
				if (x > LeaperGame.WIDTH / 1.5) {
					tempObject.setVelX(10);
				}
				else if (x < LeaperGame.WIDTH / 3) {
					tempObject.setVelX(-10);
				}
				else if (tempObject.getPowerup() == false) {
					t = tempObject.getT();
					tempObject.setVelY(tempObject.getVelY());
				}	
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if (tempObject.getID() == ID.Player  && game.gameState == state.Game) {
				if (tempObject.getID() == ID.Player) {
					if (x < LeaperGame.WIDTH / 1.5 && x > LeaperGame.WIDTH / 3) {
						if (tempObject.getl() == true) {
							for (int a = 0; a < handler.object.size(); a++) {
								GameObject tempObject1 = handler.object.get(a);
								if (tempObject1.getID() == ID.PlatformStart) {
									tempObject1.setY(LeaperGame.HEIGHT + 10);
								}
							}
							tempObject.setVelY(tempObject.getVelY() - t);
							tempObject.setl(false);
							tempObject.setFire(true);
							
						}
						

					}
					
					if (x > LeaperGame.WIDTH / 3) {
						tempObject.setVelX(0);
						
					}
					if (x < LeaperGame.WIDTH / 1.5) {
						tempObject.setVelX(0);
						
					}
					
				}
			}
		}
	}
	
	
	
	
}
