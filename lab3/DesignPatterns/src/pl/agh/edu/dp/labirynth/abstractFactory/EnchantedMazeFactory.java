package pl.agh.edu.dp.labirynth.abstractFactory;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.Door;
import pl.agh.edu.dp.labirynth.Room;
import pl.agh.edu.dp.labirynth.Wall;
import pl.agh.edu.dp.labirynth.abstractFactory.enchanted.EnchantedDoor;
import pl.agh.edu.dp.labirynth.abstractFactory.enchanted.EnchantedRoom;
import pl.agh.edu.dp.labirynth.abstractFactory.enchanted.EnchantedWall;

public class EnchantedMazeFactory extends MazeFactory {

    private static EnchantedMazeFactory instance;

    public static MazeFactory getInstance(){
        if (instance == null){
            instance = new EnchantedMazeFactory();
        }
        return instance;
    }

    @Override
    public Door createDoor(Room room1, Room room2) {
        return new EnchantedDoor(room1, room2);
    }

    @Override
    public Wall createWall() {
        return new EnchantedWall();
    }

    @Override
    public Room createRoom(int number) {
        Room room = new EnchantedRoom(number);
        room.setSide(Direction.North, new Wall());
        room.setSide(Direction.East, new Wall());
        room.setSide(Direction.South, new Wall());
        room.setSide(Direction.West, new Wall());
        return room;
    }
}