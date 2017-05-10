package UltraDome;

import Agency.Message;

public class Strike<T> extends Message<T>{
	public StrikeTypes type;
	public String description;
	public int strength;
	public Strike(T desc) {
		super(desc);
	}
	
	public void execute(){
		
	}
}
