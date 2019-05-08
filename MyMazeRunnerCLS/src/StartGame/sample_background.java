/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StartGame;

import static StartGame.menu_of_game.audios;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.border.SoftBevelBorder;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author hp
 */
public class sample_background extends JFrame implements base_form{
     static AudioStream audios;
   public sample_background() throws IOException{
         create_form();
        
   }
    @Override
    public void create_form() {
       try {
           playmusic("res\\DesiJourney.wav");
           setTitle(title);
           this.resize(1100, 900);
           this.setIconImage(Toolkit.getDefaultToolkit().getImage("res/maze.png"));
           this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           this.setLocationRelativeTo(null);
           JLabel label1_ground=new JLabel(new ImageIcon(ImageIO.read(new File(pathbackground))));
           this.setContentPane(label1_ground);
           create_title_maze(label1_ground);
           create_start_bar(label1_ground);
       } catch (IOException ex) {
           Logger.getLogger(sample_background.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    private void create_title_maze(JLabel label1_ground){
       try {
           JLabel maze=new JLabel(new ImageIcon(ImageIO.read(new File("res/mazetitle.png"))));
           maze.setBounds(35, 300, 1000, 100);
           label1_ground.add(maze);
       } catch (IOException ex) {
           Logger.getLogger(sample_background.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    private void create_start_bar(JLabel label1_ground){
       try {
           JLabel start=new JLabel();
           start.setBounds(90, 450, 900, 100);
           start.setFont(new java.awt.Font("Showcard Gothic", 0, 36)); // NOI18N
           start.setForeground(new java.awt.Color(255, 255, 225));
           start.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
           start.setText(" Getting....");
           label1_ground.add(start);
           setVisible(true);
           fun_bar(label1_ground);
       } catch (IOException ex) {
           Logger.getLogger(sample_background.class.getName()).log(Level.SEVERE, null, ex);
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
     
     //public void button_sound(String path){
       //  
     //}
       
 }
 public void fun_bar(JLabel label1_ground) throws IOException{
         JProgressBar  pbar = new JProgressBar();
         pbar.setMinimum(0);
         pbar.setMaximum(100);
         pbar.setBounds(160, 580, 710, 60);
         label1_ground.add(pbar);
        pbar.setForeground(new java.awt.Color(0,0,0));
        pbar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
         for (int i = 0; i <= 100; i++) {
      final int percent = i;
      try {
        SwingUtilities.invokeLater(new Runnable() {
          public void run() {
            pbar.setValue(percent);
          }
        });
        java.lang.Thread.sleep(70);
      } catch (InterruptedException e) {
        ;
      }
        }
         this.dispose();
         new menu_of_game();
         
         
 
 }

   
}

