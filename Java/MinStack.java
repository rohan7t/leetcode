package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {

    int minValue;
    Deque<Integer> stack;

    /** initialize your data structure here. */
    public MinStack() {
	minValue = Integer.MAX_VALUE;
	stack = new ArrayDeque<Integer>();
    }

    public void push(int x) {
	if (x <= minValue) {
	    stack.push(minValue);
	    minValue = x;
	}
	stack.push(x);
    }

    public void pop() {
	if (stack.pop() == minValue) {
	    minValue = stack.pop();
	}
    }

    public int top() {
	return stack.peek();
    }

    public int getMin() {
	return minValue;
    }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */
