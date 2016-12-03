package packageRPG.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import packageRPG.Handler;
import packageRPG.entities.Entity;
import packageRPG.entities.statics.Bed;
import packageRPG.entities.statics.DeadTreeH;
import packageRPG.entities.statics.Fruits;
import packageRPG.entities.statics.QRock1;
import packageRPG.entities.statics.QRock2;
import packageRPG.entities.statics.QRock3;
import packageRPG.entities.statics.RottenFruits;
import packageRPG.entities.statics.Well;
import packageRPG.entities.statics.flatRock;
import packageRPG.entities.statics.flatRock2;
import packageRPG.entities.statics.flatRock3;
import packageRPG.entities.statics.flatRock4;
import packageRPG.entities.statics.flatRock5;
import packageRPG.entities.statics.flatRock6;
import packageRPG.entities.statics.hwall;
import packageRPG.entities.statics.rockPcs;
import packageRPG.gfx.Animation;
import packageRPG.gfx.Assets;
import packageRPG.inventory.Inventory;
import packageRPG.items.Item;
import packageRPG.sfx.Sound;
import packageRPG.state.GameStateManager;

public class Player extends Creature {

	// Animations
	private Animation playerDown, playerUp, playerLeft, playerRight, playerStand;

	// attack timer
	private long lastAttackTimer, attackCoolDown = 800, attackTimer = attackCoolDown;

	// inventory
	private Inventory inventory;

	// flags for texts
	public int flagM1 = 1, flagM2 = 1; // man text
	public int flagB = 1; // bed
	public int flagW = 1, flagRP1 = 1, flagRP2 = 1; // making fire text
	public int flagFR = 1, flagFR2 = 1, flagFR3 = 1, flagFR4 = 1, flagFR5 = 1, flagFR6 = 1; // flat
																							// rock
																							// text

