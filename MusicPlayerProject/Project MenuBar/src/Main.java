import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;

class SongsMenu
{
    JFrame frame;
    JPanel body, trackList;
    ArrayList<JButton> songs = new ArrayList<JButton>();
    JLabel gradient;
    JScrollPane scrollPane;

    SongsMenu()
    {
        frame = new JFrame();
        frame.setSize(500,500);
//        frame.setUndecorated(true);
        frame.setLayout(null);
//        frame.setOpacity(0.9f);

        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

//        songs = new ArrayList<JButton>();
        for (int i = 0; i < 5; i ++) {
            songs.add(new JButton("Shazil the seth"));
//        songs.get(0).setBorder(null);
            songs.get(i).setBounds(1, 50*(i+1), 300, 30);
            songs.get(i).setBackground(null);
            songs.get(i).setOpaque(false);
            songs.get(i).setFocusPainted(false);
            songs.get(i).setForeground(Color.green);
            trackList.add(songs.get(i));
        }
/*        scrollPane = new JScrollPane(trackList); // Wrap trackList panel in JScrollPane
        scrollPane.setBounds(190, 0, 300, 480);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Always show vertical scrollbar
        frame.getContentPane().add(scrollPane);*/
        frame.setVisible(true);
    }
}

public class Main
{
    public static void main(String[] args)
    {
        SongsMenu songsMenu = new SongsMenu();
    }
}