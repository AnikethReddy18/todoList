import components.DoingBoard;
import components.DoneBoard;
import components.TaskPanel;
import components.TodoBoard;

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
        todoTextField = new JTextArea();
        todoTextField.setColumns(14);
        todoTextField.setRows(2);
        todoTextField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    todoTextField.setRows(todoTextField.getRows() + 1);
                } else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    try {
                        todoTextField.setRows(todoTextField.getRows() - 1);
                    }
                    catch (IllegalArgumentException ignored){
                        todoTextField.setRows(2);
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
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