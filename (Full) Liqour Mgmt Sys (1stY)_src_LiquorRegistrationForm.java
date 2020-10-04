
import com.sun.tools.javac.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class LiquorRegistrationForm extends MyFrame implements WindowListener, ActionListener{
    Database data;
    public LiquorRegistrationForm() {
        setLayout(null);
        add(new PanelInfo()).setBounds(10,10,300,250);
        add(new PanelSearch()).setBounds(340,20,310,30);
        add(new PanelTable()).setBounds(340,50,470,210);
        add(new PanelButtons()).setBounds(40, 267, 600, 30);

        addWindowListener(this);
        setResizable(false);
        setMyFrame("Liquor Registration Form", 839, 353, true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        addWindowListener(this);
        PanelButtons.btnDelete.setEnabled(false);
        PanelButtons.btnUpdate.setEnabled(false);
        PanelButtons.btnAdd.setEnabled(true);
        PanelButtons.btnClear.setEnabled(true);

        PanelButtons.btnClose.addActionListener(this::actionPerformed);


    }
    public static void main(String[] args) {
        new LiquorRegistrationForm();
    }

    public void windowOpened(WindowEvent e) { }
    public void windowClosing(WindowEvent e) {
        String records="";
        data=new Database("LiquorStorage.txt");
        for (int i = 0; i < PanelTable.modelLiquor.getRowCount(); i++) {
            for (int a = 0; a < PanelTable.modelLiquor.getColumnCount(); a++) {
                records+=PanelTable.modelLiquor.getValueAt(i, a)+"#";
            }
        }
        data.storeToFile(records);
    }
    public void windowClosed(WindowEvent e) { }
    public void windowIconified(WindowEvent e) { }
    public void windowDeiconified(WindowEvent e) { }
    public void windowActivated(WindowEvent e) { }
    public void windowDeactivated(WindowEvent e) { }

    @Override
    public void actionPerformed(ActionEvent actEvent) {
        if (actEvent.getSource().equals(PanelButtons.btnClose)){
            new MainMenu();
            dispose();

        }
    }
}
