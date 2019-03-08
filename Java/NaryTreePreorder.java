package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NaryTreePreorder {

    class Node {
	public int val;
	public List<Node> children;

	public Node() {
	}

	public Node(int _val, List<Node> _children) {
	    val = _val;
	    children = _children;
	}
    };

    public List<Integer> preorder(Node root) {
	List<Integer> result = new ArrayList<Integer>();
	if (root == null) {
	    return result;
	}
	if (root.children == null) {
	    result.add(root.val);
	    return result;
	}
	Stack<Node> stack = new Stack<Node>();
	stack.push(root);
	while (!stack.isEmpty()) {
	    Node node = stack.pop();
	    result.add(node.val);
	    List<Node> children = node.children;
	    for (int i = children.size() - 1; i >= 0; i--) {
		if (children.get(i) != null) {
		    stack.push(children.get(i));
		}
	    }
	}
	return result;
    }
}
