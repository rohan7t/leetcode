package leetcode;

public class MergeTwoSortedListsIteration {

    class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
	    val = x;
	    next = null;
	}
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	ListNode temp = new ListNode(-1);

	ListNode prev = temp;
	while (l1 != null && l2 != null) {
	    if (l1.val <= l2.val) {
		prev.next = l1;
		l1 = l1.next;
	    } else {
		prev.next = l2;
		l2 = l2.next;
	    }
	    prev = prev.next;
	}
	if (l1 == null) {
	    prev.next = l2;
	} else {
	    prev.next = l1;
	}
	return temp.next;
    }
}
