import javax.swing.*;
import java.awt.*;

class MainWindow extends JFrame{

    MainWindow(){
        this.setTitle("Todo Lister");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(650, 600));

        makePanels();

        this.pack();
        this.setLocationRelativeTo(null);
    }

    private void makePanels(){
        JPanel todo = new JPanel();
        JPanel doing = new JPanel();
        JPanel done = new JPanel();

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
}
public class Main {
    public static void main(String[] args) {
        new MainWindow();
    }
}