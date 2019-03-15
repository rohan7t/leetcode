package leetcode;

public class AddBinary {
    public String addBinary(String a, String b) {
	if (a == null || a.length() == 0 || b == null || b.length() == 0) {
	    return "";
	}
	StringBuilder sb = new StringBuilder();
	int i = a.length() - 1;
	int j = b.length() - 1;
	int carry = 0;
	while (i >= 0 || j >= 0) {
	    int sum = carry;
	    if (i >= 0) {
		sum += a.charAt(i) - '0';
	    }
	    if (j >= 0) {
		sum += b.charAt(j) - '0';
	    }
	    sb.append(sum % 2);
	    carry = sum / 2;
	    j--;
	    i--;
	}
	if (carry != 0) {
	    sb.append(carry);
	}
	return sb.reverse().toString();
    }
}
