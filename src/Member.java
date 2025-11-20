public class Member {
  private static int nextId = 1001;
  private String memberId;
  private String name;
  private int points;

  public Member(String name) {
    this.name = name;
    this.memberId = "M" + nextId++;
    this.points = 0;
  }

  public String getMemberId() {
    return memberId;
  }
  public String getName() {
    return name;
  }
  public int getPoints() {
    return points;
  }

  public void addPoints(int amount) {
    this.points += amount;
  }
  public void reducePoints(int amount) {
    this.points = Math.max(0, this.points - amount);
  }
  public int usePoints(int totalAmount) {
    int pointsToUse = ((int) (totalAmount / 100)) * 10;
    if (points < 10) return 0;
    int previousPoints = points;
    points = Math.max(0, points - pointsToUse);
    return previousPoints - points;
  }

  @Override
  public String toString() {
    return String.format("Member %s (%s): %d points", memberId, name, points);
  }
}
