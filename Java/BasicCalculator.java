package leetcode;

import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
	if (s == null || s.isEmpty()) {
	    return 0;
	}
	char[] charArr = s.toCharArray();
	Stack<Integer> stack = new Stack<Integer>();
	int result = 0;
	int number = 0;
	int sign = 1;
	for (char ch : charArr) {
	    if (Character.isDigit(ch)) {
		number = 10 * number + (int) ch - '0';
	    } else if (ch == '+') {
		result += sign * number;
		number = 0;
		sign = 1;
	    } else if (ch == '-') {
		result += sign * number;
		number = 0;
		sign = -1;
	    } else if (ch == '(') {
		stack.push(result);
		stack.push(sign);
		result = 0;
		sign = 1;
	    } else if (ch == ')') {
		result += number * sign;
		result *= stack.pop();
		result += stack.pop();
		number = 0;
	    }
	}
	if (number != 0) {
	    result += number * sign;
	}
	return result;
    }
}
