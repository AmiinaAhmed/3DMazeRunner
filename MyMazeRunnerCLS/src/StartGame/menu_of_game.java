/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StartGame;

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
import javax.swing.JPanel;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author hp
 */
public class menu_of_game extends JFrame implements base_form{
    static AudioStream audios;
   public menu_of_game() throws IOException{
        
       create_form();
        
   }
    @Override
    public void create_form() {
       try {
           setTitle(title);
           this.resize(1100, 900);
           this.setIconImage(Toolkit.getDefaultToolkit().getImage(pathicon));
           this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           this.setLocationRelativeTo(null);
           JLabel label1_ground=new JLabel(new ImageIcon(ImageIO.read(new File(pathbackground))));
           label1_ground.setBackground(new java.awt.Color(51, 51, 51));
           label1_ground.setOpaque(true);
           this.setContentPane(label1_ground);
           create_title(label1_ground);
           create_menu (label1_ground);
       } catch (IOException ex) {
           Logger.getLogger(menu_of_game.class.getName()).log(Level.SEVERE, null, ex);
       }
       }
private void create_title(JLabel label1_ground){
       try {
           JLabel maze=new JLabel(new ImageIcon(ImageIO.read(new File("res/mazetitle.png"))));
           maze.setBounds(80, 20, 900, 200);
           maze.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
           label1_ground.add(maze);
       } catch (IOException ex) {
           Logger.getLogger(menu_of_game.class.getName()).log(Level.SEVERE, null, ex);
       }
}
private void create_menu(JLabel label1_ground){
       try {
           JLabel label1_play=new JLabel(new ImageIcon(ImageIO.read(new File("res/play.png"))));
           label1_play.setBounds(95, 220, 900, 100);
           label1_play.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
           label1_ground.add(label1_play);
           JLabel label1_cursor=new JLabel(new ImageIcon(ImageIO.read(new File("res/cursor.png"))));
           label1_cursor.setBounds(200, 250, 50, 50);
           label1_ground.add(label1_cursor);
           JLabel label1_setting=new JLabel(new ImageIcon(ImageIO.read(new File("res/settings.png"))));
           label1_setting.setBounds(90, 320, 900, 100);
           label1_setting.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
           label1_ground.add(label1_setting);
           JLabel label1_exit=new JLabel(new ImageIcon(ImageIO.read(new File("res/exit.png"))));
           label1_exit.setBounds(260, 430, 580, 100);
           label1_exit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
           label1_ground.add(label1_exit);
           
           label1_play.addMouseListener(new MouseAdapter() {
               @Override
               public void mouseClicked(MouseEvent e) {
                   try {
                       playmusic("res\\sounds\\button_push.wav");
                       dispose();
                       new menu_play();
                   } catch (IOException ex) {
                       Logger.getLogger(menu_of_game.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
           });
           label1_setting.addMouseListener(new MouseAdapter() {
               @Override
               public void mouseClicked(MouseEvent e) {
                   playmusic("res\\sounds\\button_push.wav");
                   label1_cursor.setBounds(195, 350, 50, 50);
                   new form_setting();
               }
           });
           label1_exit.addMouseListener(new MouseAdapter() {
               @Override
               public void mouseClicked(MouseEvent e) {
                   playmusic("res\\sounds\\button_push.wav");
                   label1_cursor.setBounds(195, 350, 50, 50);
                   //dispose();
                   System.exit(0);
                   
               }
           });
           
           setVisible(true);
       } catch (IOException ex) {
           Logger.getLogger(menu_of_game.class.getName()).log(Level.SEVERE, null, ex);
       }
}
 public void playmusic(String path){
      InputStream test ;
     try{
         test = new FileInputStream(path);
         audios=new AudioStream(test);
         AudioPlayer.player.start(audios);
         
         //AudioPlayer.player.stop();
     }catch(Exception e){
         System.out.println("error");

}
     }

   
}

