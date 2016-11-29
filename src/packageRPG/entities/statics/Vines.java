package packageRPG.entities.statics;

import java.awt.Graphics;

import packageRPG.Handler;
import packageRPG.gfx.Assets;

public class Vines extends StaticEntity{
	public Vines(Handler handler, float x, float y) {
		super(handler, x, y, 32,64,1000);
		// TODO Auto-generated constructor stub
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
		g.drawImage(Assets.bush, (int)(x -handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height, null);
		
	}
}