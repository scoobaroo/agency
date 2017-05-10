package ES;

import Agency.Dispatcher;

public class City extends Dispatcher {
	Citizen[][] cityblock = new Citizen[5][5];
	static Double threshold = 0.5;
	public City(){
		Citizen w1 = new Citizen(Race.WHITE);
		Citizen w2 = new Citizen(Race.WHITE);
		Citizen w3 = new Citizen(Race.WHITE);
		Citizen b1 = new Citizen(Race.BLACK);
		Citizen b2 = new Citizen(Race.BLACK);
		Citizen b3 = new Citizen(Race.BLACK);
		agents.add(w1);
		agents.add(w2);
		agents.add(w3);
		agents.add(b1);
		agents.add(b2);
		agents.add(b3);
		cityblock[0][0] = w1;
		cityblock[1][1] = w2;
		cityblock[2][2] = w3;
		cityblock[4][4] = b1;
		cityblock[5][5] = b2;
		cityblock[3][3] = b3;
	}
	public static void main(String[] args){
		City c = new City();
		c.multiThread = false;
		System.out.println("Inside Emergent Segregation Application");
	}
}
