/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Levels;

import StartGame.Win;
import StartGame.gameover;
import entities.Camera;
import entities.Entity;
import entities.Gift;
import entities.Light;
import entities.Monstor;
import entities.Player;
import entities.end_point;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;
import renderEngine.DisplayManager;
import renderEngine.MasterRenderer;

/**
 *
 * @author hp
 */
public class level extends abs_class{

    public level(String player_path_image_im, String player_path_image_ob, String manstor_path_image_im, 
            String manstor_path_image_ob, String wall_path_image_im, String wall_path_image_ob, String gifts_path_image_im, String gifts_path_image_ob, 
            String land_path_image_im,String stop_path_image_im,int size,long specific_min,long specific_sec, char[][] arr) throws InterruptedException {
       super(player_path_image_im, player_path_image_ob, manstor_path_image_im, manstor_path_image_ob, wall_path_image_im, wall_path_image_ob, gifts_path_image_im, gifts_path_image_ob, land_path_image_im,stop_path_image_im,size,specific_min,specific_sec,arr);
       draw_land();
       play();
      // clear_all();
    }

   

    
     

    @Override
    void draw_land() {   
        for(int i=1;i<arr.length;i++)
                    for(int j=1;j<arr[0].length;j++){
                        //walls
                       if( j!=arr[0].length-1){
                            if(i%2==0 && j%4==1){
                                if(arr[i][j]=='-')
                                 entitiesWalls.add(new Entity(staticModelW, new Vector3f((((int)(j/4))*40),2,(((int)(i/2))*40)),0,90,0,5));
                            }
                            else if(j%4==0){
                                if(arr[i][j]=='|')
                                    entitiesWalls.add(new Entity(staticModelW, new Vector3f((((int)(j/4))*40),2,(((int)(i/2))*40)),0,0,0,5));
                            }
                        }
                        if( arr[i][j]=='G')
                            entitiesGifts.add(new Gift(stanfordGifts,new Vector3f(j*10,5,i*20),0,0,0,3));
                        if(arr[i][j]=='P')
                            player=new Player(stanfordBunny, new Vector3f(j*10,0,i*20), 0, 0, 0, 1.4f); 
                        if(arr[i][j]=='E')                           
                            end =new end_point(stanfordend,  new Vector3f(j*10,10,i*20), 0, 0, 0, 10f);
                        
                         if(arr[i][j]=='M'){
                           monster.add(new Monstor(stanfordMonstor,new Vector3f(j*10,0,i*20),0,0,0,1.3f));
                         }
                    } 
                    int width=40;
                    for(int i=0;i<terrain.getVERTEX_COUNT()-1;i++){
                        entitiesWalls.add(new Entity(staticModelW, new Vector3f((i*width),2,0),0,90,0,5));
                        entitiesWalls.add(new Entity(staticModelW, new Vector3f(0,2,i*width),0,0,0,5));
                        entitiesWalls.add(new Entity(staticModelW, new Vector3f((i*width),2,size),0,90,0,5));
                        entitiesWalls.add(new Entity(staticModelW, new Vector3f(size,2,(i*width)),0,0,0,5));
		}
    }

    @Override
    void play() {
        
        try {
            light = new Light(new Vector3f(20000, 20000, 2000), new Vector3f(1, 1, 1));
            renderer = new MasterRenderer(loader); int res=3;
            camera = new Camera(player);
            boolean move = true;   
            long current_min=0,current_second=0;
            Thread.sleep(1000); 
            while (!Display.isCloseRequested()) {
                camera.move();
                timepassed = System.currentTimeMillis() - starttime;
               
                secondspassed = timepassed / 1000;
                if (secondspassed == 60) {
                    secondspassed = 0;
                    displayMinutes++;
                    starttime = System.currentTimeMillis();
                }
                
                Display.setTitle("Mazer runner  Timer:" + displayMinutes + " : " + secondspassed + "  TRIES : "+player.tries +"  GIFTS: "+player.num_gifts );
                if (displayMinutes == specific_minutes && secondspassed==specific_second ){
                    current_min=specific_minutes; current_second=specific_second;
                    player.stop_move();
                    guirender.render(guis);
                    move=false;
                  res=0;
                  break;
                }
                
                if (move) {
                    player.move(entitiesWalls, monster, entitiesGifts,end);
                    move = player.move(entitiesWalls, monster, entitiesGifts,end);
                    renderer.processTerrain(terrain);
                    renderer.processEntity(player);
                    renderer.processEntity(end);
                    //
                    
                    
                    for (Entity entity : entitiesWalls) {
                        renderer.processEntity(entity);
                    }
                    for (Gift entity : entitiesGifts) {
                        renderer.processEntity(entity);
                    }
                    for (Monstor monster_play : monster) {
                        renderer.processEntity(monster_play);
                        monster_play.move(entitiesWalls);
                    }
                    
                    renderer.render(light, camera);
                    
                
                }
                if (!move && player.found_end==false){
                    if(player.tries > 0){
                     player.move_monster(entitiesWalls,monster);
                     move=true;
                     continue;
                    }
                    else{
                    player.stop_move();
                    for (Monstor monster1 : monster) {
                        monster1.stop_move();
                    }
                    Thread.sleep(1000);
                    current_min=displayMinutes; current_second=secondspassed;
                    guirender.render(guis);
                    res=0;
                     break;                    
                    }
                    
                }
               if (!move && player.found_end==true ){
                   if(player.num_gifts==3)
                   {
                    res=1;
                    break;
                   }
                    player.stop_move();
                    current_min=displayMinutes; current_second=secondspassed;
                    res=0;
                    break;
                }
                DisplayManager.updateDisplay();
            }
            clear_all();
            if(res==0){
            try {
                        new gameover(player.tries,player.num_gifts,current_min,current_second);
                    } catch (IOException ex) {
                        Logger.getLogger(level.class.getName()).log(Level.SEVERE, null, ex);
                    }}
            else if(res==1){
                try {
                    new Win(player.tries,player.num_gifts,current_min,current_second);
                } catch (IOException ex) {
                    Logger.getLogger(level.class.getName()).log(Level.SEVERE, null, ex);
                }
}
        } catch (InterruptedException ex) {
            Logger.getLogger(level.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    void clear_all() {
    
        guirender.cleanUp();
        guirenderWinner.cleanUp();
	renderer.cleanUp();
	loader.cleanUp();
        DisplayManager.closeDisplay();
    }
    
}
