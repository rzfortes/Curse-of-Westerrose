package packageRPG.entities.statics;

import java.awt.Graphics;

import packageRPG.Handler;
import packageRPG.gfx.Assets;
import packageRPG.items.Item;
import packageRPG.tiles.Tile;

public class Rock extends StaticEntity {

	public Rock(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT, 1);
		
		bounds.x = 3;
		bounds.y = (int) (height / 2f);
		bounds.width = width - 6;
		bounds.height = (int) (height - height / 2f);
	}
	
	@Override
	public void update() {
		
	}
	
	@Override
	public void dead() {
		handler.getMap().getItemManager().addItem(Item.rockITem.createNew((int)x, (int)y));
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.rock, (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), null);
	}

}
