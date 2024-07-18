package applet;
import java.awt.*;
import javax.swing.*;

public class JavaApplet extends JApplet {
    public void paint(Graphics g) {
        g.setColor(Color.RED); // "Color" should be capitalized
        g.drawString("hi, sheshbazzar here", 50, 50);

        g.drawLine(20, 30, 200, 30); // Corrected line coordinates

        g.setColor(Color.GREEN); // "Color" should be capitalized
        g.drawRect(70, 100, 30, 30);
    }
}

