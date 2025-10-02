import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int a = 1, b = 1;
			for (int i = 2; i <= n; ++i) {
				int t = a + b;
				b = a; a = t;
			}
			System.out.printf("%d ", a);
		}
	}
}
