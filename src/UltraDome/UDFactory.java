package UltraDome;

import java.util.Random;

import Agency.AgentFactory;
public class UDFactory implements AgentFactory {
	Random rand = new Random();
	int startid = 0;
	public Gladiator makeAgent() {
		++startid;
		return new Gladiator(startid);
	}
	public Weapon makeWeapon(String type){
		if(type=="sword") return new Sword();
		else if (type=="gun") return new Gun();
		else if (type == "bazooka") return new Bazooka();
		else if (type == "wand") return new Wand();
		else if (type == "flamethrower") return new Flamethrower();
		return null;
	}
	public Medicine makeMedicine(){
		return new Medicine(rand.nextInt(100));
	}
	
	public ShieldSkin makeSS(){
		int r = rand.nextInt(8);
		if (r>0 && r<2){
			ShieldSkin ice = new ShieldSkin();
			ice.type = StrikeTypes.ICE;
			return ice;
		}
		else if (r>=2 && r<4){
			ShieldSkin fire = new ShieldSkin();
			fire.type = StrikeTypes.FIRE;
			return fire;
		}
		else if (r>=4 && r<6){
			ShieldSkin poison = new ShieldSkin();
			poison.type = StrikeTypes.POISON;
			return poison;
		}
		else {
			ShieldSkin magic = new ShieldSkin();
			magic.type = StrikeTypes.MAGIC;
			return magic;
		}
	}
}
