package pl.agh.edu.dp.main;

import pl.agh.edu.dp.labirynth.*;
import pl.agh.edu.dp.labirynth.abstractFactory.BombedMazeFactory;
import pl.agh.edu.dp.labirynth.abstractFactory.EnchantedMazeFactory;
import pl.agh.edu.dp.labirynth.abstractFactory.MazeFactory;
import pl.agh.edu.dp.labirynth.builder.CountingMazeBuilder;
import pl.agh.edu.dp.labirynth.builder.StandardMazeBuilder;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        MazeGame mazeGame = new MazeGame();
        MazeFactory mazeFactory = MazeFactory.getInstance();
        CountingMazeBuilder builderC = new CountingMazeBuilder();
        StandardMazeBuilder builderS = new StandardMazeBuilder();
        mazeGame.createMaze(builderC, mazeFactory);
        mazeGame.createMaze(builderS, mazeFactory);

        Player player = new Player(builderS.getCurrentMaze());

        while (true){
            char input = (char) System.in.read();

            switch(input){
                case 'E': player.move(Direction.East); break;
                case 'W': player.move(Direction.West); break;
                case 'N': player.move(Direction.North); break;
                case 'S': player.move(Direction.South); break;
                case 'Z': System.exit(0);
            }
        }
    }
}



