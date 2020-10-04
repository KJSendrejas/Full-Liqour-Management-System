import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

public class Database {
    File file=null;
    FileWriter fWrite=null;
    FileReader fRead=null;
    Scanner scan=null;
    String message="";
    Vector row, column;

    StringTokenizer strToken;

    public Database() { }
    public Database(String filename) {
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
            errorMessage("Error 101: storeToFile\n"+e.getMessage());
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
            errorMessage("Error 104: getStringTokenizer\n"+e.getMessage());
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
            errorMessage("Error 103: setColumns\n"+e.getMessage());
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
            errorMessage("Error 105: recordCount\n"+e.getMessage());
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
            errorMessage("Error 106: fillToComboBox\n"+e.getMessage());
        }
    }
    public void errorMessage(String msg){
        System.err.println(msg);
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
            System.err.println("Error 103: setColumn \n"+e.getMessage());
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
            errorMessage("Error 105: isFound\n"+e.getMessage());
        }
        return flag;
    }
}
