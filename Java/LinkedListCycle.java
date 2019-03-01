package leetcode;

public class LinkedListCycle {

    class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
	    val = x;
	    next = null;
	}
    }

    public boolean hasCycle(ListNode head) {
	if (head == null || head.next == null || head.next.next == null) {
	    return false;
	}
	ListNode slow = head;
	head = head.next.next;
	while (head != null || slow != null) {
	    if (slow == head) {
		return true;
	    }
	    if (slow.next == null || head.next == null || head.next.next == null) {
		return false;
	    }
	    slow = slow.next;
	    head = head.next.next;
	}
	return false;
    }
}
