public class CollinerPoints {
	public static boolean sameLine(int[][] points) {
		int n = points.length;
		int[][] tpoints = new int[n][2];
		tpoints[0][0] = points[0][0];
		tpoints[0][1] = points[0][1];
		int m = 1;
		for (int i = 1; i < n; ++i)
			if (points[i][0] != points[i - 1][0] ||  points[i][1] != points[i - 1][1]) {
				tpoints[m][0] = points[i][0];
				tpoints[m][1] = points[i][1];
				m++;
			}
		n = m;
		System.arraycopy(tpoints, 0, points, 0, n);
		if (n < 3) return true;
		for (int i = 2; i < n; ++i) {
			int xy = (points[i - 1][1] - points[i - 2][1]) * (points[i][0] - points[i - 1][0]);
			int yx = (points[i][1] - points[i - 1][1]) * (points[i - 1][0] - points[i - 2][0]);
			if (xy != yx) return false;
		}
		return true;
	}
	public static void main(String[] args) {
		int[][] point1 = {{0, 0}, {1, 1}, {2, 2}, {3, 3}};
		int[][] point2 = {{0, 0}, {1, 2}, {2, 3}};

		System.out.println(sameLine(point1)); // should print true
		System.out.println(sameLine(point2)); // should print false
	}
}
