package packageRPG.entities.creatures;

import packageRPG.Handler;
import packageRPG.entities.Entity;
import packageRPG.tiles.Tile;


public abstract class Creature extends Entity{
	
	//private BufferedImage healthBackground, healthForeground, healthBorder;
	
	public static final float DEFAULT_SPEED = 3.0f;
	public static int DEFAULT_CREATURE_WIDTH = 64;
	public static int DEFAULT_CREATURE_HEIGHT = 64;
	public static int DEFAULT_HUNGERBAR = 100;
	
	protected float speed;
	protected float xMove, yMove;
	protected int hunger;
	
	
	public Creature(Handler handler,float x, float y, int width, int height, int life) {
		super(handler,x, y,width, height, life);
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
		hunger = DEFAULT_HUNGERBAR;
	}
	
	public void move(){
		if(!checkEntityCollisions(xMove, 0f)) {
			moveX();
		}
		if(!checkEntityCollisions(0f, yMove)) {
			moveY();
		}
	}
	
	public void moveX(){
		
		if(xMove > 0){ // moving right
			
			int tx = (int)(x+ xMove + bounds.x + bounds.width)/Tile.TILEWIDTH; // get x coordinate of the tile
			
			if(!collisionWithTile(tx, (int)(y+bounds.y)/ Tile.TILEHEIGHT) && 
					!collisionWithTile(tx, (int)(y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
				x+= xMove;
			}else{
				x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1;
			}
		}
		else if(xMove<0){// moving left
			int tx = (int)(x+ xMove + bounds.x)/Tile.TILEWIDTH; // get x coordinate of the tile
			
			if(!collisionWithTile(tx, (int)(y+bounds.y)/ Tile.TILEHEIGHT) && 
					!collisionWithTile(tx, (int)(y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
				x+= xMove;
			}else{
				x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
			}
		}
		
	}
	
	public void moveY(){
		if(yMove < 0){ //up
			 int ty = (int)(y + yMove + bounds.y)/ Tile.TILEHEIGHT;
			 
			if(!collisionWithTile((int)(x + bounds.x) / Tile.TILEWIDTH, ty) && 
					!collisionWithTile((int)(x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
					y += yMove;
			}else{
				y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
			
			}
		}
		else if(yMove > 0 ){ //down
			 int ty = (int)(y + yMove + bounds.y + bounds.height)/ Tile.TILEHEIGHT;
			 
				if(!collisionWithTile((int)(x + bounds.x) / Tile.TILEWIDTH, ty) && 
						!collisionWithTile((int)(x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
						y += yMove;
				}else{
					y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height-1;
				}
		}
	}
	
	protected boolean collisionWithTile(int x, int y){
		return handler.getMap().getTile(x, y).isSolid();
	}

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	
	
	
	
	
	
}
