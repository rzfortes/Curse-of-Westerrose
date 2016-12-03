package packageRPG.entities.statics;

import java.awt.Color;
import java.awt.Graphics;

import packageRPG.Handler;
import packageRPG.gfx.Assets;

public class hwall extends StaticEntity{

	public hwall(Handler handler, float x, float y) {
		super(handler, x, y, 32, 32*2, 1000);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.wallhalf, (int)(x -handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height, null);
		
		if (handler.getMap().getEntityManager().getPlayer().flagWall== 0){
			g.setColor(Color.WHITE);
			g.drawString("Still can't get through", 330, 120);
		}
	}

	@Override
	public void dead() {
		// TODO Auto-generated method stub
		
	}

}
