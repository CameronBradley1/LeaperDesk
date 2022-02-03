package com.LeaperGame.main;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public abstract class GameObject {
	
	protected int x, y;
	protected ID id;
	protected int VelX, VelY;
	protected boolean ScoreBool, touchPowerup;
	protected boolean l;
	protected boolean start;
	protected int T;
	float life;
	protected boolean touch, fire, buyP, buyF, buyB;
	protected int VelYStandard, level;
	
	public GameObject(int x, int y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
		
		
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setID(ID id) {
		this.id = id;
	}
	public ID getID() {
		return id;
	}
	public void setVelX(int VelX) {
		this.VelX = VelX;
	}
	public void setVelY(int VelY) {
		this.VelY = VelY;
	}
	public int getVelX() {
		return VelX;
	}
	public int getVelY() {
		return VelY;
	}
	public boolean getScoreBool() {
		return ScoreBool;
	}
	public void setScoreBool(boolean ScoreBool) {
		this.ScoreBool = ScoreBool;
	}
	public boolean getl() {
		return l;
	}
	public void setl(boolean l) {
		this.l = l;
	}
	public void setT(int T) {
		this.T = T;
	}
	public int getT() {
		return T;
	}
	public int getVelYStandard() {
		return VelYStandard;
	}
	public void setVelYStandard(int VelYStandard) {
		this.VelYStandard = VelYStandard;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getLevel() {
		return level;
	}
	
	public boolean getPowerup() {
		return touchPowerup;
	}

	public void setFire(boolean fire) {
		this.fire = fire;
	}
	
	public boolean getFire() {
		return fire;
	}
	
	public float getLife() {
		return life;
	}
	public void setLife(float life) {
		this.life = life;
	}
}
