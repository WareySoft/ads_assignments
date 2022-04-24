import java.util.ArrayList;
import java.util.List;

public class MyQueue<T> {

    ArrayList<T> queue = new ArrayList<>();

    public T peek() {
        if (queue.isEmpty())
            return null;
        return queue.get(0);
    }

    void offer(T item) {
        queue.add(item);
    }

    public T poll() {
        T head = queue.get(0);
        queue.remove(0);
        return head;
    }
    public String toString()
    {
        if (queue.isEmpty())
            return "";
        String output = "";
        for (int i = 0; i < queue.size(); i++) {
            if (i == queue.size()-1 )
                output += queue.get(i);
            else
                output += queue.get(i) + ", ";
        }
        return "[" + output + "]" ;
    }
}