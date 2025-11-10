public class ShapeTest {
	public static void main(String[] args) {
		int N = (int) Math.floor(Math.random() * 2 + 3);
		Circle[] circles = new Circle[N];
		for (int i = 0; i < N; ++i) {
			double radius = Math.random() * 2 + 1;
			double x = Math.random() * 3 + 2;
			double y = Math.random() * 3 + 2;
			circles[i] = new Circle(radius, x, y);
			System.out.println(circles[i]);
		}
		Rectangle[] rectangles = new Rectangle[N];
		for (int i = 0; i < N; ++i) {
			double width = Math.random() * 2 + 1;
			double length = Math.random() * 2 + 1;
			double x = Math.random() * 3 + 2;
			double y = Math.random() * 3 + 2;
			rectangles[i] = new Rectangle(width, length, x, y);
			System.out.println(rectangles[i]);
		}
		if (Circle.furDis > Rectangle.furDis) System.out.println("Furthest " + circles[Circle.furId - 1]);
		else System.out.println("Furthest " + rectangles[Rectangle.furId - 1]);
	}
}
