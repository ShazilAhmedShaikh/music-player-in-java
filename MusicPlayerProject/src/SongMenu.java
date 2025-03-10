import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;


class SongMenu extends JLabel  implements MouseListener , ActionListener
{
    JLabel songImage ;
   static JFrame frame;
    JPanel body, trackList;
    ArrayList<JButton> songs = new ArrayList<JButton>();
    JLabel gradient;
    JScrollPane scrollPane;
    Timer timer;

    JLabel text ;
    JLabel text1 ;

    ImageIcon imageIcon = new ImageIcon("logo.png") ;
    SongMenu()
    {
        text = new JLabel();
        text1 = new JLabel();
        timer = new Timer(-222222,this);
        frame = new JFrame();
        frame.setSize(500,500);
        frame.add(text);
        frame.add(text1);
//        frame.setUndecorated(true);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setIconImage(imageIcon.getImage());

        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        text.setText("created by : Shazil Ahmed Shaikh ");
        text1.setText("created by : Shafique Khaaki ");
        text.setBounds(0,420,200,30);
        text1.setBounds(0,435,200,30);
        text.setForeground(Color.green);
        text1.setForeground(Color.green);
        frame.add(text);
        frame.add(text1);

        ImageIcon song1 = new ImageIcon("bematlab.jpeg");
        ImageIcon song2 = new ImageIcon("Gumaan.jpeg");


        body = new JPanel();
        body.setBackground(Color.green);
        body.setBounds(0,0,200,500);
        body.setLayout(null);
        frame.getContentPane().add(body);

        ImageIcon imageIcon = new ImageIcon("MenuGradient1.jpg");
//        imageIcon.getImage();
        gradient = new JLabel(imageIcon);
        gradient.setBounds(0,0,200,500);

        body.add(gradient);



        trackList = new JPanel();
        trackList.setBackground(Color.black);
        trackList.setBounds(200,0,300,500);
        trackList.setLayout(null);
        frame.getContentPane().add(trackList);

        TitledBorder bdrNetwork = new TitledBorder("Tracks");
        bdrNetwork.setTitleColor(new Color(0,255,255));
        bdrNetwork.setTitleJustification(TitledBorder.CENTER);
        bdrNetwork.setTitlePosition(TitledBorder.TOP);
        trackList.setBorder(bdrNetwork);


        Main.song1.setBounds(1,50,300,30);
        Main.song2.setBounds(1,100,300,30);
        Main.song3.setBounds(1,150,300,30);
        Main.song4.setBounds(1,200,300,30);
        Main.song5.setBounds(1,250,300,30);
        Main.song6.setBounds(1,300,300,30);
        Main.song7.setBounds(1,350,300,30);
        Main.song8.setBounds(1,400,300,30);

        Main.song1.setBackground(null);
        Main.song2.setBackground(null);
        Main.song3.setBackground(null);
        Main.song4.setBackground(null);
        Main.song5.setBackground(null);
        Main.song6.setBackground(null);
        Main.song7.setBackground(null);
        Main.song8.setBackground(null);



        Main.song1.setForeground(Color.green);
        Main.song2.setForeground(Color.green);
        Main.song3.setForeground(Color.green);
        Main.song4.setForeground(Color.green);
        Main.song5.setForeground(Color.green);
        Main.song6.setForeground(Color.green);
        Main.song7.setForeground(Color.green);
        Main.song8.setForeground(Color.green);


        Main.song1.setFocusPainted(false);
        Main.song2.setFocusPainted(false);
        Main.song3.setFocusPainted(false);
        Main.song4.setFocusPainted(false);
        Main.song5.setFocusPainted(false);
        Main.song6.setFocusPainted(false);
        Main.song7.setFocusPainted(false);
        Main.song8.setFocusPainted(false);


        trackList.add(Main.song1);
        trackList.add(Main.song2);
        trackList.add(Main.song3);
        trackList.add(Main.song4);
        trackList.add(Main.song5);
        trackList.add(Main.song6);
        trackList.add(Main.song7);
        trackList.add(Main.song8);


        Main.song1.addMouseListener(this);
        Main.song2.addMouseListener(this);
        Main.song3.addMouseListener(this);
        Main.song4.addMouseListener(this);
        Main.song5.addMouseListener(this);
        Main.song6.addMouseListener(this);
        Main.song7.addMouseListener(this);
        Main.song8.addMouseListener(this);




        frame.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Main.frame.setVisible(true);
        frame.setVisible(false);
        if(Main.song1 == e.getSource())
        {
            Main.clip.start();
            Main.songImage();
            Main.slider.setBackground(Color.ORANGE);
            if(Main.clip.isRunning())
            {
                timer.start();
            }
            Main.playPauseButton.setText("||");
        }

        if(Main.song2 == e.getSource())
        {
            Main.frame.setVisible(true);
            frame.setVisible(false);
            Main.songImage();

            try {
                AudioInputStream audio = AudioSystem.getAudioInputStream(Main.files.get(1));
                Main.clip = AudioSystem.getClip();
                Main.clip.open(audio);
            }
            catch(Exception ex)
            {
                System.out.println(ex.getMessage());
            }
            Main.clip.start();

            Main.currentIndex = 1;
            Main.songImage();

            if(Main.clip.isRunning())
            {
                timer.start();
            }
            Main.playPauseButton.setText("||");

        }
        if(Main.song3 == e.getSource())
        {
            Main.frame.setVisible(true);
            frame.setVisible(false);
            try {
                AudioInputStream audio = AudioSystem.getAudioInputStream(Main.files.get(2));
                Main.clip = AudioSystem.getClip();
                Main.clip.open(audio);
            }
            catch(Exception ex)
            {
                System.out.println(ex.getMessage());
            }
            Main.clip.start();
            Main.currentIndex = 2;
            Main.songImage();
            if(Main.clip.isRunning())
            {
                timer.start();
            }
            Main.playPauseButton.setText("||");

        }
        if(Main.song4 == e.getSource())
        {
            Main.frame.setVisible(true);
            frame.setVisible(false);
            try {
                AudioInputStream audio = AudioSystem.getAudioInputStream(Main.files.get(3));
                Main.clip = AudioSystem.getClip();
                Main.clip.open(audio);
            }
            catch(Exception ex)
            {
                System.out.println(ex.getMessage());
            }
            Main.clip.start();
            Main.currentIndex = 3;
            Main.songImage();

            if(Main.clip.isRunning())
            {
                timer.start();
            }
            Main.playPauseButton.setText("||");
        }
        if(Main.song5 == e.getSource())
        {
            Main.frame.setVisible(true);
            frame.setVisible(false);
            try {
                AudioInputStream audio = AudioSystem.getAudioInputStream(Main.files.get(7));
                Main.clip = AudioSystem.getClip();
                Main.clip.open(audio);
            }
            catch(Exception ex)
            {
                System.out.println(ex.getMessage());
            }
            Main.clip.start();
            Main.currentIndex = 7;
            Main.songImage();
            if(Main.clip.isRunning())
            {
                timer.start();
            }
            Main.playPauseButton.setText("||");

        }
        if(Main.song6 == e.getSource())
        {
            Main.frame.setVisible(true);
            frame.setVisible(false);
            try {
                AudioInputStream audio = AudioSystem.getAudioInputStream(Main.files.get(4));
                Main.clip = AudioSystem.getClip();
                Main.clip.open(audio);
            }
            catch(Exception ex)
            {
                System.out.println(ex.getMessage());
            }
            Main.clip.start();
            Main.currentIndex = 4;
            Main.songImage();
            if(Main.clip.isRunning())
            {
                timer.start();
            }
            Main.playPauseButton.setText("||");

        }
        if(Main.song7 == e.getSource())
        {
            Main.frame.setVisible(true);
            frame.setVisible(false);
            try {
                AudioInputStream audio = AudioSystem.getAudioInputStream(Main.files.get(5));
                Main.clip = AudioSystem.getClip();
                Main.clip.open(audio);
            }
            catch(Exception ex)
            {
                System.out.println(ex.getMessage());
            }
            Main.clip.start();
            Main.currentIndex = 5;
            Main.songImage();
            if(Main.clip.isRunning())
            {
                timer.start();
            }
            Main.playPauseButton.setText("||");
        }
        if(Main.song8 == e.getSource())
        {
            Main.frame.setVisible(true);
            frame.setVisible(false);
            try {
                AudioInputStream audio = AudioSystem.getAudioInputStream(Main.files.get(6));
                Main.clip = AudioSystem.getClip();
                Main.clip.open(audio);
            }
            catch(Exception ex)
            {
                System.out.println(ex.getMessage());
            }
            Main.clip.start();
            Main.currentIndex = 6;
            Main.songImage();
            if(Main.clip.isRunning())
            {
                timer.start();
            }
            Main.playPauseButton.setText("||");
            Main.songImage();

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Main.slider.setValue(Main.clip.getFramePosition());
    }
}
