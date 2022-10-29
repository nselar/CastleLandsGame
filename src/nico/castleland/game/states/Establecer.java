/**
 * 
 */
package nico.castleland.game.states;


import java.awt.Graphics;
/**
 * @author nicks
 *
 */
public interface Establecer { //Patron State
	
	public void tick();
	public void render(Graphics g);
}
