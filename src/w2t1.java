import java.util.Scanner;
public class w2t1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the width of a rectangle:");
		double a = input.nextDouble();
		System.out.print("Enter the height of a rectangle:");
		double b = input.nextDouble();
		System.out.printf("The area is %.2f\n", a * b);
		System.out.printf("The perimeter is %.2f\n", (a + b) * 2);
		if (a == b) System.out.println("It is a square");
		else System.out.println("It is a rectangle");
		input.close();
	}
}
