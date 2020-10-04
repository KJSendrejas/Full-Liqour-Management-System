import java.awt.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class SalesPanelTable extends JPanel{
    static JTable tblSales;
    static DefaultTableModel modelSales =new DefaultTableModel();
    static TableRowSorter tblSort=new TableRowSorter();
    SalesDatabase data;
    SalesListener listen=new SalesListener();
    public SalesPanelTable() {
        data=new SalesDatabase("LiquorColumn.txt");
        modelSales =new DefaultTableModel();
        data.setColumn(modelSales);

        data=new SalesDatabase("LiquorStorage.txt");
        data.displayRecords(modelSales);
        tblSales =new JTable(modelSales);
        tblSales.addMouseListener(listen);

        setLayout(new BorderLayout());
        add(new JScrollPane(tblSales), BorderLayout.EAST);
    }
    public static int getRowCount(){
        return modelSales.getRowCount()+1;
    }
}
