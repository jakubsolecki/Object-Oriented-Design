package pl.agh.edu.dp.labirynth.visualization;

import javax.swing.*;

public class GUI extends JFrame implements Router{
    private final GamePanel gamePanel;

    public GUI(){
        super("aMAZE'ing game");
        this.gamePanel = new GamePanel(this);
        this.setSize(800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        getContentPane().add(this.gamePanel);

    }

    @Override
    public void RouteTo(JPanel panel) {
        ;
    }
}
