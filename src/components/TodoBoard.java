package components;


import javax.swing.*;
import java.awt.*;


public class TodoBoard extends Board {
    TaskInputArea todoTextField;
    DoingBoard doingBoard;
    DoneBoard doneBoard;
    public TodoBoard(DoingBoard doingBoard, DoneBoard doneBoard){
        super(Color.red);

        this.doingBoard = doingBoard;
        this.doneBoard = doneBoard;
        makeTextField();
        makeButtons();
    }

    private void makeTextField(){
        todoTextField = new TaskInputArea();
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
}

