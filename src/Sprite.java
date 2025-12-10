public class Sprite implements Comparable<Sprite> {
  private String name;
  private String id;
  ElementType elementType;
  private int hp;
  private Skill primarySkill;
  private Skill secondarySkill;
  private int score = 0;
  private int count = 0;
  public Sprite(String name, String id, ElementType elementType, int hp, Skill primarySkill, Skill secondarySkill) {
    this.name = name;
    this.id = id;
    this.elementType = elementType;
    this.hp = hp;
    this.primarySkill = primarySkill;
    this.secondarySkill = secondarySkill;
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
  public ElementType getElementType() {
    return elementType;
  }
  public void setElementType(ElementType elementType) {
    this.elementType = elementType;
  }
  public int getHp() {
    if (hp < 0) hp = 0;
    return hp;
  }
  public void setHp(int hp) {
    this.hp = hp;
  }
  public Skill getPrimarySkill() {
    return primarySkill;
  }
  public void setPrimarySkill(Skill primarySkill) {
    this.primarySkill = primarySkill;
  }
  public Skill getSecondarySkill() {
    return secondarySkill;
  }
  public void setSecondarySkill(Skill secondarySkill) {
    this.secondarySkill = secondarySkill;
  }
  public int getScore() {
    return score;
  }
  public void setScore(int score) {
    this.score = score;
  }
  public int getCount() {
    return count;
  }
  public void setCount(int count) {
    this.count = count;
  }
  public EffectIntensity compareType(Sprite other) {
    if (this.elementType == ElementType.METAL) {
      if (other.elementType == ElementType.WOOD) return EffectIntensity.STRENGTHENED;
      if (other.elementType == ElementType.FIRE) return EffectIntensity.WEAKENED;
    }
    if (this.elementType == ElementType.WOOD) {
      if (other.elementType == ElementType.EARTH) return EffectIntensity.STRENGTHENED;
      if (other.elementType == ElementType.METAL) return EffectIntensity.WEAKENED;
    }
    if (this.elementType == ElementType.EARTH) {
      if (other.elementType == ElementType.WATER) return EffectIntensity.STRENGTHENED;
      if (other.elementType == ElementType.WOOD) return EffectIntensity.WEAKENED;
    }
    if (this.elementType == ElementType.WATER) {
      if (other.elementType == ElementType.FIRE) return EffectIntensity.STRENGTHENED;
      if (other.elementType == ElementType.EARTH) return EffectIntensity.WEAKENED;
    }
    if (this.elementType == ElementType.FIRE) {
      if (other.elementType == ElementType.METAL) return EffectIntensity.STRENGTHENED;
      if (other.elementType == ElementType.WATER) return EffectIntensity.WEAKENED;
    }
    return EffectIntensity.UNCHANGED;
  }
  public String toString() {
    return String.format("%s - id: %s, elementType: %s, hp: %d, primarySkill: %s, secondarySkill: %s", name, id, elementType, hp, primarySkill.getSimpleName(), secondarySkill.getSimpleName());
  }

  @Override
  public int compareTo(Sprite o) {
    if (this.score != o.score) return this.score > o.score ? -1 : 1;
    if (this.count != o.count) return this.count < o.count ? -1 : 1;
    return this.id.compareTo(o.id);
  }
}
