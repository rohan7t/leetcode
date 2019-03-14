package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadderLength {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
	if (beginWord == null || beginWord.length() == 0 || endWord == null || endWord.length() == 0) {
	    return 0;
	}
	HashSet<String> words = new HashSet<String>(wordList);
	if (!words.contains(endWord)) {
	    return 0;
	}
	Queue<String> q = new LinkedList<String>();
	q.add(beginWord);
	int count = 1;
	while (!q.isEmpty()) {
	    int size = q.size();
	    for (int i = 0; i < size; i++) {
		char[] currWord = q.poll().toCharArray();
		for (int j = 0; j < currWord.length; j++) {
		    char tmp = currWord[j];
		    for (char ch = 'a'; ch <= 'z'; ch++) {
			currWord[j] = ch;
			String newWord = new String(currWord);
			if (words.contains(newWord)) {
			    if (endWord.equals(newWord)) {
				return count + 1;
			    }
			    q.add(newWord);
			    words.remove(newWord);
			}
		    }
		    currWord[j] = tmp;
		}
	    }
	    count++;
	}
	return 0;
    }
}
