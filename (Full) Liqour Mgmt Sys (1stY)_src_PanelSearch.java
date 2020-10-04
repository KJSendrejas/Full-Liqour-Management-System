import javax.swing.*;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PanelSearch extends JPanel implements KeyListener{
    JLabel lblSearch;
    JTextField txtSearch;

    public PanelSearch() {
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
            PanelTable.tblSort=new TableRowSorter(PanelTable.modelLiquor);
            PanelTable.tblLiquor.setRowSorter(PanelTable.tblSort);
            PanelTable.tblSort.setRowFilter(RowFilter.regexFilter(search, 0,1));
        }
    }
}
