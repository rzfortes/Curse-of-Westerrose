package packageRPG.entities.statics;

import java.awt.Color;
import java.awt.Graphics;

import packageRPG.Handler;
import packageRPG.gfx.Assets;

public class Well extends StaticEntity {
	public Well(Handler handler, float x, float y) {
		super(handler, x, y, 64, 64, 1000);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.well, (int)(x -handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height, null);
		
		if (handler.getMap().getEntityManager().getPlayer().flagW == 0) {
			g.setColor(Color.WHITE);
			g.drawString("A Well.. hunger replenished", 330, 120);

		}
	}

	@Override
	public void dead() {
		// TODO Auto-generated method stub
		
	}
	
}
