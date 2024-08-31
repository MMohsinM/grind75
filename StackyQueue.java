import java.util.LinkedList;
import java.util.Deque;

public class StackyQueue {

    private final Deque<Integer> currentStack = new LinkedList<>();
    private final Deque<Integer> backupStack = new LinkedList<>();

    public StackyQueue() {

    }

    public void push(int x) {
        currentStack.addFirst(x);
    }

    public int pop() {
        while (currentStack.size() > 1) {
            backupStack.addFirst(currentStack.removeFirst());
        }
        Integer firstElement = currentStack.removeFirst();
        backupStack.addFirst(firstElement);
        while (backupStack.size() > 0) {
            currentStack.addFirst(backupStack.removeFirst());
        }
        return firstElement;
    }

    public int peek() {
        while (currentStack.size() > 1) {
            backupStack.addFirst(currentStack.removeFirst());
        }
        Integer firstElement = currentStack.removeFirst();
        while (backupStack.size() > 0) {
            currentStack.addFirst(backupStack.removeFirst());
        }
        return firstElement;
    }

    public boolean empty() {
        return currentStack.size() == 0;
    }

    public static void main(String[] args) {
        StackyQueue myQueue = new StackyQueue();
        myQueue.push(1);
        myQueue.push(2);
    }
}