package components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;

public class Board extends JPanel {
    int minHeight = 150;
    public Board(Color color, int x) {
        this.setBackground(Color.red);
        this.setLocation(x, 50);
        this.setSize(150, 150);
        this.setBackground(color);
        this.addContainerListener(new SizeHandler());
    }

    void resizeComponentRemoved(Component component) {
        if(this.getHeight()>minHeight)this.setSize(this.getWidth(), this.getHeight() - component.getHeight());
    }
}
class SizeHandler implements ContainerListener{
    int maxSize = 500;

    @Override
    public void componentAdded(ContainerEvent e) {
        if(e.getComponent() instanceof Board board){
            int panelHeight = board.getComponent(board.getComponentCount()-3).getPreferredSize().height;
           int currHeight  = panelHeight + board.getHeight();
           board.setSize(board.getWidth(), currHeight);

           if(currHeight>maxSize){
               TaskInputArea taskInputArea = (TaskInputArea)board.getComponent(board.getComponentCount()-2);
               taskInputArea.setEditable(false);
           }
       }
    }

    @Override
    public void componentRemoved(ContainerEvent e) {}
}

