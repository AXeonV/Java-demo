import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt();
		int[][] arr = new int[n + 2][m + 2];
		for (int i = 0; i < n + 2; ++i)
			for (int j = 0; j < m + 2; ++j) {
				if (i == 0 || j == 0 || i == n + 1 || j == m + 1) arr[i][j] = -1;
				else arr[i][j] = 0;
			}
		int tot = 0, x = 1, y = 1, dx = 0, dy = 1;
		while (true) {
			arr[x][y] = sc.nextInt(); ++tot;
			if (tot == n * m) break;
			int nx = x + dx, ny = y + dy;
			if (arr[nx][ny] != 0) {
				if (dx == 1 && dy == 0) { dx = 0; dy = -1; }
				else if (dx == -1 && dy == 0) { dx = 0; dy = 1; }
				else if (dx == 0 && dy == 1) { dx = 1; dy = 0; }
				else if (dx == 0 && dy == -1) { dx = -1; dy = 0; }
			}
			x += dx; y += dy;
		}
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= m; ++j)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}
	}
}
