import org.junit.Assert;
import org.junit.Test;
import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.Maze;
import pl.agh.edu.dp.labirynth.Room;
import pl.agh.edu.dp.labirynth.abstractFactory.MazeFactory;
import pl.agh.edu.dp.labirynth.builder.StandardMazeBuilder;
import pl.agh.edu.dp.labirynth.visualization.analyzer.MazeAnalyzer;
import pl.agh.edu.dp.labirynth.visualization.analyzer.Vector2D;

import java.util.ArrayList;
import java.util.List;

public class MazeAnalyzerTest {
    private final Maze maze;

    public MazeAnalyzerTest(){
        MazeFactory factory = MazeFactory.getInstance();
        StandardMazeBuilder builder = new StandardMazeBuilder();
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


        this.maze = builder.getCurrentMaze();
    }
    //map:
    //  #
    //#F###
    //#
    // F -> first room

    @Test
    public void analyzeTest(){
        MazeAnalyzer analyzer = new MazeAnalyzer(this.maze);
        List<Vector2D> correct = new ArrayList<>();
        correct.add(new Vector2D(1,1));
        correct.add(new Vector2D(2,1));
        correct.add(new Vector2D(2,2));
        correct.add(new Vector2D(3,1));
        correct.add(new Vector2D(4,1));
        correct.add(new Vector2D(0,1));
        correct.add(new Vector2D(0,0));

        Assert.assertEquals(correct, analyzer.getPositionList());


    }
}
