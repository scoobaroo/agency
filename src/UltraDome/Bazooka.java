package UltraDome;

public class Bazooka extends Weapon{


	public Strike makeStrike(){
		Strike s = new Strike("Shoots a rocket from his bazooka with initial strenght=");
		s.strength = (int) (attacker.getHealth() * 0.3); 
		s.type = StrikeTypes.FIRE;
		System.out.println(s.strength);
		return s;
	}

}
