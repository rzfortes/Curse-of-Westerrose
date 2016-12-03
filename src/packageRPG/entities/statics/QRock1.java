package packageRPG.entities.statics;

import java.awt.Color;
import java.awt.Graphics;

import packageRPG.Handler;
import packageRPG.gfx.Assets;
import packageRPG.tiles.Tile;

public class QRock1  extends StaticEntity {
	public QRock1(Handler handler, float x, float y) {
		super(handler, x, y, 50,Tile.TILEHEIGHT, 1000);
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
		g.drawImage(Assets.bigRock, (int)(x -handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height, null);
		
		if (handler.getMap().getEntityManager().getPlayer().flagQ1== 0){
			g.setColor(Color.BLACK);
			//How many eggs can you put in an empty basket?
			g.drawString("How many eggs can you put in an empty basket?", 330, 120);
		}
	}

	@Override
	public void dead() {
		// TODO Auto-generated method stub
		
	}
}
