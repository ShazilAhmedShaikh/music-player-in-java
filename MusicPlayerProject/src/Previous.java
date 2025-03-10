import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class Previous extends JButton implements ActionListener {
    Clip clip;
    ArrayList<File> files;
    // To keep track of the current song index

    public Previous(Clip clip, ArrayList<File> files) {
        this.clip = clip;
        this.files = files;
        setText("<");
        addActionListener(this);
        setBounds(220,220,60,100);
        setFocusPainted(false);
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFont(new Font("Arial", Font.PLAIN, 24));
        setForeground(Color.BLACK);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
    if(Main.clip.isRunning()==true)
    {

        Main.clip.stop();
        Main.songImage();
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        if (files.size() >= 0) {
            Main.currentIndex--;
            System.out.println(Main.currentIndex);// Move to next song
            if (Main.currentIndex < 0) {
                Main.currentIndex = files.size()-1; // Loop back to the first song if at the end
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
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                System.err.println("Error playing the file: " + ex.getMessage());
            }

        }
    }}}