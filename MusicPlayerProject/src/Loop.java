import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Loop extends JButton implements ActionListener {


    Loop(Clip clip) {
        setText("∞");
        addActionListener(this);
        setBounds(380,220,80,100);
        setFocusPainted(false);
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFont(new Font("Arial", Font.PLAIN, 24));
        setForeground(Color.BLACK);

    }
    boolean check = false ;
    @Override
    public void actionPerformed(ActionEvent e) {

        if (Main.clip.isRunning()==true)
        {
            System.out.println("loop start");
            Main.clip.loop(2);
        }






    }


}
