package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.labirynth.visualization.analyzer.Vector2D;

public enum Direction {
    North, South, East, West;

    public Direction getOppositeDirection(){
        switch (this){
            case North: return South;
            case South: return North;
            case East: return West;
            case West: return  East;
        }
        return null;
    }

    public Vector2D toVector(){
        switch (this){
            case North: return new Vector2D(0, 1);
            case South: return new Vector2D(0, -1);
            case East: return new Vector2D(1, 0);
            case West: return  new Vector2D(-1, 0);
        }
        return null;
    }
}