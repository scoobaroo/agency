package Agency;

import java.util.ArrayList;
import java.util.Random;

public abstract class Dispatcher {
	protected static ArrayList<Agent> agents = new ArrayList<Agent>();
	public boolean multiThread; 
	Random rand = new Random();
	protected AgentFactory af;
	
	public void add(Agent a){
		agents.add(a);
	}
	
	public Agent getPartner(Agent a){
		int i = rand.nextInt(agents.size());
		while(a.partner==null){
			Agent a2 = null;
			while(a2!=a){
				a2 = agents.get(i);
				if(!a2.dead){
					a.partner = a2;
					return a2;
				}
			}
		}
		return a2;
	}

	public void send(Agent a, Message m){
		a.mailBox.add(m);
	}
	public void start(){
		
	}
	public void run(){
	}
	public static void main(String[] args) {
		System.out.println("Inside Agency Framework");
	}

}
