public enum BattleOutcome {
  DEFEAT(0), DRAW(1), VICTORY(2);

  private final int value;

  private BattleOutcome(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}