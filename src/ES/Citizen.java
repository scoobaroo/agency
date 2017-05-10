package ES;

import Agency.Agent;

public class Citizen extends Agent {
	Race color;
	public boolean happy;
	public Citizen(Race c){
		color=c;
	}
	public void update() {
		Double occupancypercentage;
		if ( occupancypercentage < City.threshold){
			// request new unoccupied unit
		}
	}
	@Override
	public void interact(Agent a) {
		// TODO Auto-generated method stub
		
	}

}
