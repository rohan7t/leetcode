package leetcode;

public class DecodeWays {

    public int numDecodings(String s) {
	if (s.startsWith("0")) {
	    return 0;
	}
	int length = s.length();
	int[] dp = new int[length + 1];
	dp[0] = 1;
	dp[1] = 1;
	char[] sArray = s.toCharArray();
	for (int i = 1; i < length; i++) {
	    int curr = sArray[i] - '0';
	    int prev = sArray[i - 1] - '0';
	    if (curr <= 26 && curr > 0) {
		dp[i + 1] = dp[i];
		if (prev == 0) {
		    continue;
		}
	    }
	    int joint = prev * 10 + curr;
	    if (joint <= 26 && joint > 0) {
		dp[i + 1] += dp[i - 1];
	    }
	}
	return dp[length];
    }
}
