import java.util.ArrayList;
import java.util.List;
public class MyStack<T> {

    private List<T> stack;

    public MyStack() {
        stack = new ArrayList<>();
    }
    
    public void push(T element) {
        stack.add(element);
    }
    public boolean isEmpty() {
        return stack.isEmpty();
    }
    public T peek() {
        if (stack.isEmpty()) {
            return null;
        }
        return stack.get(stack.size() - 1);
    }
    public T pop() {
        if (stack.isEmpty()) {
            return null;
        }
        T top = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        return top;
    }
}
