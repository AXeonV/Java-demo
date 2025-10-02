import java.util.Scanner;

public class w4t3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int A = 0, B = 0, C = 0, D = 0, F = 0;
		while (n != -1) {
			if (n >= 90 && n <= 100) ++A;
			else if (n >= 80) ++B;
			else if (n >= 70) ++C;
			else if (n >= 60) ++D;
			else ++F;
			n = sc.nextInt();
		}
		System.out.printf("A: %d\n", A);
		System.out.printf("B: %d\n", B);
		System.out.printf("C: %d\n", C);
		System.out.printf("D: %d\n", D);
		System.out.printf("F: %d\n", F);
	}
}
