import java.util.Scanner;

public class w3t1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Please input the precision:");
		double pre = input.nextDouble();

		double pi = 0, cur;
		int i = 0;
		do {
			++i;
			cur = 4.0 / (2 * i - 1);
			if (i % 2 == 0) pi -= cur;
			else pi += cur;
		} while (cur > pre);

		System.out.printf("The estimation of Pi is %f\n", pi);
		System.out.printf("It computed %d times\n", i);

		input.close();
	}
}
