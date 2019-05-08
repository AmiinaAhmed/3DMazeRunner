/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StartGame;

import StartGame.base_form;
import static StartGame.base_form.pathbackground;
import static StartGame.base_form.pathicon;
import static StartGame.base_form.title;
import StartGame.menu_of_game;
import StartGame.menu_play;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author hp
 */
public class form_setting extends JFrame implements base_form{
     
   static AudioStream audios;
   public form_setting(){
        create_form();
        
   }

    @Override
    public void create_form() {
       try {
           //playmusic("res\\DesiJourney.wav");
           setTitle("SETTING");
           this.resize(500, 500);
           this.setIconImage(Toolkit.getDefaultToolkit().getImage(pathicon));
           this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           this.setLocationRelativeTo(null);
           setType(java.awt.Window.Type.UTILITY);
           JLabel label1_ground=new JLabel(new ImageIcon(ImageIO.read(new File(pathbackground))));
           label1_ground.setBackground(new java.awt.Color(51, 51, 51));
           label1_ground.setOpaque(true);
           this.setContentPane(label1_ground);
           create_title(label1_ground);
           create_menu (label1_ground);
       } catch (IOException ex) {
           Logger.getLogger(form_setting.class.getName()).log(Level.SEVERE, null, ex);
       }
           
    
    }
    private void create_title(JLabel label1_ground){
        JLabel maze=new JLabel();
        maze.setBounds(20, 0, 400, 100);
        maze.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        maze.setFont(new java.awt.Font("Impact", 0, 48)); // NOI18N
        maze.setForeground(new java.awt.Color(255, 255, 225));
        maze.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        maze.setText("__SETTINGS__");
        label1_ground.add(maze);
}
    private void create_menu(JLabel label1_ground){
        
        JLabel label1_resume=new JLabel(new ImageIcon());
        label1_resume.setBounds(30, 130, 400, 100);
        label1_resume.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        label1_resume.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        label1_resume.setFont(new java.awt.Font("Impact", 0, 48)); // NOI18N
        label1_resume.setForeground(new java.awt.Color(255, 255, 225));
        label1_resume.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label1_resume.setText("RESUME");
        label1_ground.add(label1_resume);
        JLabel label1_paused=new JLabel();
        label1_paused.setBounds(30, 200, 400, 100);
        label1_paused.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        label1_paused.setFont(new java.awt.Font("Impact", 0, 48)); // NOI18N
        label1_paused.setForeground(new java.awt.Color(255, 255, 225));
        label1_paused.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label1_paused.setText("BUSED");
        label1_ground.add(label1_paused);
        JLabel label1_exit=new JLabel();
        label1_exit.setBounds(0, 350, 100, 100);
        label1_exit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        label1_exit.setFont(new java.awt.Font("Showcard Gothic", 0, 36)); // NOI18N
        label1_exit.setForeground(new java.awt.Color(255, 255, 225));
        label1_exit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label1_exit.setText("EXIT");
        label1_ground.add(label1_exit);
        label1_resume.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AudioPlayer.player.start(sample_background.audios);
                 
            }
        });
        label1_paused.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AudioPlayer.player.stop(sample_background.audios);
                
            }
        });
        label1_exit.addMouseListener(new MouseAdapter() {
               @Override
               public void mouseClicked(MouseEvent e) {
                   dispose();
                   
               }
           });
           
        setVisible(true);
}
}
