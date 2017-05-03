package Agency;

import java.util.Queue;

public abstract class Agent extends Thread implements Runnable {
	protected int id;
	public boolean dead;
	protected boolean done;
	protected Dispatcher dispatcher = null;
	public Queue<Message> mailBox = null;
	public Agent partner = null;
	abstract public void update();
	public Agent(){}
	public Agent(int id){
		this.id= id;
	}
	public void run(){
		while(!dead){
			update();
			yield();
		}
	}
	public void interact(Agent a){
		
	}
}
