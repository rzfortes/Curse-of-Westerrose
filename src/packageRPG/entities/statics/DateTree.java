package packageRPG.entities.statics;

import java.awt.Graphics;

import packageRPG.Handler;
import packageRPG.gfx.Assets;

public class DateTree extends StaticEntity{

	public DateTree(Handler handler, float x, float y) {
		super(handler, x, y, 70, 80, 1000);
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
	public void render(Graphics g) {
		g.drawImage(Assets.dateTree, (int)(x -handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height, null);
		
	}

	@Override
	public void dead() {
		// TODO Auto-generated method stub
		
	}
	
	

}
