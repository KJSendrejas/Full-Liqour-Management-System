import javax.swing.*;
import java.awt.*;

public class SalesCustomer_EmployeeInfo extends JPanel {
    JLabel lblEmployee, lblCustomer;
    static JTextField txtEmployee, txtCustomer;
    public SalesCustomer_EmployeeInfo(){
        lblEmployee = new JLabel("Employee's Name: ");
        lblCustomer = new JLabel("Customer's Name: ");

        txtEmployee = new JTextField(15);
        txtEmployee.setEnabled(false);

        txtCustomer = new JTextField(15);
        txtCustomer.setEnabled(false);

        setLayout(new GridLayout(2, 2, 3, 3));
        add(lblEmployee); add(txtEmployee);
        add(lblCustomer); add(txtCustomer);
    }
}
