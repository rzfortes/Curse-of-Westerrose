package packageRPG.gfx;

import java.awt.image.BufferedImage;
import java.util.Random;

public class Assets {
	private static Random rand = new Random();
	private static final int width = 32, height = 32;

	public static BufferedImage dirt, grass, stone, tree, menu, rock, wood;
	public static BufferedImage[] player_down, player_up, player_left, player_right, player_stand;
	public static BufferedImage[] controllers;
	public static BufferedImage[] exit;
	public static BufferedImage[] credits;
	public static BufferedImage[] htp;
	public static BufferedImage[] controls;
	public static BufferedImage[] mainmenu;
	public static BufferedImage bg, control;
	public static BufferedImage menu1;
	public static BufferedImage creditsbg;
	public static BufferedImage gameover;

	// dessert
	public static BufferedImage desertBorder, fruit, cactus, cactus2, sand, deadTree, boulder, dateTree, rotten,
			desertbush, desertbush2, desertbush3;
	public static BufferedImage desertRock;
	public static BufferedImage monster, treeMonster;

	// land
	public static BufferedImage path, h1, h2, h3, h4;
	public static BufferedImage palmtree, tree2, bush, vine, dtree, cotton, dirtg;

	// river
	public static BufferedImage water, bridgesign, bridge, man, well, vine2;
	public static BufferedImage orangetree, orangetreeB, rock1, rock2, cliff1, cliff2, vines, bush1, log;

	// forest
	public static BufferedImage forest_tile, stackRock, flatRock, mushroom, rockPcs, bigRock, lily;
	public static BufferedImage yellowFlower, sign, puffyTree, slantTree, greenTree, shrubs, shrub2, forestLog;
	public static BufferedImage grassRock, stump, log4, pineTree, trunk, root, hole, chunkRock, thinTree, chunkrock2;
	public static BufferedImage pebbles, grassly, puffybush, purpleFlower;

	// winter

	public static BufferedImage winterTile, snowman1, snowman2, snowman3, snowman4,fire;
	public static BufferedImage wTree1, wTree2, wTree3, wTree4, wTree5, wHouse1, wHouse2;

	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
		SpriteSheet playerS = new SpriteSheet(ImageLoader.loadImage("/textures/player.png"));
		SpriteSheet sheet1 = new SpriteSheet(ImageLoader.loadImage("/textures/desert.png"));
		SpriteSheet fruitSheet = new SpriteSheet(ImageLoader.loadImage("/textures/fruits.png"));
		SpriteSheet rottenFruitSheet = new SpriteSheet(ImageLoader.loadImage("/textures/rotten.png"));
		SpriteSheet monsterSheet = new SpriteSheet(ImageLoader.loadImage("/textures/spider-sprite.png"));
		SpriteSheet house = new SpriteSheet(ImageLoader.loadImage("/textures/house.png"));
		SpriteSheet sheet2 = new SpriteSheet(ImageLoader.loadImage("/textures/chruch_n_tree_sprite.gif"));
		SpriteSheet sheet3 = new SpriteSheet(ImageLoader.loadImage("/textures/sheet11.png"));
		SpriteSheet treeMonsterSheet = new SpriteSheet(ImageLoader.loadImage("/textures/treeMonster.png"));
		SpriteSheet waterlight = new SpriteSheet(ImageLoader.loadImage("/textures/water1.png"));
		SpriteSheet signage = new SpriteSheet(ImageLoader.loadImage("/textures/signage.png"));
		SpriteSheet bridgesheet = new SpriteSheet(ImageLoader.loadImage("/textures/bridge.png"));
		SpriteSheet mansheet = new SpriteSheet(ImageLoader.loadImage("/textures/man.png"));
		SpriteSheet riversheet = new SpriteSheet(ImageLoader.loadImage("/textures/river.png"));
		SpriteSheet winterHouse = new SpriteSheet(ImageLoader.loadImage("/textures/winter 1.png"));
		SpriteSheet snowMen = new SpriteSheet(ImageLoader.loadImage("/textures/snowman.png"));
		SpriteSheet winterTrees = new SpriteSheet(ImageLoader.loadImage("/textures/treee.png"));
		SpriteSheet controller = new SpriteSheet(ImageLoader.loadImage("/textures/controllers.png"));
		SpriteSheet back = new SpriteSheet(ImageLoader.loadImage("/textures/How to play.png"));
		SpriteSheet ct = new SpriteSheet(ImageLoader.loadImage("/textures/Controls.png"));
		SpriteSheet forest = new SpriteSheet(ImageLoader.loadImage("/textures/forest.png"));
		SpriteSheet menusheet = new SpriteSheet(ImageLoader.loadImage("/textures/Mainmenu.png"));
		SpriteSheet exitsheet = new SpriteSheet(ImageLoader.loadImage("/textures/exit.png"));
		SpriteSheet how = new SpriteSheet(ImageLoader.loadImage("/textures/htp.png"));
		SpriteSheet cre1 = new SpriteSheet(ImageLoader.loadImage("/textures/cre1.png"));
		SpriteSheet cre2 = new SpriteSheet(ImageLoader.loadImage("/textures/cre2.png"));
		SpriteSheet controlsheet = new SpriteSheet(ImageLoader.loadImage("/textures/controls2.png"));
		SpriteSheet menuBsheet = new SpriteSheet(ImageLoader.loadImage("/textures/menub.png"));
		SpriteSheet creditsheet = new SpriteSheet(ImageLoader.loadImage("/textures/credits.png"));
		SpriteSheet gameoversheet = new SpriteSheet(ImageLoader.loadImage("/textures/GameOver.png"));
		SpriteSheet firesheet = new SpriteSheet(ImageLoader.loadImage("/textures/fire.png"));
		
