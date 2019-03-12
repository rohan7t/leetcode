package leetcode;

import java.util.HashSet;
import java.util.Set;

public class GoatLatin {
    private static final String SUFFIX = "ma";
    private static final Set<Character> vowels;

    static {
	vowels = new HashSet<Character>();
	vowels.add('a');
	vowels.add('e');
	vowels.add('i');
	vowels.add('o');
	vowels.add('u');
	vowels.add('A');
	vowels.add('E');
	vowels.add('I');
	vowels.add('O');
	vowels.add('U');
    }

    public String toGoatLatin(String S) {
	if (S == null || S.isEmpty()) {
	    return "";
	}
	String[] splitS = S.split(" ");
	StringBuilder sb = new StringBuilder();
	String aString = "";

	for (String word : splitS) {
	    String goatLatinWord = getGoatLatinWord(word);
	    if (goatLatinWord != null && !goatLatinWord.isEmpty()) {
		aString = aString + "a";
		sb.append(goatLatinWord);
		sb.append(aString);
		sb.append(" ");
	    }
	}
	return sb.toString().trim();
    }

    private String getGoatLatinWord(String word) {
	if (word == null || word.isEmpty()) {
	    return "";
	}
	StringBuilder wordSb = new StringBuilder();
	char firstAlpha = word.charAt(0);
	if (!vowels.contains(firstAlpha)) {
	    String remaining = word.substring(1, word.length());
	    wordSb.append(remaining);
	    wordSb.append(firstAlpha);
	} else {
	    wordSb.append(word);
	}
	wordSb.append(SUFFIX);
	return wordSb.toString().trim();
    }
}
