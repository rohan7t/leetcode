package leetcode;

public class CountAndSay {

	public static void main(String[] args) {
		char[] result = countAndSay(4);
		System.out.println(result);
	}

	public static char[] countAndSay(int n) {

		String number = "1";
		char[] numbarray = number.toCharArray();
		int i = 1;
		int count = 0;
		int currentNumber = Character.getNumericValue(numbarray[0]);
		while (i < n) {
			for (char ch : numbarray) {
				if (Character.getNumericValue(ch) == currentNumber) {
					count++;
				} else {
					numbarray = (String.valueOf(count) + currentNumber).toCharArray();
					currentNumber = Character.getNumericValue(ch);
				}
			}
			numbarray = (String.valueOf(count) + currentNumber).toCharArray();
			i++;
			count = 0;
			currentNumber = Character.getNumericValue(numbarray[0]);
		}

		return numbarray;

	}
}
