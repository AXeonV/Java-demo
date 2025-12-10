public class StrengthenSkill extends Skill {
  public StrengthenSkill(int skillStrength) {
    super(skillStrength);
  }
  public String releaseSkill(Sprite s) {
    String result = String.format("%s skillStrength(%d) + %d", s.getName(), s.getPrimarySkill().getSkillStrength(), getSkillStrength());
    s.getPrimarySkill().setSkillStrength(s.getPrimarySkill().getSkillStrength() + getSkillStrength());
    return result;
  }
  public String getSimpleName() {
    return "StrengthenSkill";
  }
}
