package components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class TodoBoard extends Board {
    TaskInputArea todoTextField;
    DoingBoard doingBoard;
    DoneBoard doneBoard;
    int todoTextFieldHeight = 16;
    public TodoBoard(DoingBoard doingBoard, DoneBoard doneBoard){
        super(Color.red, 50);
        this.doingBoard = doingBoard;
        this.doneBoard = doneBoard;

        makeTitle();
        makeTextField();
        makeButtons();
    }

    private void makeTextField(){
        todoTextField = new TaskInputArea();
        this.add(todoTextField);
        todoTextField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                int newTodoTextFieldHeight = todoTextField.getHeight();
                if(todoTextFieldHeight != newTodoTextFieldHeight){
                    changeSize(newTodoTextFieldHeight - todoTextFieldHeight);
                }
                todoTextFieldHeight = newTodoTextFieldHeight;
            }

            @Override
            public void keyPressed(KeyEvent e) {}
            @Override
            public void keyReleased(KeyEvent e) {}
        });
    }

    private void makeButtons(){
        JButton addButton = new JButton("Add");

        addButton.addActionListener(e->{
            TaskPanel todoTaskPanel = new TaskPanel(this, doingBoard, doneBoard, todoTextField.getText());
            todoTextField.setText("");
            todoTextField.requestFocusInWindow();
            this.add(todoTaskPanel, this.getComponentCount()-2);
            this.revalidate();
        });
        this.add(addButton);
    }

    private void changeSize(int change){
        int newHeight = this.getHeight() + change;
        this.setSize(this.getWidth(), newHeight);
    }
    private void makeTitle(){
        JLabel titleLabel = new JLabel("TODO:");
        this.add(titleLabel);
    }
}

