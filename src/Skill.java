public abstract class Skill {
  private int skillStrength;
  public Skill(int skillStrength) {
    this.skillStrength = skillStrength;
  }
  public int getSkillStrength() {
    return skillStrength;
  }
  public void setSkillStrength(int skillStrength) {
    this.skillStrength = skillStrength;
  }
  public abstract String releaseSkill(Sprite s);
  public abstract String getSimpleName();
}
