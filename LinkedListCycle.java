import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
    public boolean hasCycleSlowAndMoreSpace(ListNode head) { // Time Complexity O(N)
        // Space Complexity is O(N)
        // Space Complexity can be improved to O(1) by using limits of size of list.
        // If list exceeds the size then it will prove that there is a cycle;
        // Even faster algorithm uses slow and fast head pointers
        // Fast moves two steps. Slow moves 1 step. If fast and slow meet it means there
        // is a cycle.
        if (head == null) {
            return false;
        } else {
            Set<ListNode> memory = new HashSet<>();
            while (head.next != null) {
                if (memory.contains(head)) {
                    return true;
                } else {
                    memory.add(head);
                    head = head.next;
                }
            }
            return false;
        }
    }
}
