/**
 * 
 */
package nico.castleland.game.tiles;

import nico.castleland.game.gfx.Assets;

/**
 * @author nicks
 *
 */
public class TileRoca extends Tile{

	public TileRoca(int id) {
		super(Assets.piedra, id);
	}
	
	public boolean esSolido() {
		return true;
	}
}
