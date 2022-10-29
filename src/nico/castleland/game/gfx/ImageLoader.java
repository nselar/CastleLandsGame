/**
 * 
 */
package nico.castleland.game.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author nicks
 *
 */

public class ImageLoader {

	public BufferedImage loadImage(String path){
		try {
			return ImageIO.read(getClass().getResourceAsStream(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
	
}
