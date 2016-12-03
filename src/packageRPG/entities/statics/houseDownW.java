package packageRPG.entities.statics;

import java.awt.Graphics;

import packageRPG.Handler;
import packageRPG.gfx.Assets;

public class houseDownW extends StaticEntity{

	public houseDownW(Handler handler, float x, float y) {
		super(handler, x, y, 64, 64, 1000);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.hwalld1, (int)(x -handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height, null);
		
		//hwallup,hwalll,hwallr,hwalld1,hwalld2;
	}

	@Override
	public void dead() {
		// TODO Auto-generated method stub
		
	}

}
