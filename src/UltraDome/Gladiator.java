package UltraDome;

import java.util.Random;

import Agency.Agent;
import Agency.Dispatcher;

public class Gladiator extends Agent {
	Ultradome ultradome;
	public Shield shield;
	public Weapon weapon;
	public int health=100;
	Random rand = new Random();
	public Gladiator(int id){
		super(id);
		this.shield = new BasicShield();
		this.weapon = new Sword("Sword");
	}
	public void decHealth(Strike s) {
		health -= s.strength;
	}
	public void defend(Strike s){
		s = shield.reduceStrike(s);
		decHealth(s);
	}
	public void attack(Gladiator victim) {
		if (0 < health && 0 < victim.health) {
			this.weapon.attacker = this;
			System.out.println("Gladiator" +this.id + " is attacking Gladiator" + victim.id);
			Strike blow = this.weapon.makeStrike();
			victim.mailBox.add(blow);
			this.health -=1;
		}
	}
	public void strengthenShield(ShieldSkin ss){
		ss.delegate = this.shield;
		this.shield = ss;
	}
	public void update(){
		Strike incomingStrike = (Strike) this.mailBox.poll();
		defend(incomingStrike);
		while(!dead){
			int luck = rand.nextInt(60);
			if(0<=luck && luck<10){
				Medicine m = ultradome.getMedicine();
				int healthgain = m.amount;
				this.health += healthgain;
				System.out.println("Gladiator."+this.id+"drinks some medicine and heals himself for "+healthgain);
				if (this.health>100){
					this.health=100;
				}
				System.out.println("Gladiator." + this.id +"'s health is now: " + this.health);
			}
			else if(10<=luck && luck<20){
				Weapon w = ultradome.getWeapon();
				this.weapon = w;
				System.out.println("Gladiator." + this.id +"just picked up a" + w.name);
			}
			else if(20<luck && luck<=30){
				ShieldSkin ss = ultradome.getShieldSkin();
				strengthenShield(ss);
			}
			else {
				Gladiator p = (Gladiator) dispatcher.getPartner(this);
				partner = p;
				Strike s = this.weapon.makeStrike();
				attack(p);
				partner = null;
			}
		}
	}

	public void done() throws InterruptedException{
		join();
	}
}
