import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class NextButton extends JButton implements ActionListener {
     Clip clip;
     ArrayList<File> files;

     // To keep track of the current song index

    public NextButton(Clip clip, ArrayList<File> files) {
        this.clip = clip;
        this.files = files;
        setText(">");
        addActionListener(this);
        setBounds(340,220,60,100);
        setFocusPainted(false);
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFont(new Font("Arial", Font.PLAIN, 24));
        setForeground(Color.BLACK);
//
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    if(Main.clip.isRunning()==true)
    {

        Main.clip.stop();
        if (files.size() > 0) {
            Main.currentIndex++; // Move to next song
            if (Main.currentIndex >= files.size()) {
                Main.currentIndex = 0; // Loop back to the first song if at the end
            }
            try {
                if (Main.clip.isRunning()) {
                    Main.clip.stop(); // Stop current song if playing
                }
                Main.clip.close(); // Close the current Clip
                AudioInputStream audio = AudioSystem.getAudioInputStream(files.get(Main.currentIndex));
                Main.clip.open(audio); // Open new song
                Main.clip.start(); // Play new song
                Main.songImage();
                System.out.println(Main.currentIndex);
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                System.err.println("Error playing the file: " + ex.getMessage());
            }
        }

    }}}