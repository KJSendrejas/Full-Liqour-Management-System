import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class SalesPanelInfo extends JPanel implements ActionListener, MouseListener, KeyListener, ItemListener {
    JLabel lblProduct, lblCompany, lblType,lblPrice;
    static JTextField txtSerialNum, txtProduct,  txtPrice;
    static JComboBox  cboCompany,cboType;
    Font font=new Font("Arial", Font.BOLD, 12);
    SalesDatabase db=new SalesDatabase();

    public SalesPanelInfo(){
        lblProduct = new JLabel("Product: ");
        lblCompany = new JLabel("Company: ");
        lblType = new JLabel("Type: ");
        lblPrice = new JLabel("Price: ");



        txtProduct = new JTextField(15);
        txtProduct.setEnabled(false);
        txtPrice = new JTextField(15);
        txtPrice.setText("0.00");
        txtPrice.setEnabled(false);



        db.setFilename("LiquorType.txt");
        cboType=new JComboBox(db.fillToComboBox());
        cboType.addItemListener(this);
        cboType.setEnabled(false);
        db.setFilename("LiquorCompanies.txt");
        cboCompany=new JComboBox(db.fillToComboBox());
        cboCompany.addItemListener(this);
        cboCompany.setEnabled(false);
        setBorder(BorderFactory.createTitledBorder(null,"Point of Sale",0,0,font));
        setLayout(new GridLayout(4, 2, 3, 10));
        setFont(font);
        add(lblProduct); add(txtProduct);
        add(lblCompany); add(cboCompany);
        add(lblType); add(cboType);
        add(lblPrice); add(txtPrice);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }

    @Override
    public void itemStateChanged(ItemEvent itemEvent) {

    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
