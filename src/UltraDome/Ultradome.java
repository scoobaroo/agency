package UltraDome;

import java.util.ArrayList;
import java.util.Random;

import Agency.Agent;
import Agency.AgentFactory;
import Agency.Dispatcher;

public class Ultradome extends Dispatcher {
	public static ArrayList<Weapon> weapons = new ArrayList<Weapon>();
	public static ArrayList<Medicine> medicines = new ArrayList<Medicine>();
	public static ArrayList<ShieldSkin> shieldskins = new ArrayList<ShieldSkin>();
	static AgentFactory udFactory;
	public static Random rand = new Random();
	public Ultradome getUltradome(){
		return this;
	}
	public static synchronized Medicine getMedicine(){
		System.out.println("Inside getMedicine() of ultradome");
		if(medicines.size()==1){
			return medicines.remove(0);
		}
		else if(medicines.size()>1){
			int index = rand.nextInt(medicines.size()-1);
			Medicine m = medicines.remove(index);
			return m;
		} else return null;
	}
	public static synchronized Weapon getWeapon(){
		System.out.println("Inside getWeapon() of ultradome");
		if(weapons.size()==1){
			return weapons.remove(0);
		}
		else if(weapons.size()>1){
			int index = rand.nextInt(weapons.size()-1);
			Weapon w = weapons.remove(index);
			return w;
		} else return null;
	}
	public static synchronized ShieldSkin getShieldSkin(){
		System.out.println("Inside getShieldSkin() of ultradome");
		if(shieldskins.size()==1){
			return shieldskins.remove(0);
		}
		else if(shieldskins.size()>1){
			int index = rand.nextInt(shieldskins.size()-1);
			ShieldSkin ss = shieldskins.remove(index);
			return ss;
		} else return null;
	}
	public Ultradome(){
		System.out.println("Making wepoans, medicine, and shieldskins for Ultradome");
		UDFactory uf = new UDFactory();
		Weapon sword = uf.makeWeapon("sword");
		Weapon gun = uf.makeWeapon("gun");
		Weapon bazooka = uf.makeWeapon("bazooka");
		Weapon wand = uf.makeWeapon("wand");
		Weapon flamethrower = uf.makeWeapon("flamethrower");
		Weapon sword2 = uf.makeWeapon("sword");
		Weapon gun2 = uf.makeWeapon("gun");
		Weapon bazooka2 = uf.makeWeapon("bazooka");
		Weapon wand2 = uf.makeWeapon("wand");
		Weapon flamethrower2 = uf.makeWeapon("flamethrower");
		weapons.add(sword);
		weapons.add(gun);
		weapons.add(bazooka);
		weapons.add(wand);
		weapons.add(flamethrower);
		weapons.add(sword2);
		weapons.add(gun2);
		weapons.add(bazooka2);
		weapons.add(wand2);
		weapons.add(flamethrower2);
		for(int i=0; i<20; i++){
			Medicine m = uf.makeMedicine();
			medicines.add(m);
			ShieldSkin ss = uf.makeSS();
			shieldskins.add(ss);
		}
	}

	public static Gladiator getWinner() {
		Gladiator winner = (Gladiator) agents.get(0);
		for(Agent a: agents) {
			Gladiator g= (Gladiator) a;
			if (g.health > winner.health) {
				winner = g;
			}
		}
		return winner;
	}

	public static void main(String[] args) throws InterruptedException{
		System.out.println("Inside ULTRADOME!");
		Ultradome ud = new Ultradome();
		ud.multiThread = false;
		UDFactory uf = new UDFactory();
		Gladiator g1 = uf.makeAgent();
		Gladiator g2 = uf.makeAgent();
		Gladiator g3 = uf.makeAgent();
		Gladiator g4 = uf.makeAgent();
		Gladiator g5 = uf.makeAgent();
		Gladiator g6 = uf.makeAgent();
		Ultradome.agents.add(g1);
		Ultradome.agents.add(g2);
		Ultradome.agents.add(g3);
		Ultradome.agents.add(g4);
		Ultradome.agents.add(g5);
		Ultradome.agents.add(g6);
		ud.start();
		Gladiator winner = Ultradome.getWinner();
		System.out.println("The ultimate warrior is Gladiator." + winner.id);
	}
}
