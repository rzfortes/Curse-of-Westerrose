package packageRPG.entities.statics;

import java.awt.Color;
import java.awt.Graphics;

import packageRPG.Handler;
import packageRPG.gfx.Assets;

public class Bed extends StaticEntity{

	public Bed(Handler handler, float x, float y) {
		super(handler, x, y, 32, 64, 1000);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.bed, (int)(x -handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height, null);
		
		if (handler.getMap().getEntityManager().getPlayer().flagB== 0){
			g.setColor(Color.BLACK);
			//How many eggs can you put in an empty basket?
			g.drawString("Zzz Health and Hunger Replenished", 300, 100);
		}
	}

	@Override
	public void dead() {
		// TODO Auto-generated method stub
		
	}

}
