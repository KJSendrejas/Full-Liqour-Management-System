import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;

public class CustoPanelTable extends JPanel{
    static JTable tblCustomer;
    static DefaultTableModel modelCustomer =new DefaultTableModel();
    static TableRowSorter tblSort=new TableRowSorter();
    CustoDatabase data;
    CustoActionlisteners listen=new CustoActionlisteners();

    public CustoPanelTable() {
        data=new CustoDatabase("CustomerColumn.txt");
        modelCustomer =new DefaultTableModel();
        data.setColumn(modelCustomer);

        data=new CustoDatabase("CustomerInfo.txt");
        data.displayRecords(modelCustomer);
        tblCustomer =new JTable(modelCustomer);
        tblCustomer.addMouseListener(listen);

        CustoPanelInfo.txtID.setText(getRowCount()+"");
        setLayout(new BorderLayout());
        add(new JScrollPane(tblCustomer), BorderLayout.EAST);
    }
    public static int getRowCount(){
        return modelCustomer.getRowCount()+1;
    }
}
