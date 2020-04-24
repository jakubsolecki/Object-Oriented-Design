package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.labirynth.abstractFactory.MazeFactory;
import pl.agh.edu.dp.labirynth.builder.MazeBuilder;

public class MazeGame {
    public void createMaze(MazeBuilder builder, MazeFactory factory){
        Room r1 = factory.createRoom(0);
        Room r2 = factory.createRoom(1);
        Room r3 = factory.createRoom(2);
        Room r4 = factory.createRoom(3);
        Room r5 = factory.createRoom(4);
        Room r6 = factory.createRoom(5);
        Room r7 = factory.createRoom(6);
        builder.addRoom(r1);
        builder.addRoom(r2);
        builder.addRoom(r3);
        builder.addRoom(r4);
        builder.addRoom(r5);
        builder.addRoom(r6);
        builder.addRoom(r7);

        builder.createWallBetween(r1, r2,  Direction.East);
        builder.addDoor(factory.createDoor(r1, r2));
        builder.createWallBetween(r2, r3,  Direction.North);
        builder.addDoor(factory.createDoor(r2, r3));
        builder.createWallBetween(r2, r4,  Direction.East);
        builder.addDoor(factory.createDoor(r2, r4));
        builder.createWallBetween(r4, r5,  Direction.East);
        builder.addDoor(factory.createDoor(r4, r5));

        builder.createWallBetween(r1, r6,  Direction.West);
        builder.addDoor(factory.createDoor(r1, r6));

        builder.createWallBetween(r6, r7,  Direction.South);
        builder.addDoor(factory.createDoor(r6, r7));
    }
}
