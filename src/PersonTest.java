public class PersonTest {
	public static void main(String[] args) {
		Person p = new Person(0,-1,0);
		p.walk(3);
		p.changeDirection();
		System.out.println(p);
		p.walk(2);
		p.changeDirection();
		System.out.println(p);
		p.walk(5);
		p.changeDirection();
		System.out.println(p);
	}
}
