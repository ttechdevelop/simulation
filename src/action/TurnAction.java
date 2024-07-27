package action;

import entiity.Entity;
import entiity.movingEntities.Creature;
import gameMap.GameMap;

public class TurnAction extends Action{

    @Override
    public void execute(GameMap gameMap) {
        for (int x = 0; x < gameMap.getWidth(); x++) {
            for (int y = 0; y < gameMap.getHeight(); y++) {
                Entity entity = gameMap.getEntityAt(x, y);
                if (entity instanceof Creature creature) {
                    creature.makeMove(gameMap);
                }
            }
        }
    }
}
