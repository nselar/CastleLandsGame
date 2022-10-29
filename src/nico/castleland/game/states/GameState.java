package nico.castleland.game.states;

import java.awt.Graphics;

import nico.castleland.game.Game;
import nico.castleland.game.Handler;
import nico.castleland.game.entities.creatures.Caballero;
import nico.castleland.game.entities.statics.Arbol;
import nico.castleland.game.tiles.Tile;
import nico.castleland.game.worlds.Mundo;

public class GameState extends State {
	

	private Mundo mundo;
	
	public GameState(Handler handler) {
		super(handler);  
		mundo = new Mundo(handler, "res/mundos/mundo1.txt");
		handler.setMundo(mundo);
	}
	
	@Override
	public void tick() {
		mundo.tick();
		
	}
	
	@Override
	public void render (Graphics g) {
		mundo.render(g);
		
	}

}
