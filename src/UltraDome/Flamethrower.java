package UltraDome;

public class Flamethrower extends Weapon {

	public Strike makeStrike() {
		Strike s = new Strike("Shoots a rocket from his bazooka with initial strenght=");
		s.strength = (int) (attacker.getHealth() * 0.35); 
		s.type = StrikeTypes.FIRE;
		System.out.println(s.strength);
		return s;
	}

}
