package nico.castleland.game.states;

import java.awt.Graphics;

import nico.castleland.game.Game;
import nico.castleland.game.Handler;

public abstract class State implements Establecer{
	
	private static State estadoActual = null;
	protected Handler handler;
	
	public static void setState(State state) {
		estadoActual = state;
	}
	
	public static State getEstado() {
		return estadoActual;
	}
	
	
	
	public State (Handler handler) {
		this.handler = handler;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
}
