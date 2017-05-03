package UltraDome;

public class ShieldSkin implements Shield{
	public StrikeTypes type;
	public Strike reduceStrike(Strike s) {
		if(s.type == type){
			s.strength = (int) (s.strength * 0.4);
		}
		return s;
	}
}
