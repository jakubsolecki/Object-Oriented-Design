package pl.agh.edu.dp.labirynth.visualization;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel{
    private final Router router;

    public GamePanel(Router router){
        super();
        this.router = router;
        GridLayout layout = new GridLayout(2,2);
        this.setLayout(layout);
        this.add(new JButton("button"));
        this.add(new JButton("button"));
        this.add(new JButton("button"));
        this.add(new JButton("button"));
    }
}
