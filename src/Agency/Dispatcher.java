package Agency;

import java.util.ArrayList;
import java.util.Random;

public abstract class Dispatcher {
	protected ArrayList<Agent> agents = new ArrayList<Agent>();
	public boolean multiThread;
	Random rand = new Random();
	protected AgentFactory af;
	
	public void add(Agent a){
		agents.add(a);
	}
	
	public Agent getPartner(Agent a){
		int i = rand.nextInt(agents.size()-1);
		Agent a2 = null;
		while(a.partner==null){
			while(a2!=a){
				a2 = agents.get(i);
				if(!a2.dead){
					a.partner = a2;
					a2.partner = a;
					return a2;
				}
			}
		}
		return a2 ;
	}

	public void send(Agent a, Message m){
		a.mailBox.add(m);
	}
	public void start() throws InterruptedException{
		if(multiThread){
			for (Agent a: agents){
				a.start();
				a.join();
			}
		}else if(!multiThread){
			while(!agents.isEmpty()){
				while(agents.size()>1){
					for(Agent a : agents){
						a.update();
					}
				}
			}
		}
		
	}
	public void run(){
		
	}
	public static void main(String[] args) {
		System.out.println("Inside Agency Framework");
	}

}
