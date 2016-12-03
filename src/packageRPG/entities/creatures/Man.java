package packageRPG.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;

import packageRPG.Handler;
import packageRPG.gfx.Assets;

public class Man extends Creature {

	public Man(Handler handler, float x, float y) {
		super(handler, x, y, 32, 64, 1000);
	}

	@Override
	public void update() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.man, (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);

		if (handler.getMap().getEntityManager().getPlayer().flagM1 == 0) {
			g.setColor(Color.WHITE);
			g.drawString("I need 10 wood", 330, 120);

		}

	}

	@Override
	public void dead() {
		System.out.println("yay");
		}
	}


