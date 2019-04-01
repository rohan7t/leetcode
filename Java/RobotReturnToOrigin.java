package leetcode;

public class RobotReturnToOrigin {
    public boolean judgeCircle(String moves) {
	if (moves == null || moves.length() == 0) {
	    return true;
	}
	int x = 0, y = 0;
	for (char ch : moves.toCharArray()) {
	    switch (ch) {
	    case 'L':
		x--;
		break;
	    case 'R':
		x++;
		break;
	    case 'D':
		y++;
		break;
	    case 'U':
		y--;
		break;
	    default:
		break;
	    }
	}
	return x == 0 && y == 0;
    }
}
