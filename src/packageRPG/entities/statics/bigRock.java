package packageRPG.entities.statics;

import java.awt.Graphics;

import packageRPG.Handler;
import packageRPG.gfx.Assets;

public class bigRock extends StaticEntity{

	public bigRock(Handler handler, float x, float y) {
		super(handler, x, y, 128, 80, 1000);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.boulder, (int)(x -handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height, null);
		
	}

	@Override
	public void dead() {
		// TODO Auto-generated method stub
		
	}

}
