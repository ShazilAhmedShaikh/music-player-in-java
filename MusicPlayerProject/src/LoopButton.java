import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoopButton extends JButton implements ActionListener {

    Clip clip ;

    LoopButton(Clip clip) {
        this.clip = clip;
        setText("loop");
        addActionListener(this);
        setBounds(280,250,50,20);
        setFocusPainted(false);


    }
    boolean loop = false ;

    @Override
    public void actionPerformed(ActionEvent e) {
        if(loop==false)
        {
            loop=true ;
        }
        else {
            loop=false ;
        }
        while (loop) {
            playPause();
            Main.songImage();
        }
        System.out.println(Main.currentIndex);
    }
//    NextButton button = new NextButton(clip);

    void playPause()
    {

        if(clip != null)
        {
            if(clip.isRunning())
            {
                clip.stop();
                setText("▶"); ;


            }
            else {
                clip.start();
//                currentIndex++;
                setText("||");
            }
        }
    }
}
