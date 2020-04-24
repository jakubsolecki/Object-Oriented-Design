package pl.agh.edu.dp.labirynth.abstractFactory.enchanted;

import pl.agh.edu.dp.labirynth.Door;
import pl.agh.edu.dp.labirynth.Room;

public class EnchantedDoor extends Door {
    public EnchantedDoor(Room r1, Room r2) {
        super(r1, r2);
    }

    @Override
    public void Enter() {
        System.out.println("This is enchanted Door");
    }
}