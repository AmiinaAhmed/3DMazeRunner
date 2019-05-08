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
 * @author ENG-HABIBA
 */
public class Gift extends Entity {
    public Gift(TexturedModel model, Vector3f position, float rotX, float rotY, float rotZ ,float scale) {
       super(model, position, rotX, rotY, rotZ, scale);
        
    }
     
}
