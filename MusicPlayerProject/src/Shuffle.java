import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class Shuffle extends JButton implements ActionListener {
    Random random = new Random();

    Clip clip;
    Shuffle(Clip clip)
    {
        this.clip = clip ;
        setText("Ξ");
        addActionListener(this);
        setBounds(150,220,100,100);
        setFocusPainted(false);
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFont(new Font("Arial", Font.PLAIN, 24));
        setForeground(Color.BLACK);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(Main.clip.isRunning()== true)
        {
            Main.clip.stop();
            shuffle();
            Main.songImage();
            System.out.println(Main.currentIndex);
        }
        else
        {
            Main.clip.close();
        }
    }

    boolean check = false ;

    void shuffle()
    {


            try {
                int randomNumber = random.nextInt(0,6);
                AudioInputStream audio = AudioSystem.getAudioInputStream(Main.files.get(randomNumber));
                Main.clip = AudioSystem.getClip();
                Main.clip.open(audio);
                Main.clip.start();
                Main.currentIndex = randomNumber;
                Main.songImage();
                System.out.println(randomNumber);

                }
            catch (Exception e)
            {
            System.out.println(e.getMessage());
            }
            check = true ;

    }
}

