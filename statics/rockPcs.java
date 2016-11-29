package packageRPG.entities.statics;

import java.awt.Color;
import java.awt.Graphics;

import packageRPG.Handler;
import packageRPG.entities.statics.StaticEntity;
import packageRPG.gfx.Assets;
import packageRPG.tiles.Tile;

public class rockPcs extends StaticEntity{

	public rockPcs(Handler handler, float x, float y, int scale) {
		super(handler, x, y, 30 + scale,30 + scale, 100);
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
		g.drawImage(Assets.rockPcs, (int)(x -handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height, null);
		
		if(health<100){
			if (handler.getMap().getEntityManager().getPlayer().flagRP1== 0) {
				g.setColor(Color.WHITE);
				g.drawString("rock pcs, I can make fire here", 330, 120);
				
			}
			if (handler.getMap().getEntityManager().getPlayer().flagRP2== 0) {
				g.drawImage(Assets.fire, (int)(x -handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height, null);
			}
			
		}
	}

	@Override
	public void dead() {
		// TODO Auto-generated method stub
		
	}
	
	

}
