package protoGame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	private boolean w,a,s,d;
	
	public KeyInput(Handler handler) {
		this.handler = handler;
		
		w = false;
		a = false;
		s = false;
		d = false;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		for(int i= 0; i< handler.object.size();i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player) {
				if(key == KeyEvent.VK_W || key == KeyEvent.VK_UP) { tempObject.setVelY(-5);  w = true;}
				if(key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) { tempObject.setVelX(-5); a = true; }
				if(key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) { tempObject.setVelY(5); s =true; }
				if(key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {tempObject.setVelX(5);  d = true;}
			}
		}
		if(key ==KeyEvent.VK_ESCAPE) System.exit(1);
	}
	
	public void keyReleased(KeyEvent e) {
		int key  = e.getKeyCode();
		
		for(int i= 0; i< handler.object.size();i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player) {
				//key events for player 1
				if(key == KeyEvent.VK_W || key == KeyEvent.VK_UP) w =false;
				if(key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) a =false;
				if(key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) s =false;
				if(key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) d =false;
				
				//vertical movement
				if(!w && !s) tempObject.setVelY(0);
				//horizontal movement
				if(!a && !d) tempObject.setVelX(0);
			}
		}
	}
}
