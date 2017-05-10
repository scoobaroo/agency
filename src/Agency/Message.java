package Agency;

import PD.Choice;
import PD.Prisoner;

public class Message<T> {
    public T content;
    public Agent sender = null;
    public Message(T c){
            this.content = (T) c;
    }
    public Message(Agent s, T c){
            sender = s;
            content = c;
    }

    public Message(Prisoner prisoner, Choice c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
