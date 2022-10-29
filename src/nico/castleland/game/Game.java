/**
 * 
 */
package nico.castleland.game;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import nico.castleland.display.Display;
import nico.castleland.game.gfx.*;
import nico.castleland.game.input.KeyManager;
import nico.castleland.game.input.MouseManager;
import nico.castleland.game.states.GameState;
import nico.castleland.game.states.MenuState;
import nico.castleland.game.states.State;

public class Game implements Runnable {

	private Display display;
	private int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private Assets myasset = new Assets();
	
	
	
	//Inputs
	private KeyManager controles;
	private MouseManager mouseManager;
	
	//Cámaras...
	private GameCamera gamecamera;
	
	//Handlers
	private Handler handler;
	
	//Estados del juego (menu, pantalla...)
	private State estadoJuego;
	private State estadoMenu;
	/**
	 * @return the estadoJuego
	 */
	public State getEstadoJuego() {
		return estadoJuego;
	}

	/**
	 * @param estadoJuego the estadoJuego to set
	 */
	public void setEstadoJuego(State estadoJuego) {
		this.estadoJuego = estadoJuego;
	}
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		controles = new KeyManager();
		mouseManager = new MouseManager();
	}
	
	private void init(){
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(controles);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		myasset.init();
		
		handler = new Handler(this);
		gamecamera = new GameCamera(handler, 0, 0);
		
		setEstadoMenu(new MenuState(handler));
		estadoJuego = new GameState(handler);
		
		State.setState(estadoMenu);
	}
	
	private void tick(){
		controles.tick();
		
		if(State.getEstado()!= null) {
			State.getEstado().tick();
		}
	}
	
	private void render(){
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//Borrar
		g.clearRect(0, 0, width, height);
		//Pintar por pantalla
		
		if(State.getEstado()!= null) {
			State.getEstado().render(g);
		}
		
		//Finalizar pintado
		bs.show();
		g.dispose();
	}
	
	public void run(){
		
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta=0;
		long now;
		long lastTime = System.nanoTime();
		long temporizador=0;
		int ticks = 0;
		
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime)/timePerTick;
			temporizador += now -lastTime;
			lastTime = now;
			
			if(delta >= 1) {
				tick();
				render();
				ticks++;
				delta--;
			}
			
			if(temporizador >= 1000000000) {
				System.out.println("Ticks and Frames: " + ticks);
				ticks =0;
				temporizador = 0;
			}
			
		}
		
		stop();
		
	}
	
	public KeyManager getKeyManager() {
		return controles;
	}
	
	public MouseManager getMouseManager(){
		return mouseManager;
	}
	
	public GameCamera getGameCamera() {
		return gamecamera;
	}
	
	public int getAncho() {
		return width;
	}
	
	public int getalto() {
		return height;
	}
	
	public synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the estadoMenu
	 */
	public State getEstadoMenu() {
		return estadoMenu;
	}

	/**
	 * @param menuR the estadoMenu to set
	 */
	public void setEstadoMenu(MenuState menu) {
		this.estadoMenu = menu;
	}
	
}
