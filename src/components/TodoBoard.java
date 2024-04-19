package components;


import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class TodoBoard extends Board {
    TaskInputArea todoTextField;
    DoingBoard doingBoard;
    DoneBoard doneBoard;
    public TodoBoard(DoingBoard doingBoard, DoneBoard doneBoard){
        super(Color.red, 50);
        this.doingBoard = doingBoard;
        this.doneBoard = doneBoard;

        makeTextField();
        makeButtons();
    }

    private void makeTextField(){
        todoTextField = new TaskInputArea();
        todoTextField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                int todoTextFieldHeight = todoTextField.getHeight();
                increaseSize(todoTextFieldHeight);
            }
            @Override
            public void keyPressed(KeyEvent e) {}
            @Override
            public void keyReleased(KeyEvent e) {}
        });
        this.add(todoTextField);
    }

    private void makeButtons(){
        JButton addButton = new JButton("Add");

        addButton.addActionListener(e->{
            TaskPanel todoTaskPanel = new TaskPanel(this, doingBoard, doneBoard, todoTextField.getText());
            this.add(todoTaskPanel, this.getComponentCount()-2);
            this.revalidate();
        });
        this.add(addButton);
    }

    private void increaseSize(int increment){
        int newHeight = this.getHeight() + increment;
        this.setSize(this.getWidth(), newHeight);
    }
}

