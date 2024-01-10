package clients;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;


public class playMusic {
    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setSize(200,200);
        JButton button = new JButton("click me");
        button.setForeground(Color.white);
        button.setBackground(Color.BLACK);
        frame.add(button);
        frame.setVisible(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Music("music.wav");
            }
        });


    }
    public static void Music(String filepath){
        File music = new File(filepath);
        try
        {
            AudioInputStream audio = AudioSystem.getAudioInputStream(music);
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();

        }

        catch(Exception e){
            JOptionPane.showMessageDialog(null,"error");

        }
    }
}

