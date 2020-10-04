import java.io.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;


public class DatabaseUser {
        private FileReader FRead;
        private FileWriter FWrite;
        private Scanner Scan;
        private String Filename;
        private Vector Row;

        public static void main(String[] args) {
                new DatabaseUser();
        }

        public DatabaseUser() {
                FWrite = null;
                FRead = null;
                Scan = null;
        }

        public DatabaseUser(String Filename) {
                try {
                        FWrite =  new FileWriter(this.Filename);
                } catch (Exception e) {
                        errorMessage("Error 101: Database " + e.getMessage());
                }

        }
        public void setFilename(String Filename){
                try{
                        this.Filename = Filename;
                }catch(Exception e){
                        errorMessage("Error 102: setFilename "+e.getMessage());
                }
        }
        public void displayRecords(DefaultTableModel Model){
                try{
                        String Value[];
                        Scan = new Scanner(new FileReader("UserInformation.txt"));
                        while (Scan.hasNext()){
                                Value = Scan.nextLine().split("#");
                                Row = new Vector<String>();
                                for(int i = 0; i<5; i++){
                                        Row.add(Value[i]);
                                }
                                Model.addRow(Row);
                        }
                        Scan.close();
                }catch (Exception e){
                        errorMessage("Error 103 : displayRecords "+e.getMessage());
                }
        }
        public Vector<String> loadtoComboBox(){
                Row = new Vector<String>();
                try{
                        Scan = new Scanner(new FileReader("Type.txt"));
                        while(Scan.hasNext()){
                                Row.add(Scan.nextLine());
                        }
                        Scan.close();
                } catch (Exception e){
                        errorMessage("Error 104 : loadtoComboBox "+e.getMessage());
                }
                return Row;
        }
        public void addRecords(String Records){
                try{
                        FWrite = new FileWriter(Filename);
                        FWrite.write(Records+"\n");
                        FWrite.close();
                        FWrite.flush();

                }catch (Exception e){
                        errorMessage("Record Saved Successfully : "+e.getMessage());

                }
        }

        private void errorMessage(String s) {
                System.err.println(s);
        }
}