import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CustoPanelInfo extends JPanel implements ActionListener, MouseListener, KeyListener, ItemListener {
    JLabel lblID, lblName, lblType, lblGender, lblBirthdate;
    static JTextField txtID, txtName, txtBirthdate;
    static JComboBox  cboType, cboGender;
    Font font=new Font("Arial", Font.BOLD, 16);

    CustoDatabase db=new CustoDatabase();
    CustoData custoData = new CustoData();

    public static void main(String[] args){
        new CustoPanelInfo();
    }

    public CustoPanelInfo(){
        lblID = new JLabel("ID: ");
        lblName = new JLabel("Name: ");
        lblGender = new JLabel("Gender: ");
        lblBirthdate = new JLabel("Birth-date");
        lblType = new JLabel("Acc. Type: ");



        txtID = new JTextField(17);
        txtID.setEnabled(false);
        txtID.setText(CustoPanelTable.getRowCount()+"00");
        txtName = new JTextField(17);
        txtBirthdate = new JTextField(17);

        txtBirthdate.setText("MM/DD/YYYY");

        cboGender = new JComboBox(custoData.Gender);

        db.setFilename("CustomerType.txt");
        cboType=new JComboBox(db.fillToComboBox());
        cboType.addItemListener(this);
        setBorder(BorderFactory.createTitledBorder(null,"Customers Registration Form",0,0,font));
        setLayout(new GridLayout(5, 2,3,17));
        setFont(font);
        add(lblID); add(txtID);
        add(lblName); add(txtName);
        add(lblGender); add(cboGender);
        add(lblBirthdate); add(txtBirthdate);
        add(lblType); add(cboType);

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
