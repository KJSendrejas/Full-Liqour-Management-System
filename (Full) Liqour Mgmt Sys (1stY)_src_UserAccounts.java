import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class UserAccounts extends JFrame implements ActionListener, KeyListener, WindowListener, MouseListener {
    JPanel UserInfoForm, ButtonForm, SearchForm;
    JLabel lblUsername, lblPassword, lblSearch;
    JTextField txtSearch;
    JTextField txtuaUsername;
    JPasswordField txtuaPassword;
    JButton btnAdd, btnClear, btnUpdate, btnDelete;
    String records;

    JTable tblUserInfo;
    DefaultTableModel ModelUserAccounts;

    UAData uadata = new UAData();
    UADatabase uadatabase = new UADatabase();
    Vector uacontent;


    public static void main(String [] args){
        new UserAccounts();
    }

    public UserAccounts(){

        UserInfoForm = new JPanel();
        ButtonForm = new JPanel();
        SearchForm = new JPanel();

        lblUsername = new JLabel("Username");
        lblPassword = new JLabel("Password");
        
        txtuaUsername = new JTextField();
        txtuaPassword = new JPasswordField();

        lblSearch = new JLabel("Search");
        txtSearch = new JTextField(10);

        btnAdd = new JButton("Add");
        btnClear = new JButton("Clear");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");

        Vector <String> Column = new Vector<>(uadata.setuaUserInfo());

        tblUserInfo = new JTable();
        ModelUserAccounts = new DefaultTableModel();
        tblUserInfo.setModel(ModelUserAccounts);
        ModelUserAccounts.setColumnIdentifiers(Column);

        uadatabase.setFilename("UserAccounts.txt");
        uadatabase.displayRecords(ModelUserAccounts);

        tblUserInfo.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
        tblUserInfo.setLayout(new FlowLayout());

        UserInfoForm.setBorder(BorderFactory.createTitledBorder("Account Information"));
        UserInfoForm.setLayout(new GridLayout(9,2,2,3));

        SearchForm.setLayout(new FlowLayout());
        SearchForm.add(lblSearch);
        SearchForm.add(txtSearch);
        

        UserInfoForm.add(new JLabel());
        UserInfoForm.add(new JLabel());

        UserInfoForm.add(lblUsername);
        UserInfoForm.add(txtuaUsername);
        UserInfoForm.add(lblPassword);
        UserInfoForm.add(txtuaPassword);

        ButtonForm.setLayout(new GridLayout(2,2,2,2));
        ButtonForm.add(btnAdd);
        ButtonForm.add(btnClear);
        ButtonForm.add(btnUpdate);
        ButtonForm.add(btnDelete);

        add(new JScrollPane((tblUserInfo))).setBounds(10, 40, 400, 291);
        add(UserInfoForm).setBounds(415, 10, 250, 270);
        add(ButtonForm).setBounds(415,280,250,50);
        add(SearchForm).setBounds(220,10,200,30);

        setTitle("Accounts");
        setSize(670, 380);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        addWindowListener(this);
        txtSearch.addKeyListener(this);
        tblUserInfo.addMouseListener(this);
        btnAdd.addActionListener(this);
        btnClear.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnDelete.addActionListener(this);

        Default();
    }
    public Vector uaaddNewRecord(){
        uacontent = new Vector<>();
        uacontent.add(txtuaUsername.getText());
        uacontent.add(txtuaPassword.getText());
        return uacontent;
    }

    public void uaprocessRecords() {
        records="";
        for (int row = 0; row < ModelUserAccounts.getRowCount(); row++) {
            for (int column = 0; column < ModelUserAccounts.getColumnCount(); column++) {
                records+= ModelUserAccounts.getValueAt(row, column)+"#";
            }
            records+="\n";
        }
        uadatabase.addRecords(records);
    }

    public void Default(){
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
    }

    public void uaClear(){

        txtuaUsername.setText("");
        txtuaPassword.setText("");

        txtSearch.setText("");

        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
        btnAdd.setEnabled(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnAdd)){
                    ModelUserAccounts.addRow(uaaddNewRecord());
                    JOptionPane.showMessageDialog(null, "Records successfully added");
                    uaClear();
        }
        else if(e.getSource().equals(btnClear)){
            uaClear();
        }
        else if(e.getSource().equals(btnDelete)){
            int i=tblUserInfo.getSelectedRow();
            ModelUserAccounts.removeRow(i);
            uaClear();
        }
        else if(e.getSource().equals(btnUpdate)){
            int i = tblUserInfo.getSelectedRow();
            tblUserInfo.setValueAt(txtuaUsername.getText(), i, 0);
            tblUserInfo.setValueAt(txtuaPassword.getText(), i, 1);
            uaClear();
        }
    }

    public void keyTyped(KeyEvent keyEvent) {
    }
    public void keyPressed(KeyEvent keyEvent) {
    }
    public void keyReleased(KeyEvent e) {
        if(e.getSource().equals(txtSearch)){
            String search=txtSearch.getText();
            TableRowSorter uatblSort = new TableRowSorter(ModelUserAccounts);
            tblUserInfo.setRowSorter(uatblSort);
            uatblSort.setRowFilter(RowFilter.regexFilter(search, 0,1));
        }
    }
    public void windowOpened(WindowEvent windowEvent) {
    }
    public void windowClosing(WindowEvent windowEvent) {
        uaprocessRecords();
    }
    public void windowClosed(WindowEvent windowEvent) {
    }
    public void windowIconified(WindowEvent windowEvent) {
    }
    public void windowDeiconified(WindowEvent windowEvent) {
    }
    public void windowActivated(WindowEvent windowEvent) {

    }
    public void windowDeactivated(WindowEvent windowEvent) {
    }
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(tblUserInfo)){
            int i= tblUserInfo.getSelectedRow();
            txtuaUsername.setText(ModelUserAccounts.getValueAt(i,0)+"");
            txtuaPassword.setText(ModelUserAccounts.getValueAt(i,1)+"");

            btnAdd.setEnabled(false);
            btnUpdate.setEnabled(true);
            btnDelete.setEnabled(true);
            btnClear.setEnabled(true);
        }
    }
    public void mousePressed(MouseEvent mouseEvent) {
    }
    public void mouseReleased(MouseEvent mouseEvent) {
    }
    public void mouseEntered(MouseEvent mouseEvent) {
    }
    public void mouseExited(MouseEvent mouseEvent) {
    }
}
