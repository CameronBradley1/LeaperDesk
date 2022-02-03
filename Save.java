package com.LeaperGame.main;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class Save {	
	
	private LeaperGame game;
	
	public Save(LeaperGame game) {
		this.game = game;
	}
	
	static int Coin = 0;
	static int mode;
	static int HighScore = 0;
	
	
	public void tick() {
		
	}
	
	public void render() {
		
	}
	
	public static void setSelectB(boolean bought) {
		try {
			BufferedReader bf = new BufferedReader(new FileReader("SaveSelectB"));
			String Bought = bf.readLine(); 
			
				try (FileWriter fw = new FileWriter("SaveSelectB")){
					fw.write(String.valueOf(bought));
				}
				catch (Exception e) {
					throw new RuntimeException(e);
				}	
			
			
		}
		catch(Exception e) {
			try (FileWriter fw = new FileWriter("SaveSelectB")){
				fw.write(String.valueOf(bought));
					
			}
			catch (Exception e1) {
				throw new RuntimeException(e);
			}
		}
	}
	public static boolean getSelectB() {
		try {
			BufferedReader bf = new BufferedReader(new FileReader("SaveSelectB"));
			boolean Bought = Boolean.parseBoolean(bf.readLine()); 
			if (Bought == true) {
				return true;
			}
			else {
				return false;
			}
			
		}
		catch(Exception e) {
			return false;
		}
	}
	
	
	public static void setSelectF(boolean bought) {
		try {
			BufferedReader bf = new BufferedReader(new FileReader("SaveSelectF"));
			String Bought = bf.readLine(); 
			
				try (FileWriter fw = new FileWriter("SaveSelectF")){
					fw.write(String.valueOf(bought));
				}
				catch (Exception e) {
					throw new RuntimeException(e);
				}	
			
			
		}
		catch(Exception e) {
			try (FileWriter fw = new FileWriter("SaveSelectF")){
				fw.write(String.valueOf(bought));
					
			}
			catch (Exception e1) {
				throw new RuntimeException(e);
			}
		}
	}
	public static boolean getSelectF() {
		try {
			BufferedReader bf = new BufferedReader(new FileReader("SaveSelectF"));
			boolean Bought = Boolean.parseBoolean(bf.readLine()); 
			if (Bought == true) {
				return true;
			}
			else {
				return false;
			}
			
		}
		catch(Exception e) {
			return false;
		}
	}
	
	
	public static void setSelectP(boolean bought) {
		try {
			BufferedReader bf = new BufferedReader(new FileReader("SaveSelectP"));
			String Bought = bf.readLine(); 
			
				try (FileWriter fw = new FileWriter("SaveSelectP")){
					fw.write(String.valueOf(bought));
				}
				catch (Exception e) {
					throw new RuntimeException(e);
				}	
			
			
		}
		catch(Exception e) {
			try (FileWriter fw = new FileWriter("SaveSelectP")){
				fw.write(String.valueOf(bought));
					
			}
			catch (Exception e1) {
				throw new RuntimeException(e);
			}
		}
	}
	public static boolean getSelectP() {
		try {
			BufferedReader bf = new BufferedReader(new FileReader("SaveSelectP"));
			boolean Bought = Boolean.parseBoolean(bf.readLine()); 
			if (Bought == true) {
				return true;
			}
			else {
				return false;
			}
			
		}
		catch(Exception e) {
			return false;
		}
	}
	public static boolean getBuyP() {
		try {
			BufferedReader bf = new BufferedReader(new FileReader("SaveBuyP"));
			boolean Bought = Boolean.parseBoolean(bf.readLine()); 
			if (Bought == true) {
				return true;
			}
			else {
				return false;
			}
			
		}
		catch(Exception e) {
			return false;
		}
	}
	public static void setBuyP(boolean bought) {
		try {
			BufferedReader bf = new BufferedReader(new FileReader("SaveBuyP"));
			String Bought = bf.readLine(); 
			if (bought == true) {
				try (FileWriter fw = new FileWriter("SaveBuyP")){
					fw.write("true");
				}
				catch (Exception e) {
					throw new RuntimeException(e);
				}	
			}
			
		}
		catch(Exception e) {
			if (bought == true) {
				try (FileWriter fw = new FileWriter("SaveBuyP")){
					fw.write("true");
					
				}
				catch (Exception e1) {
					throw new RuntimeException(e);
				}
			}
			else {
				try (FileWriter fw = new FileWriter("SaveBuyP")){
					fw.write("false");
					
				}
				catch (Exception e1) {
					throw new RuntimeException(e);
				}	
			}
			
		}
	}
	
	public static int getCoins() {
		try {
			BufferedReader bf = new BufferedReader(new FileReader("SaveCoins"));
			int Coin1 = Integer.parseInt(bf.readLine());
			return Coin1;
		}
		catch(Exception e) {
			return 0;
		}
	}
	
	public static void setCoins(int coins) {
		Coin = coins;
		String Coin1 = String.valueOf(coins);
		try {
			BufferedReader bf = new BufferedReader(new FileReader("SaveCoins"));
			int lastCoin = Integer.parseInt(bf.readLine()); 
			Coin = Coin + lastCoin;
			Coin1 = String.valueOf(Coin);
			try (FileWriter fw = new FileWriter("SaveCoins")){
				fw.write(Coin1);
			}
			catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		catch(Exception e) {
			try (FileWriter fw = new FileWriter("SaveCoins")){
				fw.write(Coin1);
				
			}
			catch (Exception e1) {
				throw new RuntimeException(e);
			}
		}
	}
	
	public static void setMode(int mode) {
		String mode1 = String.valueOf(mode);
		try {
			BufferedReader bf = new BufferedReader(new FileReader("SaveMode"));
			int lastMode = Integer.parseInt(bf.readLine());
			if (mode != lastMode) {
				try (FileWriter fw = new FileWriter("SaveMode")) {
					fw.write(mode1);
				} 
				catch (Exception e) {
					throw new RuntimeException(e);
				}
				
			}
		}
		catch (Exception e) {
			try (FileWriter fw = new FileWriter("SaveMode")) {
				fw.write(mode1);
				
				
			} 
			catch (Exception e1) {
				throw new RuntimeException(e);
			}
		}
	}
	
	
	public static void setScore(int score) {
		String score1 = String.valueOf(score);
		try {
			BufferedReader bf = new BufferedReader(new FileReader("SaveFile"));
			int lastScore = Integer.parseInt(bf.readLine());
			if (score > lastScore) {
				try (FileWriter fw = new FileWriter("SaveFile")) {
					fw.write(score1);
				} 
				catch (Exception e) {
					throw new RuntimeException(e);
				}
				
			}
		}
		catch (Exception e) {
			try (FileWriter fw = new FileWriter("SaveFile")) {
				fw.write(score1);
				
				
			} 
			catch (Exception e1) {
				throw new RuntimeException(e);
			}
		}
		
	}
	public static int getHighScore() {
		try {
		BufferedReader bf = new BufferedReader(new FileReader("SaveFile"));
		HighScore = Integer.parseInt(bf.readLine());
		return HighScore;
		}
		catch (Exception e){
			return 0;
		}
	}
	public static int getMode() {
		try {
			BufferedReader bf = new BufferedReader(new FileReader("SaveMode"));
			mode = Integer.parseInt(bf.readLine());
			return mode;
		}
		catch(Exception e) {
			return 1;
		}
		
	}
	public static boolean getBuyF() {
		try {
			BufferedReader bf = new BufferedReader(new FileReader("SaveBuyF"));
			boolean Bought = Boolean.parseBoolean(bf.readLine()); 
			if (Bought == true) {
				return true;
			}
			else {
				return false;
			}
			
		}
		catch(Exception e) {
			return false;
		}
	}
	public static void setBuyF(boolean bought) {
		try {
			BufferedReader bf = new BufferedReader(new FileReader("SaveBuyF"));
			String Bought = bf.readLine(); 
			if (bought == true) {
				try (FileWriter fw = new FileWriter("SaveBuyF")){
					fw.write("true");
				}
				catch (Exception e) {
					throw new RuntimeException(e);
				}	
			}
			
		}
		catch(Exception e) {
			try (FileWriter fw = new FileWriter("SaveBuyF")){
				fw.write("true");
				
			}
			catch (Exception e1) {
				throw new RuntimeException(e);
			}
		}
	}
	
	public static boolean getBuyB() {
		try {
			BufferedReader bf = new BufferedReader(new FileReader("SaveBuyB"));
			boolean Bought = Boolean.parseBoolean(bf.readLine()); 
			if (Bought == true) {
				return true;
			}
			else {
				return false;
			}
			
		}
		catch(Exception e) {
			return false;
		}
	}
	public static void setBuyB(boolean bought) {
		try {
			BufferedReader bf = new BufferedReader(new FileReader("SaveBuyB"));
			String Bought = bf.readLine(); 
			if (bought == true) {
				try (FileWriter fw = new FileWriter("SaveBuyB")){
					fw.write("true");
				}
				catch (Exception e) {
					throw new RuntimeException(e);
				}	
			}
			
		}
		catch(Exception e) {
			try (FileWriter fw = new FileWriter("SaveBuyB")){
				fw.write("true");
				
			}
			catch (Exception e1) {
				throw new RuntimeException(e);
			}
		}
	}
	
	
}
