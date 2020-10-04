
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class CartMain extends SalesFrame implements WindowListener{
    CartDatabase data;
    public CartMain() {
        setLayout(null);
        add(new CartTable()).setBounds(1,30,732,230);
        add(new CartButtons()).setBounds(40, 267, 600, 30);

        addWindowListener(this);
        setResizable(false);
        setMyFrame("Sales Cart", 750, 353, true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);



    }
    public static void main(String[] args) {
        new CartMain();
    }

    public void windowOpened(WindowEvent e) { }
    public void windowClosing(WindowEvent e) {
        String records="";
        data=new CartDatabase("CartStorage.txt");
        for (int i = 0; i < SalesPanelTable.modelSales.getRowCount(); i++) {
            for (int a = 0; a < SalesPanelTable.modelSales.getColumnCount(); a++) {
                records+=SalesPanelTable.modelSales.getValueAt(i, a)+"#";
            }
        }
        data.storeToFile(records);
        new SalesMain();
        dispose();
    }
    public void windowClosed(WindowEvent e) { }
    public void windowIconified(WindowEvent e) { }
    public void windowDeiconified(WindowEvent e) { }
    public void windowActivated(WindowEvent e) { }
    public void windowDeactivated(WindowEvent e) { }
}
