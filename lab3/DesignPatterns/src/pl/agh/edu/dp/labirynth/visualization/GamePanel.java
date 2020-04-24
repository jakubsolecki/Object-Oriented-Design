package pl.agh.edu.dp.labirynth.visualization;

import pl.agh.edu.dp.labirynth.Maze;
import pl.agh.edu.dp.labirynth.MazeGame;
import pl.agh.edu.dp.labirynth.abstractFactory.MazeFactory;
import pl.agh.edu.dp.labirynth.builder.CountingMazeBuilder;
import pl.agh.edu.dp.labirynth.builder.StandardMazeBuilder;
import pl.agh.edu.dp.labirynth.visualization.analyzer.MazeAnalyzer;
import pl.agh.edu.dp.labirynth.visualization.analyzer.Vector2D;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GamePanel extends JPanel{
    private final Router router;
    private final List<Vector2D> roomVectorList;
    private final Maze maze;
    private final Vector2D upperRight;


    public GamePanel(Router router){
        super();
        MazeGame mazeGame = new MazeGame();
        MazeFactory mazeFactory = MazeFactory.getInstance();
        StandardMazeBuilder builder = new StandardMazeBuilder();
        mazeGame.createMaze(builder, mazeFactory);
        this.maze = builder.getCurrentMaze();

        this.roomVectorList = new MazeAnalyzer(this.maze).getPositionList();
        Vector2D vectorMax = new Vector2D(Integer.MIN_VALUE, Integer.MIN_VALUE);
        for (Vector2D vector2D : this.roomVectorList){
            vectorMax = vector2D.upperRight(vectorMax);
        }
        this.upperRight = vectorMax;
        System.out.println(this.upperRight);


        this.router = router;
        GridLayout layout = new GridLayout(upperRight.getY() + 1, upperRight.getX() + 1);
        this.setLayout(layout);

        for (int row = 2; row >= 0; row--){
            for (int column = 0; column < upperRight.getX() + 1; column++){
                if (roomVectorList.contains(new Vector2D(column, row))){
                    add(new JButton("ROOM"));
                }else{
                    add(new JButton("N"));
                }

            }
        }


    }

}
