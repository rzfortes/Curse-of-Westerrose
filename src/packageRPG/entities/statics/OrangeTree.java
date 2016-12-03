package packageRPG.entities.statics;

import java.awt.Graphics;

import packageRPG.Handler;
import packageRPG.gfx.Assets;

public class OrangeTree extends StaticEntity {
	
	public OrangeTree(Handler handler, float x, float y) {
		super(handler, x, y, 32,64,1000);
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
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.orangetree, (int)(x -handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height, null);
		
	}
}
