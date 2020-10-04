import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class UserInfo extends JFrame implements ActionListener, KeyListener, WindowListener, MouseListener {
    JPanel UserInfoForm, ButtonForm, SearchForm;
    JLabel lblID, lblName, lblAddress, lblContact, lblGender;
    JLabel lblUsername, lblPassword, lblSearch;
    JTextField txtID, txtName, txtAddress, txtContact, txtSearch;
    JTextField txtUsername;
    JPasswordField txtPassword, txtRePassword;
    JButton btnAdd, btnClear, btnUpdate, btnDelete;
    JComboBox cboGender;
    String records;
    int generate;

    JTable tblUserInfo;
    DefaultTableModel ModelUserInfo;

    DataUser data = new DataUser();
    DatabaseUser database = new DatabaseUser();
    Vector content;




    public static void main(String [] args){
        new UserInfo();
    }

    public UserInfo(){
        UserInfoForm = new JPanel();
        ButtonForm = new JPanel();
        SearchForm = new JPanel();

        lblID = new JLabel("ID");
        lblName = new JLabel("Name");
        lblAddress = new JLabel("Address");
        lblContact = new JLabel("Contact");
        lblGender = new JLabel("Gender");

        lblUsername = new JLabel("Username");
        lblPassword = new JLabel("Password");

        txtID = new JTextField();
        txtName = new JTextField();
        txtAddress = new JTextField();
        txtContact = new JTextField();
        txtUsername = new JTextField();

        txtPassword = new JPasswordField();
        txtRePassword = new JPasswordField();

        lblSearch = new JLabel("Search");
        txtSearch = new JTextField(10);

        cboGender = new JComboBox();
        cboGender.addItem("Male");
        cboGender.addItem("Female");

        btnAdd = new JButton("Add");
        btnClear = new JButton("Clear");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");

        Vector <String> Column = new Vector<>(data.setUserInfo());

        tblUserInfo = new JTable();
        ModelUserInfo = new DefaultTableModel();
        tblUserInfo.setModel(ModelUserInfo);
        ModelUserInfo.setColumnIdentifiers(Column);

        database.setFilename("UserInformation.txt");
        database.displayRecords(ModelUserInfo);


        tblUserInfo.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
        tblUserInfo.setLayout(new FlowLayout());

        UserInfoForm.setBorder(BorderFactory.createTitledBorder("Account Information"));
        UserInfoForm.setLayout(new GridLayout(9,2,2,3));

        SearchForm.setLayout(new FlowLayout());
        SearchForm.add(lblSearch);
        SearchForm.add(txtSearch);

        UserInfoForm.add(lblID);
        UserInfoForm.add(txtID);
        UserInfoForm.add(lblName);
        UserInfoForm.add(txtName);
        UserInfoForm.add(lblAddress);
        UserInfoForm.add(txtAddress);
        UserInfoForm.add(lblContact);
        UserInfoForm.add(txtContact);
        UserInfoForm.add(lblGender);
        UserInfoForm.add(cboGender);

        UserInfoForm.add(new JLabel());
        UserInfoForm.add(new JLabel());

        UserInfoForm.add(lblUsername);
        UserInfoForm.add(txtUsername);
        UserInfoForm.add(lblPassword);
        UserInfoForm.add(txtPassword);

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
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        addWindowListener(this);
        txtSearch.addKeyListener(this);
        tblUserInfo.addMouseListener(this);
        btnAdd.addActionListener(this);
        btnClear.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnDelete.addActionListener(this);

        txtID.setEnabled(false);
        txtID.setText("20201");
        Default();
    }
    public Vector addNewRecord(){
        content = new Vector<>();
        content.add(txtID.getText());
        content.add(txtName.getText());
        content.add(txtAddress.getText());
        content.add(txtContact.getText());
        content.add(cboGender.getSelectedItem());
        return content;
    }

    public void processRecords() {
        records="";
        for (int row = 0; row < ModelUserInfo.getRowCount(); row++) {
            for (int column = 0; column < ModelUserInfo.getColumnCount(); column++) {
                records+=ModelUserInfo.getValueAt(row, column)+"#";
            }
            records+="\n";
        }
        database.addRecords(records);
    }

    public void Default(){
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
    }

    public void Clear(){
        txtID.setEnabled(false);
        generate = ModelUserInfo.getRowCount()+1;
        txtID.setText("2020"+generate+"");

        txtName.setText("");
        txtAddress.setText("");
        txtContact.setText("");
        cboGender.setSelectedIndex(0);

        txtUsername.setText("");
        txtPassword.setText("");

        txtSearch.setText("");

        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
        btnAdd.setEnabled(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnAdd)){
            ModelUserInfo.addRow(addNewRecord());
            JOptionPane.showMessageDialog(null, "Records successfully added");
            addAccount();
            Clear();
        }
        else if(e.getSource().equals(btnClear)){
            Clear();
        }
        else if(e.getSource().equals(btnDelete)){
            int i=tblUserInfo.getSelectedRow();
            ModelUserInfo.removeRow(i);
            Clear();
        }
        else if(e.getSource().equals(btnUpdate)){
            int i = tblUserInfo.getSelectedRow();
            tblUserInfo.setValueAt(txtName.getText(), i, 1);
            tblUserInfo.setValueAt(txtAddress.getText(), i, 2);
            tblUserInfo.setValueAt(txtContact.getText(), i, 3);
            tblUserInfo.setValueAt(cboGender.getSelectedItem(), i, 4);
            Clear();
        }
    }

    public void keyTyped(KeyEvent keyEvent) {
    }
    public void keyPressed(KeyEvent keyEvent) {
    }
    public void keyReleased(KeyEvent e) {
        if(e.getSource().equals(txtSearch)){
            String search=txtSearch.getText();
            TableRowSorter tblSort = new TableRowSorter(ModelUserInfo);
            tblUserInfo.setRowSorter(tblSort);
            tblSort.setRowFilter(RowFilter.regexFilter(search, 0,1));
        }
    }
    public void windowOpened(WindowEvent windowEvent) {
    }
    public void windowClosing(WindowEvent windowEvent) {
        processRecords();
        new LoginForm();
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
            txtID.setText(ModelUserInfo.getValueAt(i,0)+"");
            txtName.setText(ModelUserInfo.getValueAt(i,1)+"");
            txtAddress.setText(ModelUserInfo.getValueAt(i,2)+"");
            txtContact.setText(ModelUserInfo.getValueAt(i,3)+"");
            cboGender.setSelectedItem(ModelUserInfo.getValueAt(i,4)+"");

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
    public void addAccount(){
        String getuser, getpass;
        getuser = txtUsername.getText();
        getpass = txtPassword.getText();
        try {
            FileWriter myWriter = new FileWriter("UserAccounts.txt");
            myWriter.write(getuser+"#"+getpass+"#");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
