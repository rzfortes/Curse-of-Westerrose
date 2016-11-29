package packageRPG.entities.statics;

import java.awt.Graphics;

import packageRPG.Handler;
import packageRPG.entities.statics.StaticEntity;
import packageRPG.gfx.Assets;
import packageRPG.tiles.Tile;

public class slantTree extends StaticEntity{

	public slantTree(Handler handler, float x, float y, int scale) {
		super(handler, x, y, Tile.TILEWIDTH + scale,Tile.TILEHEIGHT + scale, 1000);
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
		g.drawImage(Assets.slantTree, (int)(x -handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height, null);
		
	}

	@Override
	public void dead() {
		// TODO Auto-generated method stub
		
	}
	
	

}
