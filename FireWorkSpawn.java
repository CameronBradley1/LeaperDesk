package com.LeaperGame.main;

public class FireWorkSpawn {

	static Handler handler;
	static LeaperGame game;
	public FireWorkSpawn(Handler handler, LeaperGame game) {
		this.handler = handler;
		this.game = game;
		
	}
	
	public static void start(int check) {
		
		if (check >= 1) {
			int randomx = (int) (Math.random() * LeaperGame.WIDTH + 10);
			int randomh = (int) (Math.random() * LeaperGame.HEIGHT + 10);
			int randomC = (int) (Math.random() * 3 + 0);

			handler.addObject(new FireWork(randomC,randomx, randomh, ID.FireWork, 12,12,handler,.05f,5,5,game));
			handler.addObject(new FireWork(randomC,randomx, randomh, ID.FireWork, 12,12,handler,.05f,5,-5,game));
			handler.addObject(new FireWork(randomC,randomx, randomh, ID.FireWork, 12,12,handler,.05f,-5,5,game));
			handler.addObject(new FireWork(randomC,randomx, randomh, ID.FireWork, 12,12,handler,.05f,-5,-5,game));
		}
		if (check >= 2) {
			int randomx = (int) (Math.random() * LeaperGame.WIDTH + 10);
			int randomh = (int) (Math.random() * LeaperGame.HEIGHT + 10);
			int randomC = (int) (Math.random() * 3 + 0);
			handler.addObject(new FireWork(randomC,randomx, randomh, ID.FireWork, 12,12,handler,.05f,5,5,game));
			handler.addObject(new FireWork(randomC,randomx, randomh, ID.FireWork, 12,12,handler,.05f,8,-8,game));
			handler.addObject(new FireWork(randomC,randomx, randomh, ID.FireWork, 12,12,handler,.05f,-8,8,game));
			handler.addObject(new FireWork(randomC,randomx, randomh, ID.FireWork, 12,12,handler,.05f,-8,-8,game));		
		}
			
	}

	
}
