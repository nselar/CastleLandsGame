/**
 * 
 */
package nico.castleland.game.entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import nico.castleland.game.Handler;
import nico.castleland.game.entities.creatures.Arquero;
import nico.castleland.game.entities.creatures.Boss1;
import nico.castleland.game.entities.creatures.Caballero;
import nico.castleland.game.entities.creatures.Mago;
import nico.castleland.game.entities.creatures.Personaje;

/**
 * @author nicks
 *
 */
public class EntityManager {

	private Handler handler;
	private Personaje personaje;
	private ArrayList<Entidad> entities;
	
	private Comparator<Entidad> renderSorter = new Comparator<Entidad>(){
		@Override
		public int compare(Entidad a, Entidad b) {
			if(a.getY() + a.getAlto() < b.getY() + b.getAncho())
				return -1;
			return 1;
		}
	};
	
	public EntityManager(Handler handler, Personaje personaje){
		this.handler = handler;
		this.personaje = personaje;
		entities = new ArrayList<Entidad>();
		addEntidad(personaje);
	}
	
	public void tick(){
		Iterator<Entidad> it = entities.iterator();
		while(it.hasNext()){
			Entidad e = it.next();
			e.tick();
			if(!e.isActive())
				it.remove();
		}
		entities.sort(renderSorter);
	}
	
	public void render(Graphics g){
		for(Entidad e : entities){
			e.render(g);
		}
		//entity.render(g);
	}
	
	public void addEntidad(Entidad e){
		entities.add(e);
	}
	
	//GETTERS SETTERS

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public Personaje getPersonaje() {
		return personaje;
	}

	public void setPersonaje(Personaje personaje) {
		this.personaje = personaje;
	}

	public ArrayList<Entidad> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entidad> entities) {
		this.entities = entities;
	}

}
