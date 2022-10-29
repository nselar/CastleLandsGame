/**
 * 
 */
package nico.castleland.game;

import nico.castleland.game.gfx.GameCamera;
import nico.castleland.game.input.KeyManager;
import nico.castleland.game.input.MouseManager;
import nico.castleland.game.worlds.Mundo;
import nico.castleland.game.entities.creatures.*;


/**
 * @author nicks
 *
 */
public class Handler {
	
	private Game game;
	private Mundo mundo;
	
	public Handler(Game game) {
		this.game = game;
	}
	
	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}
	
	public MouseManager getMouseManager(){
		return game.getMouseManager();
	}
	
	public GameCamera getGameCamera() {
		return game.getGameCamera();
	}
	
	public int getAncho() {
		return game.getAncho();
	}
	
	public int getAlto() {
		return game.getalto();
	}
	
	public Game getGame() {
		return game;
	}
	
	public void setGame(Game game) {
		this.game = game;
	}
	
	public Mundo getMundo() {
		return mundo;
	}

	public void setMundo(Mundo mundo2) {
		// TODO Auto-generated method stub
		this.mundo=mundo2;
	}

}
