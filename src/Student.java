public class Student implements Comparable<Student> {
  private String name;
  private String id;
  private int score;

  public Student(String id, String name, int score) {
    this.name = name;
    this.id = id;
    this.score = score;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public int getScore() {
    return score;
  }
  public void setScore(int score) {
    this.score = score;
  }

  @Override
  public String toString() {
    return String.format("%s - id: %s, score: %d", name, id, score);
  }

  @Override
  public int compareTo(Student o) {
    if (this.score != o.score) return this.score < o.score ? 1 : -1;
    return this.id.compareTo(o.id);
  }
}
