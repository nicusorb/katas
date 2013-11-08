package stack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nicubucalaete
 * Date: 9/10/13
 * Time: 11:18 AM
 */
public class MyStack {
    private int size = 0;
    private List<Integer> numbers = new ArrayList<>();

    public int size() {
        return size;
    }

    public void push(int n) {
        size++;
        numbers.add(n);
    }

    public int pop() {
        if (size == 0)
            throw new UnderflowException();

        return numbers.get(--size);
    }

    public class UnderflowException extends RuntimeException {
    }
}
