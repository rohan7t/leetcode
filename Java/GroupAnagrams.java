package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
	HashMap<Integer, List<String>> hm = new HashMap<Integer, List<String>>();

	for (String str : strs) {
	    char[] wordArray = str.toCharArray();
	    Arrays.sort(wordArray);
	    String sortedWord = new String(wordArray);
	    int hashCode = sortedWord.hashCode();
	    if (hm.containsKey(hashCode)) {
		List<String> words = hm.get(hashCode);
		words.add(str);
		hm.put(hashCode, words);
	    } else {
		List<String> words = new ArrayList<String>();
		words.add(str);
		hm.put(hashCode, words);
	    }
	}
	List<List<String>> anagrams = new ArrayList<List<String>>();
	for (Entry<Integer, List<String>> entry : hm.entrySet()) {
	    anagrams.add(entry.getValue());
	}
	return anagrams;
    }

}
