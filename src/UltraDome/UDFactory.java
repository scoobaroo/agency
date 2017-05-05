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
		if(type=="sword") return new Sword("Sword");
		else if (type=="gun") return new Gun("Gun");
		else if (type == "bazooka") return new Bazooka("Bazooka");
		else if (type == "wand") return new Wand("Wand");
		else if (type == "flamethrower") return new Flamethrower("Flamethrower");
		return null;
	}
	public Medicine makeMedicine(){
		return new Medicine(rand.nextInt(100));
	}
	
	public ShieldSkin makeSS(){
		int r = rand.nextInt(8);
		if (r>0 && r<2){
			ShieldSkin ice = new IceSkin();
			return ice;
		}
		else if (r>=2 && r<4){
			ShieldSkin fire = new FireSkin();
			return fire;
		}
		else if (r>=4 && r<6){
			ShieldSkin poison = new PoisonSkin();
			return poison;
		}
		else {
			ShieldSkin magic = new MagicSkin();
			return magic;
		}
	}
}
