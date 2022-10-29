/**
 * 
 */
package nico.castleland.game.gfx;


import java.awt.image.BufferedImage;
/**
 * @author nicks
 *
 */
public class Animación {
	
	private int velocidad, indice;
	private long lasTime, timer;
	private BufferedImage[] frames;
	
	public Animación(int velocidad, BufferedImage[] frames) {
		this.velocidad = velocidad;
		this.frames = frames;
		indice = 0;
		timer = 0;
		lasTime = System.currentTimeMillis();
	}
	
	public void tick() {
		timer += System.currentTimeMillis() - lasTime;
		lasTime = System.currentTimeMillis();
		
		if(timer > velocidad) {
			indice++;
			timer =0;
			
			if(indice >= frames.length) {
				indice = 0;
			}
		}
	}
	
	public BufferedImage getCurrentFrame() {
		return frames[indice];
	}
}
