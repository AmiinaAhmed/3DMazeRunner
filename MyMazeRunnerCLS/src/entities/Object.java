/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import models.RawModel;
import models.TexturedModel;
import renderEngine.Loader;
import renderEngine.OBJLoader;
import textures.ModelTexture;

/**
 *
 * @author ENG-HABIBA
 */
public class Object {
     RawModel model ;
     public TexturedModel staticModel;
     float width;
     float height;
     public Object(String shape ,String textureOfShape,Loader loader){
           model = OBJLoader.loadObjModel(shape, loader);		
	   staticModel = new TexturedModel(model,new ModelTexture(loader.loadTexture(textureOfShape)));
     }
       
    
}
