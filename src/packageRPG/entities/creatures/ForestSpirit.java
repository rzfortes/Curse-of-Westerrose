package packageRPG.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;

import packageRPG.Handler;
import packageRPG.entities.statics.Fruits;
import packageRPG.gfx.Assets;

public class ForestSpirit extends Creature {

	public ForestSpirit(Handler handler, float x, float y) {
		super(handler, x, y, 32, 64, 1000);
	}

	@Override
	public void update() {

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.forest_spirit, (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		
		if(handler.getMap().getEntityManager().getPlayer().flagEl ==0){
			g.setColor(Color.WHITE);
			g.drawString("You have to kill the forest plant and forest Pig", 300, 120);
		}


	}

	@Override
	public void dead() {
		
		System.out.println("yay");
	}

}
