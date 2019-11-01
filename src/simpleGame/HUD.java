package protoGame;

import java.awt.Color;
import java.awt.Graphics;


public class HUD {

	public static int HEALTH = 100;
	
	private int greenValue = HEALTH*255/100;
	
	private int score = 0;
	private int level = 1;

	public void tick() {
		HEALTH = Game.clamp(HEALTH, 0, 100);
		greenValue = Game.clamp(greenValue, 0, 255);
		greenValue = HEALTH*2;
		score++;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(15,15,200,25);
		g.setColor(new Color(255-greenValue,greenValue,0));
		g.fillRect(15,15,HEALTH*2,25);
		g.setColor(Color.WHITE);
		g.drawRect(15,15,200,25);
		
		g.drawString("Score: " + score, 15, 64);
		g.drawString("Level: " + level, 15, 80);
		if(HEALTH > 25) g.drawString(HEALTH + "/"+ "100", HEALTH-4, 32);
		else g.drawString(HEALTH + "/"+ "100", 21, 32);
		
	}
	
	public void setScore(int score){
		this.score = score;
	}
	
	public int getScore(){
		return score;
	}
	
	public int getLevel(){
		return level;
	}
	
	public void setLevel(int level){ this.level = level; }
}


















