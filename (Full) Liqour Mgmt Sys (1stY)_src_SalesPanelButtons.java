import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SalesPanelButtons extends JPanel{
    static JButton btnAddtoCart, btnClose, btnShowCart;
    SalesListener listen=new SalesListener();

    public SalesPanelButtons() {

        btnAddtoCart =new JButton("Add to Cart");
        btnShowCart = new JButton("Show Cart");
        btnClose=new JButton("Close");
        setLayout(new GridLayout(1, 2, 4,2));
        add(btnAddtoCart);
        add(new JLabel(""));
        add(btnShowCart);
        btnAddtoCart.addActionListener(listen);
        btnClose.addActionListener(listen);
        btnShowCart.addActionListener(listen);
    }
}