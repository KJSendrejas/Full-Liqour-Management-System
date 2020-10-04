

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class SalesMain extends SalesFrame implements WindowListener, ActionListener {
    SalesDatabase data;

    public SalesMain() {
        setLayout(null);
        add(new SalesCustomer_EmployeeInfo()).setBounds(10,10,300,70);
        add(new SalesPanelInfo()).setBounds(10,91,300,207);
        add(new SalesSearch()).setBounds(340,20,310,30);
        add(new SalesPanelTable()).setBounds(325,50,470,210);
        add(new SalesPanelButtons()).setBounds(341, 265, 300, 33);

        addWindowListener(this);
        setResizable(true);
        setMyFrame("Sales Form", 829, 353, true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        SalesPanelButtons.btnAddtoCart.setEnabled(false);
        SalesPanelButtons.btnShowCart.setEnabled(true);
        SalesPanelButtons.btnShowCart.addActionListener(this::actionPerformed);



    }
    public static void main(String[] args) {
        new SalesMain();
    }

    public void windowOpened(WindowEvent e) { }
    public void windowClosing(WindowEvent e) {
        String records="";
        data=new SalesDatabase("TrashCan.txt");
        for (int i = 0; i < SalesPanelTable.modelSales.getRowCount(); i++) {
            for (int a = 0; a < SalesPanelTable.modelSales.getColumnCount(); a++) {
                records+=SalesPanelTable.modelSales.getValueAt(i, a)+"#";
            }
        }
        data.storeToFile(records);
        new MainMenu();
        dispose();


    }
    public void windowClosed(WindowEvent e) {
    }
    public void windowIconified(WindowEvent e) { }
    public void windowDeiconified(WindowEvent e) { }
    public void windowActivated(WindowEvent e) { }
    public void windowDeactivated(WindowEvent e) { }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(SalesPanelButtons.btnShowCart)) {
            new CartMain();
            dispose();
        }
    }
}
