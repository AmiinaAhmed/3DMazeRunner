/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;


import java.util.List;
import models.TexturedModel;
import org.lwjgl.util.vector.Vector3f;

/**
 *
 * @author hp
 */
 public abstract class Character extends Entity {
        public static  float RUN_SPEED = 30;
	public static  float TURN_SPEED = 50;
        public  float maxSpeed = 45;
        public static  float maxSpeed_turn = 60;
	public  float currentSpeed = 0;
	public  float currentTurnSpeed = 0;
        public static float distance=0;
        public float dx,dz;

    public Character(TexturedModel model, Vector3f position, float rotX, float rotY, float rotZ, float scale) {
        super(model, position, rotX, rotY, rotZ, scale);
        
    }
    //public abstract void  mov2(List<Entity> entities);
    public abstract boolean is_collais(List<Entity> entities,Vector3f point);
     public void stop_move(){
        currentSpeed=0;
    }
}
