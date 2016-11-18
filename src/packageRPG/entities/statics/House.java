package packageRPG.entities.statics;

import java.awt.Graphics;

import packageRPG.Handler;
import packageRPG.gfx.Assets;
import packageRPG.tiles.Tile;

public class House extends StaticEntity{

	public House(Handler handler, float x, float y) {
		super(handler, x, y, 200,125,1000);
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
		g.drawImage(Assets.h1, (int)(x -handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height, null);
		
	}
	
}