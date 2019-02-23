package leetcode;

public class ReverseLinkedListRecursive {

    private class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
	    val = x;
	}
    }

    public ListNode reverseList(ListNode head) {
	if (head == null) {
	    return null;
	}
	if (head.next == null) {
	    return head;
	}
	ListNode temp = head.next;
	head.next = null;
	ListNode reversed = reverseList(temp);
	temp.next = head;
	return reversed;
    }
}
