package leetcode;

public class PalindromeLinkedList {

    class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
	    val = x;
	    next = null;
	}
    }

    public boolean isPalindrome(ListNode head) {
	if (head == null || head.next == null) {
	    return true;
	}
	ListNode fast = head;
	ListNode next = head.next;
	ListNode node = head;
	ListNode prev = node;

	while (fast.next != null && fast.next.next != null) {
	    fast = fast.next.next;

	    prev = node;
	    node = next;
	    next = next.next;
	    node.next = prev;
	}
	if (fast.next == null) {
	    node = node.next;
	}

	while (next != null) {
	    if (next.val != node.val) {
		return false;
	    }
	    next = next.next;
	    node = node.next;
	}

	return true;
    }
}
