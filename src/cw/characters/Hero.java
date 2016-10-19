package cw.characters;

import java.util.Random;

public abstract class Hero extends Character {
	
	// default HP and damage
	private static int hp = 20;
	private static int damage = 5;
	
	// attacks will be randomized first
	private Random rand = new Random();
	
	public Hero() {
		super(hp, damage);
	}
	
	// function for random integer
	public int randInt(int min, int max) {
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}
	
	public int attack() {
		int attackSkill = randInt(1, 2);
		// default damage is 5
		String[] skills = {"Arrow Attack 1", "Arrow Attack 2"};
		
		switch(attackSkill) {
		case 1:
			// Arrow Attack 1
			System.out.println("Hero will use " + skills[0]);
			return (damage + (int)(damage * 0.02));
		case 2:
			// Arrow Attack 2
			System.out.println("Hero will use " + skills[1]);
			return (damage + (int)(damage * 0.05));
		default:
			break;
		}
		return damage;
	}
	
	public void takeDamage(int damage) {
		super.takeDamage(damage);
	}
	
}
