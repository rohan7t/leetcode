package leetcode;

import java.util.HashMap;

public class IntegerToWords {
    private static final HashMap<Integer, String> digitLetter = new HashMap<Integer, String>();
    private static final HashMap<Integer, String> tensMap = new HashMap<Integer, String>();

    static {
	digitLetter.put(1, "One");
	digitLetter.put(2, "Two");
	digitLetter.put(3, "Three");
	digitLetter.put(4, "Four");
	digitLetter.put(5, "Five");
	digitLetter.put(6, "Six");
	digitLetter.put(7, "Seven");
	digitLetter.put(8, "Eight");
	digitLetter.put(9, "Nine");
	digitLetter.put(10, "Ten");
	digitLetter.put(11, "Eleven");
	digitLetter.put(12, "Twelve");
	digitLetter.put(13, "Thirteen");
	digitLetter.put(14, "Fourteen");
	digitLetter.put(15, "Fifteen");
	digitLetter.put(16, "Sixteen");
	digitLetter.put(17, "Seventeen");
	digitLetter.put(18, "Eighteen");
	digitLetter.put(19, "Nineteen");

	tensMap.put(2, "Twenty");
	tensMap.put(3, "Thirty");
	tensMap.put(4, "Forty");
	tensMap.put(5, "Fifty");
	tensMap.put(6, "Sixty");
	tensMap.put(7, "Seventy");
	tensMap.put(8, "Eighty");
	tensMap.put(9, "Ninety");
    }

    public String numberToWords(int num) {
	if (num == 0) {
	    return "Zero";
	}
	// String result = groupThree(num);
	String result = "";
	int i = 0;
	String nd = "";
	while (num != 0) {
	    String temp = groupThree(num % 1000);
	    num = num / 1000;
	    if (i == 1) {
		nd = "Thousand";
	    } else if (i == 2) {
		nd = "Million";
	    } else if (i == 3) {
		nd = "Billion";
	    }
	    if (!temp.isEmpty()) {
		result = temp + " " + nd + " " + result;
	    }
	    i++;
	}
	return result.trim();
    }

    private String groupThree(int number) {
	if (number < 20 && number > 0) {
	    return digitLetter.get(number);
	}
	int units = number % 10;
	int tens = number % 100;
	int hundreds = number % 1000;
	int digit;
	StringBuilder sb = new StringBuilder();
	if (hundreds >= 100 && hundreds < 1000) {
	    digit = hundreds / 100;
	    sb.append(digitLetter.get(digit));
	    sb.append(" Hundred ");
	}
	if (tens >= 20 && tens < 100) {
	    digit = tens / 10;
	    sb.append(tensMap.get(digit) + " ");
	    tens = 0;
	    if (units != 0) {
		sb.append(digitLetter.get(units) + " ");
		units = 0;
	    }
	} else if (tens >= 10 && tens <= 19) {
	    sb.append(digitLetter.get(tens) + " ");
	    units = 0;
	}

	if (units != 0) {
	    sb.append(digitLetter.get(units) + " ");
	}
	return sb.toString().trim();
    }
}
