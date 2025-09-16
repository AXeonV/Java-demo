import java.util.Scanner;
public class w2t3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int x = sc.nextInt();
			if (x % 2 == 1) System.out.println("Odd");
			else System.out.println("Even");
		}
		sc.close();
	}
}
