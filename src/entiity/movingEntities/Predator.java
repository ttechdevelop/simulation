package entiity.movingEntities;

import entiity.Entity;
import gameMap.GameMap;

public class Predator extends Creature {

    private int attackPower;

    public Predator(int x, int y, int hp, int speed, int attackPower) {
        super(x, y, hp, speed);
        this.attackPower = attackPower;
    }

    @Override
    public void makeMove(GameMap gameMap) {
        // реализация движения хищника
    }

    public void findPrey() {
        // реализация поиска травоядных
    }

    public void attack(Herbivore prey) {
        // реализация атаки на травоядное
    }
}