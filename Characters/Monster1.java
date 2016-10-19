package cw.characters;

public class Monster1 extends Monster {
	
	// default HP
	private static int hp = 20;
	private static int damage = 0;
	
	public Monster1() {
		super(hp, damage);
	}
	
	// slow ang first monster, dili pa sad siya ka-attack
	// damage is 0;
	public int attack() {
		return damage;
	}
	
}
