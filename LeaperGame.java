package com.LeaperGame.main;
import java.awt.Canvas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;




public class LeaperGame extends Canvas implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -988383446849745590L;
	
	public static int WIDTH = 500, HEIGHT = 600;
	
	private Thread thread;
	private boolean running  = false;
	
	private int t;
	private int t2;
	private int delayS = 375;
	private int speed = 2;
	private int mode = 1;
	
	
	
	GameObject game;
	
	
	int T = 150;
	int level = 0;
	
	
	private Handler handler;
	private spawn spawn;
	private Random r;
	
	public enum state{
		Menu,
		Game,
		Custom,
		Save,
	};
	
	private Menu menu;
	private Custom Custom; 
	
	public state gameState = state.Menu;
	
	public void Window() {
		Window test = new Window("Leaper", this);
		WIDTH = test.getW();
		HEIGHT = test.getH();
	}
	
	public LeaperGame() {
		Window();
		mode = Save.getMode();
		handler = new Handler(this);
		r = new Random();
		spawn = new spawn(handler,WIDTH, this);
		menu = new Menu(this, handler, spawn);
		Custom = new Custom(this, handler);
		
		
		this.addMouseListener(new TouchScreen(handler, this));
		this.addKeyListener(new KeyInput(handler));
		this.addMouseListener(menu);
		this.addMouseListener(Custom);
		
		
		
		
		
		
		
		
		try {
			getRocket();
			getFire();
		} catch (IOException e) {
			
		}
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public void startGame() {
		
		if (gameState == state.Game) {
			spawn.setTimer(false);
			Timer timer = new Timer();
			t = 0;
			t2 = 0;
			TimerTask timerTask = new TimerTask() {
				public void run() {
				
				spawn.setSecond(t);
				spawn.sett2(t2);
				spawn.tick();
				if (spawn.getTimer() == true) {
					timer.cancel();
				}
				
				
				t += 1;
				t2 += 1;
				}
			};
			timer.scheduleAtFixedRate(timerTask, 0, delayS);
		}
	}
	
	
	
	
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void run() {

		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running) {
			long now  = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			}
			if (running) {
				render();
				frames++;
			}
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				//System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	private void tick() {
		if (gameState == state.Game) {
			handler.tick();
		}
		else if (gameState == state.Menu) {
			menu.tick();
			handler.tick();
		}
		else if (gameState == state.Custom) {
			Custom.tick();
			handler.tick();
		}
		
	}
	
	private void render() {
		
		BufferStrategy bs = this.getBufferStrategy();
		if (bs ==  null) {
			this.createBufferStrategy(3);
			return;
		}
		
		
		Graphics g = bs.getDrawGraphics();
		
		if (mode == 1) {
			g.setColor(Color.WHITE);
		}
		else if (mode == 2) {
			g.setColor(Color.BLACK);
		}
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		
		
		if (gameState == state.Game) {
			handler.render(g);
		}
		else if (gameState == state.Menu){
			menu.render(g);
			handler.render(g);
			
		}
		else if (gameState == state.Custom) {
			Custom.render(g);
		}
		
		
		g.dispose();
		bs.show();
	}
	
	public static void main(String[] args) {
		new LeaperGame();
	}
	
	public static int clamp(int var, int min, int max) {
	 if (var >= max) {
		 return var = max;
	 }
	 else if (var <= min) {
		 return var = min;
	 }
	 else return var;
	}
	
	public void Platforms(){
		for (int i = 0; i < 4; i++) {
			handler.addObject(new Platform(r.nextInt(WIDTH), 0,ID.Platform, speed, handler, this));
		}
	}
	
	public void setMode(int mode) {
		this.mode = mode;
	}
	
	public int getMode() {
		return mode;
	}
	
	public Image getRocket() throws IOException {
		if (getMode() == 1) {
			BufferedImage rocket1 = ImageIO.read(getClass().getResource("/Resources/RocketWhite.jpg"));
			BufferedImage resized = new BufferedImage(30,30,BufferedImage.TYPE_INT_ARGB);
			Graphics2D g = resized.createGraphics();
			g.drawImage(rocket1,0,0,30,30,null);
			g.dispose();
			return resized;
		}
		else {
			BufferedImage rocket2 = ImageIO.read(getClass().getResource("/Resources/RocketBlack.jpg"));
			BufferedImage resized = new BufferedImage(30,30,BufferedImage.TYPE_INT_ARGB);
			Graphics2D g = resized.createGraphics();
			g.drawImage(rocket2,0,0,30,30,null);
			g.dispose();
			return resized;
		}
	}
	public Image getFire() throws IOException {
		if (getMode() == 1) {
			BufferedImage fire1 = ImageIO.read(getClass().getResource("/Resources/Fire1.jpg"));
			BufferedImage resized = new BufferedImage(30,30,BufferedImage.TYPE_INT_ARGB);
			Graphics2D g = resized.createGraphics();
			g.drawImage(fire1,0,0,30,30,null);
			g.dispose();
			return resized;
		}
		else {
			BufferedImage fire2 = ImageIO.read(getClass().getResource("/Resources/Fire2.jpg"));
			BufferedImage resized = new BufferedImage(30,30,BufferedImage.TYPE_INT_ARGB);
			Graphics2D g = resized.createGraphics();
			g.drawImage(fire2,0,0,30,30,null);
			g.dispose();
			return resized;
		}
	}

}
