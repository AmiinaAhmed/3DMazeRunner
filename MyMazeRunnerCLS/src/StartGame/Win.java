/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StartGame;

import Game_Object.Player;
import Levels.level;
import MainGame.Display;
import MainGame.GameMap;
import MainGame.LoadLevel;
import static StartGame.base_form.pathbackground;
import static StartGame.base_form.pathicon;
import static StartGame.base_form.title;
import static StartGame.menu_of_game.audios;
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
public class Win extends JFrame implements base_form{
    private GameMap gameMap;
     private Player player;
     private LoadLevel loadLevel;
     private Display display;
     long time_min,time_sec;
     int num_tries;
     int num_gifts;
    public Win(int num_tries,int num_g,long num_min,long num_sec)throws IOException{
        this.num_tries=num_tries;
        this.num_gifts=num_g;
        this.time_min=num_min;
        this.time_sec=num_sec;
       create_form();
        
   }

    
    @Override
    public void create_form() {
         try {
           setTitle(title);
           this.resize(900, 900);
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
           JLabel maze=new JLabel(new ImageIcon(ImageIO.read(new File("res/textfx2.png"))));
           maze.setBounds(10, 20, 800, 200);
           maze.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
           label1_ground.add(maze);
       } catch (IOException ex) {
           Logger.getLogger(menu_of_game.class.getName()).log(Level.SEVERE, null, ex);
       }
}
    private void create_menu(JLabel label1_ground){
       try {
           JLabel label1_replay=new JLabel(new ImageIcon(ImageIO.read(new File("res/replay.png"))));
           label1_replay.setBounds(10, 600, 400, 100);
           label1_replay.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
           label1_ground.add(label1_replay);
           //////////
           JLabel label1_back=new JLabel(new ImageIcon(ImageIO.read(new File("res/ba.png"))));
           label1_back.setBounds(480, 600, 400, 100);
           label1_back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
           label1_ground.add(label1_back);
           ////////////////////////////////////
            JLabel result=new JLabel();
            result.setBounds(180, 180, 500, 100);
            result.setFont(new java.awt.Font("Showcard Gothic", 0, 36)); // NOI18N
            result.setForeground(new java.awt.Color(0, 0, 0));
            result.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            result.setText("__RESULT__");
            result.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            label1_ground.add(result);
            ///////
            JLabel timer=new JLabel();
            timer.setBounds(230, 290, 400, 100);
            timer.setFont(new java.awt.Font("Leelawadee UI", 0, 36)); // NOI18N
            timer.setForeground(new java.awt.Color(225, 255, 255));
            timer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            timer.setText("TIME : "+this.time_min+" : "+this.time_sec);
            timer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            label1_ground.add(timer);
            /////////////////////////
            JLabel gifts=new JLabel();
            gifts.setBounds(230, 360, 400, 100);
            gifts.setFont(new java.awt.Font("Leelawadee UI", 0, 36)); // NOI18N
            gifts.setForeground(new java.awt.Color(225, 255, 255));
            gifts.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            gifts.setText("GIFTS : "+ this.num_gifts);
            gifts.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            label1_ground.add(gifts);
            /////////////////////////
            JLabel tries=new JLabel();
            tries.setBounds(230, 430, 400, 100);
            tries.setFont(new java.awt.Font("Leelawadee UI", 0, 36)); // NOI18N
            tries.setForeground(new java.awt.Color(225, 255, 255));
            tries.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            tries.setText("TRIES : "+this.num_tries);
            gifts.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            label1_ground.add(tries);
           
           
           label1_replay.addMouseListener(new MouseAdapter() {
               @Override
               public void mouseClicked(MouseEvent e) {
                   try {
                       playmusic("res\\sounds\\button_push.wav");
                       dispose();
                       gameMap = new GameMap(menu_play.len_wid, menu_play.len_wid);
                       player = new Player(gameMap.getRandomPosition());
                       startLoadLevel();
                       char arr[][]=gameMap.getMap();dispose();
                       level l=new level("playerTexture","person", "ogre", "spider6", "plank1","test1" ,"T_M_bag_BaseColor" ,"aid3","metal0","sticker-auto-moto-humour-gameover-01",menu_play.width_land,level.specific_minutes,level.specific_second, arr);
                   } catch (InterruptedException ex) {
                       Logger.getLogger(gameover.class.getName()).log(Level.SEVERE, null, ex);
                   }
                  
               }
           });
           label1_back.addMouseListener(new MouseAdapter() {
               @Override
               public void mouseClicked(MouseEvent e) {
                   try {
                       playmusic("res\\sounds\\button_push.wav");
                       new menu_of_game();
                   } catch (IOException ex) {
                       Logger.getLogger(gameover.class.getName()).log(Level.SEVERE, null, ex);
                   }
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
  private void startLoadLevel() {
        loadLevel = new LoadLevel(gameMap, player, display);
    }
}
