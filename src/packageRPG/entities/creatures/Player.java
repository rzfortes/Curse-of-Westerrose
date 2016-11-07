package packageRPG.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;

import packageRPG.Game;
import packageRPG.Handler;
import packageRPG.gfx.Assets;

public class Player extends Creature {

	
	public Player(Handler handler,float x, float y) {
		super(handler,x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		
		bounds.x = 16;
		bounds.y = 32;     //need to customize this to fit the player/creatures you have
		bounds.width = 32;
		bounds.height = 32;

		
	}

	@Override
	public void update() {
		getInput();
		move(); //from the creature class
		handler.getGameCamera().centerOnEntity(this);
		
	}
	
	private void getInput(){ //handling input
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up){
			yMove = -speed;
		}
		if(handler.getKeyManager().down){
			yMove = speed;
		}
		if(handler.getKeyManager().left){
			xMove = -speed;
		}
		if(handler.getKeyManager().right){
			xMove = speed;
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int)(x -handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()),width,height, null);
		
//		g.setColor(Color.red);
//		g.fillRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()),   //need to cast to int cause g.fill only takes int
//		(int)(y + bounds.y - handler.getGameCamera().getyOffset()),
//				bounds.width, bounds.height);   //need to cast to int cause g.fill only takes int
		
		 
	
	}

	
}
