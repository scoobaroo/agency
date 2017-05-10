package UltraDome;

public class PoisonSkin extends ShieldSkin {
	public PoisonSkin(){
		super();
		type = StrikeTypes.POISON;
	}
	public Strike reduceStrike(Strike s) {
		if(s.type==StrikeTypes.POISON){
			s.strength *= 0.5;
			System.out.println("Poison skin reduced damage by 0.5 to "+ s.strength);
			return super.reduceStrike(s);
		} else {
			return super.reduceStrike(s);
		}
	}
}
