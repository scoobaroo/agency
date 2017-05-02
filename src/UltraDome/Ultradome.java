package UltraDome;

import java.util.ArrayList;

import Agency.Dispatcher;

public class Ultradome extends Dispatcher {
	public ArrayList<Weapon> weapons = new ArrayList<>();
	public ArrayList<ShieldSkin> shieldskins = new ArrayList<>();
	public ArrayList<Medicine> medicines = new ArrayList<>();
	public ArrayList<Medicine> getMedicines(){
		return medicines;
	}
	public ArrayList<Weapon> getWeapons() {
		return weapons;
	}
	public ArrayList<ShieldSkin> getShieldSkins() {
		return shieldskins;
	}
	public static void main(String[] args) {
	}


}
