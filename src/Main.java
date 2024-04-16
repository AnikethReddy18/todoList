import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MainWindow extends JFrame{

    JPanel todo, doing, done;
    JTextArea j;

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
        todo = new JPanel();
        doing = new JPanel();
        done = new JPanel();

        todo.setBackground(Color.red);
        doing.setBackground(Color.yellow);
        done.setBackground(Color.green);

        Dimension panelSize = new Dimension(150, 300);
        todo.setPreferredSize(panelSize);
        doing.setPreferredSize(panelSize);
        done.setPreferredSize(panelSize);

        this.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 0));
        this.add(todo);
        this.add(doing);
        this.add(done);
    }

    private void makeTextField(){
        j = new JTextArea();
        j.setColumns(14);
        j.setRows(2);
        j.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    j.setRows(j.getRows() + 1);
                } else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    try {
                        j.setRows(j.getRows() - 1);
                    }
                    catch (IllegalArgumentException ignored){
                        j.setRows(2);
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        todo.add(j);
    }

    private void makeButtons(){
        JButton addButton = new JButton("Add");

        addButton.addActionListener(e->{
            JLabel l = new JLabel();
            l.setPreferredSize(new Dimension(140, 20));
            l.setText(j.getText());
            l.setOpaque(true);
            l.setBackground(Color.white);
            todo.add(l, todo.getComponentCount()-2);
            todo.revalidate();
        });
        todo.add(addButton);
    }
}

public class Main {
    public static void main(String[] args) {
        new MainWindow();
    }
}