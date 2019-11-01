package protoGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import protoGame.Game.STATE;


public class Menu extends MouseAdapter{
	
	private Game game;
	private Handler handler;
	private HUD hud;
	private Random r;

	public Menu(Game game, Handler handler, HUD hud) {
		this.game = game;
		this.handler = handler;
		this.hud = hud;
	}
	
	public void mousePressed(MouseEvent e) {
		int mx =  e.getX();
		int my = e.getY();
		
		if(game.gameState == STATE.Menu) {
			//play button
			if(mouseOver(mx,my,80, 180, 175, 48)) {
				game.gameState = STATE.Game;
				hud.setLevel(1);
				hud.setScore(0);
				handler.addObject(new Player(Game.WIDTH/2 -32,Game.HEIGHT/2-32,ID.Player, handler));
				handler.clearEnemy();
			}
			//help button
			if(mouseOver(mx,my,80, 270, 175, 48)) {
				game.gameState = STATE.Help;
			}
			//quit button
			if(mouseOver(mx,my,80, 360, 175, 48)) {
				System.exit(1);
			}
		}
		//back button for help
		if(game.gameState == STATE.Help) {
			if(mouseOver(mx,my,80, 360, 175, 48)) {
				game.gameState = STATE.Menu;
				return;
			}
		}
		//back button for (end)death screen
		if(game.gameState == STATE.End) {
			if(mouseOver(mx,my,70, 358, 202, 48)) {
				return;
			}
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if(mx > x && mx < x + width	) {
			if(my > y && my < y + height) {
				return true;
			}
			return false;
		}
		return false;
		
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		if(game.gameState == STATE.Menu) {
			Font fnt = new Font("Copperplate Gothic Bold", 1,50);
			Font fnt2 = new Font("Copperplate Gothic Bold", 1,30);

			g.setFont(fnt);
			g.setColor(Color.WHITE);
			g.drawString("Star Path", 150, 120);

			g.setFont(fnt2);
			g.drawRect(80, 180, 175, 48);
			g.drawString("Play", 120, 212);


			g.drawRect(80, 270, 175, 48);
			g.drawString("Help", 120, 302);

			g.drawRect(80, 360, 175, 48);
			g.drawString("Quit", 120, 392);
		} else if(game.gameState == STATE.Help) {
			Font fnt = new Font("Copperplate Gothic Bold", 1,50);
			Font fnt2 = new Font("Copperplate Gothic Bold", 1,30);
			Font fnt3 = new Font("Arial", 1,15);

			g.setFont(fnt);
			g.setColor(Color.WHITE);
			g.drawString("Help", 250, 120);
			
			g.setFont(fnt3);
			g.drawString("Use WASD keys to move your player and to dodge enemies.", 100, 160);
			g.drawString("Gain a level by increasing your score by 250pts.", 100, 180);
			g.drawString("Try to attain the highest score possible!", 100, 200);
			g.drawString("Enemy Types:", 100, 220);
			g.drawString("Red - Basic enemy that deals 1 damage", 120, 240);
			g.drawString("Green - Fast enemy that deals 3 damage", 120, 260);
			g.drawString("Blue - Smart enemy that follows you and deals 5 damage", 120, 280);
			g.drawString("Boss - Big enemy that spams bullets that deals 1 damage", 120, 300);
			g.drawString("Running into the boss instantly kills you", 120, 320);
			
			g.setFont(fnt2);
			g.drawRect(80, 360, 175, 48);
			g.drawString("Back", 120, 392);
		}
		else if(game.gameState == STATE.End) {
			Font fnt = new Font("Copperplate Gothic Bold", 1,50);
			Font fnt2 = new Font("Copperplate Gothic Bold", 1,30);
			Font fnt3 = new Font("Arial", 1,15);
			
			g.setFont(fnt);
			g.setColor(Color.WHITE);
			g.drawString("Game Over", 160, 200);
			
			g.setFont(fnt3);
			g.drawString("You lost with a score of: " + hud.getScore(), 225, 260);
			g.drawString("High Score: " + game.getHighScore(), 270, 280);

			g.setFont(fnt2);
			g.drawRect(70, 358, 202, 48);
			g.drawString("Try Again", 80, 392);
		}
	}
}
