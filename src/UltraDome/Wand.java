package UltraDome;

public class Wand extends Weapon {

	public Strike makeStrike() {
		Strike s = new Strike("Shoots a magical zap from his wand with initial strenght=");
		s.strength = (int) (attacker.getHealth() * 0.2); 
		s.type = StrikeTypes.MAGIC;
		System.out.println(s.strength);
		return s;
	}

}
