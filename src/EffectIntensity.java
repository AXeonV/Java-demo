public enum EffectIntensity {
  WEAKENED(-5),
  UNCHANGED(0),
  STRENGTHENED(5);

  private final int value;

  private EffectIntensity(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}