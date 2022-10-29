/**
 * 
 */
package nico.castleland.game.worlds;

import java.awt.Graphics;

import nico.castleland.game.Game;
import nico.castleland.game.Handler;
import nico.castleland.game.entities.Entidad;
import nico.castleland.game.entities.EntityManager;
import nico.castleland.game.entities.creatures.Arquero;
import nico.castleland.game.entities.creatures.Caballero;
import nico.castleland.game.entities.creatures.Mago;
import nico.castleland.game.entities.creatures.Personaje;
import nico.castleland.game.items.ItemManager;
import nico.castleland.game.states.MenuState;
import nico.castleland.game.tiles.Tile;
import nico.castleland.game.utils.Utils;

/**
 * @author nicks
 *
 */
public class Mundo {
	
	private Handler handler;
	
	private int spawnX, spawnY;
	
	private int ancho, alto;
	private int [][] tiles;
	
	//Entities
	private EntityManager entityManager;
    // Item
	private ItemManager itemManager;
	
	private Utils u = new Utils();
	
	public Mundo(Handler handler, String ruta) {
		this.handler=handler;
		entityManager=new EntityManager(handler, MenuState.getPersonaje());
		
		itemManager = new ItemManager(handler);
		CargarMundo(ruta);
		if(entityManager.getPersonaje()==null) {
			entityManager=new EntityManager(handler, MenuState.getPersonaje());
		} else {
			entityManager.getPersonaje().setX(spawnX);
			entityManager.getPersonaje().setY(spawnY);
		}
	}

	public void tick() {
		
		itemManager.tick();
		
		if(entityManager.getPersonaje()==null) {
			entityManager=new EntityManager(handler, MenuState.getPersonaje());
		} else {
			entityManager.tick();
		}
	}
	
	public void render (Graphics g) {
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(ancho, (handler.getGameCamera().getxOffset() + handler.getAncho()) / Tile.TILEWIDTH +1 );
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(alto, (handler.getGameCamera().getyOffset() + handler.getAlto()) / Tile.TILEHEIGHT + 1);
		
		for(int y = yStart; y < yEnd; y++) {
			for(int x = xStart; x < xEnd; x++) {
				getTile(x,y).render(g, (int)(x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
						(int) (y*Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		
		// Items
		itemManager.render(g);
		//Entities
		entityManager.render(g);
	}
	
	public Tile getTile(int x, int y) {
		if(x < 0 || y < 0 || x >= ancho || y >=alto) {
			return Tile.tileHierba;
		}
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t==null) {
			return Tile.tileHierba;
		}
		return t;
	}

	private void CargarMundo(String ruta) {
		String file = u.loadFileAsString(ruta);
		String[] tokens = file.split("\\s+");
		ancho = Utils.parseInt(tokens[0]);
		alto = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int [ancho] [alto];
		for(int y = 0; y < alto; y++) {
			for(int x = 0; x < ancho; x++) {
				tiles [x] [y] = Utils.parseInt(tokens[(x+y*ancho)+4]);
			}
		}
	}
	
	public int getAncho() {
		return ancho;
	}
	
	public int getAlto() {
		return alto;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public ItemManager getItemManager() {
		return itemManager;
	}
	
	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}
}
