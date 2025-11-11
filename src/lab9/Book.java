package lab9;

public class Book {
  private int id;
  private String name;
  private BookStatus status;
  public static int count;

  public Book(String name) {
    this.id = ++count;
    this.name = name;
    this.status = BookStatus.IDLE;
  }
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public BookStatus getStatus() {
    return status;
  }
  public void setStatus(BookStatus status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return String.format("%d: %s %s", this.id, this.name, this.status);
  }
}
