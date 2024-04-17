import components.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class MainWindow extends JFrame{

    DoneBoard doneBoard;
    TodoBoard todoBoard;
    DoingBoard doingBoard;
    JTextArea todoTextField;

    MainWindow() {
        this.setTitle("Todo Lister");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(650, 600));

        makePanels();
        makeTextField();
        makeButtons();

        this.pack();
        this.setLocationRelativeTo(null);
    }

    private void makePanels(){
        todoBoard = new TodoBoard();
        doingBoard = new DoingBoard();
        doneBoard = new DoneBoard();


        this.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 0));
        this.add(todoBoard);
        this.add(doingBoard);
        this.add(doneBoard);
    }

    private void makeTextField(){
        todoTextField = new TaskInputArea();
        todoBoard.add(todoTextField);
    }

    private void makeButtons(){
        JButton addButton = new JButton("Add");

        addButton.addActionListener(e->{
            TaskPanel todoTaskPanel = new TaskPanel(todoBoard, doingBoard, doneBoard, todoTextField.getText());
            todoBoard.add(todoTaskPanel, todoBoard.getComponentCount()-2);
            todoBoard.revalidate();
        });
        todoBoard.add(addButton);
    }
}