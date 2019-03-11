package leetcode;

public class ReverseKNodesGroup {

    class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
	    val = x;
	    next = null;
	}
    }

    public ListNode reverseKGroup(ListNode head, int k) {
	if (head == null) {
	    return null;
	}
	if (fetchLength(head) < k || k <= 0) {
	    return head;
	}
	ListNode kNode = findKNode(head, k);
	ListNode prev = null;
	ListNode curr = head;
	ListNode result = kNode;
	while (curr != null && kNode != null) {
	    ListNode nextNode = kNode.next;
	    reverse(curr, kNode);
	    if (prev != null) {
		prev.next = kNode;
	    }
	    curr.next = nextNode;
	    prev = curr;
	    curr = curr.next;
	    kNode = findKNode(curr, k);
	}
	return result;
    }

    private void reverse(ListNode start, ListNode end) {
	if (end == null) {
	    return;
	}
	ListNode pre = null;
	ListNode current = start;
	ListNode nex = null;
	ListNode last = end.next;
	while (current != last) {
	    nex = current.next;
	    current.next = pre;
	    pre = current;
	    current = nex;
	}
    }

    private ListNode findKNode(ListNode node, int k) {
	if (node == null || k < 0) {
	    return null;
	}
	ListNode kNode = node;
	while (k != 1) {
	    if (kNode != null) {
		kNode = kNode.next;
	    }
	    k--;
	}
	return kNode;
    }

    private int fetchLength(ListNode node) {
	if (node == null) {
	    return 0;
	}
	int length = 0;
	ListNode curr = node;
	while (curr != null) {
	    length++;
	    curr = curr.next;
	}
	return length;
    }
}
