package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
	HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
	paragraph = paragraph.replaceAll("[^a-zA-Z0-9]", " ").toLowerCase().replaceAll("( )+", " ");
	String[] words = paragraph.split(" ");
	for (String word : words) {
	    word = word.trim();
	    if (hashMap.containsKey(word)) {
		hashMap.put(word, hashMap.get(word) + 1);
	    } else {
		hashMap.put(word, 1);
	    }
	}

	for (String bannedWord : banned) {
	    if (hashMap.containsKey(bannedWord)) {
		hashMap.remove(bannedWord);
	    }
	}
	int maxCount = 0;
	String result = "";
	for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
	    int count = entry.getValue().intValue();
	    if (count > maxCount) {
		maxCount = count;
		result = entry.getKey();
	    }
	}
	return result;
    }
}
