import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import javax.sound.sampled.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class Main {
    static int randomNumber;
    static Container pane;
    static int currentIndex = 0;
    static int i = 0 ;
    static JLabel label = new JLabel();
    Random random = new Random();
    static int min ;
    static Clip clip = null;
    static JSlider slider = new JSlider (JSlider.HORIZONTAL, 0, 8281088,0  );
    static InputStream is ;
    static BufferedImage image ;
    static PlayPauseButton playPauseButton;
    static PPanel panel = new PPanel();
    static JFrame frame = new JFrame();
    static JButton song2 = new JButton("Downers At Dusk - Talha Anjum | Prod. by Umair");
    static JButton song1 = new JButton("LONG TIME NO SEE - TAIMOUR BAIG ft. AUR | Prod. Raffey Anwar");
    static JButton song3 = new JButton("GUMAAN - Young Stunners | Talha Anjum | Talhah Yunus | Prod. By Jokhay");
    static JButton song4 = new JButton("DJ Snake, J Balvin, Tyga - Loco Contigo");
    static JButton song5 = new JButton("You Asim Azhar feat. Hasan Raheem | BEMATLAB");
    static JButton song6 = new JButton("Perfect | Ed Shereen");
    static JButton song7 = new JButton("Glass Animals - Heat Waves");
    static JButton song8 = new JButton("Jokhay, Shareh, JJ47, Talhah Yunus - Therapy");


    static void songImage() {
        if (currentIndex == 0) {
            ImageIcon imageIcon = new ImageIcon("longtimenosee.jpeg");
            Image image = imageIcon.getImage();
            Image newImage = image.getScaledInstance(120, 160, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(newImage);
            label.setIcon(imageIcon);
            slider.setBackground(Color.ORANGE);
            panel.repaint();

        }
        if (currentIndex == 1) {
            ImageIcon imageIcon = new ImageIcon("downer.jpg");
            Image image = imageIcon.getImage();
            Image newImage = image.getScaledInstance(120, 160, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(newImage);
            label.setIcon(imageIcon);
            slider.setBorder(null);
            slider.setBackground(Color.RED);
            panel.repaint();

        }
        if (currentIndex == 2) {
            ImageIcon imageIcon = new ImageIcon("Gumaan.jpeg");
            Image image = imageIcon.getImage();
            Image newImage = image.getScaledInstance(120, 160, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(newImage);
            label.setIcon(imageIcon);
            slider.setBackground(Color.DARK_GRAY);
            panel.repaint();

        }
        if (Main.currentIndex == 3) {
            ImageIcon imageIcon = new ImageIcon("loco image.jpeg");
            Image image = imageIcon.getImage();
            Image newImage = image.getScaledInstance(120, 160, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(newImage);
            label.setIcon(imageIcon);
            slider.setBackground(Color.ORANGE);

        }
        if (Main.currentIndex == 4) {
            ImageIcon imageIcon = new ImageIcon("perfect.png");
            Image image = imageIcon.getImage();
            Image newImage = image.getScaledInstance(120, 160, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(newImage);
            label.setIcon(imageIcon);
            slider.setBackground(Color.BLACK);


        }
        if (Main.currentIndex == 5) {
            ImageIcon imageIcon = new ImageIcon("heatWaves.jpeg");
            Image image = imageIcon.getImage();
            Image newImage = image.getScaledInstance(120, 160, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(newImage);
            label.setIcon(imageIcon);
            slider.setBackground(Color.magenta);


        }
        if (currentIndex == 6) {
            ImageIcon imageIcon = new ImageIcon("therapy.jpeg");
            Image image = imageIcon.getImage();
            Image newImage = image.getScaledInstance(120, 160, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(newImage);
            label.setIcon(imageIcon);
            slider.setBackground(Color.cyan);

        }
        if (currentIndex == 7) {
            ImageIcon imageIcon = new ImageIcon("bematlab.jpeg");
            Image image = imageIcon.getImage();
            Image newImage = image.getScaledInstance(120, 160, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(newImage);
            label.setIcon(imageIcon);
            slider.setBackground(Color.red);

        }

    }
    static ArrayList<File> files = new ArrayList<File>();
    public static void main(String[] args) {
        SongMenu menu = new SongMenu();


        // ARRAY LIST
        files.add(new File("longTime.wav"));
        files.add(new File ("Downers-At-Dusk.wav"));
        files.add(new File("Gumaan.wav"));
        files.add(new File("loco contigo.wav"));
        files.add(new File("Perfect.wav"));
        files.add(new File("Heat Waves.wav"));
        files.add(new File("therapy.wav"));
        files.add(new File("you.wav"));


        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(files.get(0));
            clip = AudioSystem.getClip();
            clip.open(audio);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        NextButton nextButton;
        Previous previousButton;
        Loop loopButton ;
        Shuffle shuffleButton ;

        ImageIcon i = new ImageIcon("logo.png");
        boolean check = false ;


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setTitle("Musifyyy");
        frame.setIconImage(i.getImage());
        frame.add(label);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);


        playPauseButton = new PlayPauseButton(clip);
        nextButton = new NextButton(clip, files);
        previousButton = new Previous(clip, files);
        loopButton = new Loop(clip) ;
        shuffleButton = new Shuffle(clip);


        label.setSize(120, 160);
        label.setBounds(250, 40, 360, 160);
        label.setBackground(Color.cyan);
        // slider
        pane = frame.getContentPane();//Container

        slider.setBounds(220,230,180,10);
        slider.setBackground(null);
        slider.setBackground(Color.green);
        PPanel panel = new PPanel();

        pane.add(label);
        pane.add(slider);
        pane.repaint();
        pane.add(playPauseButton);
        pane.add(nextButton);
        pane.add(previousButton);
        pane.add(loopButton);
        pane.add(shuffleButton);
        pane.add(panel);
        pane.repaint();
        frame.pack();

        clip.setFramePosition(slider.getValue());



        frame.add(panel);

    }

}
