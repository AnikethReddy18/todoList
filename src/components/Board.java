package components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;

public class Board extends JPanel {
    public Board(Color color){
        this.setBackground(Color.red);
        Dimension initialSize = new Dimension(150, 0);

        this.setPreferredSize(initialSize);
        this.setBackground(color);
        SizeHandler sizeHandler = new SizeHandler(this);
        this.addContainerListener(sizeHandler);
    }
}

class SizeHandler implements ContainerListener{
    private final Board board;
    private final int boardWidth;
    private  int boardHeight;

    SizeHandler(Board board) {
        this.board = board;
        this.boardWidth = board.getPreferredSize().width;
        this.boardHeight = board.getPreferredSize().height;
    }

    @Override
    public void componentAdded(ContainerEvent e) {
        boardHeight += 50;
        board.setPreferredSize(new Dimension(boardWidth, boardHeight));
    }

    @Override
    public void componentRemoved(ContainerEvent e) {

    }
}