		menu1 = menusheet.crop(0, 0, 640, 360);
		exit = new BufferedImage[2];
		exit[0] = exitsheet.crop(0, 0, width*2, height*2);
		exit[1] = exitsheet.crop(width*2, height*2, width*2, height*2);
		
		htp = new BufferedImage[2];
		htp[0] = how.crop(0, 0, width*2, height*2);
		htp[1] = how.crop(width*2, height*2, width*2, height*2);
		
		credits = new BufferedImage[2];
		credits[0] = cre1.crop(0, 0, width*2, height*2);
		credits[1] = cre2.crop(0, 0, width*2, height*2);
		
		creditsbg = creditsheet.crop(0, 0, 640, 360);
		
		
		controllers = new BufferedImage[2];
		controllers[0] = controller.crop(width * 2, height * 2, width * 2, height * 2);
		controllers[1] = controller.crop(0, 0, width * 2, height * 2);
		bg = back.crop(0, 0, 640, 360);
		control = ct.crop(0, 0, 640, 360);
		
		controls = new BufferedImage[2];
		controls[0] = controlsheet.crop(0, 0, width*2, height*2);
		controls[1] = controlsheet.crop(width*2, height*2, width*2, height*2);
		
		mainmenu = new BufferedImage[2];
		mainmenu[0] = menuBsheet.crop(0, 0, width*2, height*2);
		mainmenu[1] = menuBsheet.crop(width*2, height*2, width*2, height*2);
		
		gameover = gameoversheet.crop(0, 0, 640, 360);

		wood = sheet.crop(width, height, width, height);
		rock = sheet.crop(0, 32 * 2, width, height);
		treeMonster = treeMonsterSheet.crop(0, 0, 200, 145);

		player_down = new BufferedImage[2];
		player_up = new BufferedImage[2];
		player_left = new BufferedImage[2];
		player_right = new BufferedImage[2];
		player_stand = new BufferedImage[2];

		player_stand[0] = playerS.crop(0, 0, 340, 530);
		player_stand[1] = playerS.crop(340 * 2, 0, 340, 530);
		player_down[0] = playerS.crop(340, 0, 340, 530);
		player_down[1] = playerS.crop(340 * 3, 0, 340, 530);
		player_up[0] = playerS.crop(340, 530, 340, 530);
		player_up[1] = playerS.crop(340 * 3, 530, 340, 530);
		player_left[0] = playerS.crop(340, 530 * 2, 340, 530);
		player_left[1] = playerS.crop(340 * 2, 530 * 2, 340, 530);
		player_right[0] = playerS.crop(340, 1500, 340, 530);
		player_right[1] = playerS.crop(340 * 2, 1500, 340, 530);

		monster = monsterSheet.crop(150, 0, width * 2, height * 3);

		boulder = sheet1.crop(width * 4, 0, width, height);
		desertbush = sheet1.crop(width * 1, 0, width, height);
		deadTree = sheet1.crop(width * 6, 0, width, height);
		cactus = sheet1.crop(width * 3, 0, width, height);
		cactus2 = sheet1.crop(width * 2, width * 1, width, height);
		sand = sheet1.crop(0, 0, width, height);
		desertBorder = sheet1.crop(width * 7, 0, width, height);
		desertbush3 = sheet1.crop(width * 5, 0, width, height);
		int rnd = randInt();
		fruit = fruitSheet.crop(width * rnd, 0, width, height);
		rnd = randInt();
		rotten = rottenFruitSheet.crop(width * rnd, 0, width, height);

