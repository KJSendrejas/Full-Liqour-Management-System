import java.util.Vector;

public class UAData {
    private Vector <String> uaUserInfo;
    public static void main(String[]args){
        new UAData();
    }
    public Vector <String> setuaUserInfo(){
        uaUserInfo = new Vector<>();
        uaUserInfo.add("Name");
        uaUserInfo.add("Password");
        return uaUserInfo;
    }
}
