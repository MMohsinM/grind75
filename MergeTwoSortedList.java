class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    static ListNode fromArray(int[] myArray) {
        ListNode myNode = null;
        ListNode myNodePtr = null;
        ListNode myNodePtr2 = null;
        for (int i = 0; i < myArray.length; i++) {
            myNodePtr = new ListNode(myArray[i]);
            if (myNode == null) {
                myNode = myNodePtr;
                myNodePtr2 = myNode;
            } else {
                myNodePtr2.next = myNodePtr;
                myNodePtr2 = myNodePtr2.next;
            }
        }
        return myNode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode myPtr = this;
        while (myPtr != null) {
            sb.append(myPtr.val + " ");
            myPtr = myPtr.next;
        }
        return sb.toString();
    }
}

class MergeTwoSortedList {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ptr1, ptr2, head, ptr3, dummy;
        ptr1 = list1;
        ptr2 = list2;
        head = null;
        dummy = null;
        while (ptr1 != null || ptr2 != null) {
            ptr3 = new ListNode();
            if (ptr1 != null && ptr2 == null) {
                ptr3.val = ptr1.val;
                ptr1 = ptr1.next;
            } else if (ptr1 == null && ptr2 != null) {
                ptr3.val = ptr2.val;
                ptr2 = ptr2.next;
            } else if (ptr1.val < ptr2.val) {
                ptr3.val = ptr1.val;
                ptr1 = ptr1.next;
            } else {
                ptr3.val = ptr2.val;
                ptr2 = ptr2.next;
            }
            if (head == null) {
                head = ptr3;
                dummy = head;
            } else {
                dummy.next = ptr3;
                dummy = dummy.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode a = ListNode.fromArray(new int[] { 1, 2, 4 });
        ListNode b = ListNode.fromArray(new int[] { 1, 3, 4 });
        System.out.println(a != null ? a.toString() : " ");
        System.out.println(b != null ? b.toString() : " ");

        ListNode c = mergeTwoLists(a, b);
        System.out.println(c);

    }
}