package Study.Generic.Two;

import java.util.LinkedList;

public class GenericStack<T> {
    
    private LinkedList<T> container = new LinkedList<T>();
    
    public void push(T t) {
        container.addFirst(t);
    }
    
    public T pop() {
        return container.removeFirst();
    }
    
    public boolean empty() {
        return container.isEmpty();
    }
}
