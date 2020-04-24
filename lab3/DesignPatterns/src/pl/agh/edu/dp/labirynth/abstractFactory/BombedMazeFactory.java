package pl.agh.edu.dp.labirynth.abstractFactory;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.Room;
import pl.agh.edu.dp.labirynth.Wall;
import pl.agh.edu.dp.labirynth.abstractFactory.bombed.BombedRoom;
import pl.agh.edu.dp.labirynth.abstractFactory.bombed.BombedWall;

public class BombedMazeFactory extends MazeFactory {

    private static BombedMazeFactory instance;

    public static MazeFactory getInstance(){
        if (instance == null){
            instance = new BombedMazeFactory();
        }
        return instance;
    }

    public BombedMazeFactory() {
        super();
    }

    @Override
    public Wall createWall() {
        return new BombedWall();
    }

    @Override
    public Room createRoom(int number) {
        Room room = new BombedRoom(number);
        room.setSide(Direction.North, new Wall());
        room.setSide(Direction.East, new Wall());
        room.setSide(Direction.South, new Wall());
        room.setSide(Direction.West, new Wall());
        return room;
    }
}