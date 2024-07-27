package entiity.movingEntities;

import entiity.Entity;
import gameMap.GameMap;

public abstract class Creature extends Entity {

    protected int speed;
    protected int hp;


    public Creature(int x, int y, int hp, int speed) {
        super(x, y);
        this.speed = speed;
        this.hp = hp;
    }

    public abstract void makeMove(GameMap gameMap);

    public int getSpeed() {
        return speed;
    }

    public int getHp() {
        return hp;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setHp(int speed) {
        this.speed = speed;
    }


}