		// land
		dirt = sheet3.crop(width, 0, width, height);
		grass = sheet3.crop(width * 2, 0, width, height);
		stone = sheet3.crop(width * 3, 0, width, height);
		tree = sheet2.crop(300, 0, 120, 160);
		path = sheet3.crop(width * 2, height * 7, width, height);

		bush = sheet3.crop(width * 6, 0, width, height);
		vine = sheet3.crop(width * 5, height * 2, width, height);
		dtree = sheet3.crop(width, height * 3, width * 2, height * 2);
		cotton = sheet3.crop(width * 7, 0, width, height);

		// house
		h1 = sheet3.crop(width * 2, height, width * 3, height * 2);
		h2 = house.crop(0, width, width * 2, height * 2);
		h3 = house.crop(width * 2, height, width * 2, height * 2);
		h4 = house.crop(0, height * 2, width * 2, height * 2);
		
		// crossing river
		water = waterlight.crop(0, 0, width, height);
		bridgesign = signage.crop(0, 0, width, height);
		bridge = bridgesheet.crop(0, 0, width * 3, height * 2);
		man = mansheet.crop(0, 0, width, height * 2);
		well = sheet3.crop(0, height, width * 2, height * 2);
		orangetree = riversheet.crop(0, 0, width, height * 2);
		orangetreeB = riversheet.crop(0, height * 3, width * 2, height * 2);
		rock1 = riversheet.crop(width, height, width, height);
		rock2 = riversheet.crop(width * 2, 0, width, height * 2);
		cliff1 = riversheet.crop(width * 8, height*2, width, height*3);
		cliff2 = riversheet.crop(width * 9, height, width, height*4);
		vines = riversheet.crop(width * 2, height * 2, width, height * 2);
		bush1 = riversheet.crop(width, 0, width, height);
		log = riversheet.crop(width * 3, 0, width * 2, height);
		vine2 = riversheet.crop(width * 5, 0, width, height * 2);

		// start of forest
		forest_tile = forest.crop(0, 0, width, height);
		stackRock = forest.crop(0, height, width, height);
		flatRock = forest.crop(0, height * 2, width, height);
		mushroom = forest.crop(0, height * 3, width, height);
		rockPcs = forest.crop(0, height * 4, width, height);
		bigRock = forest.crop(0, height * 5, width, height);
		lily = forest.crop(0, height * 6, width, height);
		yellowFlower = forest.crop(0, height * 7, width, height);
		sign = forest.crop(width, height * 6, width * 2, height * 2);
		puffyTree = forest.crop(width, height * 4, width * 2, height * 2);
		slantTree = forest.crop(width, height * 2, width * 2, height * 2);
		greenTree = forest.crop(width, 0, width * 2, height * 2);
		shrubs = forest.crop(width * 3, 0, width, height);
		shrub2 = forest.crop(width * 4, 0, width, height);
		grassRock = forest.crop(width * 5, 0, width, height);
		stump = forest.crop(width * 6, 0, width, height);
		log4 = forest.crop(width * 7, 0, width, height);
		pineTree = forest.crop(width * 5, height, width * 2, height * 2);
		trunk = forest.crop(width * 3, height, width * 2, height * 2);
		root = forest.crop(width * 3, height * 3, width * 2, height * 2);
		hole = forest.crop(width * 3, height * 5, width, height);
		chunkRock = forest.crop(width * 3, height * 6, width * 2, height * 2);
		thinTree = forest.crop(width * 5, height * 3, width * 2, height * 2);
		pebbles = forest.crop(width * 7, height * 4, width, height);
		grassly = forest.crop(width * 7, height * 3, width, height);
		puffybush = forest.crop(width * 7, height * 2, width, height);
		purpleFlower = forest.crop(width * 7, height, width, height);

		// end of forest

		// winter
		// winter map
		winterTile = winterHouse.crop(0, 0, width, height);
		snowman1 = snowMen.crop(0, 0, 128, 128);
		snowman2 = snowMen.crop(width * 4, width * 4, 128, 128);
		snowman3 = snowMen.crop(width * 4, 0, 128, 128);
		snowman4 = snowMen.crop(0, width * 4, 128, 128);
		wTree1 = winterTrees.crop(0, 0, 96, 128);
		wTree2 = winterTrees.crop(width * 3, 0, 96, 128);
		wTree3 = winterTrees.crop(0, width * 4, 96, 128);
		wTree4 = winterHouse.crop(0, width * 3, 96, 96);
		wTree5 = winterHouse.crop(width * 3, width * 3, 96, 96);
		wHouse1 = winterHouse.crop(width * 1, 0, 96, 96);
		wHouse2 = winterHouse.crop(width * 4, 0, 96, 96);
		fire = firesheet.crop(0, 0, 100, 100);
	}

	public static int randInt() {
		return rand.nextInt(7 - 0) + 0;
	}

}
