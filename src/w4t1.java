import java.util.Scanner;

public class w4t1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input a number between [1,9]:");
		int n = sc.nextInt();
		while (n != 0) {
			while (n < 1 || n > 9) {
				System.out.println("You number is not in [1,9]");
				System.out.println("Please input a number between [1,9]:");
				n = sc.nextInt();
				if (n == 0) return;
			}
			for (int i = 1; i <= n; ++i) {
				for (int j = 1; j <= i; ++j)
					System.out.printf("%d * %d = %d ", i, j, i * j);
				System.out.println();
			}
			System.out.println("Please input a number between [1,9]:");
			n = sc.nextInt();
		}
	}
}
