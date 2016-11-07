package packageRPG.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	//STATIC Stuff
	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile = new GrassTile(0);
	public static Tile dirtTile = new DirtTile(1);
	public static Tile rockTile = new RockTile(2);
	
	
	//Class
	public static final int TILEWIDTH = 64;
	public static final int TILEHEIGHT = 64;
	
	protected BufferedImage texture;
	protected final int id;  //way to identify each tile 
							//final because	every id should be unique
	public Tile(BufferedImage texture, int id){
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this; //set tiles array to tile like dirt tile
	
	}

	public void update(){
		
	}
	
	public void render(Graphics g, int x, int y){  //x and y position //where to render at the screen
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	
	public boolean isSolid(){  //checker if it is a solid block or not
		return false;
	}
	public int getId(){
		return id;
	}

	
}
