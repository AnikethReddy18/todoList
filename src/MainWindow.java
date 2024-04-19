import components.*;

import javax.swing.*;
import java.awt.*;



class MainWindow extends JFrame{

    DoneBoard doneBoard;
    TodoBoard todoBoard;
    DoingBoard doingBoard;

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

        this.setLayout(null);
        this.add(todoBoard);
        this.add(doingBoard);
        this.add(doneBoard);
    }
}