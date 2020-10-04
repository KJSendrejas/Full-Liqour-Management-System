import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;


public class CustoDatabase {
    File file=null;
    FileWriter fWrite=null;
    FileReader fRead=null;
    Scanner scan=null;
    String message="";
    Vector row, column;

    StringTokenizer strToken;


    public static void main(String[]args){
        new CustoDatabase();
    }

    public CustoDatabase() { }
    public CustoDatabase(String filename) {
        file=new File(filename);
    }
    public void setFilename(String filename) {
        file=new File(filename);
    }
    public String getFilename() {
        return file.getName();
    }
    public void storeToFile(String records){
        try {
            fWrite=new FileWriter(file);
            fWrite.write(records);
            fWrite.flush();
        } catch (Exception e) {

        }
    }

    public String readRecordsFromTextFile(){
        String original="";
        try {
            fRead=new FileReader(file);
            scan=new Scanner(fRead);
            while(scan.hasNext()){
                original+=scan.nextLine()+"\n";
            }
            fRead.close();
            scan.close();
        } catch (Exception e) {

        }
        return original;
    }

    public void displayRecords(DefaultTableModel model){
        try {
            strToken=new StringTokenizer(readRecordsFromTextFile(), "#");
            while(strToken.hasMoreTokens()){
                row = new Vector();
                for (int i = 0; i < model.getColumnCount(); i++) {
                    row.add(strToken.nextToken());

                }
                model.addRow(row);
            }
        } catch (Exception e) {

        }
    }


    public void setColumn(DefaultTableModel model){
        try {
            column=new Vector();
            fRead=new FileReader(file);
            scan=new Scanner(fRead);
            while(scan.hasNext()){
                column.add(scan.nextLine());
            }
            model.setColumnIdentifiers(column);
            fRead.close();
            scan.close();

        } catch (Exception e) {

        }
    }
    public int recordCount(){
        int i=0;
        try {
            fRead=new FileReader(file);
            scan=new Scanner(fRead);
            while(scan.hasNext()){
                scan.nextLine();
                i++;
            }
            fRead.close();
            scan.close();
        } catch (Exception e) {

        }
        return i;
    }
    public void fillToComboBox(JComboBox combo){
        try {
            strToken=new StringTokenizer(readRecordsFromTextFile(), "#");
            while(strToken.hasMoreTokens()){
                combo.addItem(strToken.nextToken());
            }
        } catch (Exception e) {

        }
    }

    public Vector fillToComboBox(){
        try {
            column=new Vector();
            fRead=new FileReader(file);
            scan=new Scanner(fRead);
            strToken=new StringTokenizer(readRecordsFromTextFile(), "#");
            while(strToken.hasMoreTokens()){
                column.add(strToken.nextToken());
            }
            fRead.close();
            scan.close();
        } catch (Exception e) {

        }
        return column;
    }

    public boolean isFound(String username, String password){
        boolean flag = false;
        try {
            fRead=new FileReader(file);
            scan=new Scanner(fRead);
            while(scan.hasNext()){
                if(username.equals(scan.next()) && password.equals(scan.next())){
                    flag=true;
                }
            }
            fRead.close();
            scan.close();
        } catch (Exception e) {

        }
        return flag;
    }
}
