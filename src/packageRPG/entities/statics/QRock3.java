package packageRPG.entities.statics;

import java.awt.Color;
import java.awt.Graphics;

import packageRPG.Handler;
import packageRPG.gfx.Assets;
import packageRPG.tiles.Tile;

public class QRock3  extends StaticEntity {
	public QRock3(Handler handler, float x, float y) {
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
		
		if (handler.getMap().getEntityManager().getPlayer().flagQ3== 0){
			g.setColor(Color.BLACK);
			g.drawString("If you take 3 apples from a group of 5, "
				      + "how many do you have?", 250, 120);
		}
	}

	@Override
	public void dead() {
		// TODO Auto-generated method stub
		
	}
}