	public int flagEl=1, flagFPig =1, flagFPlant=1; //forest entities
	public int flagWall = 1; // wall
	public int flagCheck = 1, flagCheck2 = 1, flagCheck3 = 1, flagClear = 1;
	public int flagQ1 = 1, flagQ2 = 1, flagQ3 = 1;
	public int flagD=1;

	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT, 100);

		bounds.x = 16;
		bounds.y = 16; // need to customize this to fit the player/creatures you
						// have
		bounds.width = 16;
		bounds.height = 16;

		// Animations
		playerDown = new Animation(200, Assets.player_down);
		playerUp = new Animation(200, Assets.player_up);
		playerLeft = new Animation(200, Assets.player_left);
		playerRight = new Animation(200, Assets.player_right);
		playerStand = new Animation(200, Assets.player_stand);

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
		move(); // from the creature class
		handler.getGameCamera().centerOnEntity(this);

		// attack
		checkAttacks();

		// inventory
		inventory.update();

		if (handler.getKeyManager().getCount() >= 20) {
			hunger -= 5;
			System.out.println("hunger:" + hunger);
			handler.getKeyManager().setCount(1);
		}
		

		if (health >= 0 && hunger <= 0) {
			this.health -= 25;
			System.out.println("health: " + this.health);
			this.hunger = 100;
		} else if (this.health <= 0) {
			dead();
		}

		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_C)) {
			clearText();
		}
		

	}

	public void checkAttacks() {

		attackTimer += System.currentTimeMillis() - lastAttackTimer;
		lastAttackTimer = System.currentTimeMillis();
		if (attackTimer < attackCoolDown) {
			return;
		}

		Rectangle cb = getCollisionBounds(0, 0);
		Rectangle ar = new Rectangle();
		int arSize = 20;
		ar.width = arSize;
		ar.height = arSize;

		if (handler.getKeyManager().aUp) {
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y - arSize;
		} else if (handler.getKeyManager().aDown) {
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y + cb.height;
		} else if (handler.getKeyManager().aLeft) {
			ar.x = cb.x - arSize;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
		} else if (handler.getKeyManager().aRight) {
			ar.x = cb.x + cb.width;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
		} else {
			return;
		}

		attackTimer = 10;

		for (Entity e : handler.getMap().getEntityManager().getEntities()) {
			if (e.equals(this)) {
				continue;
			}
			if (e.getCollisionBounds(0, 0).intersects(ar)) {
				e.damage(1);
				if (hunger < 100 && e instanceof Fruits) {
					hunger += 10;
					if (hunger > 100) {
						hunger -= (hunger - 100);
					}
				} else if (hunger > 0 && e instanceof RottenFruits) {
					System.out.println("Oh no! A Rotten fruit!");
					hunger -= 8;
					if (hunger < 0) {
						hunger = 0;
					}
				} else if (e instanceof DeadTreeH) {
					if (this.inventory.r >= 1) {
						inventory.removeItem(Item.rockITem);
						e.damage(1000);
						
					}
						
										
				}  else if (e instanceof Monster) {
					System.out.println("spider collision");
					health = health - 1;
				} else if (e instanceof Man) {
					clearText();
					flagM1 = 0;
					
					System.out.println("Man collision");
					if (this.inventory.w >= 10) {

						int j = 0;
						while (j < 10) {
							inventory.removeItem(Item.woodITem);
							j++;
							System.out.println(j);
						}
						
						e.damage(1000);
						flagM1 = 1;

						break;
						
					} else {
						System.out.println("need more wood");

					}

				} else if (e instanceof Man2) {
					clearText();
					flagM2 = 0;
					System.out.println("Man collision");
					if (this.inventory.m == 9) {

						int j = 0;
						while (j < 9) {
							inventory.removeItem(Item.mushroom);
							j++;
						}
						e.damage(1000);
						flagM2 = 1;

						health += 10;
						if (health > 100)
							health = 100;

					} else {
						System.out.println("need more mushroom");

					}
				} else if (e instanceof Well) {
					clearText();
					flagW = 0;
					flagQ1 = 1;
					flagQ2 = 1;
					flagQ3 = 1;
					

					System.out.println("Well Collision");

					hunger += 5;
					if (hunger > 100) {
						hunger -= (hunger - 100);
					}

				} else if (e instanceof rockPcs) {
					System.out.println("rockpcs collision");
					clearText();
					flagQ1 = 1;
					flagQ2 = 1;
					flagQ3 = 1;
					flagRP1 = 0;
					flagM2 = 1;
					if (this.inventory.w >= 2) {
						flagRP1 = 1;
						flagRP2 = 0;
						int j = 0;
						while (j < 2) {
							inventory.removeItem(Item.woodITem);
							j++;
						}

						health += 5;
						if (health > 100)
							health = 100;

					}
				} else if (e instanceof QRock1) {
					clearText();
					flagQ1 = 0;
					flagQ2 = 1;
					flagQ3 = 1;

				} else if (e instanceof QRock2) {
					clearText();
					flagQ2 = 0;
					flagQ1 = 1;
					flagQ3 = 1;

				} else if (e instanceof QRock3) {
					clearText();
					flagQ3 = 0;
					flagQ1 = 1;
					flagQ2 = 1;
	

				} else if (e instanceof flatRock) {
					clearText();
					flagFR = 0;
					flagQ1 = 1;
					flagQ2 = 1;
					flagQ3 = 1;

				} else if (e instanceof flatRock2) {
					clearText();
					flagFR2 = 0;

					if (flagQ1 == 0) {
						flagQ1 = 1;
						System.out.println("q1 correct");
						flagCheck = 0;
					} else {
						System.out.println("q1 incorrect");
						flagQ1 = 1;
						flagQ2 = 1;
						flagQ3 = 1;
						flagCheck = 1;
					}
				} else if (e instanceof flatRock3) {
					clearText();
					flagFR3 = 0;

					if (flagQ3 == 0) {
						flagQ3 = 1;
						flagCheck3 = 0;
						System.out.println("q3 correct");
						if (flagCheck2 == 0 && flagCheck == 0 && flagCheck3 == 0) {
							flagClear = 0;
							hunger += 20;
						}
					} else {
						flagQ3 = 1;
						flagQ1 = 1;
						flagQ2 = 1;
						flagCheck3 = 1;
						flagClear = 1;
						System.out.println("q3 incorrect");

					}
				} else if (e instanceof flatRock4) {
					clearText();
					flagFR4 = 0;
					flagQ1 = 1;
					flagQ2 = 1;
					flagQ3 = 1;

				} else if (e instanceof flatRock5) {
					clearText();
					flagFR5 = 0;

					if (flagQ2 == 0) {
						flagQ2 = 1;
						System.out.println("q2 correct");
						flagCheck2 = 0;
					} else {
						flagQ1 = 1;
						flagQ2 = 1;
						flagQ3 = 1;
						System.out.println("q2 incorrect");
						flagCheck2 = 1;
					}

				} else if (e instanceof flatRock6) {
					clearText();
					flagFR6 = 0;
					flagQ1 = 1;
					flagQ2 = 1;
					flagQ3 = 1;
				}

				else if (e instanceof hwall) { // wall blocking rocky map
					clearText();
					flagWall = 0;
					System.out.println("wall coll");

					if (this.inventory.r >= 1) {
						e.damage(1000);
						int j=0;
						if(j<1)
						inventory.removeItem(Item.rockITem);
					}
				} 
				else if(e instanceof ForestSpirit){
					clearText();
					flagEl =0;
					System.out.println("elder collision");
					
					if(flagFPig ==0 && flagFPlant == 0){
						e.damage(1000);
						
						hunger+=50;
						if(hunger>100)
							hunger=100;
					}
					
				}
				
				else if (e instanceof Bed) {
					clearText();
					System.out.println("Bed collision");
					flagB = 0;

					health += 10;
					if (health > 100)
						health = 100;
					hunger += 10;
					if (hunger > 100)
						hunger = 100;
				}

				return;
			}
		}

	}

	public void dead() {
		Sound.BACK.stop();
		Sound.GAMEOVER.play();
		System.out.println("Dead");
		handler.getGame().getGameStateManager().setState(GameStateManager.GAMEOVER);
	}

	private void getInput() { // handling input
		xMove = 0;
		yMove = 0;

		if (handler.getKeyManager().up) {
			yMove = -speed;
		}
		if (handler.getKeyManager().down) {
			yMove = speed;
		}
		if (handler.getKeyManager().left) {
			xMove = -speed;
		}
		if (handler.getKeyManager().right) {
			xMove = speed;
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimFrame(), (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
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

	private BufferedImage getCurrentAnimFrame() {
		if (xMove < 0) { // moving left
			return playerLeft.getCurrentFrame();
		} else if (xMove > 0) { // moving right
			return playerRight.getCurrentFrame();
		} else if (yMove < 0) { // moving up
			return playerUp.getCurrentFrame();
		} else if (yMove > 0) { // moving down
			return playerDown.getCurrentFrame();
		} else { // standing still
			return playerStand.getCurrentFrame();
		}
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public void clearText() {
		flagM1 = 1;
		flagM2 = 1;
		flagW = 1;
		flagRP1 = 1;
		flagRP2 = 1;
		flagFR = 1;
		flagFR2 = 1;
		flagFR3 = 1;
		flagFR4 = 1;
		flagFR5 = 1;
		flagFR6 = 1;
		flagWall = 1;
		flagB = 1;
		flagEl = 1;
		//flagQ1=1;
		//flagQ2=1;
		//flagQ3=1;
	}

}
