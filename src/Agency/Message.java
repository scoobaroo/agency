package Agency;

public class Message<T> {
    public T content;
    public boolean response;
    public Agent sender = null;
    public Message(T c){
            this.content = (T) c;
    }
    public Message(Agent s, T c){
            sender = s;
            content = c;
    }
}
