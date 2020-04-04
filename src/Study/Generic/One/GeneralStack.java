package Study.Generic.One;

public class GeneralStack {
    private Object[] container = new Object[10];
    private int index = 0;
    
    public void push(Object o) {
        if (index != container.length) {
            container[index++] = o;
        }
    }
    
    public Object pop() {
        if (index != -1) {
            return container[--index];
        }
        return null;
    }
    
    public boolean empty() {
        if (index == 0) {
            return true;
        } else {
            return false;
        }
    }
}
