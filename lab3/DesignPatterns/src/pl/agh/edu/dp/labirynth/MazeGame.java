package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.labirynth.abstractFactory.MazeFactory;
import pl.agh.edu.dp.labirynth.builder.MazeBuilder;

public class MazeGame {
    public void createMaze(MazeBuilder builder, MazeFactory factory){
        Room r1 = factory.createRoom(1);
        Room r2 = factory.createRoom(2);
        builder.addRoom(r1);
        builder.addRoom(r2);

        builder.createWallBetween(r1, r2,  Direction.East);
        builder.addDoor(factory.createDoor(r1, r2));
    }
}
