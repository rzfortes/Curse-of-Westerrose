package cw.characters;

public abstract class Monster extends Character {
	
	private static int hp;
	private static int damage;
	
	public Monster(int hp, int damage) {
		super(hp, damage);
	}
	
	@Override
	public int attack() {
		// TODO Auto-generated method stub
		return damage;
	}

}
