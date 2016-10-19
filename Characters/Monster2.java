package cw.characters;

import java.util.Random;

public abstract class Monster2 extends Monster {
	
	// default HP
	private static int hp = 20;
	private static int damage = 0;
	private Random rand = new Random();

	public Monster2() {
		super(hp, damage);
	}
	
	// function for random integer
	public int randInt(int min, int max) {
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}
	
	public int attack() {
		int monsAttack = randInt(1, 2);
		
		String[] monsSkill = {"Scratch", "Bite"};
		
		switch(monsAttack) {
		case 1:
			System.out.println("Monster2 used " + monsSkill[0]);
			return damage + 3;
		case 2:
			System.out.println("Monster2 used " + monsSkill[1]);
			return damage + 5;
		}
		return damage;
	}
}
