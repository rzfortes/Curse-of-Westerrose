package packageRPG.entities.creatures;

import java.awt.Graphics;

import packageRPG.Game;
import packageRPG.gfx.Assets;

public class Player extends Creature {

	
	public Player(Game game,float x, float y) {
		super(game,x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
	}

	@Override
	public void update() {
		getInput();
		move(); //from the creature class
		game.getGameCamera().centerOnEntity(this);
		
	}
	
	private void getInput(){ //handling input
		xMove = 0;
		yMove = 0;
		
		if(game.getKeyManager().up){
			yMove = -speed;
		}
		if(game.getKeyManager().down){
			yMove = speed;
		}
		if(game.getKeyManager().left){
			xMove = -speed;
		}
		if(game.getKeyManager().right){
			xMove = speed;
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int)(x -game.getGameCamera().getxOffset()), (int)(y - game.getGameCamera().getyOffset()),width,height, null);
		
		
	}

	
}
