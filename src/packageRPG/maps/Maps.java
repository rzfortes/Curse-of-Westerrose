package packageRPG.maps;

import java.awt.Graphics;

import packageRPG.Handler;
import packageRPG.entities.EntityManager;
import packageRPG.entities.creatures.Monster;
import packageRPG.entities.creatures.Player;
import packageRPG.entities.creatures.TreeMonster;
import packageRPG.entities.statics.Boulder;
import packageRPG.entities.statics.Bush;
import packageRPG.entities.statics.Cactus;
import packageRPG.entities.statics.Cactus2;
import packageRPG.entities.statics.Cotton;
import packageRPG.entities.statics.DateTree;
import packageRPG.entities.statics.DeadTree;
import packageRPG.entities.statics.DeadTreeH;
import packageRPG.entities.statics.DesertBush;
import packageRPG.entities.statics.DesertBush2;
import packageRPG.entities.statics.DesertBush3;
//import packageRPG.entities.statics.DirtG;
import packageRPG.entities.statics.Fruits;
import packageRPG.entities.statics.House;
import packageRPG.entities.statics.House2;
import packageRPG.entities.statics.Rock;
import packageRPG.entities.statics.RottenFruits;
import packageRPG.entities.statics.Tree;
import packageRPG.entities.statics.Vine;
import packageRPG.items.ItemManager;
import packageRPG.tiles.Tile;
import packageRPG.utils.Utils;

public class Maps {
	
	private Handler handler;
	private int width, height; 
	private int spawnX, spawnY;
	private int[][] tiles;     //for the id , which tile to use
	
	// Entities
	private EntityManager entityManager;
	// item
	private ItemManager itemManager;
	
