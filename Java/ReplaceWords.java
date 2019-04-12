package leetcode;

import java.util.List;

public class ReplaceWords {
    class TrieNode {
	TrieNode[] children;
	String word;

	public TrieNode() {
	    children = new TrieNode[26];
	}
    }

    public String replaceWords(List<String> dict, String sentence) {
	TrieNode trie = new TrieNode();
	for (String word : dict) {
	    TrieNode curr = trie;
	    for (char ch : word.toCharArray()) {
		if (curr.children[ch - 'a'] == null) {
		    curr.children[ch - 'a'] = new TrieNode();
		}
		curr = curr.children[ch - 'a'];
	    }
	    curr.word = word;
	}

	StringBuilder result = new StringBuilder();
	for (String word : sentence.split(" ")) {
	    if (result.length() > 0) {
		result.append(" ");
	    }
	    TrieNode curr = trie;
	    for (char ch : word.toCharArray()) {
		if (curr.children[ch - 'a'] == null || curr.word != null) {
		    break;
		}
		curr = curr.children[ch - 'a'];
	    }
	    if (curr.word != null) {
		result.append(curr.word);
	    } else {
		result.append(word);
	    }
	}
	return result.toString();
    }
}
