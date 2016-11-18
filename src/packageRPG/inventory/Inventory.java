package packageRPG.inventory;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import packageRPG.Handler;
import packageRPG.entities.statics.Rock;
import packageRPG.gfx.Assets;
import packageRPG.items.Item;

public class Inventory {

	private Handler handler;
	private boolean active = false;
	private ArrayList<Item> inventoryItems;
	
	public int r,w;
	
	String str;
	
	public Inventory(Handler handler) {
		this.handler = handler;
		inventoryItems = new ArrayList<Item>();
	}
	
	public void update() {
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_E)) {
			active = !active;
		}
		if(!active) {
			return;
		}
		
		System.out.println("Inventory:");
		for(Item i : inventoryItems) {
			System.out.println(i.getName() + "   " + i.getCount());
			
		}
				
	}
	
	public void render(Graphics g) {
		if(!active) {
			return;
		}
		
		for(Item i : inventoryItems) {
			//System.out.println(i.getName() + "   " + i.getCount());
			//if(i.rockITem != null){
				if(i.getId() == 1){
				g.drawImage(Assets.rock, 470, 325, null);
				g.drawString(String.valueOf(i.getCount()), 470, 320);
				r = i.getCount();
				}
				else if(i.getId() == 0){
					g.drawImage(Assets.wood, 520, 325, null);
					g.drawString(String.valueOf(i.getCount()), 520, 320);
					w = i.getCount();
				}
			
		}
	
	}
	
	// inventory methods section
	
	public void addItem(Item item) {
		for(Item i : inventoryItems) {
			if(i.getId() == item.getId()) {
				i.setCount(i.getCount() + item.getCount());
				return;
			}
		}
		inventoryItems.add(item);
	}
	
	public void removeItem(Item item){
		for(Item i : inventoryItems) {
			if(i.getId() == item.getId()) {
				i.setCount(item.getCount() - 1);
				return;
			}
		}
	}
	
	// getters and setters

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	
}
