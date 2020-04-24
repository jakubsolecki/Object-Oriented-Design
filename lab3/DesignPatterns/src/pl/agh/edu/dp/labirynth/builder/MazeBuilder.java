package pl.agh.edu.dp.labirynth.builder;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.Door;
import pl.agh.edu.dp.labirynth.Room;

public interface MazeBuilder{
    void addRoom(Room room);
    void addDoor(Door door);
    void createWallBetween(Room room1, Room room2, Direction r1Wall);
}

