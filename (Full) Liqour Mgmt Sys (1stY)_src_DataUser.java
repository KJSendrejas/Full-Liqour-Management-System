import java.util.*;
public class DataUser {
    private Vector <String> UserInfo;
    public static void main(String[]args){
        new DataUser();
    }
    public Vector <String> setUserInfo(){
        UserInfo = new Vector<>();
        UserInfo.add("ID");
        UserInfo.add("Name");
        UserInfo.add("Address");
        UserInfo.add("Contact");
        UserInfo.add("Gender");
        return UserInfo;
    }
 }
