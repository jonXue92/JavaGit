package bigdata;

class Point {
    int x;
    int y;
    Point() {
        x = 0;
        y = 0;
    }
    Point(int a, int b) {
        x = a;
        y = b;
    }
}

public class KClosest {
    private Point origin;
    public Point[] kClosest(Point[] points, Point origin, int k) {
        if (points == null || points.length == 0) {
            return points;
        }
        this.origin = origin;
        heapify(points); //O(n)
        Point[] results = new Point[k];
        // O(klogn)
        for (int i = 0; i < k; i++) {
            results[i] = pop(points);
        }
        return results;
    }
    private void heapify(Point[] points) {
        for (int i = points.length / 2; i >= 0; i--) {
            siftDown(points, i);
        }
    }
    private void siftDown(Point[] points, int index) {
        while (index < points.length) {
            int left = index * 2 + 1;
            int right = index * 2 + 2;
            int min = index;
            if (left < points.length && compare(points[min], points[left]) > 0) {
                min = left;
            }
            if (right < points.length && compare(points[min], points[right]) > 0) {
                min = right;
            }
            if (index != min) {
                Point temp = points[index];
                points[index] = points[min];
                points[min] = temp;
                index = min;
            } else {
                break;
            }
        }
    }
    private Point pop(Point[] points) {
        Point top = points[0];
        points[0] = points[points.length - 1];
        siftDown(points, 0);
        return top;
    }
    private int compare(Point a, Point b) {
        int cmp = dist(a, origin) - dist(b, origin);
        if (cmp == 0) {
            cmp = a.x - b.x;
        }
        if (cmp == 0) {
            cmp = a.y - b.y;
        }
        return cmp;
    }
    private int dist(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }
}
