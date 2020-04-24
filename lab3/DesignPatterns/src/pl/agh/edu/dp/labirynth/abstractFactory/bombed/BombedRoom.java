package pl.agh.edu.dp.labirynth.abstractFactory.bombed;

import pl.agh.edu.dp.labirynth.Room;

public class BombedRoom extends Room {
    public BombedRoom(int number) { super(number); }

    @Override
    public void Enter() {
        System.out.println("You've entered bombed room");
    }
}