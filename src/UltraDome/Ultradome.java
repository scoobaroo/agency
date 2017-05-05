package UltraDome;

import java.util.ArrayList;
import java.util.Random;

import Agency.Agent;
import Agency.AgentFactory;
import Agency.Dispatcher;

public class Ultradome extends Dispatcher {
	public ArrayList<Weapon> weapons = new ArrayList<Weapon>();
	public ArrayList<Medicine> medicines = new ArrayList<Medicine>();
	public ArrayList<ShieldSkin> shieldskins = new ArrayList<ShieldSkin>();
	static AgentFactory udFactory;
	public Random rand;
	public synchronized Medicine getMedicine(){
		int index = rand.nextInt(medicines.size()-1)
		return medicines.remove(index);
	}
	public synchronized Weapon getWeapon(){
		int index = rand.nextInt(weapons.size()-1)
		return weapons.remove(index);
	}
	public synchronized ShieldSkin getShieldSkin(){
		int index = rand.nextInt(shieldskins.size()-1)
		return shieldskins.remove(index);
	}
	public Ultradome(){
		UDFactory uf = new UDFactory();
		Weapon sword = uf.makeWeapon("sword");
		Weapon gun = uf.makeWeapon("gun");
		Weapon bazooka = uf.makeWeapon("bazooka");
		Weapon wand = uf.makeWeapon("wand");
		Weapon flamethrower = uf.makeWeapon("flamethrower");
		weapons.add(sword);
		weapons.add(gun);
		weapons.add(bazooka);
		weapons.add(wand);
		weapons.add(flamethrower);
		for(int i=0; i<20; i++){
			Medicine m = uf.makeMedicine();
			medicines.add(m);
			ShieldSkin ss = uf.makeSS();
			shieldskins.add(ss);
		}
	}
	public boolean stillAlive(){
		for (Agent g : agents){
			if(!g.dead) return true;
		}
		return false;
	}
	
	public void start() {
		for(Agent a1: agents) {
			Gladiator g1 = (Gladiator) a1;
			if (g1.health > 0) {
				for(Agent a2: agents) {
					Gladiator g2 = (Gladiator) a2;
					if (g1 != g2 && g2.health > 0) {
						g1.attack(g2);
						if (g1.health <= 0) {
							System.out.println("Gladiator."+g1.id + " has been killed!");
						}
						if (g2.health <= 0) {
							System.out.println("Gladiator."+g2.id + " has been killed!");
						}
					}
				}
			}
		}
	}

	public Gladiator getWinner() {
		Gladiator winner = (Gladiator) agents.get(0);
		for(Agent a: agents) {
			Gladiator g= (Gladiator) a;
			if (g.health > winner.health) {
				winner = g;
			}
		}
		return winner;
	}

	public static void main(String[] args) {
		System.out.println("Inside ULTRADOME");
		Ultradome ud = new Ultradome();
		ud.multiThread = false;
		UDFactory uf = new UDFactory();
		Gladiator g1 = uf.makeAgent();
		Gladiator g2 = uf.makeAgent();
		Gladiator g3 = uf.makeAgent();
		ud.agents.add(g1);
		ud.agents.add(g2);
		ud.agents.add(g3);
		ud.start();
		Gladiator winner = ud.getWinner();
		System.out.println("The ultimate warrior is " + winner);
	}
}
