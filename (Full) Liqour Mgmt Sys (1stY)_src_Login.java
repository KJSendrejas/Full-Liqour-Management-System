import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends MyFrame implements ActionListener {
    JLabel lblUserName, lblPassword;
    JTextField txtUser;
    JPasswordField txtPass;
    JButton btnLogin, btnExit;
    Database db=new Database();
    public Login() {
        lblUserName=new JLabel("Username");
        lblPassword=new JLabel("Password");

        txtUser =new JTextField(10);
        txtPass=new JPasswordField(10);
        txtPass.setEchoChar('*');

        btnLogin =new JButton("Login");
        btnExit=new JButton("Exit");

        btnLogin.addActionListener(this);
        btnExit.addActionListener(this);
    }
    public void init(){
        db.setFilename("Account.txt");
        setLayout(new FlowLayout());
        add(lblUserName);add(txtUser);
        add(lblPassword);add(txtPass);
        add(btnLogin);add(btnExit);
        setLocationRelativeTo(null);
        setResizable(true);
        setMyFrame("Log-in", 230, 130, true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        Login login =new Login();
        login.init();

    }
    public void actionPerformed(ActionEvent e) {
        String un, pass;
        if(e.getSource().equals(btnLogin)){
            un= txtUser.getText();
            pass=txtPass.getText();
            if(db.isFound(un, pass)){
                JOptionPane.showMessageDialog(this, "Logged in successfully");
                new LiquorRegistrationForm();
                dispose();
            }else{
                JOptionPane.showMessageDialog(this, "Log-in Failed, Please check your account");
            }
        }else if(e.getSource().equals(btnExit)){
            System.exit(0);
        }
    }
}
