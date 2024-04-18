package components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;

public class Board extends JPanel {
    public Board(Color color, int x){
        this.setBackground(Color.red);
        this.setLocation(x, 50);
        this.setSize(150, 50);
        this.setBackground(color);
        this.addContainerListener(new SizeHandler());
    }
}

class SizeHandler implements ContainerListener{

    @Override
    public void componentAdded(ContainerEvent e) {
        Board board = (Board)e.getComponent();
        int newHeight = board.getHeight()+50;

        System.out.println(newHeight);
        if(newHeight<500)board.setSize(board.getWidth(),newHeight);
    }

    @Override
    public void componentRemoved(ContainerEvent e) {
        Board board = (Board)e.getComponent();
        int newHeight = board.getHeight()-50;

        if(newHeight>150)board.setSize(board.getWidth(),newHeight);
    }
}
