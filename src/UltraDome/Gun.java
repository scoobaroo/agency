package UltraDome;

public class Gun extends Weapon {
	

	public Strike makeStrike() {
		Strike s = new Strike("Shoots an icy bullet with initial power=");
		s.strength = (int) (attacker.getHealth() * 0.25);
		s.type = StrikeTypes.ICE;
		System.out.print(s.strength);
		return s;
	}


}
