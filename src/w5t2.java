import java.util.Arrays;
import java.util.Scanner;

public class w5t2 {
	public static int[][] matrixProduct(int[][] a, int[][] b) {
		if (a == null) return b;
		int m = a.length, n = b[0].length, p = b.length;
		int[][] c = new int[m][n];
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				for (int k = 0; k < p; k++)
					c[i][j] += a[i][k] * b[k][j];
		return c;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the number of matrix:");
		int n = sc.nextInt();
		int[][] ans = new int[0][0];
		for (int t = 1; t <= n; ++t) {
			System.out.println("Enter the number of row and column of matrix:");
			int col = sc.nextInt();
			int row = sc.nextInt();
			int[][] a = new int[col][row];
			System.out.println("Enter the elements of the matrix:");
			for (int i = 0; i < col; ++i)
				for (int j = 0; j < row; ++j)
					a[i][j] = sc.nextInt();
			if (t == 1) {
				ans = a;
				continue;
			}
			ans = matrixProduct(ans, a);
			System.out.println("Product of Matrix is:");
			col = ans.length; row = ans[0].length;
			for (int i = 0; i < col; ++i) {
				System.out.print("[");
				for (int j = 0; j < row; ++j) {
					System.out.print(ans[i][j]);
					if (j < row - 1) System.out.print(", ");
				}
				System.out.print("]\n");
			}
		}
	}
}
