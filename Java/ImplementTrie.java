package leetcode;

public class ImplementTrie {
    class Trie {
	TrieNode root;

	/** Initialize your data structure here. */
	public Trie() {
	    this.root = new TrieNode();
	}

	class TrieNode {
	    boolean finished = false;
	    final TrieNode[] trieNodes = new TrieNode[26];

	    public TrieNode next(char ch) {
		return trieNodes[ch - 'a'];
	    }
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
	    if (word == null || word.length() == 0) {
		return;
	    }
	    TrieNode current = root;
	    for (int i = 0; i < word.length(); i++) {
		if (current.trieNodes[word.charAt(i) - 'a'] == null) {
		    current.trieNodes[word.charAt(i) - 'a'] = new TrieNode();
		}
		current = current.next(word.charAt(i));
	    }
	    current.finished = true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
	    if (word == null || word.length() == 0) {
		return false;
	    }
	    TrieNode current = root.next(word.charAt(0));
	    if (current == null) {
		return false;
	    }
	    for (int i = 1; i < word.length(); i++) {
		current = current.next(word.charAt(i));
		if (current == null) {
		    return false;
		}
	    }
	    return current.finished;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
	    if (prefix == null || prefix.length() == 0) {
		return false;
	    }
	    TrieNode current = root.next(prefix.charAt(0));
	    if (current == null) {
		return false;
	    }
	    for (int i = 1; i < prefix.length(); i++) {
		current = current.next(prefix.charAt(i));
		if (current == null) {
		    return false;
		}
	    }
	    return true;
	}
    }

    /**
     * Your Trie object will be instantiated and called as such: Trie obj = new
     * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
     * = obj.startsWith(prefix);
     */
}
