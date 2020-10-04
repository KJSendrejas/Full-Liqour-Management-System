import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

public class CustoActionlisteners implements ActionListener, MouseListener {
    Vector val;
    String ID, Name, Type;
    CustoDatabase data;
    public CustoActionlisteners(){
        val = new Vector();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(CustoPanelButtons.btnAdd)){
            CustoPanelTable.modelCustomer.addRow(addNewRecord());
            CustoPanelInfo.txtID.setText(CustoPanelTable.getRowCount()+"");
            JOptionPane.showMessageDialog(null, "Customer's info are successfully added.");
            Clear();
        }
        else if(e.getSource().equals(CustoPanelButtons.btnUpdate)){
            int row= CustoPanelTable.tblCustomer.getSelectedRow();
            ID = CustoPanelInfo.txtID.getText();
            Name = CustoPanelInfo.txtName.getText();
                addNewRecord();
                for (int j = 1; j < CustoPanelTable.modelCustomer.getColumnCount(); j++) {
                    CustoPanelTable.modelCustomer.setValueAt(val.get(j), row, j);

            }
            Clear();
        }
        else if(e.getSource().equals(CustoPanelButtons.btnDelete)){
            int row= CustoPanelTable.tblCustomer.getSelectedRow();
            CustoPanelTable.modelCustomer.removeRow(row);
            Clear();

        }else if(e.getSource().equals(CustoPanelButtons.btnClose)){
            data=new CustoDatabase("CustomerInfo.txt");
            String records="";
            for (int r = 0; r < CustoPanelTable.modelCustomer.getRowCount(); r++) {
                for (int c = 0; c < CustoPanelTable.modelCustomer.getColumnCount(); c++) {
                    records+= CustoPanelTable.modelCustomer.getValueAt(r, c)+"#";
                }
                records+="\n";
            }
            data.storeToFile(records);
            Clear();

        }
        else if(e.getSource().equals(CustoPanelButtons.btnClear)){
            Clear();
        }
    }
    public Vector addNewRecord(){
        val=new Vector();
        val.add(CustoPanelInfo.txtID.getText());
        val.add(CustoPanelInfo.txtName.getText());
        val.add(CustoPanelInfo.cboGender.getSelectedItem());
        val.add(CustoPanelInfo.txtBirthdate.getText());
        val.add(CustoPanelInfo.cboType.getSelectedItem());
        return val;
    }
    public void getValues(){
        ID = CustoPanelInfo.txtID.getText();
        Name = CustoPanelInfo.txtName.getText();
    }
    public void mouseClicked(MouseEvent e) {
        if(e.getSource().equals(CustoPanelTable.tblCustomer)){
            int row= CustoPanelTable.tblCustomer.getSelectedRow();
            CustoPanelInfo.txtID.setText(CustoPanelTable.modelCustomer.getValueAt(row,0)+"");
            CustoPanelInfo.txtName.setText(CustoPanelTable.modelCustomer.getValueAt(row, 1)+"");
            CustoPanelInfo.cboGender.setSelectedItem(CustoPanelTable.modelCustomer.getValueAt(row, 2)+"");
            CustoPanelInfo.txtBirthdate.setText(CustoPanelTable.modelCustomer.getValueAt(row, 3)+"");
            CustoPanelInfo.cboType.setSelectedItem(CustoPanelTable.modelCustomer.getValueAt(row, 4)+"");

            CustoPanelButtons.btnAdd.setEnabled(false);
            CustoPanelButtons.btnUpdate.setEnabled(true);
            CustoPanelButtons.btnClear.setEnabled(true);
            CustoPanelButtons.btnDelete.setEnabled(true);
        }
    }
    public void Clear(){
        CustoPanelInfo.txtID.setEnabled(false);
        int gen = CustoPanelTable.modelCustomer.getRowCount()+1;
        CustoPanelInfo.txtID.setText("00"+gen+"");
        CustoPanelInfo.txtName.setText("");
        CustoPanelInfo.cboGender.setSelectedIndex(0);
        CustoPanelInfo.txtBirthdate.setText("");
        CustoPanelInfo.cboType.setSelectedIndex(0);

        CustoPanelButtons.btnAdd.setEnabled(true);
        CustoPanelButtons.btnUpdate.setEnabled(false);
        CustoPanelButtons.btnDelete.setEnabled(false);
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

