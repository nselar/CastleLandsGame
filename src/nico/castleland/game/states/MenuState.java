/**
 * 
 */
package nico.castleland.game.states;

import java.awt.Graphics;
import java.awt.Color;

import javax.swing.JLabel;

import nico.castleland.game.Handler;
import nico.castleland.game.entities.creatures.Arquero;
import nico.castleland.game.entities.creatures.Caballero;
import nico.castleland.game.entities.creatures.Mago;
import nico.castleland.game.entities.creatures.Personaje;
import nico.castleland.game.gfx.Assets;
import nico.castleland.game.gfx.Text;
import nico.castleland.game.ui.ClickListener;
import nico.castleland.game.ui.UIImageButton;
import nico.castleland.game.ui.UIManager;

public class MenuState extends State {

	private UIManager uiManager;
	private static Personaje personaje;
	private State miestado;

	public MenuState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		uiManager.addObject(new UIImageButton(100, 200, 64, 64, Assets.caballero_down, new ClickListener() {
			@Override
			public void onClick() {
				personaje=new Caballero(handler, 100, 100);
				handler.getMouseManager().setUIManager(null);
				miestado.setState(handler.getGame().getEstadoJuego());
			}
		}));
		
		uiManager.addObject(new UIImageButton(300, 200, 64, 64, Assets.arquero_down, new ClickListener() {
			@Override
			public void onClick() {
				personaje=new Arquero(handler, 100, 100);
				handler.getMouseManager().setUIManager(null);
				miestado.setState(handler.getGame().getEstadoJuego());
			}
		}));
		
		uiManager.addObject(new UIImageButton(500, 200, 128, 128, Assets.mago_down, new ClickListener() {
			@Override
			public void onClick() {
				personaje=new Mago(handler, 100, 100);
				handler.getMouseManager().setUIManager(null);
				miestado.setState(handler.getGame().getEstadoJuego());
			}
		}));
	}

	@Override
	public void tick() {
		uiManager.tick();
	}

	@Override
	public void render(Graphics g) {
		uiManager.render(g);
	}
	
	public static Personaje getPersonaje() {
		return personaje;
	}
	

}
