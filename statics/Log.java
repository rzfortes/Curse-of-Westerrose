package packageRPG.entities.statics;

import java.awt.Graphics;

import packageRPG.Handler;
import packageRPG.gfx.Assets;

public class Log extends StaticEntity{
	public Log(Handler handler, float x, float y) {
		super(handler, x, y, 64,32,1000);
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
		g.drawImage(Assets.log, (int)(x -handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height, null);
		
	}
}
