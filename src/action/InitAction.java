package action;

import entiity.movingEntities.Herbivore;
import entiity.movingEntities.Predator;
import entiity.staticEntities.Grass;
import entiity.staticEntities.Rock;
import entiity.staticEntities.Tree;
import gameMap.GameMap;

public class InitAction extends Action{


    @Override
    public void execute(GameMap gameMap) {
        gameMap.addEntity(new Grass(5, 5));
        gameMap.addEntity(new Grass(6, 5));
        gameMap.addEntity(new Grass(5, 6));
        gameMap.addEntity(new Herbivore(10, 10, 100, 2));
        gameMap.addEntity(new Predator(15, 15, 100, 3, 50));
        gameMap.addEntity(new Rock(12, 12));
        gameMap.addEntity(new Tree(14, 14));
    }
}
