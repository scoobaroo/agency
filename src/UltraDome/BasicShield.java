package UltraDome;

public class BasicShield extends ShieldSkin {
	public BasicShield(){
		super();
		type = null;
	}

	public Strike reduceStrike(Strike s) {
		s.strength = (int) (s.strength * 0.9);
		return super.reduceStrike(s);
	}

}
