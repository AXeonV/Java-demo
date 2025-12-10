public class HealingSkill extends Skill {
  public HealingSkill(int skillStrength) {
    super(skillStrength);
  }
  public String releaseSkill(Sprite s) {
    String result = String.format("%s hp(%d) + %d", s.getName(), s.getHp(), getSkillStrength());
    s.setHp(s.getHp() + getSkillStrength());
    return result;
  }
  public String getSimpleName() {
    return "HealingSkill";
  }
}
