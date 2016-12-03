package packageRPG.entities.statics;

import java.awt.Color;
import java.awt.Graphics;

import packageRPG.Handler;
import packageRPG.gfx.Assets;
import packageRPG.tiles.Tile;

public class QRock2  extends StaticEntity {
	public QRock2(Handler handler, float x, float y) {
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
		
		if (handler.getMap().getEntityManager().getPlayer().flagQ2== 0){
			g.setColor(Color.BLACK);
			//If 1/2 of 5 is 3, then what is 1/3 of 10?
			g.drawString("If 1/2 of 5 is 3, then what is 1/3 of 10?", 330, 120);
		}
	}

	@Override
	public void dead() {
		// TODO Auto-generated method stub
		
	}
}
