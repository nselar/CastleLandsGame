/**
 * 
 */
package nico.castleland.game.entities.statics;

import java.awt.Graphics;

import nico.castleland.game.Handler;
import nico.castleland.game.gfx.Assets;
import nico.castleland.game.items.Item;
import nico.castleland.game.tiles.Tile;

/**
 * @author nicks
 *
 */
public class Arbol extends StaticEntity {

	public Arbol(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT*2);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void tick() {
		
	}
	
	@Override
	public void die(){
		handler.getMundo().getItemManager().addItem(Item.woodItem.createNew((int) x, (int) y));
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.tierra, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), ancho, alto, null);
	}

}
