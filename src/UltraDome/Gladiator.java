package UltraDome;

import java.util.Random;

import Agency.Agent;
import Agency.Message;
import java.util.LinkedList;

@SuppressWarnings("rawtypes")
public class Gladiator extends Agent {

	public Shield shield;
	public Weapon weapon;
	public int health=100;
	Random rand = new Random();
	public Gladiator(int id){
		super(id);
		this.shield = new BasicShield();
		this.weapon = new Sword("Sword");
                mailBox = new LinkedList<Message>();
	}
	public void decHealth(Strike s){
		health -= s.strength;
		if(this.health<=0){
                    System.out.println("Gladiator."+this.id+ " has died");
                    die();
		}
	}
	public void defend(Strike s){
		System.out.println("Inside defend of Gladiator."+this.id);
		s = shield.reduceStrike(s);
		System.out.println("Gladiator."+this.id+"'s shield reduced damage to " +s.strength);
		decHealth(s);
	}
	public void attack(Gladiator victim) {
            if (0 < this.health && 0 < victim.health) {
                weapon.attacker = this;
                Strike blow = weapon.makeStrike();
                System.out.println("Gladiator." +this.id + " is attacking Gladiator." + victim.id +" with a "+this.weapon.name+
                                " for " +blow.strength +" damage");
                Ultradome.send(victim, blow);
                this.health -=1;
            }
	}
        public void interact(){
            Gladiator g = (Gladiator) Ultradome.getPartner(this);
            attack(g);
	}
	public void strengthenShield(ShieldSkin ss){
		ss.delegate = shield;
		shield = ss;
	}
	public synchronized void update(){
		System.out.println("Inside update function of Gladiator." +this.id);
		if(!mailBox.isEmpty()){
                    Strike incomingStrike = (Strike) this.mailBox.poll();
                    defend(incomingStrike);
		}
		int luck = rand.nextInt(60);
		if(0<=luck && luck<10){
                    if(Ultradome.medicines.size()>0){
                        Medicine m = Ultradome.getMedicine();
                        if (m!=null){
                            int healthgain = m.amount;
                            if(health<100){
                                System.out.println("Gladiator."+this.id+" drinks some medicine and heals himself from "+health);
                                health += healthgain;
                                System.out.println(" to "+health);
                            }
                            if (health>100){
                                health=100;
                                System.out.println("Gladiator." + this.id +"'s health is now: " + this.health);
                            }
                        }
                    }
		}
		else if(10<=luck && luck<20){
                    if(Ultradome.weapons.size()>0){
                        Weapon w = Ultradome.getWeapon();
                        if(w!=null){
                            weapon = w;
                            weapon.attacker = this;
                            System.out.println("Gladiator." + this.id +" just picked up a " + w.name);
                        }
                    }
		}
		else if(20<luck && luck<=30){
                    if(Ultradome.shieldskins.size()>0){
                        ShieldSkin ss = Ultradome.getShieldSkin();
                        if(ss!=null){
                            System.out.println("Gladiator." + this.id +" just picked up a shieldskin of type " + ss.type);
                            strengthenShield(ss);
                        }
                    }
		}
		else {
                    System.out.println("Gladiator."+this.id +"is looking for a partner");
                    if(Ultradome.agents.size()>1){
                        System.out.println("Calling Ultradomes getPartner()");
                        Gladiator p = (Gladiator) Ultradome.getPartner(this);
                        partner = p;
                        attack((Gladiator) partner);
                        partner.partner = null;
                        partner = null;
                    } else {
                        Ultradome.getWinner();
                        System.out.println("Ultimate warrior is Gladiator."+this.id);
                    }
		}
	}
	public void done() throws InterruptedException{
		join();
	}

}
