import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainMenu extends JFrame implements ActionListener, WindowListener, MouseListener {
    JPanel CurrentUserPanel, ButtonMenuPanel, AdPanel;
    JButton btnINVENTORY, btnSALES, btnLOGOUT, btnCUSTOMERACC;
    JTextField txtCurrentUser,txtCurrentDate;
    JLabel DateTime, UserName;

    DateFormat datetime = new SimpleDateFormat("MM/dd/yy HH:mm:ss");

    public static void main(String [] args){
        new MainMenu();
    }
    MainMenu(){

        LoginForm lf = new LoginForm();
        lf.dispose();
        setTitle("Main Menu");
        setSize(610, 350);

        CurrentUserPanel = new JPanel();
        ButtonMenuPanel = new JPanel();
        AdPanel = new JPanel();

        Date dateobj = new Date();
        String displaydt = (datetime.format(dateobj));

        ImageIcon image = new ImageIcon("/home/jude/IdeaProjects/MainMenu/Images/MainLogo.png");
        JLabel label = new JLabel(image);
        AdPanel.setBorder(BorderFactory.createTitledBorder(""));
        AdPanel.add(label);

        btnINVENTORY = new JButton("Inventory");
        btnSALES = new JButton("Sales");
        btnLOGOUT = new JButton("Log-Out");
        btnCUSTOMERACC = new JButton(("Customer Accounts"));

        txtCurrentUser = new JTextField();
        txtCurrentDate = new JTextField(displaydt);

        DateTime = new JLabel("Date & Logged Time");
        UserName = new JLabel("Username");

        txtCurrentUser.setEditable(false);
        txtCurrentDate.setEditable(false);

        CurrentUserPanel.setBorder(BorderFactory.createTitledBorder("Current User"));
        CurrentUserPanel.setLayout(new GridLayout(4,1,2,3));

        ButtonMenuPanel.setLayout(new GridLayout(6,1,2,3));

        ButtonMenuPanel.add(btnINVENTORY);
        ButtonMenuPanel.add(btnSALES);
        ButtonMenuPanel.add(btnCUSTOMERACC);
        ButtonMenuPanel.add(new JLabel());
        ButtonMenuPanel.add(btnLOGOUT);

        CurrentUserPanel.add(DateTime);
        CurrentUserPanel.add(txtCurrentDate);
        CurrentUserPanel.add(UserName);
        CurrentUserPanel.add(txtCurrentUser);

        setLayout(null); //Frame's layout manager
        add(CurrentUserPanel).setBounds(10, 10, 200, 130);
        add(ButtonMenuPanel).setBounds(10, 140, 200, 200);
        add(AdPanel).setBounds(220, 15, 380, 290);

        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        //Listeners
        btnINVENTORY.addActionListener(this);
        btnSALES.addActionListener(this);
        btnLOGOUT.addActionListener(this);
        btnCUSTOMERACC.addActionListener(this);
        addWindowListener(this);
    }


    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(btnINVENTORY)){
            setVisible(false);
            new LiquorRegistrationForm();
        }else if(e.getSource().equals(btnSALES)){
            new SalesMain();
            setVisible(false);
        }else if(e.getSource().equals(btnCUSTOMERACC)){
            //JOptionPane.showMessageDialog(null, "Kay Abunda ni! GAOOOOO!");
            new Customer();
            setVisible(false);

        }else if(e.getSource().equals(btnLOGOUT)) {
            new LoginForm();
            setVisible(false);
            //JOptionPane.showMessageDialog(null, "LOG-OUT NI");
        }
    }


    public void mouseClicked(MouseEvent mouseEvent) {}
    public void mousePressed(MouseEvent mouseEvent) {}
    public void mouseReleased(MouseEvent mouseEvent) {}
    public void mouseEntered(MouseEvent mouseEvent) {}
    public void mouseExited(MouseEvent mouseEvent) {}
    public void windowOpened(WindowEvent windowEvent) {}
    public void windowClosing(WindowEvent windowEvent) {}
    public void windowClosed(WindowEvent windowEvent) {}
    public void windowIconified(WindowEvent windowEvent) {}
    public void windowDeiconified(WindowEvent windowEvent) {}
    public void windowActivated(WindowEvent windowEvent) {}
    public void windowDeactivated(WindowEvent windowEvent) {}
}
