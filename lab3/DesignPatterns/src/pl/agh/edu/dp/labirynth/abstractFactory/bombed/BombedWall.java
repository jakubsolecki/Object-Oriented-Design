package pl.agh.edu.dp.labirynth.abstractFactory.bombed;

import pl.agh.edu.dp.labirynth.Wall;

public class BombedWall extends Wall {
    public BombedWall() { super();}

    @Override
    public void Enter() {
        System.out.println("This is room Wall");
    }
}
