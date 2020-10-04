import javax.swing.*;

public class MyFrame extends JFrame{
    private int Width, Height;
    public MyFrame() {
        Height =800;
        Width =500;
    }
    public MyFrame(int width, int height) {
        Height =height;
        Width =width;
    }
    public MyFrame(String title,int width, int height) {
        super(title);
        Height =width;
        Width =height;
    }
    public void setTitle(String title) {
        super.setTitle(title);
    }
    public void setWindowSize(int width, int height) {
        Height =height; Width =width;
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