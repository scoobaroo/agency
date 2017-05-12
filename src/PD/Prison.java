package PD;

import Agency.Agent;
import Agency.Dispatcher;

public class Prison extends Dispatcher {
    public Prison(){
        Strategy s0000 = new Strategy("0000");
        Strategy s0001 = new Strategy("0001");
        Strategy s0010 = new Strategy("0010");
        Strategy s0011 = new Strategy("0011");
        Strategy s0100 = new Strategy("0100");
        Strategy s0101 = new Strategy("0101");
        Strategy s0110 = new Strategy("0110");
        Strategy s0111 = new Strategy("0111");
        Strategy s1000 = new Strategy("1000");
        Strategy s1001 = new Strategy("1001");
        Strategy s1010 = new Strategy("1010");
        Strategy s1011 = new Strategy("1011");
        Strategy s1100 = new Strategy("1100");
        Strategy s1101 = new Strategy("1101");
        Strategy s1110 = new Strategy("1110");
        Strategy s1111 = new Strategy("1111");
        Prisoner p0 = new Prisoner(0);
        Prisoner p1 = new Prisoner(1);
        Prisoner p2 = new Prisoner(2);
        Prisoner p3 = new Prisoner(3);
        Prisoner p4 = new Prisoner(4);
        Prisoner p5 = new Prisoner(5);
        Prisoner p6 = new Prisoner(6);
        Prisoner p7 = new Prisoner(7);
        Prisoner p8 = new Prisoner(8);
        Prisoner p9 = new Prisoner(9);
        Prisoner p10 = new Prisoner(10);
        Prisoner p11 = new Prisoner(11);
        Prisoner p12 = new Prisoner(12);
        Prisoner p13 = new Prisoner(13);
        Prisoner p14 = new Prisoner(14);
        Prisoner p15 = new Prisoner(15);
        p0.strategy = s0000.strategyArray;
        p1.strategy = s0001.strategyArray;
        p2.strategy = s0010.strategyArray;
        p3.strategy = s0011.strategyArray;
        p4.strategy = s0100.strategyArray;
        p5.strategy = s0101.strategyArray;
        p6.strategy = s0110.strategyArray;
        p7.strategy = s0111.strategyArray;
        p8.strategy = s1000.strategyArray;
        p9.strategy = s1001.strategyArray;
        p10.strategy = s1010.strategyArray;
        p11.strategy = s1011.strategyArray;
        p12.strategy = s1100.strategyArray;
        p13.strategy = s1101.strategyArray;
        p14.strategy = s1110.strategyArray;
        p15.strategy = s1111.strategyArray;
        Prison.agents.add(p0);
        Prison.agents.add(p1);
        Prison.agents.add(p2);
        Prison.agents.add(p3);
        Prison.agents.add(p4);
        Prison.agents.add(p5);
        Prison.agents.add(p6);
        Prison.agents.add(p7);
        Prison.agents.add(p8);
        Prison.agents.add(p9);
        Prison.agents.add(p10);
        Prison.agents.add(p11);
        Prison.agents.add(p12);
        Prison.agents.add(p13);
        Prison.agents.add(p14);
        Prison.agents.add(p15);
    }

    public static void main(String[] args) throws InterruptedException {
        Prison p = new Prison();
        p.multiThread = true;
        p.start();
        for(Agent pris : Prison.agents){
            Prisoner prisoner = (Prisoner) pris;
            System.out.println("Prisoner." +prisoner.id+": "+prisoner.score);
        }
    }
}
