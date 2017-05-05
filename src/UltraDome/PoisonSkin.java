package UltraDome;

public class PoisonSkin extends ShieldSkin {
	public Strike reduceStrike(Strike s) {
		if(s.type==StrikeTypes.POISON){
			s.strength *= 0.5;
			return super.reduceStrike(s);
		} else {
			return super.reduceStrike(s);
		}
	}
}
