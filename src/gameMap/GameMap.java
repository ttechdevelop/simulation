package gameMap;

import entiity.Entity;
import entiity.movingEntities.Herbivore;
import entiity.movingEntities.Predator;
import entiity.staticEntities.Grass;
import java.util.ArrayList;
import java.util.List;

public class GameMap {

    private int width;
    private int height;
    private List<Entity> entities;

    public GameMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.entities = new ArrayList<>();
    }

    public void render() {
        char[][] map = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                map[i][j] = '.';
            }
        }

        for (Entity entity : entities) {
            char symbol = ' ';
            if (entity instanceof Grass) {
                symbol = 'G';
            } else if (entity instanceof Herbivore) {
                symbol = 'H';
            } else if (entity instanceof Predator) {
                symbol = 'P';
            }
            map[entity.getY()][entity.getX()] = symbol;
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean isValidPosition(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public void removeEntity(Entity entity) {
        entities.remove(entity);
    }

    public Entity getEntityAt(int x, int y) {
        for (Entity entity : entities) {
            if (entity.getX() == x && entity.getY() == y) {
                return entity;
            }
        }
        return null;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}