
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Customer extends CustoFrame implements WindowListener, ActionListener {
    CustoDatabase data;

    public static void main(String[] args) {
        new Customer();
    }
    public Customer() {
        setLayout(null);
        add(new CustoPanelInfo()).setBounds(10,10,250,215);
        add(new CustoPanelSearch()).setBounds(280,20,310,30);
        add((new CustoPanelTable())).setBounds(237,50,500,170);
        add(new CustoPanelButtons()).setBounds(45, 240, 550, 23);

        addWindowListener(this);
        setResizable(false);
        setMyFrame("Customer Registration Form", 750, 310, true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        CustoPanelButtons.btnClose.addActionListener(this::actionPerformed);

        CustoPanelButtons.btnDelete.setEnabled(false);
        CustoPanelButtons.btnUpdate.setEnabled(false);
        CustoPanelButtons.btnAdd.setEnabled(true);
        CustoPanelButtons.btnClear.setEnabled(true);


    }


    public void windowOpened(WindowEvent e) { }
    public void windowClosing(WindowEvent e) {
        String records="";
        data=new CustoDatabase("CustomerInfo.txt");
        for (int i = 0; i < CustoPanelTable.modelCustomer.getRowCount(); i++) {
            for (int a = 0; a < CustoPanelTable.modelCustomer.getColumnCount(); a++) {
                records+= CustoPanelTable.modelCustomer.getValueAt(i, a)+"#";
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
        if (actEvent.getSource().equals(CustoPanelButtons.btnClose)){
            new MainMenu();
            dispose();
        }
    }
}