	public Maps(Handler handler, String path){
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 100, 100));
		itemManager = new ItemManager(handler);
		
		//monster
		entityManager.addEntity(new Monster(handler,1375,665));
		entityManager.addEntity(new TreeMonster(handler, 1560, 300));

		
		entityManager.addEntity(new Cactus(handler, 100 , 200));
		entityManager.addEntity(new Cactus(handler, 100 , 232));
		entityManager.addEntity(new Cactus(handler, 100 , 264));
		entityManager.addEntity(new Cactus(handler, 100 , 296));
		entityManager.addEntity(new Cactus(handler, 100 , 328));
		entityManager.addEntity(new Cactus(handler, 150 , 200));
		entityManager.addEntity(new Cactus(handler, 150 , 232));
		entityManager.addEntity(new Cactus(handler, 200 , 328));
		entityManager.addEntity(new Fruits(handler, 68, 264));
		
		entityManager.addEntity(new DesertBush(handler, 96, 424));
		entityManager.addEntity(new DesertBush(handler, 192, 424));
		entityManager.addEntity(new DesertBush(handler, 288, 424));
		entityManager.addEntity(new DesertBush(handler, 338, 424));
		entityManager.addEntity(new DesertBush(handler, 388, 424));
		entityManager.addEntity(new DesertBush(handler, 150, 40));
		
		entityManager.addEntity(new Boulder(handler, 40, 820));
		
		entityManager.addEntity(new RottenFruits(handler, 140, 800));
		entityManager.addEntity(new Fruits(handler, 400, 150));
		entityManager.addEntity(new Fruits(handler, 390, 560));
		
		entityManager.addEntity(new DesertBush(handler, 50, 624));
		
		entityManager.addEntity(new DeadTree(handler, 460, 80));
		entityManager.addEntity(new DeadTree(handler, 585, 624));
		
		entityManager.addEntity(new Cactus(handler, 338, 670));
		entityManager.addEntity(new Cactus(handler, 350, 700));
		entityManager.addEntity(new Cactus(handler, 590, 800));
		entityManager.addEntity(new Cactus2(handler, 620, 830));
		entityManager.addEntity(new Cactus2(handler, 670, 810));
		
		entityManager.addEntity(new DesertBush(handler, 200, 720));
		entityManager.addEntity(new DesertBush(handler, 530, 300));
		entityManager.addEntity(new DesertBush3(handler, 580, 340));
		entityManager.addEntity(new DesertBush3(handler, 640, 340));
		entityManager.addEntity(new DesertBush3(handler, 600, 300));
		
		entityManager.addEntity(new RottenFruits(handler, 700, 50));
		entityManager.addEntity(new Cactus2(handler, 780, 250));
		entityManager.addEntity(new Fruits(handler, 810, 860));
		
		// Monster lair, food as bait
		entityManager.addEntity(new Fruits(handler, 865, 350));
		entityManager.addEntity(new DesertBush3(handler, 790, 450));
		entityManager.addEntity(new Cactus(handler, 810, 500));
		entityManager.addEntity(new DesertBush(handler, 810, 550));
		entityManager.addEntity(new Cactus(handler, 810, 600));
		entityManager.addEntity(new DesertBush(handler, 810, 650));
		entityManager.addEntity(new Cactus(handler, 810, 700));
		entityManager.addEntity(new DesertBush(handler, 810, 750));
		entityManager.addEntity(new Cactus(handler, 810, 800));
		entityManager.addEntity(new Cactus(handler, 865, 830));
		entityManager.addEntity(new Cactus2(handler, 930, 450));
		entityManager.addEntity(new Cactus(handler, 910, 500));
		entityManager.addEntity(new DesertBush(handler, 910, 550));
		entityManager.addEntity(new Cactus(handler, 910, 600));
		entityManager.addEntity(new Fruits(handler, 865, 600));
		entityManager.addEntity(new Fruits(handler, 865, 350));
		entityManager.addEntity(new DesertBush(handler, 910, 650));
		entityManager.addEntity(new Cactus(handler, 910, 700));
		entityManager.addEntity(new Cactus(handler, 915, 830));
		entityManager.addEntity(new DesertBush(handler, 965, 830));
		entityManager.addEntity(new Cactus(handler, 1015, 830));
		entityManager.addEntity(new DesertBush(handler, 1065, 830));
		entityManager.addEntity(new Cactus(handler, 1115, 830));
		entityManager.addEntity(new DesertBush(handler, 965, 700));
		entityManager.addEntity(new Cactus(handler, 1015, 700));
		entityManager.addEntity(new DesertBush(handler, 1065, 700));
		entityManager.addEntity(new Cactus(handler, 1115, 700));
		entityManager.addEntity(new DesertBush3(handler, 1115, 855));
		entityManager.addEntity(new Boulder(handler, 1155, 650));
		entityManager.addEntity(new Boulder(handler, 1205, 590));
		entityManager.addEntity(new Boulder(handler, 1255, 530));
		entityManager.addEntity(new Boulder(handler, 1315, 537));
		entityManager.addEntity(new Boulder(handler, 1375, 534));
		entityManager.addEntity(new Boulder(handler, 1425, 590));
		entityManager.addEntity(new Boulder(handler, 1460, 665));
		entityManager.addEntity(new Boulder(handler, 1470, 737));
		entityManager.addEntity(new Boulder(handler, 1452, 810));
		
		entityManager.addEntity(new Boulder(handler, 1800, 50));
		//entityManager.addEntity(new DesertBush3(handler, 1790, 50));
		//entityManager.addEntity(new DesertBush3(handler, 1800, 56));
		entityManager.addEntity(new DesertBush(handler, 1789, 50));
		entityManager.addEntity(new DesertBush(handler, 1765, 70));
		entityManager.addEntity(new DesertBush(handler, 1755, 100));
		entityManager.addEntity(new RottenFruits(handler, 1740, 50));
		
		entityManager.addEntity(new DeadTree(handler, 1000, 80));
		entityManager.addEntity(new DeadTree(handler, 1000, 120));
		entityManager.addEntity(new DeadTree(handler, 1050, 80));
		entityManager.addEntity(new DeadTree(handler, 1050, 120));
		entityManager.addEntity(new DeadTree(handler, 1040, 160));
		
		
		//town map
		entityManager.addEntity(new DeadTreeH(handler, 1900, 710));
		
		entityManager.addEntity(new Tree(handler, 380+2100 , 80));
		//entityManager.addEntity(new Vine(handler, 200, 80));
		
		//bush
		entityManager.addEntity(new Bush(handler, 150+1900, 490));
		entityManager.addEntity(new Bush(handler, 150+1900, 550));
		entityManager.addEntity(new Bush(handler, 150+1900, 610));
		
		//deadtree
		entityManager.addEntity(new DeadTreeH(handler, 290+1900, 550));
		entityManager.addEntity(new DeadTreeH(handler, 355+1900, 550));
		entityManager.addEntity(new DeadTreeH(handler, 415+1900, 550));
		entityManager.addEntity(new DeadTreeH(handler, 415+1900, 590));
		entityManager.addEntity(new DeadTreeH(handler, 415+1900, 630));
		entityManager.addEntity(new Tree(handler, 415+1900 , 660));
		entityManager.addEntity(new Fruits(handler, 315+1900, 640));
		entityManager.addEntity(new Fruits(handler, 315+1900, 640));
		entityManager.addEntity(new Fruits(handler, 360+1900, 640));
		entityManager.addEntity(new Fruits(handler, 315+1900, 720));
		entityManager.addEntity(new Fruits(handler, 360+1900, 720));
		
		
		
		//vine
		entityManager.addEntity(new Vine(handler, 210+1900 , 220));
		entityManager.addEntity(new Vine(handler, 210+1900 , 270));
		entityManager.addEntity(new Vine(handler, 210+1900 , 330));
		entityManager.addEntity(new Vine(handler, 340+1900 , 220));
		entityManager.addEntity(new Vine(handler, 340+1900 , 270));
		entityManager.addEntity(new Vine(handler, 340+1900 , 330));
		
		//cotton
		entityManager.addEntity(new Cotton(handler, 220+1900 , 40));
		entityManager.addEntity(new Cotton(handler, 280+1900 , 40));
		entityManager.addEntity(new Cotton(handler, 330+1900 , 40));
		entityManager.addEntity(new Cotton(handler, 380+1900 , 40));
		
		//house
		entityManager.addEntity(new House(handler, 650+1900, 80));
		//entityManager.addEntity(new House2(handler, 100, 60));
		entityManager.addEntity(new House2(handler, 400+1900, 60));
		
		//monster part
		//entityManager.addEntity(new DirtG(handler, 600+1800, 500));
		entityManager.addEntity(new Tree(handler, 745+1900 , 400));
		entityManager.addEntity(new Tree(handler, 660+1900, 400));
		entityManager.addEntity(new Tree(handler, 580+1900 , 400));
		entityManager.addEntity(new Tree(handler, 580+1900 , 550));
		entityManager.addEntity(new Tree(handler, 660+1900 , 550));
		entityManager.addEntity(new Tree(handler, 745+1900 , 550));
		

		entityManager.addEntity(new DesertBush(handler, 1250, 200));
		entityManager.addEntity(new Cactus(handler, 1300, 340));
		entityManager.addEntity(new Cactus(handler, 1270, 370));
		entityManager.addEntity(new Cactus(handler, 1320, 400));
	
		
		
		
		loadMaps(path);
		
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
		
	}
	
	public void update(){
		itemManager.update();
		entityManager.update();
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
		itemManager.update();
		//
		itemManager.render(g);
		// Entities
		entityManager.render(g);
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
	
	
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public ItemManager getItemManager() {
		return itemManager;
	}

	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}
	
}
