package leetcode;

import java.util.PriorityQueue;

public class KClosestPoints {
    class Point implements Comparable<Point> {
	int x;
	int y;
	int dist;

	@Override
	public int compareTo(Point o) {
	    return Integer.compare(o.dist, dist);
	}

	public Point(int i, int j) {
	    x = i;
	    y = j;
	    dist = calculateDistance(i, j);
	}
    }

    public int[][] kClosest(int[][] points, int K) {
	if (points == null || points.length == 0) {
	    return new int[0][0];
	}
	if (K == points.length) {
	    return points;
	}
	PriorityQueue<Point> pq = new PriorityQueue<Point>();
	for (int[] point : points) {
	    Point currPoint = new Point(point[0], point[1]);
	    if (pq.size() >= K) {
		Point maxPoint = pq.peek();
		if (currPoint.dist < maxPoint.dist) {
		    pq.poll();
		    pq.add(currPoint);
		}
	    } else {
		pq.add(currPoint);
	    }
	}
	int[][] result = new int[K][2];
	int i = 0;
	while (!pq.isEmpty() && i <= K) {
	    Point p = pq.poll();
	    result[i][0] = p.x;
	    result[i][1] = p.y;
	    i++;
	}
	return result;
    }

    private int calculateDistance(int i, int j) {
	return i * i + j * j;
    }
}
