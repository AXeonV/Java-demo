public class Rectangle {
	private double width;
	private double length;
	private Position position;
	private int id;
	public static int countRec;
	public static int furId;
	public static double furDis = 0;

	public Rectangle(double width, double length, double x, double y) {
		this.width = width;
		this.length = length;
		this.position = new Position(x, y);
		this.id = ++countRec;
		if (position.distanceToOrigin() > furDis) {
			furDis = position.distanceToOrigin();
			furId = this.id;
		}
	}

	public String toString() {
		return String.format("Rectangle id=#%d, position=(%.1f, %.1f)", this.id, this.position.getX(), this.position.getY());
	}
}
