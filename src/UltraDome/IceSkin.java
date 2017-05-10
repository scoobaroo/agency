package UltraDome;

public class IceSkin extends ShieldSkin {
	public IceSkin(){
		super();
		type = StrikeTypes.ICE;
	}
	public Strike reduceStrike(Strike s) {
		if (s.type==StrikeTypes.ICE){
			s.strength *= 0.5;
			System.out.println("Ice skin reduced damage by 0.5 to "+ s.strength);
			return super.reduceStrike(s);
		}
		else 
			return super.reduceStrike(s);
	}
}