import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayPauseButton extends JButton implements ActionListener {



    PlayPauseButton(Clip clip) {

        setText("►");
        System.out.println(clip.getFrameLength());
        Main.slider.repaint();

        addActionListener(this);
        setBounds(260,220,100,100);
        setFocusPainted(false);
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFont(new Font("Arial", Font.PLAIN, 24));
        setForeground(Color.BLACK);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        playPause();
        Main.songImage();



    }

    //    NextButton button = new NextButton(clip);
    void playPause()
    {
        if(Main.clip != null)
        {

            if( Main.clip.isRunning())
            {
                Main.clip.stop();
                setText("►"); ;

            }
            else {
                    setText("||");
                    Main.clip.start();


            }
            }
        }
    }

