package entiity.movingEntities;

import entiity.Entity;
import entiity.staticEntities.Grass;
import gameMap.GameMap;
import java.util.Random;

public class Herbivore extends Creature {

    private final Random random = new Random();
    private final int maxHP = 100;

    public Herbivore(int x, int y, int hp, int speed) {
        super(x, y, hp, speed);
    }

    @Override
    public void makeMove(GameMap gameMap) {
        if (!findGrass(gameMap)) {
            moveRandomly(gameMap);
        }
    }

    private void moveRandomly(GameMap gameMap) {
        int randomDirection = random.nextInt(4);

        switch (randomDirection) {
            case 0 -> moveUp(gameMap);
            case 1 -> moveDown(gameMap);
            case 2 -> moveLeft(gameMap);
            case 3 -> moveRight(gameMap);
        }
    }

    private void moveUp(GameMap gameMap) {
        int newY = getY() - 1;
        if (gameMap.isValidPosition(getX(), newY)) {
            setY(newY);
        }
    }

    private void moveDown(GameMap gameMap) {
        int newY = getY() + 1;
        if (gameMap.isValidPosition(getX(), newY)) {
            setY(newY);
        }
    }

    private void moveLeft(GameMap gameMap) {
        int newX = getX() - 1;
        if (gameMap.isValidPosition(newX, getY())) {
            setX(newX);
        }
    }

    private void moveRight(GameMap gameMap) {
        int newX = getX() + 1;
        if (gameMap.isValidPosition(newX, getY())) {
            setX(newX);
        }
    }

    private boolean findGrass(GameMap gameMap) {
        int[][] directions = {
                {-1, 0}, // left
                {1, 0},  // right
                {0, -1}, // up
                {0, 1}   // down
        };
        for (int[] dir : directions) {
            int newX = getX() + dir[0];
            int newY = getY() + dir[1];
            Entity entity = gameMap.getEntityAt(newX, newY);
            if (entity instanceof Grass) {
                gameMap.removeEntity(entity);
                setX(newX);
                setY(newY);
                restoreHP();
                return true;
            }
        }
        return false;
    }

    private void restoreHP() {
        this.hp = maxHP;
    }
}