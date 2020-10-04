import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame implements ActionListener {
    JPanel LoginPanel, InputPanel, ImagePanel, BtnPanel, AdPanel;
    JLabel lblUsername, lblPassword;
    JTextField txtUsername;
    JPasswordField  txtPassword;
    JButton btnLogIn, btnSignUp;

    UADatabase uadatabase = new UADatabase();

    public static void main(String[] args){
        new LoginForm();
    }

    LoginForm(){

        LoginPanel = new JPanel();
        InputPanel = new JPanel();
        ImagePanel = new JPanel();
        BtnPanel = new JPanel();
        AdPanel = new JPanel();

        lblUsername = new JLabel("Username:");
        lblPassword = new JLabel("Password:");

        txtUsername = new JTextField();
        txtPassword = new JPasswordField();

        btnLogIn = new JButton("Log-In");
        btnSignUp = new JButton("Sign-Up");

        setTitle("WELCOME");
        setSize(625, 340);

        BtnPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        BtnPanel.add(btnLogIn);
        BtnPanel.add(btnSignUp);


        InputPanel.setLayout(new GridLayout(2, 1, 2, 3));
        InputPanel.add(lblUsername);
        InputPanel.add(txtUsername);
        InputPanel.add(lblPassword);
        InputPanel.add(txtPassword);

        LoginPanel.setLayout(new GridLayout(2, 1, 2, 3));
        LoginPanel.add(InputPanel);
        LoginPanel.add(BtnPanel);

        AdPanel.setBorder(BorderFactory.createLineBorder( Color.lightGray,1));
        ImagePanel.setBorder(BorderFactory.createLineBorder( Color.lightGray,1));
        LoginPanel.setBorder(BorderFactory.createTitledBorder("Log-in Form"));

        ImageIcon IMimage = new ImageIcon("/home/jude/IdeaProjects/MainMenu/Images/MainLogo.png");
        JLabel IMlabel = new JLabel(IMimage);
        AdPanel.add(IMlabel);

        ImageIcon ADimage = new ImageIcon("/home/jude/IdeaProjects/LoginSignup/LoginPictures/ImagePanel.png");
        JLabel ADlabel = new JLabel(ADimage);
        ImagePanel.add(ADlabel);

        add(LoginPanel).setBounds(355, 180, 250, 120);
        add(ImagePanel).setBounds(357, 10,248, 160);
        add(AdPanel).setBounds(10, 10, 340, 290);

        setResizable(false);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        btnLogIn.addActionListener(this);
        btnSignUp.addActionListener(this);


    }
    String logname, logpass;
    public void actionPerformed(ActionEvent act) {

            if(act.getSource().equals(btnLogIn)){
                logname= txtUsername.getText();
                logpass=txtPassword.getText();
                if(uadatabase.isFound(logname, logpass)){
                   // JOptionPane.showMessageDialog(this, "Logged in successfully");
                    MainMenu main = new MainMenu();
                    SalesCustomer_EmployeeInfo salesmain = new SalesCustomer_EmployeeInfo();
                    main.txtCurrentUser.setText(logname);
                    salesmain.txtEmployee.setText(logname);
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(this, "Log-in Failed, Please check your account");
                }
            }
            else if
            (act.getSource().equals(btnSignUp)){
            new UserInfo();
            dispose();
            }
            else{}
        }
    }

