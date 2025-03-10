import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class PPanel extends JPanel {

    public PPanel ()
    {

            Main.is = Main.class.getResourceAsStream("background.webp");
            if (Main.is == null) System.out.println("hi");
            setPreferredSize(new Dimension(640, 320));
            try {
                Main.image = ImageIO.read(Main.is);
            } catch (IOException e) {
                System.out.println("no image found");
                throw new RuntimeException(e);
            }
           // System.out.println("hello");


    }


    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(Main.image,0,0,640,640,null);
    }

}
