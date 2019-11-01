package protoGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Boss1 extends GameObject{
	
	private Handler handler;
	Random r = new Random();
	
	private int timer = 65;
	private int timer2 = 50;
	
	public Boss1(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		velX = 0;
		velY = 2;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,96,96);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		if(timer<=0) velY = 0;
		else timer --;
		
		if(timer <= 0) timer2--;
		if(timer2<=0)
		{
			if(velX == 0)	velX = 5;
			
			if(velX > 0)	velX += 1;
			else if(velX < 0) velX -= 1;
			
			velX = Game.clamp(velX, -10, 10);
			
			int spawn = r.nextInt(10);
			if(spawn == 0) handler.addObject(new Boss1Bullet(x+48, y+88, ID.BasicEnemy, handler));
			
		}
		if(x <=0 || x >= Game.WIDTH-96) velX*=-1;
	}

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, 96, 96);
	}
}
