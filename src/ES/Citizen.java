package ES;

import Agency.Agent;

public class Citizen extends Agent {
	City city;
	Race color;
	public boolean happy;
	public void update() {
		Double occupancypercentage;
		if ( occupancypercentage < city.threshold){
			// request new unoccupied unit
		}
	}

}
