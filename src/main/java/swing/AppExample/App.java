package swing.AppExample;

public class App {
    public static void main(String[] args){
        MyFrame frame = new MyFrame();
        MyLabel label = new MyLabel();
        MyPanel panel = new MyPanel();
        MyButton1 button1 = new MyButton1();
        MyButton2 button2 = new MyButton2();
        panel.add(label);
        panel.add(button1);
        panel.add(button2);
        frame.add(panel);
    }

}
