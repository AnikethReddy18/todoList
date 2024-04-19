package components;

import javax.swing.*;
import java.awt.*;

public class DoneBoard extends Board {
    public DoneBoard(){
        super(Color.green, 450);
        makeTitle();
    }
    private void makeTitle(){
        JLabel titleLabel = new JLabel("DONE:");
        this.add(titleLabel);
    }
}