import javax.swing.*;
import java.awt.*;

public class PanelButtons extends JPanel{
    static JButton btnAdd, btnClear, btnUpdate, btnDelete, btnClose;
    Listeners listen=new Listeners();

    public PanelButtons() {

        btnAdd=new JButton("Add New");
        btnClear=new JButton("Clear");
        btnUpdate=new JButton("Update");
        btnDelete=new JButton("Delete");
        btnClose=new JButton("Close");
        setLayout(new GridLayout(1, 5, 4,2));
        add(btnAdd); add(btnClear);
        add(new JLabel(""));
        add(btnUpdate); add(btnDelete);
        add(btnClose);
        btnDelete.addActionListener(listen);
        btnAdd.addActionListener(listen);
        btnUpdate.addActionListener(listen);
        btnClose.addActionListener(listen);
        btnClear.addActionListener(listen);
    }
}