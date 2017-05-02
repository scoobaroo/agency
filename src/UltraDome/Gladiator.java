package UltraDome;

import java.util.Random;

import Agency.Agent;

public class Gladiator extends Agent {
	Ultradome ultradome;
	private int health;
	Random rand = new Random();
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public void defend(Strike s){
		
	}
	public void strengthenShield(ShieldSkin ss){
		
	}
	public void interact(Agent other){
		
	}
	public void update(){
		int luck = rand.nextInt(30);
		if(0<=luck && luck<10){
			Medicine m = ultradome.getMedicines().remove(luck);
		}
		else if(10<=luck && luck<20){
			Weapon w = ultradome.getWeapons().remove(luck);
		}
		else if(20<luck && luck<=30){
			ShieldSkin ss = ultradome.getShieldSkins().remove(luck);
		}
	}
}
