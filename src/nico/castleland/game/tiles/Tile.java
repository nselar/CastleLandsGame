/**
 * 
 */
package nico.castleland.game.tiles;

import java.awt.image.BufferedImage;
import java.awt.Graphics;

/**
 * @author nicks
 *
 */
public class Tile {
	
	public static Tile[] tiles = new Tile[256];
	public static Tile tileHierba = new TileHierba(0);
	public static Tile tileMuro = new TileMuro(1);
	public static Tile tileRoca = new TileRoca(2);
	
	public static final int TILEWIDTH = 64, TILEHEIGHT=64;

	protected BufferedImage textura;
	protected final int id;
	
	public Tile(BufferedImage textura, int id) {
		this.textura=textura;
		this.id=id;
		
		tiles[id] = this;
		
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(textura, x, y, TILEWIDTH, TILEWIDTH, null);
	}
	
	public boolean esSolido() {
		return false;
	}
	
	public int getId() {
		return id;
	}
}
