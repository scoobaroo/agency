package UltraDome;

public class Flamethrower extends Weapon {
	public Flamethrower(String name){
		super(name);
	}
	public Strike makeStrike() {
		Strike s = new Strike("Shoots a giant flame from his flamethrower initial strength=");
		s.strength = (int) (attacker.health * 0.35); 
		s.type = StrikeTypes.FIRE;
		System.out.println(s.description);
		System.out.println(s.strength);
		return s;
	}
}
