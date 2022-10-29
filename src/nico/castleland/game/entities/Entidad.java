/**
 * 
 */
package nico.castleland.game.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import nico.castleland.game.Game;
import nico.castleland.game.Handler;

/**
 * @author nicks
 *
 */
public abstract class Entidad {
	
	public static final int DEFAULT_HEALTH = 3;
	protected Handler handler;

	protected float x, y;
	protected int ancho, alto;
	protected int salud;
	protected Rectangle bordes;
	protected boolean active = true;
	
	public Entidad(Handler handler,float x, float y, int ancho, int alto) {
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.alto = alto;
		this.ancho = ancho;
		salud = DEFAULT_HEALTH;
		
		bordes = new Rectangle(0,0, ancho, alto);
	}
	
	/**
	 * @return the x
	 */
	public float getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public float getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(float y) {
		this.y = y;
	}

	/**
	 * @return the ancho
	 */
	public int getAncho() {
		return ancho;
	}

	/**
	 * @param ancho the ancho to set
	 */
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	/**
	 * @return the alto
	 */
	public int getAlto() {
		return alto;
	}

	/**
	 * @param alto the alto to set
	 */
	public void setAlto(int alto) {
		this.alto = alto;
	}

	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	public abstract void die();
	
	public void hurt(int amt){
		salud -= amt;
		if(salud <= 0){
			active = false;
			die();
		}
	}
	
	public boolean checkEntityCollisions(float xOffset, float yOffset){
		for(Entidad e : handler.getMundo().getEntityManager().getEntities()){
			if(e.equals(this))
				continue;
			if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset)))
				return true;
		}
		return false;
	}
	
	public Rectangle getCollisionBounds(float xOffset, float yOffset){
		return new Rectangle((int) (x + bordes.x + xOffset), (int) (y + bordes.y + yOffset), bordes.width, bordes.height);
	}
	
	public int getSalud() {
		return salud;
	}

	public void setSalud(int salud) {
		this.salud = salud;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
