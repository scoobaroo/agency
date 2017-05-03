package UltraDome;

import java.util.ArrayList;

import Agency.Agent;
import Agency.Dispatcher;

public class Ultradome extends Dispatcher {
	public ArrayList<Weapon> weapons = new ArrayList<Weapon>();
	public ArrayList<ShieldSkin> shieldskins = new ArrayList<ShieldSkin>();
	public ArrayList<Medicine> medicines = new ArrayList<Medicine>();
	public ArrayList<Medicine> getMedicines(){
		return medicines;
	}
	public ArrayList<Weapon> getWeapons() {
		return weapons;
	}
	public ArrayList<ShieldSkin> getShieldSkins() {
		return shieldskins;
	}
	public static boolean stillAlive(){
		for (Agent g : agents){
			if(!g.dead) return true;
		}
		return false;
	}
	public static void main(String[] args) {
		System.out.println("Inside ULTRADOME");
		Ultradome ud = new Ultradome();
		ud.multiThread = false;
		UDFactory uf = new UDFactory();
		Gladiator g1 = uf.makeAgent();
		g1.shieldskins.add(new BasicShield());
		g1.weapon = uf.makeWeapon("sword");
		Gladiator g2 = uf.makeAgent();
		g2.shieldskins.add(new BasicShield());
		g2.weapon = uf.makeWeapon("sword");
		Gladiator g3 = uf.makeAgent();
		g3.shieldskins.add(new BasicShield());
		g3.weapon = uf.makeWeapon("sword");
		Dispatcher.agents.add(g1);
		Dispatcher.agents.add(g2);
		Dispatcher.agents.add(g3);
		Weapon sword = uf.makeWeapon("sword");
		Weapon gun = uf.makeWeapon("gun");
		Weapon bazooka = uf.makeWeapon("bazooka");
		Weapon wand = uf.makeWeapon("wand");
		Weapon flamethrower = uf.makeWeapon("flamethrower");
		ud.weapons.add(sword);
		ud.weapons.add(gun);
		ud.weapons.add(bazooka);
		ud.weapons.add(wand);
		ud.weapons.add(flamethrower);
		for(int i=0; i<20; i++){
			Medicine m = uf.makeMedicine();
			ud.medicines.add(m);
			ShieldSkin ss = uf.makeSS();
			ud.shieldskins.add(ss);
		}
		while (stillAlive()){
			Agent a1 = Dispatcher.agents.get(0);
			Agent a2 = Dispatcher.agents.get(1);
			Agent a3 = Dispatcher.agents.get(2);
			a1.interact(a2);
			a2.interact(a3);
			a3.interact(a1);
		}
	}
}
