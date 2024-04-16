import components.TaskPanel;
import components.TodoBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class MainWindow extends JFrame{

    JPanel doing, done;
    TodoBoard todoBoard;
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
        doing = new JPanel();
        done = new JPanel();


        doing.setBackground(Color.yellow);
        done.setBackground(Color.green);

        Dimension panelSize = new Dimension(150, 300);

        doing.setPreferredSize(panelSize);
        done.setPreferredSize(panelSize);

        this.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 0));
        this.add(todoBoard);
        this.add(doing);
        this.add(done);
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
            TaskPanel todoTaskPanel = new TaskPanel(todoBoard, todoTextField.getText());
            todoBoard.add(todoTaskPanel, todoBoard.getComponentCount()-2);
            todoBoard.revalidate();
        });
        todoBoard.add(addButton);
    }
}