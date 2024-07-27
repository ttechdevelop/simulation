package simulation;

import action.Action;
import action.InitAction;
import action.TurnAction;
import gameMap.GameMap;

public class Simulation {

    private final GameMap gameMap;

    public Simulation(int width, int height) {
        gameMap = new GameMap(width, height);
    }

    public void initSimulation() {
        Action initAction = new InitAction();
        initAction.execute(gameMap);
    }

    public void runSimulation() {
        while (true) {
            Action turnAction = new TurnAction();
            turnAction.execute(gameMap);
            gameMap.render(); // Визуализация карты

            try {
                Thread.sleep(1000); // Задержка для визуализации
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}