import javax.swing.*;
import java.awt.event.*;
import java.util.Vector;

import static java.lang.System.*;

public class Listeners implements ActionListener, MouseListener, WindowListener {
    Vector val;
    String SerialNum,Product, Company,Alcohol,Type,Stocks,Price;
    Database data;
    public Listeners(){
        val = new Vector();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(PanelButtons.btnAdd)){
            PanelTable.modelLiquor.addRow(addNewRecord());
            PanelInfo.txtSerialNum.setText(PanelTable.getRowCount()+"");
            JOptionPane.showMessageDialog(null, "Liquor's record are successfully added.");
            Clear();
        }
        else if(e.getSource().equals(PanelButtons.btnUpdate)){
            int row=PanelTable.tblLiquor.getSelectedRow();
            SerialNum=PanelInfo.txtSerialNum.getText();
            Product = PanelInfo.txtProduct.getText();
            Alcohol = PanelInfo.txtAlcohol.getText();
            Stocks = PanelInfo.txtStocks.getText();
            Price = PanelInfo.txtPrice.getText();
            if(Product.equals("")||(Alcohol.equals("%")||(Stocks.equals("")||(Price.equals("0.00")))))
            {
                JOptionPane.showMessageDialog(null,"Please fill the empty fields!");
            }
            else{
            addNewRecord();
                for (int j = 1; j < PanelTable.modelLiquor.getColumnCount(); j++) {
                    PanelTable.modelLiquor.setValueAt(val.get(j), row, j);
                }
            }
        Clear();
        }
        else if(e.getSource().equals(PanelButtons.btnDelete)){
            int row=PanelTable.tblLiquor.getSelectedRow();
                PanelTable.modelLiquor.removeRow(row);

                Clear();
        }else if(e.getSource().equals(PanelButtons.btnClose)){
            data=new Database("LiquorStorage.txt");
            String records="";
            for (int r = 0; r < PanelTable.modelLiquor.getRowCount(); r++) {
                for (int c = 0; c < PanelTable.modelLiquor.getColumnCount(); c++) {
                    records+=PanelTable.modelLiquor.getValueAt(r, c)+"#";
                }
                records+="\n";
            }
            data.storeToFile(records);
        Clear();
        }
        else if(e.getSource().equals(PanelButtons.btnClear)){
            Clear();
        }
    }
    public Vector addNewRecord(){
        val=new Vector();
        val.add(PanelInfo.txtSerialNum.getText());
        val.add(PanelInfo.txtProduct.getText());
        val.add(PanelInfo.cboCompany.getSelectedItem());
        val.add(PanelInfo.txtAlcohol.getText());
        val.add(PanelInfo.cboType.getSelectedItem());
        val.add(PanelInfo.txtStocks.getText());
        val.add(PanelInfo.txtPrice.getText());
        return val;
    }
    public void getValues(){
        SerialNum=PanelInfo.txtSerialNum.getText();
        Product = PanelInfo.txtProduct.getText();
        Alcohol = PanelInfo.txtAlcohol.getText();
        Stocks = PanelInfo.txtStocks.getText();
        Price = PanelInfo.txtPrice.getText();
    }
    public void mouseClicked(MouseEvent e) {
        if(e.getSource().equals(PanelTable.tblLiquor)){
            int row=PanelTable.tblLiquor.getSelectedRow();
            PanelInfo.txtSerialNum.setText(PanelTable.modelLiquor.getValueAt(row,0)+"");
            PanelInfo.txtProduct.setText(PanelTable.modelLiquor.getValueAt(row, 1)+"");
            PanelInfo.cboCompany.setSelectedItem(PanelTable.modelLiquor.getValueAt(row,2)+"");
            PanelInfo.txtAlcohol.setText(PanelTable.modelLiquor.getValueAt(row, 3)+"");
            PanelInfo.cboType.setSelectedItem(PanelTable.modelLiquor.getValueAt(row, 4)+"");
            PanelInfo.txtStocks.setText(PanelTable.modelLiquor.getValueAt(row, 5)+"");
            PanelInfo.txtPrice.setText(PanelTable.modelLiquor.getValueAt(row, 6)+"");
            PanelButtons.btnAdd.setEnabled(false);
            PanelButtons.btnUpdate.setEnabled(true);
            PanelButtons.btnClear.setEnabled(true);
            PanelButtons.btnDelete.setEnabled(true);
        }
    }
    public void Clear(){
        PanelInfo.txtSerialNum.setEnabled(false);
        int gen = PanelTable.modelLiquor.getRowCount()+1;
        PanelInfo.txtSerialNum.setText(gen+"");
        PanelInfo.txtProduct.setText("");
        PanelInfo.cboCompany.setSelectedIndex(0);
        PanelInfo.txtAlcohol.setText("%");
        PanelInfo.cboType.setSelectedIndex(0);
        PanelInfo.txtStocks.setText("");
        PanelInfo.txtPrice.setText("0.00");

        PanelButtons.btnAdd.setEnabled(true);
        PanelButtons.btnUpdate.setEnabled(false);
        PanelButtons.btnDelete.setEnabled(false);
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

    @Override
    public void windowOpened(WindowEvent windowEvent) {

    }

    @Override
    public void windowClosing(WindowEvent windowEvent) {
        new MainMenu();
    }

    @Override
    public void windowClosed(WindowEvent windowEvent) {

    }

    @Override
    public void windowIconified(WindowEvent windowEvent) {

    }

    @Override
    public void windowDeiconified(WindowEvent windowEvent) {

    }

    @Override
    public void windowActivated(WindowEvent windowEvent) {

    }

    @Override
    public void windowDeactivated(WindowEvent windowEvent) {

    }
}

