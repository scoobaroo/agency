package UltraDome;

public class ShieldSkin implements Shield{
	public Shield delegate;
	public StrikeTypes type;
	public Strike reduceStrike(Strike s) {
		if(delegate != null) return delegate.reduceStrike(s);
		else return s;
	}
}
