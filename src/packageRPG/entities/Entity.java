package packageRPG.entities;

import java.awt.Graphics;

import packageRPG.Game;

public abstract class Entity {
	
	protected Game game;
	protected float x, y;  //position of the entity on the screen
	protected int width, height; //the size of the entity
	
	
	public Entity(Game game, float x, float y, int width, int height){
		this.game = game;
		this.x = x;
		this.y = y;
		
		this.width = width;
		this.height = height;
		
	}
	
	public abstract void update();
	public abstract void render(Graphics g);

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
