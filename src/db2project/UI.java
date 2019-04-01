package db2project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI {
    private JButton buttonTest;
    private JPanel panelMain;
    private DBManager dbManager;

    public UI() {
        dbManager = new DBManager();

        buttonTest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String res = dbManager.createQuery("select * from hotel");
                JOptionPane.showMessageDialog(null, res);
            }
        });
    }

    public JPanel getPanelMain(){
        return this.panelMain;
    }


}
