public class Person {
	private Direction[] direction;
	private int i;
	private int j;
	private int index;

	public Person(int i, int j, int index) {
		this.i = i;
		this.j = j;
		this.index = index;
		this.direction = new Direction[8];
		this.direction[0] = new Direction(0, 1);
		this.direction[1] = new Direction(-1, 1);
		this.direction[2] = new Direction(-1, 0);
		this.direction[3] = new Direction(-1, -1);
		this.direction[4] = new Direction(0, -1);
		this.direction[5] = new Direction(1, -1);
		this.direction[6] = new Direction(1, 0);
		this.direction[7] = new Direction(1, 1);
	}

	public void changeDirection() {
		this.index = (this.index + 1) % this.direction.length;
	}

	public int getIndex() {
		return this.index;
	}

	public void walk(int step) {
		this.i += step * this.direction[this.index].getRow();
		this.j += step * this.direction[this.index].getCol();
	}

	public String toString() {
		return String.format("(%d,%d)", this.i, this.j);
	}
}
