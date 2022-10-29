/**
 * 
 */
package nico.castleland.game.entities.creatures;

import java.awt.Graphics;
import java.awt.*;
import java.awt.image.BufferedImage;

import nico.castleland.game.Game;
import nico.castleland.game.Handler;
import nico.castleland.game.entities.Entidad;
import nico.castleland.game.gfx.Animación;
import nico.castleland.game.gfx.Assets;
import nico.castleland.game.inventory.Inventario;

/**
 * @author nicks
 *
 */
public class Boss1 extends Personaje {

	/** 
	 * 
	 */
	
	//Animations
	private Animación animDown, animUp, animLeft, animRight;
	
	//Tiempos de ataque
	private long lastAttackTimer, attackCooldown = 800, attackTimer = attackCooldown;
	// Inventario
	private Inventario inventory;
	
	public Boss1(Handler handler, float x, float y) {
		
		super(handler, x,y, Personaje.ANCHO_PREDETERMINADO_PERSONAJE, Personaje.ALTO_PREDETERMINADO_PERSONAJE);
		
		bordes.x= 22;
		bordes.y = 44;
		bordes.width = 19;
		bordes.height = 19;
		
		//Animaciones
		animDown = new Animación(500, Assets.caballero_down);
		animUp = new Animación(500, Assets.caballero_up);
		animLeft = new Animación(500, Assets.caballero_left);
		animRight = new Animación(500, Assets.caballero_right);
		
		inventory = new Inventario(handler);
		System.out.println("Boss1 creado.");
	}

	@Override
	public void tick() {
		//Animaciones
		animDown.tick();
		animUp.tick();
		animRight.tick();
		animLeft.tick();
		//Movimiento
		
		move();
		
		// Ataques
	    checkAttacks();
	    // Inventario
	   inventory.tick();
	}
	
	private void checkAttacks() {
		// TODO Auto-generated method stub
		attackTimer += System.currentTimeMillis() - lastAttackTimer;
		lastAttackTimer = System.currentTimeMillis();
		if(attackTimer < attackCooldown)
			return;
		
		if(inventory.isActive())
			return;
		
		Rectangle cb = getCollisionBounds(0, 0);
		Rectangle ar = new Rectangle();
		int arSize = 20;
		ar.width = arSize;
		ar.height = arSize;
		
		if(handler.getKeyManager().aUp){
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y - arSize;
		}else if(handler.getKeyManager().aDown){
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y + cb.height;
		}else if(handler.getKeyManager().aLeft){
			ar.x = cb.x - arSize;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
		}else if(handler.getKeyManager().aRight){
			ar.x = cb.x + cb.width;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
		}else{
			return;
		}
		
		attackTimer = 0;
		
		for(Entidad e : handler.getMundo().getEntityManager().getEntities()){
			if(e.equals(this))
				continue;
			if(e.getCollisionBounds(0, 0).intersects(ar)){
				e.hurt(1);
				return;
			}
		}
		
	}
	
	@Override
	public void die(){
		System.out.println("Ganaste");
	}

	private void follow(Personaje personaje) {
		xMove = 10;
		yMove = 10;
		
		if(inventory.isActive())
			return;
		
		if(handler.getKeyManager().arriba) {
			yMove = -speed;
		}
		if(handler.getKeyManager().abajo) {
			yMove = speed;
		}
		if(handler.getKeyManager().izquierda) {
			xMove = -speed;
		}
		if(handler.getKeyManager().derecha) {
			xMove = speed;
		}
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(getCurrentAnimationFrame(),(int) (x - handler.getGameCamera().getxOffset()),(int) (y - handler.getGameCamera().getyOffset()), ancho, alto, null);
		
/*		g.setColor(Color.red);
		g.fillRect((int) (x + bordes.x - handler.getGameCamera().getxOffset()),
				(int) (y + bordes.y - handler.getGameCamera().getyOffset()), bordes.width, bordes.height);*/
	}
	
	public void postRender(Graphics g){
		inventory.render(g);
	}
	
	private BufferedImage getCurrentAnimationFrame() {
		if(xMove < 0) {
			return animLeft.getCurrentFrame();
		} else if (xMove > 0){
			return animRight.getCurrentFrame();
		} else if (yMove < 0) {
			return animUp.getCurrentFrame();
		} else {
			return animDown.getCurrentFrame();
		}
	}
	
	public Inventario getInventory() {
		return inventory;
	}
	
	public void setInventory(Inventario inventory) {
		this.inventory = inventory;
	}

}
