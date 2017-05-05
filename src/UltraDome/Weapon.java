package UltraDome;

public abstract class Weapon {
	public Gladiator attacker;
	public String name;
	public Weapon(String name){
		this.name = name;
	}
	public abstract Strike makeStrike();
}
