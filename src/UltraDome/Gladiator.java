package UltraDome;

import java.util.ArrayList;
import java.util.Random;

import Agency.Agent;

public class Gladiator extends Agent {
	Ultradome ultradome;
	public ArrayList<ShieldSkin> shieldskins = new ArrayList<ShieldSkin>();
	Weapon weapon = null;
	private int health=100;
	Random rand = new Random();
	public Gladiator(int id){
		super(id);
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public void defend(Strike s){
		for (int i = 0; i <shieldskins.size(); i++){
			ShieldSkin ss = shieldskins.get(i);
			s = ss.reduceStrike(s);
		}
		health -= s.strength;
	}
	public void strengthenShield(ShieldSkin ss){
		this.shieldskins.add(ss);
	}
	public void interact(Agent other){
//		Strike incomingStrike = (Strike) this.mailBox.poll();
//		defend(incomingStrike);
		this.weapon.attacker = this;
		Strike s = this.weapon.makeStrike();
		other.mailBox.add(s);
	}
	public void update(){
		while(!dead){
			Agent other = ultradome.getPartner(this);
			int luck = rand.nextInt(30);
			if(0<=luck && luck<10){
				Medicine m = ultradome.getMedicines().remove(0);
				int healthgain = m.amount;
				this.health += healthgain;
				if (this.health>100){
					this.health=100;
				}
			}
			else if(10<=luck && luck<20){
				Weapon w = ultradome.getWeapons().remove(0);
				this.weapon = w;
			}
			else if(20<luck && luck<=30){
				ShieldSkin ss = ultradome.getShieldSkins().remove(0);
				strengthenShield(ss);
			}
		}
	}

	public void done() throws InterruptedException{
		join();
	}
}
