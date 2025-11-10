public class Circle {
	private double radius;
	private Position position;
	private int id;

	public static int countCir;

	public static int furId;
	public static double furDis = 0;

	public Circle(double radius, double x, double y) {
		this.radius = radius;
		this.position = new Position(x, y);
		this.id = ++countCir;
		if (position.distanceToOrigin() > furDis) {
			furDis = position.distanceToOrigin();
			furId = this.id;
		}
	}

	public String toString() {
		return String.format("Circle id=#%d, position=(%.1f, %.1f)", this.id, this.position.getX(), this.position.getY());
	}
}
