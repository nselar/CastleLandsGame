/**
 * 
 */
package nico.castleland.game.gfx;

import java.awt.Font;
import java.awt.image.BufferedImage;

/**
 * @author nicks
 *
 */
public class Assets {
	
	private static final int ancho = 32, alto = 32;
	
	private ImageLoader myimg = new ImageLoader();
	
	public static BufferedImage jugador, piedra, tierra, ladrillo, muro;
	
	public static BufferedImage[] caballero_down, caballero_up, caballero_left, caballero_right;
	public static BufferedImage[] arquero_down, arquero_up, arquero_left, arquero_right;
	public static BufferedImage[] mago_down, mago_up, mago_left, mago_right;
	
	public static BufferedImage[] zombie_down, zombie_up, zombie_left, zombie_right;
	public static BufferedImage[] btn_start;
	public static BufferedImage inventoryScreen;
	public static BufferedImage wood;

	public static Font font28;

	public void init() {
		SpriteSheet sheet = new SpriteSheet(myimg.loadImage("/textures/sheet.png"));
		SpriteSheet caballero = new SpriteSheet (myimg.loadImage("/textures/caballero.png"));
		SpriteSheet arquero = new SpriteSheet (myimg.loadImage("/textures/archer.png"));
		SpriteSheet mago = new SpriteSheet (myimg.loadImage("/textures/wizard.png"));
		SpriteSheet enemigos = new SpriteSheet (myimg.loadImage("/textures/enemies.png"));
		
		caballero_down = new BufferedImage[2];
		caballero_up = new BufferedImage[2];
		caballero_left = new BufferedImage[2];
		caballero_right = new BufferedImage[2];
		
		caballero_down[0] = caballero.crop(46, 0, 46, 46);
		caballero_down[1] = caballero.crop(89, 0, 46, 46);
		caballero_up[0] = caballero.crop(1, 50, 46, 46);
		caballero_up[1] = caballero.crop(4, 50, 46, 46);
		caballero_left[0] = caballero.crop(142, 0, 46, 46);
		caballero_left[1] = caballero.crop(182, 0, 46, 46);
		caballero_right[0] = caballero.crop(136, 0, 46, 46);
		caballero_right[1] = caballero.crop(176, 3, 46, 46);
		
		arquero_down = new BufferedImage[2];
		arquero_up = new BufferedImage[2];
		arquero_left = new BufferedImage[2];
		arquero_right = new BufferedImage[2];
		
		arquero_down[0] = arquero.crop(25, 12, 46, 46);
		arquero_down[1] = arquero.crop(89, 0, 46, 46);
		arquero_up[0] = arquero.crop(6, 50, 46, 46);
		arquero_up[1] = arquero.crop(20, 50, 46, 46);
		arquero_left[0] = arquero.crop(142, 0, 46, 46);
		arquero_left[1] = arquero.crop(182, 0, 46, 46);
		arquero_right[0] = arquero.crop(136, 0, 46, 46);
		arquero_right[1] = arquero.crop(176, 3, 46, 46);
		
		mago_down = new BufferedImage[2];
		mago_up = new BufferedImage[2];
		mago_left = new BufferedImage[2];
		mago_right = new BufferedImage[2];
		
		mago_down[0] = mago.crop(5, 5, 87, 87);
		mago_down[1] = mago.crop(89, 0, 46, 46);
		mago_up[0] = mago.crop(6, 50, 46, 46);
		mago_up[1] = mago.crop(20, 50, 46, 46);
		mago_left[0] =mago.crop(142, 0, 46, 46);
		mago_left[1] = mago.crop(182, 0, 46, 46);
		mago_right[0] = mago.crop(136, 0, 46, 46);
		mago_right[1] = mago.crop(176, 3, 46, 46);
		
		
		tierra = sheet.crop(ancho, 0, ancho, alto);
		piedra = sheet.crop(0,  alto, ancho, alto);
		muro = sheet.crop(0, alto, ancho, alto);
		
		
	}
}
