import java.util.ArrayList;
import java.util.Collections;

public class Arena {
  private ArrayList<Sprite> sprites = new ArrayList<>();
  private ArrayList<Battle> battles = new ArrayList<>();
  public ArrayList<Battle> getBattles() {
    return battles;
  }
  public void setBattles(ArrayList<Battle> battles) {
    this.battles = battles;
  }
  public ArrayList<Sprite> getSprites() {
    return sprites;
  }
  public void setSprites(ArrayList<Sprite> sprites) {
    this.sprites = sprites;
  }
  public boolean addBattle(Battle battle) {
    if (!sprites.contains(battle.homeSprite) || !sprites.contains(battle.awaySprite)) return false;
    if (battle.homeSprite.equals(battle.awaySprite)) return false;
    battles.add(battle);
    return true;
  }
  public void beginFreeForAllBattle() {
    for (Sprite sprite : sprites) {
      sprite.setScore(0);
      sprite.setCount(0);
    }
    for (Battle battle : battles) {
      battle.homeSprite.setCount(battle.homeSprite.getCount() + 1);
      battle.awaySprite.setCount(battle.awaySprite.getCount() + 1);
      BattleOutcome homeR = battle.begin1v1Battle();
      BattleOutcome awayR = switch (homeR) {
        case DEFEAT -> BattleOutcome.VICTORY;
        case VICTORY -> BattleOutcome.DEFEAT;
        case DRAW -> BattleOutcome.DRAW;
      };
      battle.homeSprite.setScore(battle.homeSprite.getScore() + homeR.getValue());
      battle.awaySprite.setScore(battle.awaySprite.getScore() + awayR.getValue());
    }
  }
  public void show() {
    Collections.sort(sprites);
    for (Sprite sprite : sprites)
      System.out.printf("%s %s %d %d\n", sprite.getName(), sprite.getId(), sprite.getScore(), sprite.getCount());
  }
}
