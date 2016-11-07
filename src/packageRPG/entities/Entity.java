package packageRPG.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import packageRPG.Game;
import packageRPG.Handler;

public abstract class Entity {
	
	protected Handler handler;
	protected float x, y;  //position of the entity on the screen
	protected int width, height; //the size of the entity
	protected Rectangle bounds;
	
	
	public Entity(Handler handler, float x, float y, int width, int height){
		this.handler = handler;
		this.x = x;
		this.y = y;
		
		this.width = width;
		this.height = height;
		
		bounds = new Rectangle(0,0,width , height); //upper left corner of the entities image
		//width and height of the actual entity;
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
