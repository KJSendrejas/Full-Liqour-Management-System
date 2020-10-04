import java.awt.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class CartTable extends JPanel{
    static JTable tblCart;
    static DefaultTableModel modelCart =new DefaultTableModel();
    static TableRowSorter tblSort=new TableRowSorter();
    CartDatabase data;
    CartListener listen=new CartListener();
    public CartTable() {
        data=new CartDatabase("LiquorColumn.txt");
        modelCart =new DefaultTableModel();
        data.setColumn(modelCart);

        data=new CartDatabase("CartStorage.txt");
        data.displayRecords(modelCart);
        tblCart =new JTable(modelCart);
        tblCart.addMouseListener(listen);

        setLayout(new BorderLayout());
        add(new JScrollPane(tblCart));
    }
    public static int getRowCount(){
        return modelCart.getRowCount()+1;
    }
}