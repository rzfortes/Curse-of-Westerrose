package packageRPG.gfx;

import java.awt.image.BufferedImage;
import java.util.Random;

public class Assets {
	private static Random rand = new Random();
	private static final int width = 32, height = 32;
	
	//dessert
	public static BufferedImage dirt, grass, stone , tree, menu, rock, wood;
	public static BufferedImage[] player_down, player_up, player_left, player_right, player_stand;
	public static BufferedImage[] monster_down, monster_up, monster_left, monster_right;
	public static BufferedImage[] button_start, button_rules, button_exit;

	public static BufferedImage desertBorder,fruit,cactus, cactus2, sand, deadTree, boulder, dateTree, rotten, desertbush, desertbush2, desertbush3;
	public static BufferedImage desertRock;
	public static BufferedImage monster, treeMonster;
	
	
	//land
	public static BufferedImage path,h1,h2,h3,h4,h5,h6;
	public static BufferedImage palmtree,tree2,bush,vine,dtree,cotton,dirtg;
	
	
	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
		SpriteSheet menu = new SpriteSheet(ImageLoader.loadImage("/textures/Menu.png"));
		SpriteSheet playerS = new SpriteSheet(ImageLoader.loadImage("/textures/player.png"));
		SpriteSheet sheet1 = new SpriteSheet(ImageLoader.loadImage("/textures/desert.png"));
		SpriteSheet fruitSheet = new SpriteSheet(ImageLoader.loadImage("/textures/fruits.png"));
		SpriteSheet rottenFruitSheet = new SpriteSheet(ImageLoader.loadImage("/textures/rotten.png"));
		SpriteSheet monsterSheet = new SpriteSheet(ImageLoader.loadImage("/textures/spider-sprite.png"));
		SpriteSheet house = new SpriteSheet(ImageLoader.loadImage("/textures/house.png"));
		SpriteSheet sheet2 = new SpriteSheet(ImageLoader.loadImage("/textures/chruch_n_tree_sprite.gif"));
		SpriteSheet sheet4 = new SpriteSheet(ImageLoader.loadImage("/textures/sheet4.png"));
		SpriteSheet sheet3 = new SpriteSheet(ImageLoader.loadImage("/textures/sheet11.png"));
		SpriteSheet treeMonsterSheet = new SpriteSheet(ImageLoader.loadImage("/textures/treeMonster.png"));
		
		button_start = new BufferedImage[2];
		button_start[0] = menu.crop(256, 64, 128, 64);
		button_start[1] = menu.crop(256, 0, 128, 64);
		
		button_rules = new BufferedImage[2];
		button_rules[0] = menu.crop(128, 64, 128, 64);
		button_rules[1] = menu.crop(128, 0, 128, 64);
		
		button_exit = new BufferedImage[2];
		button_exit[0] = menu.crop(0, 64, 128, 64);
		button_exit[1] = menu.crop(0, 0, 128, 64);
		
		wood = sheet.crop(width, height, width, height);
		rock = sheet.crop(0, 32*2, width, height);
		treeMonster = treeMonsterSheet.crop(0,0, 200, 145);
		
		player_down = new BufferedImage[2];
		player_up = new BufferedImage[2];
		player_left = new BufferedImage[2];
		player_right = new BufferedImage[2];
		player_stand = new BufferedImage[2];
		
		player_stand[0] = playerS.crop(0, 0, 340, 530);
		player_stand[1] = playerS.crop(340*2, 0, 340, 530);
		player_down[0] = playerS.crop(340, 0, 340, 530);
		player_down[1] = playerS.crop(340*3, 0, 340, 530);
		player_up[0] = playerS.crop(340, 530, 340, 530);
		player_up[1] = playerS.crop(340*3, 530, 340, 530);
		player_left[0] = playerS.crop(340, 530*2, 340, 530);
		player_left[1] = playerS.crop(340*2, 530*2, 340, 530);
		player_right[0] = playerS.crop(340, 1500, 340, 530);
		player_right[1] = playerS.crop(340*2, 1500, 340, 530);
		
		monster = monsterSheet.crop(150, 0, width*2, height*3);
		
//		monster_down[0] = monsterSheet.crop(150, 0, width*2, height*3);
//		monster_down[1] = monsterSheet.crop(150, 0, width*2, height*3);
//		monster_up[0] = monsterSheet.crop(150, 0, width*2, height*3);
//		monster_up[1] = monsterSheet.crop(150, 0, width*2, height*3);
		
		
		boulder = sheet1.crop(width*4, 0, width, height);
		desertbush = sheet1.crop(width*1, 0, width, height);
		deadTree = sheet1.crop(width*6, 0, width, height);
		cactus = sheet1.crop(width*3, 0, width, height);
		cactus2 = sheet1.crop(width*2, width*1, width, height);
		sand = sheet1.crop(0,0, width, height);
		desertBorder = sheet1.crop(width*7, 0, width, height);
		desertbush3 = sheet1.crop(width*5, 0, width, height);
		int rnd = randInt();
		fruit = fruitSheet.crop(width*rnd, 0, width, height);
		rnd = randInt();
		rotten = rottenFruitSheet.crop(width*rnd, 0, width, height);
		
		
		
		//land
		dirt = sheet3.crop(width, 0, width, height);
		grass = sheet3.crop(width*2, 0, width, height);
		stone = sheet3.crop(width*3, 0, width, height);
		tree = sheet2.crop(300, 0, 120, 160);
		path = sheet3.crop(width*2, height*7, width, height);
		
		bush = sheet3.crop(width*6, 0, width, height);
		vine = sheet3.crop(width*5, height*2, width, height);		
		dtree = sheet3.crop(width, height*3, width*2, height*2);
		cotton = sheet3.crop(width*7, 0, width, height);
		
		//house
		h1 = sheet3.crop(width*2, height, width*3, height*2);
		h2 = house.crop(0, width, width*2, height*2);
		h3 = house.crop(width*2, height, width*2, height*2);
		h4 = house.crop(0, height*2, width*2, height*2);
		h5 = house.crop(width*2, height*2, width*2, height*2);
		h6 = house.crop(width*4, height, width*2, height*2);
		
	}
	
	public static int randInt(){
		return rand.nextInt(7 - 0) + 0;
	}
}
