package packageRPG.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.swing.JOptionPane;

import packageRPG.Handler;
import packageRPG.entities.Entity;
import packageRPG.entities.statics.DeadTreeH;
import packageRPG.entities.statics.Fruits;
import packageRPG.entities.statics.RottenFruits;
import packageRPG.gfx.Animation;
import packageRPG.gfx.Assets;
import packageRPG.inventory.Inventory;
import packageRPG.items.Item;

public class Player extends Creature {
	
	// Animations
	private Animation playerDown, playerUp, playerLeft, playerRight, playerStand;
	
	// attack timer
	private long lastAttackTimer, attackCoolDown = 800, attackTimer = attackCoolDown;
	
	// inventory
	private Inventory inventory;

	
	public Player(Handler handler,float x, float y) {
		super(handler,x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT,100);
		
		
		bounds.x = 16;
		bounds.y = 32;     //need to customize this to fit the player/creatures you have
		bounds.width = 32;
		bounds.height = 32;

		// Animations
		playerDown = new Animation(500, Assets.player_down);
		playerUp = new Animation(500, Assets.player_up);
		playerLeft = new Animation(500, Assets.player_left);
		playerRight = new Animation(500, Assets.player_right);
		playerStand = new Animation(500, Assets.player_stand);
		
		inventory = new Inventory(handler);
	}

	@Override
	public void update() {
		// Animations
		playerDown.update();
		playerUp.update();
		playerLeft.update();
		playerRight.update();
		playerStand.update();
		
		getInput();
		move(); //from the creature class
		handler.getGameCamera().centerOnEntity(this);
		
		// attack
		checkAttacks();
		
		// inventory
		inventory.update();
		
		if(handler.getKeyManager().getCount()>=20){
			hunger-=2;
			System.out.println("hunger:" + hunger);
			handler.getKeyManager().setCount(0);
		}
		
		if(health >= 0 && hunger <= 0){
			this.health -= 25;
			System.out.println("health: " + this.health);
			this.hunger = 100;
		} else if(this.health == 0){
			dead();
		}
	}
	
	
	public void checkAttacks() {
		
		attackTimer += System.currentTimeMillis() - lastAttackTimer;
		lastAttackTimer = System.currentTimeMillis();
		if(attackTimer < attackCoolDown) {
			return;
		}
		
		Rectangle cb = getCollisionBounds(0,0);
		Rectangle ar = new Rectangle();
		int arSize = 20;
		ar.width = arSize;
		ar.height = arSize;
		
		if(handler.getKeyManager().aUp) {
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y - arSize;
		}
		else if(handler.getKeyManager().aDown) {
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y + cb.height;
		}
		else if(handler.getKeyManager().aLeft) {
			ar.x = cb.x - arSize;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
		}
		else if(handler.getKeyManager().aRight) {
			ar.x = cb.x + cb.width;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
		} else {
			return;
		}
		
		attackTimer = 10;
		
		for(Entity e : handler.getMap().getEntityManager().getEntities()) {
			if(e.equals(this)) {
				continue;
			}
			if(e.getCollisionBounds(0, 0).intersects(ar)) {
				e.damage(1);
				if(hunger < 100 && e instanceof Fruits){
					hunger += 10;
					if(hunger > 100){
						hunger -= (hunger - 100);
					}
				}else if(hunger > 0 && e instanceof RottenFruits){
					System.out.println("Oh no! A Rotten fruit!");
					hunger -= 8;
					if(hunger < 0){
						hunger = 0;
					}
				}
				else if(e instanceof DeadTreeH && this.inventory.r >=1){
					e.damage(1000);
					inventory.removeItem(Item.rockITem);
					
				}
				
				return;
			}
		}
		
	}
	
	public void dead() {
		System.out.println("Dead");
		JOptionPane.showMessageDialog(null, "You died!", "Game Over!", JOptionPane.PLAIN_MESSAGE);
		handler.getGame().restart();
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
		g.drawImage(getCurrentAnimFrame(), (int)(x -handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()),width,height, null);
		inventory.render(g);
		
		// life bar of the player
		g.setColor(Color.black);
		g.drawString("Health", 5, 285);
		g.setColor(Color.gray);
		g.fillRect(5, 290, 100, 20);
		
		
		g.setColor(Color.MAGENTA);
		g.fillRect(5, 290, this.health, 20);
		
		g.setColor(Color.white);
		g.drawRect(5, 290, 100, 20);
		
		// try lang for hunger bar, edit: success hunger bar
		g.setColor(Color.BLACK);
		g.drawString("Hunger", 5, 325);
		g.setColor(Color.gray);
		g.fillRect(5, 330, 100, 20);
		
		g.setColor(Color.green);
		g.fillRect(5, 330, hunger, 20);
		
		g.setColor(Color.WHITE);
		g.drawRect(5, 330, 100, 20);
			
				
	}
	
	private BufferedImage getCurrentAnimFrame(){
		if(xMove < 0){ //moving left
			return playerLeft.getCurrentFrame();
		}
		else if(xMove >0){ //moving right
			return playerRight.getCurrentFrame();
		}
		else if(yMove < 0){ //moving up
			return playerUp.getCurrentFrame();	
		}
		else if(yMove > 0 ){ //moving down
			return playerDown.getCurrentFrame();
		}
		else{ //standing still
			return playerStand.getCurrentFrame();
		}
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
	

	
}
