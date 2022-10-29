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
public class Roca extends StaticEntity{

	public Roca(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		// TODO Auto-generated constructor stub
		
		bordes.x = 3;
		bordes.y = (int) (alto / 2f);
		bordes.width = ancho - 6;
		bordes.height = (int) (alto - alto / 2f);
	}
	
	@Override
	public void tick() {
		
	}
	
	@Override
	public void die(){
		handler.getMundo().getItemManager().addItem(Item.rockItem.createNew((int) x, (int) y));
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.piedra, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), ancho, alto, null);
	}

}
