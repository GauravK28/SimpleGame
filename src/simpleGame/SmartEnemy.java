package protoGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class SmartEnemy extends GameObject{
	
	private Handler handler;
	private GameObject player;
	
	public SmartEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		for(int i=0; i< handler.object.size(); i++) {
			if(handler.object.get(i).getId() == ID.Player) player = handler.object.get(i); 
		}
		velX = 5;
		velY = 5;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,16,16);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		if(x>player.getX())
			velX=-2;
		else if(x<player.getX())
			velX=2;
		else if(x==player.getX())
			velX=0;
		if(y>player.getY()+1)
			velY=-2;
		else if(y<player.getY()+1)
			velY=2;
		else if(y==player.getY()+1)
			velY=0;

		handler.addObject(new Trail(x,y, ID.Trail, Color.BLUE, 16,16, 0.06f, handler));
	}
	
	public void render(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, 16, 16);
	}
}
