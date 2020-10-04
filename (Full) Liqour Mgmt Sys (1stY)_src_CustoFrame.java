import javax.swing.*;

public class CustoFrame extends JFrame{
    private int W, H;
    public CustoFrame() {
        H =800;
        W =500;
    }
    public CustoFrame(int width, int height) {
        H =height;
        W =width;
    }
    public CustoFrame(String title, int width, int height) {
        super(title);
        H =width;
        W =height;
    }
    public void setTitle(String title) {
        super.setTitle(title);
    }
    public void setWindowSize(int width, int height) {
        H =height; W =width;
        super.setSize(width, height);
    }
    public void setMyFrame(String title, int width, int height){
        setTitle(title);
        setWindowSize(width, height);
    }
    public void setMyFrame(String title, int width, int height, boolean visible){
        setMyFrame(title, width, height);
        setVisible(true);
    }
}