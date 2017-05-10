package UltraDome;

public class Bazooka extends Weapon{
	public Bazooka(String name){
		super(name);
	}
	public Strike makeStrike(){
		Strike s = new Strike("Shoots a rocket from his bazooka with initial strenght=");
		s.strength = (int) (attacker.health* 0.3); 
		s.type = StrikeTypes.FIRE;
		System.out.println(s.description);
		System.out.println(s.strength);
		return s;
	}
}
