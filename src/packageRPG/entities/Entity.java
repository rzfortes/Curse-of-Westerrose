package packageRPG.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import packageRPG.Handler;

public abstract class Entity {
	
	protected Handler handler;
	protected float x, y;  //position of the entity on the screen
	protected int width, height; //the size of the entity
	protected Rectangle bounds;
	protected boolean active = true;
	protected int health;

	public static final int DEFAULT_HEALTH = 3;
	
	public Entity(Handler handler, float x, float y, int width, int height, int health){
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.health = health;
		this.width = width;
		this.height = height;
		
		bounds = new Rectangle(0, 0, width , height); //upper left corner of the entities image
		//width and height of the actual entity;
	}
	
	public abstract void update();
	public abstract void render(Graphics g);
	public abstract void dead();
	
	public void damage(int amount) {
		health -= amount;
		if(health <= 0) {
			active = false;
			dead();
		}
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public boolean checkEntityCollisions(float xOffset, float yOffset) {
		for(Entity e : handler.getMap().getEntityManager().getEntities()) {
			if(e.equals(this)){
				continue;
			}
			if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))) {
				return true;
			}
		}
		
		return false;
	}
	
	public Rectangle getCollisionBounds(float xOffset, float yOffset) {
		return new Rectangle((int)(x + bounds.x + xOffset), (int)(y + bounds.y + yOffset), bounds.width, bounds.height);
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
}
