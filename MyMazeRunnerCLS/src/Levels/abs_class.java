/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Levels;

import entities.Camera;
import entities.Entity;
import entities.Gift;
import entities.Light;
import entities.Monstor;
import entities.Player;
import entities.end_point;
import guis.GuiRenderer;
import guis.GuiTexture;
import java.util.ArrayList;
import java.util.List;
import models.RawModel;
import models.TexturedModel;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.MasterRenderer;
import renderEngine.OBJLoader;
import terrains.Terrain;
import textures.ModelTexture;

/**
 *
 * @author hp
 */
public abstract class abs_class {
    private String player_path_image_im;
    private String player_path_image_ob;
    private String manstor_path_image_im;
    private String manstor_path_image_ob;
    private String wall_path_image_im;
    private String wall_path_image_ob;
    private String gifts_path_image_im;
    private String gifts_path_image_ob;
    private String land_path_image_im;
    private String stop_path_image_im;
    private String end_path_image_im;
    Terrain terrain;
    int size ;
    List<Entity> entitiesWalls;
    List<Monstor> monster;
    Player player;
    List<Gift> entitiesGifts;
    GuiTexture guis;
    GuiTexture win;
    end_point end;
    Loader loader;
    GuiRenderer guirender;
    GuiRenderer guirenderWinner;
    TexturedModel staticModelW ;
    TexturedModel stanfordMonstor; 
    TexturedModel stanfordGifts;
    TexturedModel stanfordBunny;
    TexturedModel stanfordend;
    MasterRenderer renderer;
    
    Camera camera;
    Light light;
    
    static long starttime=System.currentTimeMillis();
    static long timepassed=System.currentTimeMillis()-starttime;
    static long secondspassed=timepassed/1000;
    static long displayMinutes=00;
    public static long specific_second;
    public static long specific_minutes;
    char arr[][];
    int delay = 1000; // delay for 1 sec. 
    int period = 1000; // repeat every sec.

    public abs_class(String player_path_image_im, String player_path_image_ob, String manstor_path_image_im, 
            String manstor_path_image_ob, String wall_path_image_im, String wall_path_image_ob, String gifts_path_image_im,
            String gifts_path_image_ob , String land_path_image_im,String stop_path_image_im,int size,long specific_minutes,long specific_second,char arr[][]) throws InterruptedException {
        this.player_path_image_im = player_path_image_im;
        this.player_path_image_ob = player_path_image_ob;
        this.manstor_path_image_im = manstor_path_image_im;
        this.manstor_path_image_ob = manstor_path_image_ob;
        this.wall_path_image_im = wall_path_image_im;
        this.wall_path_image_ob = wall_path_image_ob;
        this.gifts_path_image_im = gifts_path_image_im;
        this.gifts_path_image_ob = gifts_path_image_ob;
        this.land_path_image_im = land_path_image_im;
        this.stop_path_image_im= stop_path_image_im;
        this.specific_minutes=specific_minutes;
        this.specific_second=specific_second;
        this.arr=arr;
        this.size=size;
       create_base();
        
        
    }
    
    void create_base() throws InterruptedException{
       
        DisplayManager.createDisplay();
        loader = new Loader();
        terrain = new Terrain(0f, 0f, loader, new ModelTexture(loader.loadTexture(land_path_image_im)), this.size);
        ///////////////wall
        RawModel modelW = OBJLoader.loadObjModel(wall_path_image_ob, loader); //load object
        staticModelW = new TexturedModel(modelW, new ModelTexture(loader.loadTexture(wall_path_image_im))); //load picture
        entitiesWalls = new ArrayList<Entity>();
        //////////////////////////////Monster
        RawModel monstermodel = OBJLoader.loadObjModel(manstor_path_image_ob, loader); // load object monstor
        stanfordMonstor = new TexturedModel(monstermodel, new ModelTexture(loader.loadTexture(manstor_path_image_im))); // load image monstor
        monster = new ArrayList<Monstor>();
        //player
        RawModel ModelPlayer = OBJLoader.loadObjModel(player_path_image_ob, loader);
         stanfordBunny = new TexturedModel(ModelPlayer, new ModelTexture(loader.loadTexture(player_path_image_im)));
         ////////end point
          RawModel Modelendpoint = OBJLoader.loadObjModel("f", loader);
         stanfordend = new TexturedModel(Modelendpoint, new ModelTexture(loader.loadTexture("metal0")));
       
         
        //////Gifts  
        entitiesGifts = new ArrayList<Gift>();
        RawModel Giftsmodel = OBJLoader.loadObjModel(gifts_path_image_ob, loader); // load object monstor
        stanfordGifts = new TexturedModel(Giftsmodel, new ModelTexture(loader.loadTexture(gifts_path_image_im))); // load image monstor
        /////Picture when player losed
        guis= new GuiTexture(loader.loadTexture(stop_path_image_im), new Vector2f(.5f, -.5f), new Vector2f(1f,1f));
        guirender = new GuiRenderer(loader);
        win= new GuiTexture(loader.loadTexture("win"), new Vector2f(0f,0f), new Vector2f(.5f,.5f));
        guirenderWinner = new GuiRenderer(loader);
    }
    abstract void draw_land();
    abstract void play();
    abstract void clear_all();
    
    
}
