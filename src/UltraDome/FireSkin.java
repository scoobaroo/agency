package UltraDome;

public class FireSkin extends ShieldSkin {
	public Strike reduceStrike(Strike s) {
		if(s.type==StrikeTypes.FIRE){
			s.strength *= 0.5;
			return super.reduceStrike(s);
		} else {
		return super.reduceStrike(s);
		}
	}
}
