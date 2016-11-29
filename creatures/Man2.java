package packageRPG.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;

import packageRPG.Handler;
import packageRPG.gfx.Assets;
import packageRPG.items.Item;

public class Man2 extends Creature {

	public Man2(Handler handler, float x, float y) {
		super(handler, x, y, 32, 64, 1000);
	}

	@Override
	public void update() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.man, (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);

		if (handler.getMap().getEntityManager().getPlayer().flagM2 == 0) {
			g.setColor(Color.WHITE);
			g.drawString("I need All mushrooms", 330, 120);

		}

	}

	@Override
	public void dead() {
		System.out.println("yay");
		handler.getMap().getItemManager().addItem(Item.rockITem.createNew((int) x, (int) y));
	}

}
