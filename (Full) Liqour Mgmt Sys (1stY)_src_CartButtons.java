import javax.swing.*;
import java.awt.*;

public class CartButtons extends JPanel {
    static JButton btnCheckout, btnDelete;

    public CartButtons(){
        btnCheckout = new JButton("Check out");
        btnDelete = new JButton("Delete");
        setLayout(new GridLayout(1, 5, 4,2));
        add(btnCheckout);
        add(new JLabel(""));
        add(btnDelete);
    }
}
