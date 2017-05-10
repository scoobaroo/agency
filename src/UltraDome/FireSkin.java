package UltraDome;

public class FireSkin extends ShieldSkin {
	public FireSkin(){
		super();
		type = StrikeTypes.FIRE;
	}
	public Strike reduceStrike(Strike s) {
		if(s.type==StrikeTypes.FIRE){
			s.strength *= 0.5;
			System.out.println("Fire skin reduced damage by 0.5 to "+ s.strength);
			return super.reduceStrike(s);
		} else {
		return super.reduceStrike(s);
		}
	}
}
