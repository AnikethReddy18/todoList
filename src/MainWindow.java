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

        this.pack();
        this.setLocationRelativeTo(null);
    }

    private void makePanels(){
        doingBoard = new DoingBoard();
        doneBoard = new DoneBoard();
        todoBoard = new TodoBoard(doingBoard, doneBoard);

        this.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 0));
        this.add(todoBoard);
        this.add(doingBoard);
        this.add(doneBoard);
    }
}