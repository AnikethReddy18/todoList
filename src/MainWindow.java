import components.*;

import javax.swing.*;
import java.awt.*;



class MainWindow extends JFrame{

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
        DoingBoard doingBoard = new DoingBoard();
        DoneBoard doneBoard = new DoneBoard();
        TodoBoard todoBoard = new TodoBoard(doingBoard, doneBoard);

        this.setLayout(null);
        this.add(todoBoard);
        this.add(doingBoard);
        this.add(doneBoard);
    }
}