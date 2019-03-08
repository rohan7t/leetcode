package leetcode;

public class RemoveNthFromEnd {

    class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
	    val = x;
	    next = null;
	}
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
	if (head == null) {
	    return head;
	}
	if (head.next == null && n == 1) {
	    return head.next;
	}
	ListNode result = head;
	ListNode del = head;
	ListNode prev = null;

	while (n > 1 && head.next != null) {
	    head = head.next;
	    n--;
	}

	while (head.next != null) {
	    prev = del;
	    del = del.next;
	    head = head.next;
	}
	if (prev == null) {
	    return result.next;
	} else if (prev.next != null) {
	    prev.next = del.next;
	}

	return result;
    }
}
