package leetcode;

public class PowXN {

    public double myPow(double x, int n) {
	if (n == 0) {
	    return 1;
	}
	if (x == 0) {
	    return 0;
	}
	if (n == 1) {
	    return x;
	}
	boolean negative = (n < 0) ? true : false;
	n = Math.abs(n);
	double result = myPowHandler(x, n);
	return negative ? 1 / result : result;
    }

    private double myPowHandler(double x, int n) {
	if (n == 0) {
	    return 1;
	}
	if (x == 0) {
	    return 0;
	}
	if (n == 1) {
	    return x;
	}
	double temp = myPowHandler(x, n / 2);
	temp = temp * temp;
	if (n % 2 == 0) {
	    return temp;
	} else {
	    return x * temp;
	}
    }

}
