package UltraDome;

import Agency.Message;

public class Strike extends Message{
	public StrikeTypes type;
	public String description;
	public int strength;
	public Strike(String desc) {
		super(desc);
	}
	
	public void execute(){
		
	}
}
