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
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import java.util.Scanner;
import Game_Object.Player;
import Levels.level;
import MainGame.Display;
import MainGame.GameMap;
import MainGame.LoadLevel;
import MainGame.StartGame;

/**
 *
 * @author hp
 */
public class menu_play extends JFrame implements base_form{
    private GameMap gameMap;
     private Player player;
     private LoadLevel loadLevel;
     private Display display;
     AudioStream audios;
     static int len_wid;
     static int width_land;
   public menu_play() throws IOException{
        create_form();
   }
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
        maze.setBounds(90, 20, 900, 200);
        maze.setBackground(new java.awt.Color(255, 255, 225));
        maze.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        label1_ground.add(maze);
       } catch (IOException ex) {
           Logger.getLogger(menu_of_game.class.getName()).log(Level.SEVERE, null, ex);
       }
}
private void create_menu(JLabel label1_ground){
       
       int mazeHeight = 0, mazeWidth = 0;
       try {
        JLabel maze=new JLabel(new ImageIcon(ImageIO.read(new File("res/mazetitle.png"))));
        maze.setBounds(90, 20, 900, 200);
        maze.setBackground(new java.awt.Color(255, 255, 225));
        maze.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        label1_ground.add(maze);
        //////////////
        JLabel level1=new JLabel();
        level1.setBounds(80, 200, 900, 100);
        level1.setFont(new java.awt.Font("Showcard Gothic", 0, 36)); // NOI18N
        level1.setForeground(new java.awt.Color(255, 255, 225));
        level1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        level1.setText("Base Level");
        level1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        label1_ground.add(level1);
        level1.addMouseListener(new MouseAdapter() {
               @Override
               public void mouseClicked(MouseEvent e) {
                   try {
                       playmusic("res\\sounds\\button_push.wav");
                        gameMap = new GameMap(10, 10);
                        player = new Player(gameMap.getRandomPosition());
                        startLoadLevel();
                        char arr[][]=gameMap.getMap();dispose();
                        len_wid=10; width_land=400;
                       level l=new level("playerTexture","person", "ogre", "spider6", "plank1","test1" ,"T_M_bag_BaseColor" ,"aid3","metal0","sticker-auto-moto-humour-gameover-01",400,03L,30L, arr);
                  
                   } catch (InterruptedException ex) {
                       Logger.getLogger(menu_play.class.getName()).log(Level.SEVERE, null, ex);
                   }
               
                    
                   
               }
           });
        /////////////////////////////////////////
        JLabel label1_cursor=new JLabel(new ImageIcon(ImageIO.read(new File("res/cursor.png"))));
        label1_cursor.setBounds(200, 230, 50, 50);
        label1_ground.add(label1_cursor);
        ///////////////////
        JLabel level2=new JLabel();
        level2.setBounds(80, 300, 900, 100);
        level2.setFont(new java.awt.Font("Showcard Gothic", 0, 36)); // NOI18N
        level2.setForeground(new java.awt.Color(255, 255, 225));
        level2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        level2.setText("Medium Level");
        level2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        label1_ground.add(level2);
        level2.addMouseListener(new MouseAdapter() {
               @Override
               public void mouseClicked(MouseEvent e) {
                   try {
                       label1_cursor.setBounds(200, 330, 50, 50);
                       playmusic("res\\sounds\\button_push.wav");
                       gameMap = new GameMap(20, 20);
                        player = new Player(gameMap.getRandomPosition());
                        startLoadLevel();
                        char arr[][]=gameMap.getMap();dispose();
                        len_wid=20; width_land=800;
                       level l=new level("playerTexture","person", "ogre", "spider6", "plank1","test1" ,"T_M_bag_BaseColor" ,"aid3","metal0","sticker-auto-moto-humour-gameover-01",800,04L,60L, arr);
                  
                   } catch (InterruptedException ex) {
                       Logger.getLogger(menu_play.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   
               }
           });
        ////////////////////////////////////////////
        JLabel level3=new JLabel();
        level3.setBounds(80, 400, 900, 100);
        level3.setFont(new java.awt.Font("Showcard Gothic", 0, 36)); // NOI18N
        level3.setForeground(new java.awt.Color(255, 255, 225));
        level3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        level3.setText("Advanced Level");
        level3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        label1_ground.add(level3);
        level3.addMouseListener(new MouseAdapter() {
               @Override
               public void mouseClicked(MouseEvent e) {
                   try {
                       label1_cursor.setBounds(200, 430, 50, 50);
                       gameMap = new GameMap(30, 30);
                        player = new Player(gameMap.getRandomPosition());
                        startLoadLevel();
                        char arr[][]=gameMap.getMap();dispose();
                        len_wid=30; width_land=1200;
                       level l=new level("playerTexture","person", "ogre", "spider6", "plank1","test1" ,"T_M_bag_BaseColor" ,"aid3","metal0","sticker-auto-moto-humour-gameover-01",1200,06L,00L, arr);
                  
                   } catch (InterruptedException ex) {
                       Logger.getLogger(menu_play.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   
               }
           });
        /////////////////////////
        JLabel labelB=new JLabel();
        labelB.setBounds(7, 600, 100, 100);
        labelB.setFont(new java.awt.Font("Showcard Gothic", 0, 36)); // NOI18N
        labelB.setForeground(new java.awt.Color(255, 255, 225));
        labelB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelB.setText("BACK");
        labelB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        label1_ground.add(labelB);
        setVisible(true);
        labelB.addMouseListener(new MouseAdapter() {
        @Override
         public void mouseClicked(MouseEvent e) {
            try {
                playmusic("res\\sounds\\button_push.wav");
                dispose();
                new menu_of_game();
            } catch (IOException ex) {
                Logger.getLogger(menu_of_game.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    });
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
     }catch(Exception e){
         System.out.println("error");
}
     }
   private void startLoadLevel() {
        loadLevel = new LoadLevel(gameMap, player, display);
      //  display.createCoveredMap();
    }
}
