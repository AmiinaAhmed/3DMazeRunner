/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import static entities.Character.RUN_SPEED;
import static entities.Character.TURN_SPEED;
import static entities.Character.distance;
import java.util.List;
import models.TexturedModel;
import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;
import renderEngine.DisplayManager;

/**
 *
 * @author hp
 */
public class Monstor extends Character {
         public static  float RUN_SPEED=7;
         float rotation=90;
    public Monstor(TexturedModel model, Vector3f position, float rotX, float rotY, float rotZ, float scale) {
        super(model, position, rotX, rotY, rotZ, scale);
    }

   
    public void move(List<Entity> entities) { 
       
                    this.currentSpeed = RUN_SPEED;
                   Mov(entities);              			
    }
     public void re_move(List<Entity> entities,Vector3f point) { 
       
                    this.currentSpeed = RUN_SPEED;
                   mov2(entities,point);              			
    }
    
    public void mov2(List<Entity> entities,Vector3f point) {
        try{
		 distance = currentSpeed * DisplayManager.getFrameTimeseconds();
		 dx = (float) (distance * Math.sin(Math.toRadians(super.getRotY())));
		 dz = (float) (distance * Math.cos(Math.toRadians(super.getRotY())));               
                  if( !is_collais(entities,new Vector3f(super.getPosition().x+dx,0,super.getPosition().z+dz)) && !is_collais_player(new Vector3f(super.getPosition().x+dx,0,super.getPosition().z+dz),point))
                     super.increasePosition(dx, 0, dz);  
                  
             }catch(Exception e)
             {
                 System.out.println(e.getCause());
             } 
    }
  
     public void Mov(List<Entity> entities) {
        try{
		 distance = currentSpeed * DisplayManager.getFrameTimeseconds();
		 dx = (float) (distance * Math.sin(Math.toRadians(super.getRotY())));
		 dz = (float) (distance * Math.cos(Math.toRadians(super.getRotY())));               
                  if( !is_collais(entities,new Vector3f(super.getPosition().x+dx,0,super.getPosition().z+dz)))
                     super.increasePosition(dx, 0, dz); 
                  else 
                      super.increaseRotation(0, 1, 0);
                  
             }catch(Exception e)
             {
                 System.out.println(e.getCause());
             } 
    }
    @Override
    public boolean is_collais(List<Entity> entities, Vector3f point) {
         boolean found=false; 
                      for(Entity entity:entities){ 
                          if(entity.getRotY()==90){
                           if ((point.x-15 <= entity.getPosition().x +40 && point.x+15 >= entity.getPosition().x) && //
					(point.z-15 <= entity.getPosition().z && point.z+15 >= entity.getPosition().z)) //
                           {
                               
                                         found=true; break;}
                                        
                           else
		            found=false;
                          }
                          else{
                              if ((point.x-15 <= entity.getPosition().x  &&   point.x+15 >= entity.getPosition().x) && //
				(point.z-15 <= entity.getPosition().z+40 && point.z+15 >= entity.getPosition().z)) //
                                     {
                               
                                         found=true; break;}
                                        
                                   else
		                            found=false;
                          }
                      }
                      return found;
         }
         
     public boolean is_collais_player( Vector3f point_p, Vector3f point_m) { 
                          
                if ((point_m.x-15 <= point_p.x +50 && point_m.x+15 >= point_p.x) && //
			(point_m.z-15 <= point_p.z && point_m.z+15 >= point_p.z)) //
                           {
                               
                              return true;          
                }
                                        
                           else
		           return false; 
                          
                          
                      }
                     
         
    }


