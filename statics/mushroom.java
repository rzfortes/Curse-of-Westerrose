package packageRPG.entities.statics;

import java.awt.Graphics;

import packageRPG.Handler;
import packageRPG.entities.statics.StaticEntity;
import packageRPG.gfx.Assets;
import packageRPG.items.Item;
import packageRPG.tiles.Tile;

public class mushroom extends StaticEntity{

	public mushroom(Handler handler, float x, float y, int i) {
		super(handler, x, y, Tile.TILEWIDTH + i,Tile.TILEHEIGHT + i, 3);
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
		g.drawImage(Assets.mushroom, (int)(x -handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height, null);
		
	}

	@Override
	public void dead() {
		handler.getMap().getItemManager().addItem(Item.mushroom.createNew((int)x+75, (int)y));
		
	}
	
	

}
