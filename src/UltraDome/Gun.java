package UltraDome;

public class Gun extends Weapon {
	public Gun(String name){
		super(name);
	}
	public Strike makeStrike() {
		Strike s = new Strike("Shoots an icy bullet with initial strength=");
		s.strength = (int) (attacker.health * 0.25);
		s.type = StrikeTypes.ICE;
		System.out.println(s.description);
		System.out.print(s.strength);
		return s;
	}
}
