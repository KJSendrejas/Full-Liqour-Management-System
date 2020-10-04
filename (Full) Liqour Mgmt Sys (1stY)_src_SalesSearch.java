import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

public class SalesSearch extends JPanel implements KeyListener{
    JLabel lblSearch;
    JTextField txtSearch;

    public SalesSearch() {
        lblSearch=new JLabel("Search");
        txtSearch=new JTextField(11);
        setLayout(new FlowLayout(FlowLayout.LEFT,2,1));
        add(lblSearch);
        add(txtSearch);
        txtSearch.addKeyListener(this);
    }

    public void keyTyped(KeyEvent e) { }
    public void keyPressed(KeyEvent e) { }

    public void keyReleased(KeyEvent e) {
        if(e.getSource().equals(txtSearch)){
            String search=txtSearch.getText();
            SalesPanelTable.tblSort=new TableRowSorter(SalesPanelTable.modelSales);
            SalesPanelTable.tblSales.setRowSorter(SalesPanelTable.tblSort);
            SalesPanelTable.tblSort.setRowFilter(RowFilter.regexFilter(search, 0,1));
        }
    }
}
