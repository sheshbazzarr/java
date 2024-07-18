package applet;
import java.awt.*;
import javax.swing.*;
public class JavaApplet extends JApplet {
    public void paint(Graphics g){
        g.setColor(color.red);
        g.drawString("hi ,sheshbazzar here",50,50);

        g.drawLine(20,30,300);
    }
}
