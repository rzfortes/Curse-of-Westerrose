package packageRPG.entities.statics;

import java.awt.Color;
import java.awt.Graphics;

import packageRPG.Handler;
import packageRPG.entities.statics.StaticEntity;
import packageRPG.gfx.Assets;
import packageRPG.tiles.Tile;

public class flatRock2 extends StaticEntity{

	public flatRock2(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH,Tile.TILEHEIGHT, 1000);
		// TODO Auto-generated constructor stub
		bounds.x = 15;
		bounds.y = (int)(height / 2.0f);
		bounds.width = width - 20;
		bounds.height = (int)(height - height / 1.5f);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.flatRock, (int)(x -handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height, null);
		if (handler.getMap().getEntityManager().getPlayer().flagFR2== 0){
			g.setColor(Color.BLACK);
			//g.drawString("MOVING", 330, 120);
			//4
			g.drawString("1", 330, 120);
			if(handler.getMap().getEntityManager().getPlayer().flagCheck== 0){
				g.drawString(",CORRECT", 340, 120);
			}
			
		}
	}

	@Override
	public void dead() {
		// TODO Auto-generated method stub
		
	}
	
	

}

