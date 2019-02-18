package leetcode;

import java.util.EmptyStackException;
import java.util.Stack;

public class ValidParanthesis {

	public static void main(String[] args) {
		System.out.println(isValid("{{{[[()]]}{}}}"));
	}

	public static boolean isValid(String s) {
		char[] input = s.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		try {
			for (char ch : input) {
				if (ch == '{' || ch == '[' || ch == '(') {
					stack.push(ch);
				} else {
					char prevBrace = stack.peek();
					char currBrace = getInverse(prevBrace);
					if (ch == currBrace) {
						stack.pop();
					} else {
						return false;
					}
				}
			}
			if (!stack.isEmpty()) {
				return false;
			}
		} catch (EmptyStackException e) {
			return false;
		}
		return true;
	}

	private static char getInverse(char prevBrace) {
		switch (prevBrace) {
		case '{':
			return '}';
		case '[':
			return ']';
		case '(':
			return ')';
		}
		return '0';
	}

}
