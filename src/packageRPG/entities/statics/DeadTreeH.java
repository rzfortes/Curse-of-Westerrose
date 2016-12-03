package packageRPG.entities.statics;


import java.awt.Color;
import java.awt.Graphics;

import packageRPG.Handler;
import packageRPG.gfx.Assets;
import packageRPG.items.Item;

public class DeadTreeH extends StaticEntity{

	public DeadTreeH(Handler handler, float x, float y) {
		super(handler, x, y, 50,80,10);
		// TODO Auto-generated constructor stub
		bounds.x = 10;
		bounds.y = (int)(height / 1.5f);
		bounds.width = width - 20;
		bounds.height = (int)(height - height / 1.5f);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void dead() {
		handler.getMap().getItemManager().addItem(Item.woodITem.createNew((int)x+50, (int)y));
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.dtree, (int)(x -handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height, null);
		
		// dead tree H's health bar so that the user will know the tree's health
		g.setColor(Color.black);
		g.drawString("Dead Tree H's health", 500, 335);
		
		g.setColor(Color.gray);
		g.fillRect(570, 340, 50, 10);
		
		g.setColor(Color.BLUE);
		g.fillRect(570, 340, this.health * 5, 10);
		
		g.setColor(Color.WHITE);
		g.drawRect(570, 340, 50, 10);
	}
	
}

