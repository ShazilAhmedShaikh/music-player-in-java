import javax.swing.border.Border;
import java.awt.*;

public class RoundedBorder implements Border {
    private int radius ;
    public RoundedBorder(int i) {
        this.radius = i;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {

    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
    }

    @Override
    public boolean isBorderOpaque() {
        return false;
    }
}
