package components;

import javax.swing.*;
import java.awt.*;

public class TaskPanel extends JPanel {
    public TaskPanel(TodoBoard todoBoard, String text){
        JLabel taskLabel = new JLabel();
        JCheckBox taskCheckBox = new JCheckBox();

        taskLabel.setText(text);
        taskCheckBox.addActionListener(e->{
            todoBoard.remove(this);
            todoBoard.revalidate();
        });

        this.add(taskLabel);
        this.add(taskCheckBox);
    }

}


