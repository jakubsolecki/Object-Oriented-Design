package pl.agh.edu.dp.labirynth.abstractFactory.enchanted;

import pl.agh.edu.dp.labirynth.Room;

public class EnchantedRoom extends Room {
    public EnchantedRoom(int number) {
        super(number);
    }

    @Override
    public void Enter() {
        System.out.println("You've entered enchanted room! ");
    }
}