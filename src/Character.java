//package cw.characters;

public abstract class Character {
	private int hp;
	private int damage;
	
	public Character(int hp, int damage) {
		this.hp = hp;
		this.damage = damage;
	}
	
	// subtract damage points inflicted on this character
	public void takeDamage(int damage) {
		hp -= damage;
	}
	
	// applies damage to given defender
	// implemented in subclass
	public abstract int attack();
	
	// returns true if alive
	public boolean isAlive() {
		if(hp > 0) {
			return true;
		}
		return false;
	}
	
	public int getDamage() {
		return damage;
	}
	
}
