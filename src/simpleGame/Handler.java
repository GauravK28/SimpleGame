package protoGame;

import java.awt.Graphics;
import java.util.LinkedList;

/**
 * 
 * @author Gaurav Krishnan
 * updates and renders all the objects in the game
 *loops through all of the objects and individually updates and renders them
 */
public class Handler {

	LinkedList<GameObject> object = new LinkedList<GameObject>(); //list of all of the game objects
	
	private Game game;
	
	public Handler(Game game) {
		this.game = game;
	}
	
	public void tick() {
		for(int i = 0; i< object.size(); i++) {
			GameObject tempObject = object.get(i); // gets the id of what object the tick is at
			
			tempObject.tick();
		}
	}
	
	public void render(Graphics g) {
		for(int i =0; i< object.size(); i++) {
			GameObject tempObject = object.get(i);
			tempObject.render(g);
		}
	}
	
	public void clearEnemy() {
		for(int i =0; i< object.size(); i++) {
			GameObject tempObject = object.get(i);
			if(tempObject.getId() != ID.Player) {
				object.clear();
				if(game.gameState != Game.STATE.End)
				addObject(new Player(304, 244, ID.Player, this));
			}
		}
	}
	public void addObject(GameObject object) {
		this.object.add(object);
	}
	
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}
}
