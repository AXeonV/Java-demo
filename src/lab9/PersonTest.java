package lab9;

import lab9.model.Person;

public class PersonTest {
  public static void main(String[] args) {
    Person person1 = new Person(0,-1,0);
    System.out.println(person1);
    person1.walk(3);
    person1.changeDirection();
    System.out.println(person1);
    person1.walk(2);
    person1.changeDirection();
    System.out.println(person1);
    person1.walk(5);
    person1.changeDirection();
    System.out.println(person1);
    Person person2 = new Person(1,2,6);
    System.out.println(person2);
    person2.walk(3);
    person2.changeDirection();
    System.out.println(person2);
    person2.walk(2);
    person2.changeDirection();
    System.out.println(person2);
    person2.walk(5);
    person2.changeDirection();
    System.out.println(person2);
  }
}
