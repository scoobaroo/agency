package UltraDome;

public class MagicSkin extends ShieldSkin {
	public Strike reduceStrike(Strike s) {
		if(s.type==StrikeTypes.MAGIC){
			s.strength *= 0.5;
			return super.reduceStrike(s);
		} else {
			return super.reduceStrike(s);
		}
	}
}
