/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.nio.file.FileVisitResult;
import java.util.ArrayList;
import java.util.List;
import models.TexturedModel;
import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;
import renderEngine.DisplayManager;
import terrains.Terrain;

/**
 *
 * @author hp
 */
public class Player extends Character  {
    static public boolean found_end=false;
    static public int num_gifts=0;
    public static int tries=3;
    public Player(TexturedModel model, Vector3f position, float rotX, float rotY, float rotZ, float scale) {
        super(model, position, rotX, rotY, rotZ, scale);
            
    }
    
   
    public void mov2(List<Entity> entities,end_point end){
         try{
               super.increaseRotation(0, currentTurnSpeed * DisplayManager.getFrameTimeseconds(), 0);
		 distance = currentSpeed * DisplayManager.getFrameTimeseconds();
		 dx = (float) (distance * Math.sin(Math.toRadians(super.getRotY())));
		 dz = (float) (distance * Math.cos(Math.toRadians(super.getRotY())));
                 if( !is_collais(entities,new Vector3f(super.getPosition().x+dx,0,super.getPosition().z+dz)) && !foundflag(end))
                 {
                     super.increasePosition(dx, 0, dz); }
                
                 
             }catch(Exception e)
             {
                 System.out.println(e.getCause());
             }          
    }
    @Override
         public boolean is_collais(List<Entity> entities,Vector3f point){
            boolean found=false; 
                      for(Entity entity:entities){ 
                          if(entity.getRotY()==90){
                               if ((point.x <= entity.getPosition().x +40 && point.x+3 >= entity.getPosition().x) && //
					(point.z <= entity.getPosition().z+5 && point.z+3 >= entity.getPosition().z)) //
                                    {
                               
                                         found=true; break;
                                    }
                                        
                           else
		            found=false;
                          }
                          else{
                              if ((point.x <= entity.getPosition().x+5  &&   point.x+4 >= entity.getPosition().x) && //
				(point.z <= entity.getPosition().z+40 && point.z+4 >= entity.getPosition().z)) //
                                     {
                               
                                         found=true; break;}
                                        
                                   else
		                            found=false;
                          }
                      }
                      return found;
         }
      public boolean move(List<Entity> entities,List<Monstor> monsters,List<Gift> gifts,end_point end) {
     boolean moving=true;
      
                 if (Keyboard.isKeyDown(Keyboard.KEY_UP )) {
                   
                    if (Keyboard.isKeyDown(Keyboard.KEY_E)){
                     
                     this.currentSpeed = maxSpeed;
                     }
                    else {
                     
                     this.currentSpeed = RUN_SPEED;
                     }
                     mov2(entities,end);
                    
                    foundGift(gifts);
                    if(is_collias_monster(monsters) || foundflag(end))
                    { moving=false; return false;}
                } else if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)){
                        
                    if (Keyboard.isKeyDown(Keyboard.KEY_E)){
                     this.currentSpeed = -maxSpeed;
                     }
                    else {
                     
                     this.currentSpeed = -RUN_SPEED;
                     }
                      mov2(entities,end);
                          foundGift(gifts);
			if(is_collias_monster(monsters) || foundflag(end))
                    { moving=false; return false;}
                }
                else{
                    this.currentSpeed = 0;
                   
                }
		if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
                    //this.currentTurnSpeed = -TURN_SPEED; 
                    
                     if (Keyboard.isKeyDown(Keyboard.KEY_E)){
                     
                     this.currentTurnSpeed = -maxSpeed_turn;
                     }
                    else {
                     
                     this.currentTurnSpeed = -TURN_SPEED;
                     }
                      mov2(entities,end);
                     foundGift(gifts);
                     
                      if(is_collias_monster(monsters) || foundflag(end))
                    { moving=false; return false;}
		} else if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
                         if (Keyboard.isKeyDown(Keyboard.KEY_E)){
                     
                     this.currentTurnSpeed = maxSpeed_turn;
                     }
                    else {
                     
                     this.currentTurnSpeed = TURN_SPEED;
                     }
                          mov2(entities,end);
                         foundGift(gifts);
                          if(is_collias_monster(monsters) || foundflag(end))
                    { moving=false; return false;}
		} else {
			this.currentTurnSpeed = 0;
                        
		}
             return moving;  
        }
     boolean is_collias_monster(List<Monstor> monsters){
         boolean found=false; 
                      for(Monstor monster:monsters){ 
                          if(monster.getRotY()==90){
                           if ((super.getPosition().x <= monster.getPosition().x +20 && super.getPosition().x+5 >= monster.getPosition().x) && //
					(super.getPosition().z <= monster.getPosition().z+20 && super.getPosition().z+5 >= monster.getPosition().z)) //
                           {
                               
                                         found=true; break;}
                                        
                           else
		            found=false;
                          }
                          else{
                              if ((super.getPosition().x <= monster.getPosition().x+20  &&   super.getPosition().x+4 >= monster.getPosition().x) && //
				(super.getPosition().z <= monster.getPosition().z+20 && super.getPosition().z+4 >= monster.getPosition().z)) //
                                     {
                               
                                         found=true; break;}
                                        
                                   else
		                            found=false;
                          }
                      }
                      return found;

}
    void foundGift(List<Gift> entities){
            for(Entity entity:entities){                         
                if ((super.getPosition().x-5 <= entity.getPosition().x  && super.getPosition().x+5>= entity.getPosition().x) && //
					(super.getPosition().z-5 <= entity.getPosition().z+5 && super.getPosition().z+5 >= entity.getPosition().z)){ //
                   num_gifts++;
                    entities.remove(entity);
                   break;
                }
            }         

    }
   public void move_monster(List<Entity> entities,List<Monstor> monsters){
         boolean found=false; 
                      for(Monstor monster:monsters){ 
                          if(monster.getRotY()==90){
                           if ((super.getPosition().x <= monster.getPosition().x  && super.getPosition().x+5 >= monster.getPosition().x) && //
					(super.getPosition().z <= monster.getPosition().z && super.getPosition().z+5 >= monster.getPosition().z)) //
                           {
                                       tries--; 
                                        monster.re_move(entities, super.getPosition());
                                        break;}
                                        
                          
                          }
                          else{
                              if ((super.getPosition().x <= monster.getPosition().x+20  &&   super.getPosition().x+4 >= monster.getPosition().x) && //
				(super.getPosition().z <= monster.getPosition().z+20 && super.getPosition().z+4 >= monster.getPosition().z)) //
                                     {
                                        tries--; 
                                        monster.re_move(entities, super.getPosition()); break;
                              }
                          }
                      }
}
    boolean foundflag(end_point end){
                                 
                if ((super.getPosition().x <= end.getPosition().x +3  && super.getPosition().x+5>= end.getPosition().x) && //
					(super.getPosition().z <= end.getPosition().z+3 && super.getPosition().z+5 >= end.getPosition().z)){ //
                    {
                                            found_end=true;
                                            return true;}
                  
                }
                return false;
            }        

    

    }
