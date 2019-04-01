package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SerializeDeserializeBinaryTree {
    class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
	    val = x;
	}
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
	StringBuilder result = new StringBuilder();
	serialize(root, result);
	return result.toString();
    }

    private void serialize(TreeNode root, StringBuilder str) {
	if (root == null) {
	    str.append("null,");
	    return;
	}
	str.append(String.valueOf(root.val) + ",");
	serialize(root.left, str);
	serialize(root.right, str);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
	String[] datas = data.split(",");
	List<String> dataSplit = new LinkedList<String>(Arrays.asList(datas));
	return deserialize(dataSplit);
    }

    private TreeNode deserialize(List<String> dataSplit) {
	if (dataSplit.get(0) == null || dataSplit.get(0).equals("null")) {
	    dataSplit.remove(0);
	    return null;
	}
	TreeNode node = new TreeNode(Integer.valueOf(dataSplit.get(0)));
	dataSplit.remove(0);
	node.left = deserialize(dataSplit);
	node.right = deserialize(dataSplit);
	return node;
    }
}
