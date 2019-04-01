package db2project;

import javax.swing.*;

public class Application {

    public static void main(String[] args){
        UI ui = new UI();

        JFrame frame = new JFrame("DB2-Project");
        frame.setContentPane(ui.getPanelMain());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);




    }
}
