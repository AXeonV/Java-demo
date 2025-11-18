package lab9.model;

public class Person {
  public static int id;
	private final Direction[] direction;
	private int i;
	private int j;
	private int index;

	public Person(int i, int j, int index) {
    ++id;
		this.i = i;
		this.j = j;
		this.index = index;
		this.direction = new Direction[8];
		this.direction[0] = Direction.RIGHT;
		this.direction[1] = Direction.RIGHT_UP;
		this.direction[2] = Direction.UP;
		this.direction[3] = Direction.LEFT_UP;
		this.direction[4] = Direction.LEFT;
		this.direction[5] = Direction.LEFT_DOWN;
		this.direction[6] = Direction.DOWN;
		this.direction[7] = Direction.RIGHT_DOWN;
	}

	public void changeDirection() {
		this.index = (this.index + 1) % this.direction.length;
	}

	public void walk(int step) {
		this.i += step * this.direction[this.index].getRow();
		this.j += step * this.direction[this.index].getCol();
    System.out.printf("Person #%d walked %s for %d steps: ", id, this.direction[this.index].toString().split(" ")[0], step);
	}

	public String toString() {
		return String.format("Person #%d current location: (%d,%d)", id, this.i, this.j);
	}
}
