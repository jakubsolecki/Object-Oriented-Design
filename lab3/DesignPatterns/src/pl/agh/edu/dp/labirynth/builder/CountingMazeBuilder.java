package pl.agh.edu.dp.labirynth.builder;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.Door;
import pl.agh.edu.dp.labirynth.Room;

public class CountingMazeBuilder implements MazeBuilder {
    private int doors;
    private int walls;
    private int rooms;

    public int getCounts(){
        return rooms + doors + walls;
    }

    public CountingMazeBuilder() {
        this.doors = 0;
        this.walls = 0;
        this.rooms = 0;
    }

    @Override
    public void addRoom(Room room) {
        this.rooms += 1;
        this.walls += 4;
    }

    @Override
    public void addDoor(Door door) {
        this.doors += 1;
        this.walls -= 1;
    }

    @Override
    public void createWallBetween(Room room1, Room room2, Direction r1Wall) {
        this.walls -= 1;
    }
}