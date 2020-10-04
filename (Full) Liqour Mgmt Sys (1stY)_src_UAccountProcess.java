import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class UAccountProcess{

    String logusername = "", logpassword = "", getusername = "", getpassword = "";
    BufferedReader in = null;

    UAccountProcess(){

        try {
            in = new BufferedReader(new FileReader("UserAccounts.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner read = new Scanner(in);
        read.useDelimiter("#");

        while(read.hasNext())
        {
            logusername = read.next();
            logpassword = read.nextLine();

            //getusername = txtUsername+ "#";
            //getpassword = txtPassword + "#";

        }
        read.close();
    }
}
