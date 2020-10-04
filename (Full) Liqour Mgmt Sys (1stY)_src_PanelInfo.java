import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelInfo extends JPanel implements ActionListener, MouseListener, KeyListener, ItemListener {
    JLabel lblSerialNum,lblProduct, lblCompany, lblAlcohol, lblType,lblStocks,lblPrice;
    static JTextField txtSerialNum, txtProduct, txtAlcohol, txtStocks,  txtPrice;
    static JComboBox  cboCompany,cboType;
    Font font=new Font("Arial", Font.BOLD, 12);
    Database db=new Database();

    public PanelInfo(){
        lblSerialNum = new JLabel("Serial Num: ");
        lblProduct = new JLabel("Product: ");
        lblCompany = new JLabel("Company: ");
        lblAlcohol = new JLabel("Alcohol Per. ");
        lblType = new JLabel("Type: ");
        lblStocks = new JLabel("Stocks: ");
        lblPrice = new JLabel("Price: ");


        txtSerialNum = new JTextField(15);
        txtSerialNum.setText("00");
        txtSerialNum.setEditable(false);
        txtSerialNum.setText(PanelTable.getRowCount()+"");
        txtProduct = new JTextField(15);
        txtAlcohol = new JTextField(15);
        txtAlcohol.setText("%");
        txtStocks = new JTextField(15);
        txtPrice = new JTextField(15);
        txtPrice.setText("0.00");



        db.setFilename("LiquorType.txt");
        cboType=new JComboBox(db.fillToComboBox());
        cboType.addItemListener(this);
        db.setFilename("LiquorCompanies.txt");
        cboCompany=new JComboBox(db.fillToComboBox());
        cboCompany.addItemListener(this);
        setBorder(BorderFactory.createTitledBorder(null,"Liquor Registration Form",0,0,font));
        setLayout(new GridLayout(7, 2));
        setFont(font);
        add(lblSerialNum); add(txtSerialNum);
        add(lblProduct); add(txtProduct);
        add(lblCompany); add(cboCompany);
        add(lblAlcohol); add(txtAlcohol);
        add(lblType); add(cboType);
        add(lblStocks); add(txtStocks);
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
