/**
 * 
 */
package nico.castleland.game.entities.creatures;

import nico.castleland.game.Game;
import nico.castleland.game.Handler;
import nico.castleland.game.entities.Entidad;
import nico.castleland.game.inventory.Inventario;
import nico.castleland.game.tiles.Tile;

/**
 * @author nicks
 *
 */
public abstract class Personaje extends Entidad {
	
	public static final double DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int ANCHO_PREDETERMINADO_PERSONAJE = 64, ALTO_PREDETERMINADO_PERSONAJE = 64;
	
	protected int salud;
	protected float speed;
	protected float xMove, yMove;
	
	public Personaje(Handler handler, float x, float y, int ancho, int alto) {
		super(handler, x, y, ancho, alto);
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}
	
	public void move() {
		if(!checkEntityCollisions(xMove, 0f))
			moveX();
		if(!checkEntityCollisions(0f, yMove))
			moveY();
	}
	
	public void moveX() {
		if(xMove  > 0) { //Movimiento hacia la derecha -x
			
			int tx = (int) (x + xMove + bordes.x + bordes.width) / Tile.TILEWIDTH;
			
			if(!collisionWithTile(tx, (int) (y + bordes.y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y + bordes.y + bordes.height) / Tile.TILEHEIGHT)){
				x += xMove;
			}
			else {
				x = tx * Tile.TILEWIDTH - bordes.x - bordes.width -1 ;
			}
		} else if (xMove < 0) { //Movimiento hacia la izquierda +x
			
			int tx = (int) (x + xMove + bordes.x) / Tile.TILEWIDTH;
			
			if(!collisionWithTile(tx, (int) (y + bordes.y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y + bordes.y + bordes.height) / Tile.TILEHEIGHT)){
				x += xMove;
			}
			else {
				x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bordes.x;
			}
		}
	}
	
	public void moveY() {
		if(yMove < 0){//Up
			int ty = (int) (y + yMove + bordes.y) / Tile.TILEHEIGHT;
			
			if(!collisionWithTile((int) (x + bordes.x) / Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + bordes.x + bordes.width) / Tile.TILEWIDTH, ty)){
				y += yMove;
			}
			else {
				y = ty * Tile.TILEHEIGHT - Tile.TILEHEIGHT - bordes.y;
			}
		}else if(yMove > 0){//Down
			int ty = (int) (y + yMove + bordes.y + bordes.height) / Tile.TILEHEIGHT;
			
			if(!collisionWithTile((int) (x + bordes.x) / Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + bordes.x + bordes.width) / Tile.TILEWIDTH, ty)){
				y += yMove;
			}
			else {
				y = ty * Tile.TILEHEIGHT - bordes.y - bordes.height - 1;
			}
		}
	}
	
	protected boolean collisionWithTile(int x, int y) {
		return handler.getMundo().getTile(x, y).esSolido();
	}
	
	//getters y setters de las variables protegidas/privadas

	/**
	 * @return the xMove
	 */
	public float getxMove() {
		return xMove;
	}

	/**
	 * @param xMove the xMove to set
	 */
	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	/**
	 * @return the yMove
	 */
	public float getyMove() {
		return yMove;
	}

	/**
	 * @param yMove the yMove to set
	 */
	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	/**
	 * @return the salud
	 */
	public int getSalud() {
		return salud;
	}

	/**
	 * @param salud the salud to set
	 */
	public void setSalud(int salud) {
		this.salud = salud;
	}

	/**
	 * @return the speed
	 */
	public float getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	public abstract Inventario getInventory();
	
	public abstract void setInventory(Inventario inventory);

	

}
