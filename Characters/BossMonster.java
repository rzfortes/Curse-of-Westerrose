package cw.characters;

import java.util.Random;

public class BossMonster extends Monster {
	
	// default HP
	private static int hp = 20;
	private static int damage = 0;
	private Random rand = new Random();

	public BossMonster() {
		super(hp, damage);
	}
	
	// function for random integer
	public int randInt(int min, int max) {
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}
	
	public int attack() {
		int monsAttack = randInt(1, 3);
		
		String[] monsSkill = {"Scratch", "Bite", "Curse"};
		
		switch(monsAttack) {
		case 1:
			System.out.println("BossMonster used " + monsSkill[0]);
			return damage + 3;
		case 2:
			System.out.println("BossMonster used " + monsSkill[1]);
			return damage + 5;
		case 3:
			System.out.println("BossMonster used " + monsSkill[2]);
			return damage + 10;
		}
		return damage;
	}

}
