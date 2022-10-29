/**
 * 
 */
package nico.castleland.game.gfx;

import nico.castleland.game.Game;
import nico.castleland.game.Handler;
import nico.castleland.game.entities.Entidad;
import nico.castleland.game.tiles.Tile;

/**
 * @author nicks
 *
 */
public class GameCamera {
	
	private float xOffset, yOffset;
	private Handler handler;
	
	public GameCamera(Handler handler, float xOffset, float yOffset) {
		this.handler=handler;
		this.xOffset=xOffset;
		this.yOffset=yOffset;
	}
	
	public void checkBlankSpace() {
		if(xOffset < 0) {
			xOffset = 0;
		} else if(xOffset > handler.getMundo().getAncho() * Tile.TILEWIDTH - handler.getAncho()) {
			xOffset = handler.getMundo().getAncho() * Tile.TILEWIDTH - handler.getAncho();
		}
		
		if(yOffset < 0) {
			yOffset = 0;
		} else if (yOffset > handler.getMundo().getAlto() * Tile.TILEHEIGHT - handler.getAlto()) {
			yOffset = handler.getMundo().getAlto() * Tile.TILEHEIGHT - handler.getAlto();
		}
	}
	
	public void centrarenPersonaje(Entidad e) {
		xOffset = e.getX() - handler.getAncho() / 2 + e.getAncho() / 2;
		yOffset = e.getY() - handler.getAlto() / 2 + e.getAlto() / 2;
		checkBlankSpace();
	}
	
	public void move(float xAmt, float yAmt) {
		xOffset += xAmt;
		yOffset += yAmt;
	}

	/**
	 * @return the xOffset
	 */
	public float getxOffset() {
		return xOffset;
	}

	/**
	 * @param xOffset the xOffset to set
	 */
	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	/**
	 * @return the yOffset
	 */
	public float getyOffset() {
		return yOffset;
	}

	/**
	 * @param yOffset the yOffset to set
	 */
	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}

}
