package components;

import javax.swing.*;
import java.awt.*;

public class TaskPanel extends JPanel {

    public TaskPanel(TodoBoard todoBoard, DoingBoard doingBoard, DoneBoard doneBoard,String text){
        JLabel taskLabel = new JLabel();
        JCheckBox taskCheckBox = new JCheckBox();
        taskLabel.setForeground(Color.blue);
        taskLabel.setText(text);

        taskCheckBox.addActionListener(e->{
            todoBoard.remove(this);
            todoBoard.revalidate();
            todoBoard.repaint();

            new TaskPanel(doingBoard, doneBoard, text);
        });

        this.add(taskLabel);
        this.add(taskCheckBox);
    }

    private TaskPanel(DoingBoard doingBoard, DoneBoard doneBoard,String text){
        JLabel taskLabel = new JLabel();
        JCheckBox taskCheckBox = new JCheckBox();

        taskLabel.setText(text);
        taskCheckBox.addActionListener(e->{
            doingBoard.remove(this);
            doingBoard.revalidate();
            doingBoard.repaint();

            new TaskPanel(doneBoard, text);
        });

        this.add(taskLabel);
        this.add(taskCheckBox);
        doingBoard.add(this);
    }

    private TaskPanel(DoneBoard doneBoard, String text){
        JLabel taskLabel = new JLabel();
        JCheckBox taskCheckBox = new JCheckBox();

        taskLabel.setText(text);
        taskCheckBox.addActionListener(e->{
            doneBoard.remove(this);
            doneBoard.revalidate();
            doneBoard.repaint();
        });

        this.add(taskLabel);
        this.add(taskCheckBox);
        doneBoard.add(this);
    }

}


