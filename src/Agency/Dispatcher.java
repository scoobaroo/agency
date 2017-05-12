package Agency;

import java.util.ArrayList;
import java.util.Random;

public abstract class Dispatcher {
    public static ArrayList<Agent> agents = new ArrayList<Agent>();
    public boolean multiThread;
    public boolean quit;
    static Random rand = new Random();
    protected AgentFactory af;

    public void add(Agent a){
        agents.add(a);
    }

    public synchronized static Agent getPartner(Agent a){
        Agent a2 = null;
        int count = 0;
        while(a.partner==null){
            int i = rand.nextInt(agents.size()-1);
            a2 = agents.get(i);
            count++;
            if(a2.partner==null && !a2.dead && a2!=a){
                a.partner = a2;
                a2.partner = a;
                System.out.println("inside GETPARTNER:::" + a2);
                return a2;
            }
            if(count>=agents.size()*2){
                System.out.println("breaking from getpartner");
                break;
            }
        }
        return a2;
    }

    public static void send(Agent a, Message m){
        a.mailBox.add(m);
    }

    public boolean quit(){
        int numberAlive=0;
        for(Agent a : agents){
            if(!a.dead) numberAlive++;
        }
        if(numberAlive==0){
            quit=true;
        }
        return numberAlive==0;
    }

    public synchronized void start() throws InterruptedException{
        if(multiThread){
            while(!quit()){
                for (Agent a: agents){
                    if(!a.dead){
                        a.start();
                        a.join();
                    }
                }
            }
            cleanUp();
        }else{
            while(!quit()){
                for(Agent a : agents){
                    if(!a.dead) a.update();
                }
            }
            cleanUp();
        }
    }

    public void cleanUp(){
        System.out.println("Bye");
    }

    public void run(){

    }
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Inside Agency Framework");
    }

}
