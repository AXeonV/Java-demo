import java.util.Scanner;

public class w6t1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[][] board = new int[9][9];
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++)
				board[i][j] = in.nextInt();
		System.out.println(isValidSudoku(board) ? "Yes" : "No");
	}
	public static boolean isValidSudoku(int[][] board) {
		for (int i = 0; i < 9; ++i) {
			boolean[] f = new boolean[10];
			for (int j = 0; j < 9; ++j) {
				if (f[board[i][j]]) return false;
				f[board[i][j]] = true;
			}
		}
		for (int j = 0; j < 9; ++j) {
			boolean[] f = new boolean[10];
			for (int i = 0; i < 9; ++i) {
				if (f[board[i][j]]) return false;
				f[board[i][j]] = true;
			}
		}
		return true;
	}
}