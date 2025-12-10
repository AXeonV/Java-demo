public class Battle {
  Sprite homeSprite;
  Sprite awaySprite;
  public Battle(Sprite hs, Sprite as) {
    homeSprite = hs;
    awaySprite = as;
  }
  private void restore(int oriHph, int oriHpa, int oriSt1h, int oriSt2h, int oriSt1a, int oriSt2a) {
    homeSprite.setHp(oriHph);
    awaySprite.setHp(oriHpa);
    homeSprite.getPrimarySkill().setSkillStrength(oriSt1h);
    homeSprite.getSecondarySkill().setSkillStrength(oriSt2h);
    awaySprite.getPrimarySkill().setSkillStrength(oriSt1a);
    awaySprite.getSecondarySkill().setSkillStrength(oriSt2a);
  }
  public BattleOutcome begin1v1Battle() {
    int oriHph = homeSprite.getHp();
    int oriHpa = awaySprite.getHp();
    int oriSt1h = homeSprite.getPrimarySkill().getSkillStrength();
    int oriSt2h = homeSprite.getSecondarySkill().getSkillStrength();
    int oriSt1a = awaySprite.getPrimarySkill().getSkillStrength();
    int oriSt2a = awaySprite.getSecondarySkill().getSkillStrength();
    homeSprite.getPrimarySkill().setSkillStrength(oriSt1h + homeSprite.compareType(awaySprite).getValue());
    homeSprite.getSecondarySkill().setSkillStrength(oriSt2h + homeSprite.compareType(awaySprite).getValue());
    awaySprite.getPrimarySkill().setSkillStrength(oriSt1a + awaySprite.compareType(homeSprite).getValue());
    awaySprite.getSecondarySkill().setSkillStrength(oriSt2a + awaySprite.compareType(homeSprite).getValue());
    for (int i = 1; i <= 10; ++i) {
      System.out.println(homeSprite.getPrimarySkill().releaseSkill(awaySprite));
      if (awaySprite.getHp() == 0) {
        restore(oriHph, oriHpa, oriSt1h, oriSt2h, oriSt1a,  oriSt2a);
        return BattleOutcome.VICTORY;
      }
      System.out.println(awaySprite.getPrimarySkill().releaseSkill(homeSprite));
      if (homeSprite.getHp() == 0) {
        restore(oriHph, oriHpa, oriSt1h, oriSt2h, oriSt1a,  oriSt2a);
        return BattleOutcome.DEFEAT;
      }
      System.out.println(homeSprite.getSecondarySkill().releaseSkill(homeSprite.getSecondarySkill().getSimpleName().equals("AttackSkill") ? awaySprite : homeSprite));
      if (awaySprite.getHp() == 0) {
        restore(oriHph, oriHpa, oriSt1h, oriSt2h, oriSt1a,  oriSt2a);
        return BattleOutcome.VICTORY;
      }
      System.out.println(awaySprite.getSecondarySkill().releaseSkill(awaySprite.getSecondarySkill().getSimpleName().equals("AttackSkill") ? homeSprite : awaySprite));
      if (homeSprite.getHp() == 0) {
        restore(oriHph, oriHpa, oriSt1h, oriSt2h, oriSt1a,  oriSt2a);
        return BattleOutcome.DEFEAT;
      }
    }
    restore(oriHph, oriHpa, oriSt1h, oriSt2h, oriSt1a,  oriSt2a);
    return BattleOutcome.DRAW;
  }
}
