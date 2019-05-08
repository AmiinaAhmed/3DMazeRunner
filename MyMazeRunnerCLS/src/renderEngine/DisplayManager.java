package renderEngine;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;
import org.newdawn.slick.opengl.ImageIOImageData;

public class DisplayManager {
	
	private static final int WIDTH = 1100;
	private static final int HEIGHT = 900;
	private static final int FPS_CAP = 120;
        private static long lastFrametime;
        private static float delta;
	
	public static void createDisplay() {
		ContextAttribs attribs = new ContextAttribs(3,2)
		.withForwardCompatible(true)
		.withProfileCore(true);
                   
		 try {
                        Display.setIcon(new ByteBuffer[] {
                            new ImageIOImageData().imageToByteBuffer(ImageIO.read(new File("res/maze (1).png")), false, false, null),
                            new ImageIOImageData().imageToByteBuffer(ImageIO.read(new File("res/maze.png")), false, false, null)
                        });
                    } catch (IOException ex) {
                        Logger.getLogger(DisplayManager.class.getName()).log(Level.SEVERE, null, ex);
                    }
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH,HEIGHT));
			Display.create(new PixelFormat(), attribs);
			Display.setTitle("Maze Runner");
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		GL11.glViewport(0,0, WIDTH, HEIGHT);
                lastFrametime=getCurrentime();
               
	}
	
	public static void updateDisplay(){
		
		Display.sync(FPS_CAP);
		Display.update();
		long currentFrametime=getCurrentime();
                delta=(currentFrametime-lastFrametime)/1000f;
		lastFrametime=getCurrentime();
	}
	
	public static void closeDisplay(){
		
		Display.destroy();
		
	}
        public static float getFrameTimeseconds(){
            return delta;
        }
        private static long getCurrentime(){
            return Sys.getTime()*1000/Sys.getTimerResolution();
        }
}
