package PD;

import java.util.HashMap;

import Agency.Agent;
import Agency.Message;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Prisoner extends Agent {
    public HashMap<Prisoner, int[]> history;
    public int[] strategy = new int[4];
    public int score = 0;
    public int gamesPlayed = 0;
    public Prisoner(){}
    public Prisoner(int id){
            super(id);
            mailBox=new LinkedList<Message>();
            history = new HashMap<Prisoner, int[]>();
    }
    
    @SuppressWarnings("unchecked")
    public void update(){
        System.out.println("Inside Prisoner."+id+"'s update function");
        System.out.println(mailBox);
        gamesPlayed++;
        if(gamesPlayed>100){
            die();
        }
        if(!mailBox.isEmpty()){
            Message m = mailBox.poll();
            if (m == null) interact();
            else while(m != null) {
                respond(m);
                m = mailBox.poll();
            }
        } else interact();
    }
    
    @Override
    public void interact() {
        Prisoner p = (Prisoner) Prison.getPartner(this);
        Choice c = null;
        if(history.get(p) == null){
            int[] initArray = {0,0};
            history.put(p,initArray);
        }
        c = strategy(history.get(p));
        Prison.send(p, new Message((Prisoner) this, c));
        Message msg = mailBox.poll();
        if(msg!=null){
            updateHistory(p, (Choice) msg.content);
            updateScore(c,(Choice) msg.content);
        }
    }
	
    public Choice strategy(int[] hist){
        if(hist!=null){
            System.out.println(hist[0]+""+hist[1]);
            if(strategy[0]==0 && strategy[1]==0 && strategy[2]==0 && strategy[3]==0){
                    return Choice.DEFECT;
            }
            else if(strategy[0]==0 && strategy[1]==0 && strategy[2]==0 && strategy[3]==1){
                    if(hist[0]==1 && hist[1]==1){
                            return Choice.COOPERATE;
                    } else return Choice.DEFECT;
            }
            else if(strategy[0]==0 && strategy[1]==0 && strategy[2]==1 && strategy[3]==0){
                    if(hist[0]==1 && hist[1]==0){
                            return Choice.COOPERATE;
                    } else return Choice.DEFECT;
            }
            else if(strategy[0]==0 && strategy[1]==0 && strategy[2]==1 && strategy[3]==1){
                    if((hist[0]==1 && hist[1]==0)||(hist[0]==1 && hist[1]==1)){
                            return Choice.COOPERATE;
                    } else return Choice.DEFECT;
            }
            else if(strategy[0]==0 && strategy[1]==1 && strategy[2]==0 && strategy[3]==0){
                    if(hist[0]==0 && hist[1]==1){
                            return Choice.COOPERATE;
                    } else return Choice.DEFECT;
            }
            else if(strategy[0]==0 && strategy[1]==1 && strategy[2]==0 && strategy[3]==1){
                    if((hist[0]==0 && hist[1]==1)||(hist[0]==1 && hist[1]==1)){
                            return Choice.COOPERATE;
                    } else return Choice.DEFECT;
            }
            else if(strategy[0]==0 && strategy[1]==1 && strategy[2]==1 && strategy[3]==0){
                    if((hist[0]==0 && hist[1]==1)||(hist[0]==1 && hist[1]==0)){
                            return Choice.COOPERATE;
                    } else return Choice.DEFECT;
            }
            else if(strategy[0]==0 && strategy[1]==1 && strategy[2]==1 && strategy[3]==1){
                    if(hist[0]==0 && hist[1]==0){
                            return Choice.DEFECT;
                    } else return Choice.COOPERATE;
            }
            else if(strategy[0]==1 && strategy[1]==0 && strategy[2]==0 && strategy[3]==0){
                    if(hist[0]==0 && hist[1]==0){
                            return Choice.COOPERATE;
                    } else return Choice.DEFECT;
            }
            else if(strategy[0]==1 && strategy[1]==0 && strategy[2]==0 && strategy[3]==1){
                    if((hist[0]==0 && hist[1]==0)||(hist[0]==1 && hist[1]==1)){
                            return Choice.COOPERATE;
                    } else return Choice.DEFECT;
            }
            else if(strategy[0]==1 && strategy[1]==0 && strategy[2]==1 && strategy[3]==0){
                    if((hist[0]==0 && hist[1]==0)||(hist[0]==1 && hist[1]==0)){
                            return Choice.COOPERATE;
                    } else return Choice.DEFECT;
            }
            else if(strategy[0]==1 && strategy[1]==0 && strategy[2]==1 && strategy[3]==1){
                    if(hist[0]==0 && hist[1]==1){
                            return Choice.DEFECT;
                    } else return Choice.COOPERATE;
            }
            else if(strategy[0]==1 && strategy[1]==1 && strategy[2]==0 && strategy[3]==0){
                    if((hist[0]==0 && hist[1]==0)||(hist[0]==0 && hist[1]==1)){
                            return Choice.COOPERATE;
                    } else return Choice.DEFECT;
            }
            else if(strategy[0]==1 && strategy[1]==1 && strategy[2]==0 && strategy[3]==1){
                    if(hist[0]==1 && hist[1]==0){
                            return Choice.DEFECT;
                    } else return Choice.COOPERATE;
            }
            else if(strategy[0]==1 && strategy[1]==1 && strategy[2]==1 && strategy[3]==0){
                    if(hist[0]==1 && hist[1]==1){
                            return Choice.DEFECT;
                    } else return Choice.COOPERATE;
            }
            else if(strategy[0]==1 && strategy[1]==1 && strategy[2]==1 && strategy[3]==1){
                    return Choice.COOPERATE;
            }
        }
        return null;
        
    }

    @SuppressWarnings({"unchecked", "empty-statement"})
    public void respond(Message msg){
        Prisoner p = (Prisoner) msg.sender;
        if(history.get(p)==null){
            int[] initArray = {0,0};
            history.put(p, initArray);
        }
        Choice decision = (Choice) strategy(history.get((Prisoner)msg.sender));
        Prison.send(msg.sender, new Message(this, decision));
        updateScore(decision, (Choice) msg.content);
        updateHistory((Prisoner) msg.sender, (Choice) msg.content);
    }
        
    public void updateHistory(Prisoner p, Choice c){
        int choiceInteger;
        if (c == Choice.DEFECT) choiceInteger = 0; 
        else choiceInteger = 1;
        (history.get(p))[1] = (history.get(p))[0];
        (history.get(p))[0] = choiceInteger;
    }

    private void updateScore(Choice c1, Choice c2) {
        if(c1 == Choice.COOPERATE && c2 == Choice.COOPERATE) score += 3;
        else if(c1 == Choice.DEFECT && c2 == Choice.DEFECT) score += 1;
        else if(c1 == Choice.DEFECT && c2 == Choice.COOPERATE) score += 5;
        else score += 0;
    }
}