package leetcode;

public class LinkedListCycle2 {

    class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
	    val = x;
	    next = null;
	}
    }

    public ListNode detectCycle(ListNode head) {
	if (head == null || head.next == null) {
	    return null;
	}
	ListNode slow = head;
	ListNode fast = head;
	do {
	    if (slow == null || fast == null || fast.next == null || slow.next == null || fast.next.next == null) {
		return null;
	    }
	    slow = slow.next;
	    fast = fast.next.next;
	} while (slow != fast);

	ListNode start = head;
	while (start != slow) {
	    start = start.next;
	    slow = slow.next;
	}
	return start;
    }
}
