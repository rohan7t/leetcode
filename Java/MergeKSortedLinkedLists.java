package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLinkedLists {

    class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
	    val = x;
	    next = null;
	}
    }

    public ListNode mergeKLists(ListNode[] lists) {
	if (lists == null || lists.length == 0) {
	    return null;
	}
	PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
	    @Override
	    public int compare(ListNode l1, ListNode l2) {
		return Integer.compare(l1.val, l2.val);
	    }
	});

	for (ListNode list : lists) {
	    if (list != null) {
		pq.offer(list);
	    }
	}
	ListNode temp = new ListNode(0);
	ListNode tail = temp;
	while (!pq.isEmpty()) {
	    tail.next = pq.poll();
	    tail = tail.next;
	    if (tail.next != null) {
		pq.offer(tail.next);
	    }
	}
	return temp.next;
    }
}
