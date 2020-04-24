package pl.agh.edu.dp.labirynth;

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
}