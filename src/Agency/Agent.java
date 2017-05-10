package Agency;

import java.util.LinkedList;
import java.util.Queue;

public abstract class Agent extends Thread implements Runnable {
	public int id;
	public boolean dead;
	protected boolean done;
	protected Dispatcher dispatcher = null;
	public Queue<Message<T>> mailBox = null;
	public Agent partner = null;
	public abstract void update();
	public Agent(){}
	public Agent(int i){
		partner = null;
		id= i;
		mailBox = new LinkedList<Message<T>>();
	}
	public synchronized void run(){
		while(!dead){
			update();
			yield();
		}
	}
	public synchronized void start(){
		while(!dead){
			update();
			yield();
		}
	}
	public void halt(){
		
	}
	public abstract void interact(Agent a);
	public void interact() {
	}
}
