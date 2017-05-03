package UltraDome;

public class Sword extends Weapon {

	public Strike makeStrike() {
		Strike s = new Strike("Slashes with a poison tipped sword with initial damage");
		s.strength = (int) (attacker.getHealth() * 0.15);
		s.type = StrikeTypes.POISON;
		System.out.print(s.strength);
		return s;
	}

}
