package pl.agh.edu.dp.labirynth.builder;

import pl.agh.edu.dp.labirynth.*;
import pl.agh.edu.dp.labirynth.builder.MazeBuilder;

public class StandardMazeBuilder implements MazeBuilder {
    private Maze currentMaze;

    public StandardMazeBuilder(){
        this.currentMaze = new Maze();
    }

    private Direction commonWall(Room room1, Room room2){
        for (Direction direction : Direction.values()){
            MapSite site = room1.getSide(direction);
            if (site.equals(room2.getSide(direction.getOppositeDirection()))){
                return direction;
            }
        }
        return null;
    }

    @Override
    public void addRoom(Room room) {
        currentMaze.addRoom(room);
    }

    @Override
    public void addDoor(Door door) {
        Direction commonWall = commonWall(door.getRoom1(), door.getRoom2());
        if (commonWall == null){
            return;
        }

        door.getRoom1().setSide(commonWall, door);
        door.getRoom2().setSide(commonWall.getOppositeDirection(), door);
    }

    @Override
    public void createWallBetween(Room room1, Room room2, Direction r1Wall) {
        MapSite site = room1.getSide(r1Wall);
        room2.setSide(r1Wall.getOppositeDirection(), site);
    }

    public Maze getCurrentMaze() {
        return currentMaze;
    }
}
