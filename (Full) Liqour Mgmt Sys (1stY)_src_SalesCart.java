import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class SalesCart extends SalesFrame implements WindowListener {
    SalesDatabase data;
    public SalesCart() {
        setLayout(null);
        add(new SalesSearch()).setBounds(340,20,310,30);
        add(new SalesPanelTable()).setBounds(325,50,470,210);
        add(new SalesPanelButtons()).setBounds(40, 267, 600, 30);

        addWindowListener(this);
        setResizable(false);
        setMyFrame("Sales Cart", 800, 353, true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);



    }

    @Override
    public void windowOpened(WindowEvent windowEvent) {

    }

    @Override
    public void windowClosing(WindowEvent windowEvent) {

    }

    @Override
    public void windowClosed(WindowEvent windowEvent) {

    }

    @Override
    public void windowIconified(WindowEvent windowEvent) {

    }

    @Override
    public void windowDeiconified(WindowEvent windowEvent) {

    }

    @Override
    public void windowActivated(WindowEvent windowEvent) {

    }

    @Override
    public void windowDeactivated(WindowEvent windowEvent) {

    }
}
