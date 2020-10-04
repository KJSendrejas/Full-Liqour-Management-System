import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;

public class PanelTable extends JPanel{
    static JTable tblLiquor;
    static DefaultTableModel modelLiquor =new DefaultTableModel();
    static TableRowSorter tblSort=new TableRowSorter();
    Database data;
    Listeners listen=new Listeners();
    public PanelTable() {
        data=new Database("LiquorColumn.txt");
        modelLiquor =new DefaultTableModel();
        data.setColumn(modelLiquor);

        data=new Database("LiquorStorage.txt");
        data.displayRecords(modelLiquor);
        tblLiquor =new JTable(modelLiquor);
        tblLiquor.addMouseListener(listen);

        PanelInfo.txtSerialNum.setText(getRowCount()+"");
        setLayout(new BorderLayout());
        add(new JScrollPane(tblLiquor), BorderLayout.CENTER);
    }
    public static int getRowCount(){
        return modelLiquor.getRowCount()+1;
    }
}
