package leetcode;

public class Swap2LinkedList {

    private static class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
	    val = x;
	}

	@Override
	public String toString() {
	    return val + " -> " + next;
	}
    }

    public ListNode swapPairs(ListNode head) {
	if (head == null) {
	    return null;
	}
	if (head.next == null) {
	    return head;
	}
	ListNode result = head.next;
	ListNode current = head;
	ListNode prev = null;
	ListNode swappingNode = head.next;
	while (current != null && swappingNode != null) {
	    ListNode nextNode = swappingNode.next;
	    reverseSwap(current, swappingNode);
	    if (prev != null) {
		prev.next = swappingNode;
	    }
	    current.next = nextNode;
	    prev = current;
	    current = current.next;
	    if (nextNode == null || nextNode.next == null) {
		break;
	    }
	    swappingNode = nextNode.next;
	}
	return result;
    }

    private void reverseSwap(ListNode start, ListNode end) {
	if (end == null) {
	    return;
	}
	ListNode current = start;
	ListNode tail = end.next;
	ListNode prev = null;
	ListNode next = null;
	while (current != tail) {
	    next = current.next;
	    current.next = prev;
	    prev = current;
	    current = next;
	}
    }

}
