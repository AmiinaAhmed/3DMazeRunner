package terrains;

import models.RawModel;
import models.TexturedModel;
import org.lwjgl.opengl.GL11;
import renderEngine.Loader;
import textures.ModelTexture;

public class Terrain {
	
       public static  float SIZE = 400;
       private   int VERTEX_COUNT ;
       int count ;
       public float[] vertices;
	
	private float x;
	private float z;
	private RawModel model;
	private ModelTexture texture;
	
	public Terrain(float gridX, float gridZ, Loader loader, ModelTexture texture,float size){
		this.texture = texture;
                this.SIZE=size;
                VERTEX_COUNT = (int)(SIZE/40)+1;
                count = VERTEX_COUNT * VERTEX_COUNT;
                vertices=new float [count*3];
		this.x = gridX * SIZE;
		this.z = gridZ * SIZE;
		this.model = generateTerrain(loader);
                
	}
	
	
	
	public float getX() {
		return x;
	}

	public float getZ() {
		return z;
	}



	public RawModel getModel() {
		return model;
	}



	public ModelTexture getTexture() {
		return texture;
	}

	private RawModel generateTerrain(Loader loader){
         
		//int count = VERTEX_COUNT * VERTEX_COUNT
		float[] normals = new float[count * 3];
		float[] textureCoords = new float[count*2];
		int[] indices = new int[6*(VERTEX_COUNT-1)*(VERTEX_COUNT-1)];
		int vertexPointer = 0;
		for(int i=0;i<VERTEX_COUNT;i++){
			for(int j=0;j<VERTEX_COUNT;j++){
				vertices[vertexPointer*3] = (float)j/((float)VERTEX_COUNT - 1) * SIZE;
				vertices[vertexPointer*3+1] = 0;
				vertices[vertexPointer*3+2] = (float)i/((float)VERTEX_COUNT - 1) * SIZE;
				normals[vertexPointer*3] = 0;
				normals[vertexPointer*3+1] = 1;
				normals[vertexPointer*3+2] = 0;
				textureCoords[vertexPointer*2] = (float)j/((float)VERTEX_COUNT - 1);
				textureCoords[vertexPointer*2+1] = (float)i/((float)VERTEX_COUNT - 1);
				vertexPointer++;
			}
		}
		int pointer = 0;
		for(int gz=0;gz<VERTEX_COUNT-1;gz++){
			for(int gx=0;gx<VERTEX_COUNT-1;gx++){
				int topLeft = (gz*VERTEX_COUNT)+gx;
				int topRight = topLeft + 1;
				int bottomLeft = ((gz+1)*VERTEX_COUNT)+gx;
				int bottomRight = bottomLeft + 1;
				indices[pointer++] = topLeft;
				indices[pointer++] = bottomLeft;
				indices[pointer++] = topRight;
				indices[pointer++] = topRight;
				indices[pointer++] = bottomLeft;
				indices[pointer++] = bottomRight;
			}
		}
		return loader.loadToVAO(vertices, textureCoords, normals, indices);
	}

    public int getVERTEX_COUNT() {
        return VERTEX_COUNT;
    }

}
