package Agency;

import java.util.LinkedList;
import java.util.Queue;

public abstract class Agent extends Thread implements Runnable {
	public int id;
	public boolean dead=false;
	protected boolean done;
	protected Dispatcher dispatcher = null;
	public Queue<Message> mailBox = null;
	public Agent partner = null;
	public abstract void update();
	public Agent(){}
	public Agent(int i){
            dead=false;
            partner = null;
            id= i;
            mailBox = new LinkedList<Message>();
	}
	public synchronized void die(){
		dead=true;
	}

	public synchronized void start(){
            if(!dead){
                update();
                yield();
            }
	}
        
	public void halt(){
		
	}
	public abstract void interact();

}
