package UltraDome;

public class MagicSkin extends ShieldSkin {
	public MagicSkin(){
		super();
		type = StrikeTypes.MAGIC;
	}
	public Strike reduceStrike(Strike s) {
		if(s.type==StrikeTypes.MAGIC){
			s.strength *= 0.5;
			System.out.println("Magic skin reduced damage by 0.5 to "+ s.strength);
			return super.reduceStrike(s);
		} else {
			return super.reduceStrike(s);
		}
	}
}
