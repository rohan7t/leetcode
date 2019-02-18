package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhoneNumberCombinations {

	private static final HashMap<Character, char[]> map = new HashMap<Character, char[]>();
	static {
		map.put('2', new char[] { 'a', 'b', 'c' });
		map.put('3', new char[] { 'd', 'e', 'f' });
		map.put('4', new char[] { 'g', 'h', 'i' });
		map.put('5', new char[] { 'j', 'k', 'l' });
		map.put('6', new char[] { 'm', 'n', 'o' });
		map.put('7', new char[] { 'p', 'q', 'r', 's' });
		map.put('8', new char[] { 't', 'u', 'v' });
		map.put('9', new char[] { 'w', 'x', 'y', 'z' });
	}

	public static void main(String[] args) {
		System.out.println(letterCombinations("72678"));
	}

	public static List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<String>();
		if (digits == null || digits.isEmpty() || digits.length() == 0) {
			return result;
		}

		char[] temp = new char[digits.length()];
		recursive(digits, 0, result, temp);
		return result;
	}

	private static void recursive(String digits, int n, List<String> result, char[] temp) {
		int noOfDigits = digits.length();
		if (n == noOfDigits) {
			result.add(new String(temp));
			return;
		}

		for (char ch : map.get(digits.charAt(n))) {
			temp[n] = ch;
			recursive(digits, n + 1, result, temp);
		}
	}
}
