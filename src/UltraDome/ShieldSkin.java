package UltraDome;

public class ShieldSkin implements Shield{
	public Shield delegate;
	public Strike reduceStrike(Strike s) {
		s = delegate.reduceStrike(s);
		return s;
	}
}
