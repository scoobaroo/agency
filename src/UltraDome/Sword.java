package UltraDome;

public class Sword extends Weapon {
	public Sword(String name){
		super(name);
	}
	public Strike makeStrike() {
		Strike s = new Strike("Slashes with a poison tipped sword with initial damage=");
		s.strength = (int) (attacker.health * 0.15);
		s.type = StrikeTypes.POISON;
		System.out.println(s.description);
		System.out.print(s.strength);
		return s;
	}
}
