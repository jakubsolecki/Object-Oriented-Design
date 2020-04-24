package pl.agh.edu.dp.labirynth.abstractFactory.enchanted;

import pl.agh.edu.dp.labirynth.Wall;

public class EnchantedWall extends Wall {
    public EnchantedWall(){
        super();
    }

    @Override
    public void Enter() {
        System.out.println("This is enchanted Wall");
    }
}