package leetcode;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedIntegerIterator implements Iterator<Integer> {

    interface NestedInteger {
	public boolean isInteger();

	public Integer getInteger();

	public List<NestedInteger> getList();
    }

    private Stack<NestedInteger> stack;

    public NestedIntegerIterator(List<NestedInteger> nestedList) {
	stack = new Stack<NestedInteger>();
	for (int i = nestedList.size() - 1; i >= 0; i--) {
	    stack.push(nestedList.get(i));
	}
    }

    @Override
    public Integer next() {
	return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
	while (!stack.isEmpty()) {
	    NestedInteger curr = stack.peek();
	    if (curr.isInteger()) {
		return true;
	    }
	    stack.pop();
	    for (int i = curr.getList().size() - 1; i >= 0; i--) {
		stack.push(curr.getList().get(i));
	    }
	}
	return false;
    }
}
