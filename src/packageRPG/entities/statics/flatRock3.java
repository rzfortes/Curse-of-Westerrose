package packageRPG.entities.statics;

import java.awt.Color;
import java.awt.Graphics;

import packageRPG.Handler;
import packageRPG.entities.statics.StaticEntity;
import packageRPG.gfx.Assets;
import packageRPG.items.Item;
import packageRPG.tiles.Tile;

public class flatRock3 extends StaticEntity{

	public flatRock3(Handler handler, float x, float y) {
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
		
		if (handler.getMap().getEntityManager().getPlayer().flagFR3== 0){
			g.setColor(Color.BLACK);
			//g.drawString("FORWARD", 330, 120);
			g.drawString("3", 330, 120);
			//How many eggs can you put in an empty basket? 
			if(handler.getMap().getEntityManager().getPlayer().flagCheck3== 0){
				g.drawString(",CORRECT", 340, 120);
			}
			
			
			if(handler.getMap().getEntityManager().getPlayer().flagClear== 0){
				handler.getMap().getItemManager().addItem(Item.rockITem.createNew((int) x+50, (int) y-50));
				handler.getMap().getEntityManager().getPlayer().flagClear= 1;
				handler.getMap().getEntityManager().getPlayer().flagCheck3= 1;
				handler.getMap().getEntityManager().getPlayer().flagCheck= 1;
				handler.getMap().getEntityManager().getPlayer().flagCheck2= 1;
			}
		}
	}

	@Override
	public void dead() {
		// TODO Auto-generated method stub
		
	}
	
	

}
