package engineTester;


import Levels.level;
import MainGame.GameMap;
import MainGame.StartGame;
import StartGame.gameover;
import StartGame.sample_background;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import models.RawModel;
import models.TexturedModel;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.MasterRenderer;
import renderEngine.OBJLoader;
import terrains.Terrain;
import textures.ModelTexture;
import entities.Camera;
import entities.Entity;
import entities.Gift;
import entities.Light;
import entities.Monstor;
import entities.Player;
import guis.GuiRenderer;
import guis.GuiTexture;
import java.io.IOException;
import org.lwjgl.opengl.GL11;
import static org.lwjgl.opengl.GL11.glRotatef;
import org.lwjgl.opengl.GL30;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;

public class MainGameLoop {
	public static void main(String[] args) throws InterruptedException, IOException {
            
              new sample_background();
////                  StartGame g1=new StartGame();
////                  GameMap Mazesh=g1.getGameMap();
////                  char arr[][]=Mazesh.getMap();
////                   level l=new level("46E6F958","solider", "ogre", "spider6", "grass","test1" ,"T_M_bag_BaseColor" ,"aid3","dirt0","sticker-auto-moto-humour-gameover-01",400, arr);
////                 
//    // new result();
        //  new gameover(0,0,01L,11L);
        }

}
