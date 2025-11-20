public class GoldMember extends Member {
  public GoldMember(String name) {
    super(name);
  }

  @Override
  public int usePoints(int totalAmount) {
    int pointsToUse = ((int) (totalAmount / 100)) * 20;
    if (super.getPoints() < 20) return 0;
    int previousPoints = super.getPoints();
    super.reducePoints(Math.min(pointsToUse, super.getPoints()));
    return previousPoints - super.getPoints();
  }
}
