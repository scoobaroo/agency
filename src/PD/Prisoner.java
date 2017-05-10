package PD;

import java.util.HashMap;

import Agency.Agent;
import Agency.Message;
import java.util.logging.Level;
import java.util.logging.Logger;

@SuppressWarnings("hiding")
public class Prisoner extends Agent {
    public HashMap<Prisoner, int[]> history;
    public int[] strategy = new int[4];
    public int score = 0;

    public Prisoner(){}
    public Prisoner(int id){
            super(id);
    }
    public void update(){}
    
    public <Choice> void update(){
        Message<Choice> msg = (Message<Choice>) mailBox.poll();
        if (msg !=null) respond(msg);
        else interact(); 
    }

    @Override
    public void interact() {
        Prisoner p = (Prisoner) Prison.getPartner(this);
        Choice c = strategy(history.get(p));
        Prison.send(p, new Message<Choice>((Prisoner) this, c));
        try {
            sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Prisoner.class.getName()).log(Level.SEVERE, null, ex);
        }
        Message<Choice> msg = (Message<Choice>) mailBox.poll();
        updateScore(msg.content, c);
    }
	
    public Choice strategy(int[] hist){
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
                if((hist[0]==1 && hist[1]==1)||(hist[0]==1 && hist[1]==1)){
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
        return null;
    }

    @SuppressWarnings("unchecked")
    public <Choice> void respond(Message<Choice> msg){
        msg = (Message<Choice>) (Choice) msg;
        Choice decision = (Choice) strategy(history.get(msg.sender));
        Prison.send(msg.sender, (Message<T>) new Message<Choice>(this,decision));
        updateScore(decision, msg.content);
        updateHistory((Prisoner) msg.sender, (Choice) msg.content);
        /* 
         * use strategy to decide D/C
         * send to partner
         * update score 
         */
    }
        
    public void updateHistory(Prisoner p, Choice c){
        int choiceInteger;
        if (c == Choice.DEFECT) choiceInteger = 0; 
        else choiceInteger = 1;
        if(history.get(p).length>=1){
            history.get(p)[1]= history.get(p)[0];
            history.get(p)[0]=choiceInteger;
        } else history.get(p)[0]=choiceInteger;
    }

    private <Choice> void updateScore(Choice c1, Choice c2) {
        if(c1 == Choice.COOPERATE && c2 == Choice.COOPERATE) score += 3;
        else if(c1 == Choice.DEFECT && c2 == Choice.DEFECT) score += 1;
        else if(c1 == Choice.DEFECT && c2 == Choice.COOPERATE) score += 5;
        else score += 0;
    }

    @Override
    public void interact(Agent a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}