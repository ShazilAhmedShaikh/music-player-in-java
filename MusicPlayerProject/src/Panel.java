import javax.swing.*;
import java.awt.*;
import javax.swing.*;
public class Panel extends JPanel {
    public void paintComponent(Graphics g)
    {
        if(Main.currentIndex==4) {
            ImageIcon image = new ImageIcon("pause1.png");
            g.drawImage(image.getImage(), 260, 220, 24, 24, null);
        }
    }

}
