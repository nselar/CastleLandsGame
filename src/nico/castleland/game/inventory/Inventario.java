/**
 * 
 */
package nico.castleland.game.inventory;

import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.event.KeyEvent;

import nico.castleland.game.Handler;
import nico.castleland.game.gfx.Assets;
import nico.castleland.game.gfx.Text;
import nico.castleland.game.items.Item;

/**
 * @author nicks
 *
 */
public class Inventario {
	
	private Handler handler;
	private boolean active = false;
	private ArrayList<Item> inventoryItems;
	
	private int invX = 64, invY = 48,
			invWidth = 512, invHeight = 384,
			invListCenterX = invX + 171,
			invListCenterY = invY + invHeight / 2 + 5,
			invListSpacing = 30;
	
	private int invImageX = 452, invImageY = 82,
			invImageWidth = 64, invImageHeight = 64;
	
	private int invCountX = 484, invCountY = 172;
	
	private int selectedItem = 0;

	public Inventario(Handler handler) {
		// TODO Auto-generated constructor stub
		this.handler = handler;
		inventoryItems = new ArrayList<Item>();
	}

	public void tick() {
		// TODO Auto-generated method stub
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_E))
			active = !active;
		if(!active)
			return;
		
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_W))
			selectedItem--;
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_S))
			selectedItem++;
		
		if(selectedItem < 0)
			selectedItem = inventoryItems.size() - 1;
		else if(selectedItem >= inventoryItems.size())
			selectedItem = 0;
	}

	public boolean isActive() {
		// TODO Auto-generated method stub
		return false;
	}

	public void render(Graphics g) {
		// TODO Auto-generated method stub
		if(!active)
			return;
		
		g.drawImage(Assets.inventoryScreen, invX, invY, invWidth, invHeight, null);
		
		int len = inventoryItems.size();
		if(len == 0)
			return;
		
		for(int i = -5;i < 6;i++){
			if(selectedItem + i < 0 || selectedItem + i >= len)
				continue;
			if(i == 0){
				Text.drawString(g, "> " + inventoryItems.get(selectedItem + i).getName() + " <", invListCenterX, 
						invListCenterY + i * invListSpacing, true, Color.YELLOW, Assets.font28);
			}else{
				Text.drawString(g, inventoryItems.get(selectedItem + i).getName(), invListCenterX, 
						invListCenterY + i * invListSpacing, true, Color.WHITE, Assets.font28);
			}
		}
		
		Item item = inventoryItems.get(selectedItem);
		g.drawImage(item.getTexture(), invImageX, invImageY, invImageWidth, invImageHeight, null);
		Text.drawString(g, Integer.toString(item.getCount()), invCountX, invCountY, true, Color.WHITE, Assets.font28);
	}
	
	public void addItem(Item item){
		for(Item i : inventoryItems){
			if(i.getId() == item.getId()){
				i.setCount(i.getCount() + item.getCount());
				return;
			}
		}
		inventoryItems.add(item);
	}
	
	public Handler getHandler() {
		return handler;
	}
	
	public void setHandler(Handler handler) {
		this.handler = handler;
	}

}
