package UltraDome;

public class IceSkin extends ShieldSkin {
	public Strike reduceStrike(Strike s) {
		if (s.type==StrikeTypes.ICE){
			s.strength *= 0.5;
			return super.reduceStrike(s);
		}
		else 
			return super.reduceStrike(s);
	}
}