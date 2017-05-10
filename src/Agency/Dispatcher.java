package Agency;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Random;

public abstract class Dispatcher {
	public static ArrayList<Agent> agents = new ArrayList<Agent>();
	public boolean multiThread;
	static Random rand = new Random();
	protected AgentFactory af;
	
	public <T> void add(Agent a){
		agents.add(a);
	}
	
	public synchronized static Agent getPartner(Agent a){
		Agent a2 = null;
		int count = 0;
		ArrayList<Agent> deadagents = new ArrayList<Agent>();
		ArrayList<Agent> liveagents = new ArrayList<Agent>();
		if(liveagents.size()==1){
			return a;
		} else
		while(a.partner==null){
			int i = rand.nextInt(agents.size()-1);
			a2 = agents.get(i);
			if(a2.dead) deadagents.add(a2); 
			else liveagents.add(a2);
			count++;
			if(a2.partner==null && !a2.dead && a2!=a){
				a.partner = a2;
				a2.partner = a;
				System.out.println("inside GETPARTNER:::" + a2);
				return a2;
			}
			if(count>=agents.size()){
				System.out.println("breaking from getpartner");
				break;
			}
		}
		return a2;
	}

	public static void send(Agent a, Message<T> m){
            a.mailBox.add(m);
	}
	public synchronized void start() throws InterruptedException{
		if(multiThread){
			for (Agent a: agents){
				a.start();
				a.join();
			}
		}else if(!multiThread){
			while(!agents.isEmpty()){
				while(agents.size()>=1){
					for(Agent a : agents){
						if(!a.dead) a.update();
					}
				}
			}
		}
	}
	public void run(){
		
	}
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Inside Agency Framework");
	}

}
