package packageRPG.maps;

import java.awt.Graphics;

import packageRPG.Game;
import packageRPG.Handler;
import packageRPG.tiles.Tile;
import packageRPG.utils.Utils;

public class Maps {
	
	private Handler handler;
	private int width, height; 
	private int spawnX, spawnY;
	private int[][] tiles;     //for the id , which tile to use
	
	public Maps(Handler handler,String path){
		this.handler = handler;
		loadMaps(path);
		
	}
	
	public void update(){
		
	}
	
	public void render(Graphics g){
		int xStart =(int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);  //for the rendering be only at the part where the camera is
		int xEnd =(int) Math.min(width, (handler.getGameCamera().getxOffset()+handler.getWidth()) / Tile.TILEWIDTH + 1);  //far end tile from the user than see
				//plus one for it to render smoothly in the window / frame
		int yStart =(int) Math.max(0, handler.getGameCamera().getyOffset()/ Tile.TILEHEIGHT);  //the tile the user can see from the screen
		int yEnd = (int)Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);
		 
		for(int y = yStart; y< yEnd ; y++){
			for(int x = xStart; x<xEnd; x++){
				getTile(x,y).render(g, (int)(x*Tile.TILEWIDTH - handler.getGameCamera().getxOffset()), 
						(int)(y*Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
	}
	
	public Tile getTile(int x, int y){
		if(x<0 || y<0 || x>=width || y>=height)
			return Tile.grassTile; //the game thinks he/ player is standing on a grass tile even 
			// though he is outside of the map
		
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t== null){
			return Tile.dirtTile;
			}
		return t;
	}
	
	private void loadMaps(String path){  //responsible for loading the map
	
		String file = Utils.loadFileAsString(path);
		String [] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
	
		tiles = new int[width][height];
		for(int y = 0;y<height ; y++){
			for(int x =0;x<width; x++){
				tiles[x][y] = Utils.parseInt(tokens[(x+y*width)+4]);
			}
		}
		
		//	width = 5;
	//	height = 5;
	//	tiles = new int[width][height];  //x and y coordinates
	
		
	//	for(int x = 0; x<width; x++){
	//		for(int y = 0; y<height ; y++){
	//			tiles[x][y] = 1;
	//		}
	//	}
	}
}
