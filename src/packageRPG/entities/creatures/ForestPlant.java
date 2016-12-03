package packageRPG.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import packageRPG.Handler;
import packageRPG.entities.Entity;
import packageRPG.gfx.Assets;

public class ForestPlant extends Creature {

	private static Random rand = new Random();

	private long lastAttackTimer, attackCoolDown = 800, attackTimer = attackCoolDown;

	public ForestPlant(Handler handler, float x, float y, int i) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH * 2 + i, Creature.DEFAULT_CREATURE_HEIGHT * 2 + i, 10);

	}

	@Override
	public void update() {

		attackTimer += System.currentTimeMillis() - lastAttackTimer;
		lastAttackTimer = System.currentTimeMillis();
		if (attackTimer < attackCoolDown) {
			return;
		}

		moveRan();
		move();

		Rectangle ar = new Rectangle();
		int arSize = 20;
		ar.width = arSize;
		ar.height = arSize;

		attackTimer = 10;

		for (Entity e : handler.getMap().getEntityManager().getEntities()) {
			if (e.equals(this)) {
				continue;
			}
			if (e.getCollisionBounds(0, 0).intersects(ar)) {
				e.damage(1);
			}
			return;
		}
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(Assets.forest_plant, (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		// health bar for the monster so that the player will be aware of
		// monster's health
		g.setColor(Color.black);
		g.drawString("Fire Plant's health", 483, 45);

		g.setColor(Color.gray);
		g.fillRect(570, 50, 50, 10);

		g.setColor(Color.red);
		g.fillRect(570, 50, this.health * 5, 10);

		g.setColor(Color.WHITE);
		g.drawRect(570, 50, 50, 10);


	}

	@Override
	public void dead() {

		System.out.println("monster :" + this.health);
		handler.getMap().getEntityManager().getPlayer().flagFPlant =0;


	}

	public void moveRan() {
		xMove = 0;
		yMove = 0;

		int rnd = randInt();

		// System.out.println(rnd);

		if (rnd == 1) {
			yMove = -speed;

		}
		if (rnd == 2) {
			yMove = speed;
		}
		if (rnd == 3) {
			speed = speed + 2;
			xMove = -speed;
		}
		if (rnd == 4) {
			speed = speed + 2;
			xMove = speed;
		}

	}

	public static int randInt() {
		return rand.nextInt(4 - 0) + 0;
	}

}
