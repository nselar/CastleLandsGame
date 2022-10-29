/**
 * 
 */
package nico.castleland.game.tiles;

import nico.castleland.game.gfx.Assets;

/**
 * @author nicks
 *
 */
public class TileMuro extends Tile {

	public TileMuro(int id) {
		
		super(Assets.muro, id);
	}
	
	@Override
	public boolean esSolido() {
		return true;
	}

}
