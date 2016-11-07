package packageRPG.maps;

import java.awt.Graphics;

import packageRPG.Game;
import packageRPG.tiles.Tile;
import packageRPG.utils.Utils;

public class Maps {
	
	private Game game;
	private int width, height; 
	private int spawnX, spawnY;
	private int[][] tiles;     //for the id , which tile to use
	
	public Maps(Game game,String path){
		this.game = game;
		loadMaps(path);
		
	}
	
	public void update(){
		
	}
	
	public void render(Graphics g){
		int xStart =0;
		int xEnd =width;
		int yStart =0;
		int yEnd = height;
		 
		for(int y = yStart; y< yEnd ; y++){
			for(int x = xStart; x<xEnd; x++){
				getTile(x,y).render(g, (int)(x*Tile.TILEWIDTH - game.getGameCamera().getxOffset()), 
						(int)(y*Tile.TILEHEIGHT - game.getGameCamera().getyOffset()));
			}
		}
	}
	
	public Tile getTile(int x, int y){
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
