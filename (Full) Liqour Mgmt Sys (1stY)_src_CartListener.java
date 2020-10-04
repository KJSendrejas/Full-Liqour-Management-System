
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.*;

public class CartListener implements ActionListener, MouseListener {
    Vector val;
    String Product,Price;
    SalesDatabase data;
    public CartListener(){
        val = new Vector();
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if(e.getSource().equals(CartButtons.btnDelete)){
            data=new SalesDatabase("CartStorage.txt");
            String records="";
            for (int r = 0; r < CartTable.modelCart.getRowCount(); r++) {
                for (int c = 0; c < CartTable.modelCart.getColumnCount(); c++) {
                    records+=CartTable.modelCart.getValueAt(r, c)+"#";
                }
                records+="\n";
            }
            data.storeToFile(records);
        }
    }
    public Vector addNewRecord(){
        val=new Vector();
        val.add(SalesPanelInfo.txtProduct.getText());
        val.add(SalesPanelInfo.cboCompany.getSelectedItem());
        val.add(SalesPanelInfo.cboType.getSelectedItem());
        val.add(SalesPanelInfo.txtPrice.getText());
        return val;
    }
    public void getValues(){

        Product = SalesPanelInfo.txtProduct.getText();
        Price = SalesPanelInfo.txtPrice.getText();
    }
    public void mouseClicked(MouseEvent e) {
        if(e.getSource().equals(SalesPanelTable.tblSales)){
            int row=SalesPanelTable.tblSales.getSelectedRow();
            SalesPanelInfo.txtProduct.setText(SalesPanelTable.modelSales.getValueAt(row, 0)+"");
            SalesPanelInfo.cboCompany.setSelectedItem(SalesPanelTable.modelSales.getValueAt(row,1)+"");
            SalesPanelInfo.cboType.setSelectedItem(SalesPanelTable.modelSales.getValueAt(row, 2)+"");
            SalesPanelButtons.btnAddtoCart.setEnabled(true);

        }
    }


    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
