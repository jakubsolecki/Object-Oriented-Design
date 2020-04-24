package pl.agh.edu.dp.labirynth.abstractFactory;

import pl.agh.edu.dp.labirynth.*;

public class MazeFactory {
    private static MazeFactory instance;

    public static MazeFactory getInstance(){
        if (instance == null){
            instance = new MazeFactory();
        }
        return instance;
    }

    public Door createDoor(Room room1, Room room2){
        return new Door(room1, room2);
    }

    public Wall createWall(){
        return new Wall();
    }

    public Room createRoom(int number){
        Room room = new Room(number);
        room.setSide(Direction.North, new Wall());
        room.setSide(Direction.East, new Wall());
        room.setSide(Direction.South, new Wall());
        room.setSide(Direction.West, new Wall());
        return room;
    }
}
