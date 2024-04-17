package components;


import javax.swing.*;

public class TaskInputArea extends JTextArea {
     public TaskInputArea(){
         this.setColumns(14);
         this.setRows(1);
     }

     public String getText(){
         String text = super.getText();
         text = "<html>" + text.replace("\n", "<br>") + "</html>";
         return text;
     }
}
