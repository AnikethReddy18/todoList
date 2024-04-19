package components;

import javax.swing.*;
import java.awt.*;

public class DoingBoard extends Board {
    public DoingBoard(){
        super(Color.yellow, 250);
        makeTitle();
    }
    private void makeTitle(){
        JLabel titleLabel = new JLabel("DOING:");
        this.add(titleLabel);
    }
}
