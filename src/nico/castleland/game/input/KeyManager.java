package nico.castleland.game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
	
	private boolean[] justPressed, cantPress;
	private boolean[] teclas;
	public boolean arriba, izquierda, abajo, derecha;
	public boolean aUp, aDown, aLeft, aRight;
	
	public KeyManager() {
		teclas = new boolean[256];
		justPressed = new boolean[teclas.length];
		cantPress = new boolean[teclas.length];
	}
	
	public void tick() {
		for(int i = 0;i < teclas.length;i++){
			if(cantPress[i] && !teclas[i]){
				cantPress[i] = false;
			}else if(justPressed[i]){
				cantPress[i] = true;
				justPressed[i] = false;
			}
			if(!cantPress[i] && teclas[i]){
				justPressed[i] = true;
			}
		}
		
		arriba = teclas[KeyEvent.VK_W];
		izquierda = teclas[KeyEvent.VK_A];
		abajo = teclas[KeyEvent.VK_S];
		derecha = teclas[KeyEvent.VK_D];
		
		aUp = teclas[KeyEvent.VK_UP];
		aDown = teclas[KeyEvent.VK_DOWN];
		aLeft = teclas[KeyEvent.VK_LEFT];
		aRight = teclas[KeyEvent.VK_RIGHT];
	}
	
	public boolean keyJustPressed(int keyCode){
		if(keyCode < 0 || keyCode >= teclas.length)
			return false;
		return justPressed[keyCode];
	}
 
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() < 0 || e.getKeyCode() >= teclas.length)
			return;
		teclas[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() < 0 || e.getKeyCode() >= teclas.length)
			return;
		teclas[e.getKeyCode()] = false;
	}
	
}
