package packageRPG.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;

import packageRPG.Handler;
import packageRPG.gfx.Assets;
import packageRPG.items.Item;

public class TreeMonster extends Creature {

	public TreeMonster(Handler handler, float x, float y) {
		super(handler, x, y, 250, 100, 10);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		// ranMove();
		// move();

	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(Assets.treeMonster, (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);

		// health bar for the monster so that the player will be aware of
		// monster's health
		g.setColor(Color.black);
		g.drawString("Tree Monster's health", 500, 275);

		g.setColor(Color.gray);
		g.fillRect(570, 280, 50, 10);

		g.setColor(Color.black);
		g.fillRect(570, 280, (int) (this.health * 2.5), 10);

		g.setColor(Color.WHITE);
		g.drawRect(570, 280, 50, 10);

		if (health == 0) {
			g.drawImage(Assets.rock, 500, 330, 16, 16, null);
		}

	}

	@Override
	public void dead() {

		System.out.println("treeMonster :" + this.health);
		handler.getMap().getItemManager().addItem(Item.rockITem.createNew((int) x, (int) y));

	}

	// private void ranMove(){ //handling input
	// xMove = 0;
	// yMove = 0;
	//
	// int ctr=0;
	// while(health!=0){
	//
	// if(ctr==1)
	// yMove = -speed;
	//
	// else if(ctr==2)
	// yMove = speed;
	//
	// else if(ctr==3)
	// xMove = -speed;
	//
	// else if(ctr==4)
	// xMove = speed;
	//
	// ctr++;
	//
	// if(ctr>4)
	// ctr=0;
	//
	// }
	// }

}
