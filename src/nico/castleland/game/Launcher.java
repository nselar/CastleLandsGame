/**
 * 
 */
package nico.castleland.game;

/**
 * @author nicks
 *
 */
public class Launcher {

	public static void main(String[] args){
		Game game = new Game("CastleLands", 640, 360);
		game.start();
	}
	//Con el grupo he conseguido terminar el menu principal del juego, terminar de implementar el patron, 
	//Leer las imagenes del ejecutable pero no he conseguido que lea el mundo.txt
}
