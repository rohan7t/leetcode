package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReorderLinkedList {
    private static class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
	    val = x;
	}
    }

    public void reorderList(ListNode head) {
	if (head == null || head.next == null) {
	    return;
	}
	ListNode result = head;
	Deque<ListNode> arrayD = new ArrayDeque<ListNode>();
	while (result != null) {
	    arrayD.push(result);
	    result = result.next;
	}
	result = head;
	int count = (arrayD.size() - 1) / 2;
	while (count-- > 0) {
	    ListNode tmp = result.next;
	    ListNode top = arrayD.pop();
	    result.next = top;
	    top.next = tmp;
	    result = tmp;
	}
	arrayD.pop().next = null;
    }
}
