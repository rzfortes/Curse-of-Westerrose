package packageRPG.maps;

import java.awt.Graphics;
import java.io.InputStream;

import packageRPG.Handler;
import packageRPG.entities.EntityManager;
import packageRPG.entities.creatures.Man;
import packageRPG.entities.creatures.Man2;
import packageRPG.entities.creatures.Monster;
import packageRPG.entities.creatures.Player;
import packageRPG.entities.creatures.TreeMonster;
import packageRPG.entities.statics.Boulder;
import packageRPG.entities.statics.BridgeSign;
import packageRPG.entities.statics.Bush;
import packageRPG.entities.statics.Bushriver;
import packageRPG.entities.statics.Cactus;
import packageRPG.entities.statics.Cactus2;
import packageRPG.entities.statics.Cliff1;
import packageRPG.entities.statics.Cliff2;
import packageRPG.entities.statics.Cotton;
import packageRPG.entities.statics.DeadTree;
import packageRPG.entities.statics.DeadTreeH;
import packageRPG.entities.statics.DesertBush;
import packageRPG.entities.statics.DesertBush3;
//import packageRPG.entities.statics.DirtG;
import packageRPG.entities.statics.Fruits;
import packageRPG.entities.statics.GreenVine;
import packageRPG.entities.statics.House;
import packageRPG.entities.statics.House2;
import packageRPG.entities.statics.House4;
import packageRPG.entities.statics.LongRock;
import packageRPG.entities.statics.OrangeTree;
import packageRPG.entities.statics.OrangeTree2;
import packageRPG.entities.statics.RottenFruits;
import packageRPG.entities.statics.SnowMan1;
import packageRPG.entities.statics.SnowMan2;
import packageRPG.entities.statics.SnowMan4;
import packageRPG.entities.statics.Tree;
import packageRPG.entities.statics.Well;
import packageRPG.entities.statics.WinHouse1;
import packageRPG.entities.statics.WinHouse2;
import packageRPG.entities.statics.WinTree1;
import packageRPG.entities.statics.WinTree3;
import packageRPG.entities.statics.WinTree4;
import packageRPG.entities.statics.grassRock;
import packageRPG.entities.statics.grassly;
import packageRPG.entities.statics.greenTree;
import packageRPG.entities.statics.hole;
import packageRPG.entities.statics.log4;
import packageRPG.entities.statics.mushroom;
import packageRPG.entities.statics.pebbles;
import packageRPG.entities.statics.puffyBush;
import packageRPG.entities.statics.puffyTree;
import packageRPG.entities.statics.purpleFlower;
import packageRPG.entities.statics.rockPcs;
import packageRPG.entities.statics.root;
import packageRPG.entities.statics.shrub2;
import packageRPG.entities.statics.sign;
import packageRPG.entities.statics.stump;
import packageRPG.entities.statics.thinTree;
import packageRPG.entities.statics.trunk;
import packageRPG.entities.statics.yellowFlower;
import packageRPG.items.ItemManager;
import packageRPG.tiles.Tile;
import packageRPG.utils.Utils;

public class Maps {

	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles; // for the id , which tile to use

	// Entities
	private EntityManager entityManager;
	// item
	private ItemManager itemManager;

	public Maps(Handler handler, InputStream in) {
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 100, 100));
		itemManager = new ItemManager(handler);

		// monster
		entityManager.addEntity(new Monster(handler, 1275, 640));
		entityManager.addEntity(new TreeMonster(handler, 1360, 300));

		// dessert part
		entityManager.addEntity(new Cactus(handler, 100, 200));
		entityManager.addEntity(new Cactus(handler, 100, 232));
		entityManager.addEntity(new Cactus(handler, 100, 264));
		entityManager.addEntity(new Cactus(handler, 100, 296));
		entityManager.addEntity(new Cactus(handler, 100, 328));
		entityManager.addEntity(new Cactus(handler, 150, 200));
		entityManager.addEntity(new Cactus(handler, 150, 232));
		entityManager.addEntity(new Cactus(handler, 200, 328));
		entityManager.addEntity(new Fruits(handler, 68, 264));

		entityManager.addEntity(new DesertBush(handler, 96, 424));
		entityManager.addEntity(new DesertBush(handler, 192, 424));
		entityManager.addEntity(new DesertBush(handler, 288, 424));
		entityManager.addEntity(new DesertBush(handler, 338, 424));
		entityManager.addEntity(new DesertBush(handler, 388, 424));
		entityManager.addEntity(new DesertBush(handler, 150, 40));

		entityManager.addEntity(new Boulder(handler, 40, 720));

		entityManager.addEntity(new RottenFruits(handler, 140, 700));
		entityManager.addEntity(new Fruits(handler, 400, 150));
		entityManager.addEntity(new Fruits(handler, 390, 560));

		entityManager.addEntity(new DesertBush(handler, 50, 624));

		entityManager.addEntity(new DeadTree(handler, 460, 80));
		entityManager.addEntity(new DeadTree(handler, 585, 624));

		entityManager.addEntity(new Cactus(handler, 338, 570));
		entityManager.addEntity(new Cactus(handler, 350, 600));
		entityManager.addEntity(new Cactus(handler, 590, 700));
		entityManager.addEntity(new Cactus2(handler, 620, 730));
		entityManager.addEntity(new Cactus2(handler, 670, 710));

		entityManager.addEntity(new DesertBush(handler, 200, 720));
		entityManager.addEntity(new DesertBush(handler, 530, 300));
		entityManager.addEntity(new DesertBush3(handler, 580, 340));
		entityManager.addEntity(new DesertBush3(handler, 640, 340));
		entityManager.addEntity(new DesertBush3(handler, 600, 300));

		entityManager.addEntity(new RottenFruits(handler, 700, 50));
		entityManager.addEntity(new Cactus2(handler, 780, 250));
		entityManager.addEntity(new Fruits(handler, 810, 860));

		// Monster lair, food as bait
		entityManager.addEntity(new Fruits(handler, 765, 350));
		entityManager.addEntity(new DesertBush3(handler, 690, 350));
		entityManager.addEntity(new Cactus(handler, 710, 400));
		entityManager.addEntity(new DesertBush(handler, 710, 450));
		entityManager.addEntity(new Cactus(handler, 710, 500));
		entityManager.addEntity(new DesertBush(handler, 710, 550));
		entityManager.addEntity(new Cactus(handler, 710, 600));
		entityManager.addEntity(new DesertBush(handler, 710, 650));
		entityManager.addEntity(new Cactus(handler, 710, 700));
		entityManager.addEntity(new Cactus(handler, 765, 730));
		entityManager.addEntity(new Cactus2(handler, 830, 350));
		entityManager.addEntity(new Cactus(handler, 810, 400));
		entityManager.addEntity(new DesertBush(handler, 810, 450));
		entityManager.addEntity(new Cactus(handler, 810, 500));
		entityManager.addEntity(new Fruits(handler, 765, 500));
		entityManager.addEntity(new Fruits(handler, 765, 350));
		entityManager.addEntity(new DesertBush(handler, 810, 550));
		entityManager.addEntity(new Cactus(handler, 810, 600));
		entityManager.addEntity(new Cactus(handler, 815, 730));
		entityManager.addEntity(new DesertBush(handler, 865, 730));
		entityManager.addEntity(new Cactus(handler, 915, 730));
		entityManager.addEntity(new DesertBush(handler, 965, 730));
		entityManager.addEntity(new Cactus(handler, 1015, 730));
		entityManager.addEntity(new DesertBush(handler, 865, 600));
		entityManager.addEntity(new Cactus(handler, 915, 600));
		entityManager.addEntity(new DesertBush(handler, 965, 600));
		entityManager.addEntity(new Cactus(handler, 1015, 600));
		entityManager.addEntity(new DesertBush3(handler, 1015, 755));
		entityManager.addEntity(new Boulder(handler, 1055, 550));
		entityManager.addEntity(new Boulder(handler, 1105, 490));
		entityManager.addEntity(new Boulder(handler, 1155, 430));
		entityManager.addEntity(new Boulder(handler, 1215, 437));
		entityManager.addEntity(new Boulder(handler, 1275, 434));
		entityManager.addEntity(new Boulder(handler, 1325, 490));
		entityManager.addEntity(new Boulder(handler, 1360, 565));
		entityManager.addEntity(new Boulder(handler, 1370, 637));
		entityManager.addEntity(new Boulder(handler, 1352, 710));

		entityManager.addEntity(new Boulder(handler, 1600, 50));
		entityManager.addEntity(new DesertBush(handler, 1589, 50));
		entityManager.addEntity(new DesertBush(handler, 1565, 70));
		entityManager.addEntity(new DesertBush(handler, 1555, 100));
		entityManager.addEntity(new RottenFruits(handler, 1540, 50));

		entityManager.addEntity(new DeadTree(handler, 900, 80));
		entityManager.addEntity(new DeadTree(handler, 900, 120));
		entityManager.addEntity(new DeadTree(handler, 950, 80));
		entityManager.addEntity(new DeadTree(handler, 950, 120));
		entityManager.addEntity(new DeadTree(handler, 940, 160));

		entityManager.addEntity(new DesertBush(handler, 1050, 200));
		entityManager.addEntity(new Cactus(handler, 1100, 340));
		entityManager.addEntity(new Cactus(handler, 1070, 370));
		entityManager.addEntity(new Cactus(handler, 1120, 400));
		entityManager.addEntity(new DeadTreeH(handler, 1640, 630));

		// crossing river part
		entityManager.addEntity(new BridgeSign(handler, 1670 + 1180, 380));
		entityManager.addEntity(new Man(handler, 1670 + 1185, 305));

		entityManager.addEntity(new GreenVine(handler, 1670 + 850, 0));
		entityManager.addEntity(new GreenVine(handler, 1670 + 900, 0));
		entityManager.addEntity(new GreenVine(handler, 1670 + 950, 0));
		entityManager.addEntity(new GreenVine(handler, 1670 + 1000, 0));
		entityManager.addEntity(new GreenVine(handler, 1670 + 1050, 0));
		entityManager.addEntity(new GreenVine(handler, 1670 + 1100, 0));
		entityManager.addEntity(new GreenVine(handler, 1670 + 1150, 0));
		entityManager.addEntity(new GreenVine(handler, 1670 + 1150, 750));
		entityManager.addEntity(new GreenVine(handler, 1670 + 1100, 750));
		entityManager.addEntity(new GreenVine(handler, 1670 + 950, 750));
		entityManager.addEntity(new GreenVine(handler, 1670 + 900, 750));
		entityManager.addEntity(new GreenVine(handler, 1670 + 850, 750));
		entityManager.addEntity(new GreenVine(handler, 1670 + 1050, 750));
		entityManager.addEntity(new GreenVine(handler, 1670 + 1000, 750));
		entityManager.addEntity(new Tree(handler, 1670 + 900, 60));
		entityManager.addEntity(new Tree(handler, 1670 + 1000, 60));
		entityManager.addEntity(new Tree(handler, 1670 + 1100, 60));
		entityManager.addEntity(new Tree(handler, 1670 + 900, 700));
		entityManager.addEntity(new Tree(handler, 1670 + 1000, 700));
		entityManager.addEntity(new Tree(handler, 1670 + 1100, 700));
		entityManager.addEntity(new Cotton(handler, 1670 + 1080, 150));
		
		entityManager.addEntity(new RottenFruits(handler, 1670 + 1180, 180));
		entityManager.addEntity(new Tree(handler, 1670 + 1080, 210));
		entityManager.addEntity(new Tree(handler, 1670 + 950, 200));
		entityManager.addEntity(new Tree(handler, 1670 + 950, 300));
		entityManager.addEntity(new Tree(handler, 1670 + 1010, 380));
		entityManager.addEntity(new Tree(handler, 1670 + 1010, 440));
		entityManager.addEntity(new Tree(handler, 1670 + 970, 530));
		entityManager.addEntity(new Fruits(handler, 1670 + 870, 560));
		entityManager.addEntity(new Fruits(handler, 1670 + 1100, 570));

		entityManager.addEntity(new LongRock(handler, 1670 + 900, 200));
		entityManager.addEntity(new Bushriver(handler, 1670 + 870, 200));
		entityManager.addEntity(new Bushriver(handler, 1670 + 870, 460));
		entityManager.addEntity(new Bushriver(handler, 1670 + 900, 460));
		entityManager.addEntity(new RottenFruits(handler, 1670 + 1100, 500));
		entityManager.addEntity(new Well(handler, 1670 + 1100, 610));

		entityManager.addEntity(new Cliff1(handler, 1670 + 1350, 0));
		entityManager.addEntity(new Cliff1(handler, 1670 + 1350, 95));
		entityManager.addEntity(new Cliff1(handler, 1670 + 1350, 190));
		entityManager.addEntity(new Cliff1(handler, 1670 + 1350, 240)); //edit
		entityManager.addEntity(new Cliff1(handler, 1670 + 1350, 380));
		entityManager.addEntity(new Cliff1(handler, 1670 + 1350, 475));
		entityManager.addEntity(new Cliff1(handler, 1670 + 1350, 570));
		entityManager.addEntity(new Cliff1(handler, 1670 + 1350, 665));
		entityManager.addEntity(new Cliff1(handler, 1670 + 1350, 760));
		entityManager.addEntity(new Cliff2(handler, 1670 + 1195, 0));
		entityManager.addEntity(new Cliff2(handler, 1670 + 1195, 125));
		entityManager.addEntity(new Cliff2(handler, 1670 + 1195, 210));//edit
		entityManager.addEntity(new Cliff2(handler, 1670 + 1195, 375));
		entityManager.addEntity(new Cliff2(handler, 1670 + 1195, 500));
		entityManager.addEntity(new Cliff2(handler, 1670 + 1195, 625));
		entityManager.addEntity(new Cliff2(handler, 1670 + 1195, 750));


		entityManager.addEntity(new OrangeTree2(handler, 1670 + 1550, 0));
		entityManager.addEntity(new OrangeTree2(handler, 1670 + 1600, 0));
		entityManager.addEntity(new OrangeTree2(handler, 1670 + 1450, 0));
		entityManager.addEntity(new OrangeTree2(handler, 1670 + 1350, 0));
		entityManager.addEntity(new OrangeTree2(handler, 1670 + 1650, 0));
		entityManager.addEntity(new OrangeTree2(handler, 1670 + 1500, 0));
		entityManager.addEntity(new OrangeTree2(handler, 1670 + 1500, 20));
		entityManager.addEntity(new OrangeTree2(handler, 1670 + 1550, 20));
		entityManager.addEntity(new OrangeTree2(handler, 1670 + 1550, 80));
		entityManager.addEntity(new OrangeTree2(handler, 1670 + 1550, 80));
		entityManager.addEntity(new Bushriver(handler, 1670 + 1420, 30));
		entityManager.addEntity(new Bushriver(handler, 1670 + 1450, 80));
		entityManager.addEntity(new OrangeTree2(handler, 1670 + 1500, 730));
		entityManager.addEntity(new OrangeTree2(handler, 1670 + 1400, 730));
		entityManager.addEntity(new OrangeTree2(handler, 1670 + 1350, 760));
		entityManager.addEntity(new OrangeTree2(handler, 1670 + 1400, 760));
		entityManager.addEntity(new OrangeTree2(handler, 1670 + 1600, 730));
		entityManager.addEntity(new OrangeTree2(handler, 1670 + 1600, 760));
		entityManager.addEntity(new OrangeTree2(handler, 1670 + 1460, 760));
		entityManager.addEntity(new OrangeTree2(handler, 1670 + 1500, 760));
		entityManager.addEntity(new OrangeTree2(handler, 1670 + 1550, 760));
		entityManager.addEntity(new OrangeTree2(handler, 1670 + 1650, 760));
		entityManager.addEntity(new Bushriver(handler, 1670 + 1380, 400));
		entityManager.addEntity(new LongRock(handler, 1670 + 1380, 500));
		entityManager.addEntity(new Fruits(handler, 1670 + 1380, 450));
		entityManager.addEntity(new Fruits(handler, 1670 + 1380, 240));
		entityManager.addEntity(new Fruits(handler, 1670 + 1380, 70));
		entityManager.addEntity(new OrangeTree(handler, 1670 + 1380, 260));
		entityManager.addEntity(new OrangeTree(handler, 1670 + 1410, 260));
		entityManager.addEntity(new OrangeTree(handler, 1670 + 1440, 260));
		entityManager.addEntity(new OrangeTree(handler, 1670 + 1440, 220));
		entityManager.addEntity(new OrangeTree(handler, 1670 + 1440, 180));
		entityManager.addEntity(new OrangeTree(handler, 1670 + 1410, 360));
		entityManager.addEntity(new OrangeTree(handler, 1670 + 1440, 360));
		entityManager.addEntity(new OrangeTree(handler, 1670 + 1440, 390));
		entityManager.addEntity(new OrangeTree(handler, 1670 + 1440, 420));
		entityManager.addEntity(new OrangeTree(handler, 1670 + 1440, 560));
		entityManager.addEntity(new OrangeTree(handler, 1670 + 1470, 560));
		entityManager.addEntity(new OrangeTree(handler, 1670 + 1500, 560));
		entityManager.addEntity(new OrangeTree(handler, 1670 + 1530, 560));
		entityManager.addEntity(new OrangeTree(handler, 1670 + 1530, 590));
		entityManager.addEntity(new OrangeTree(handler, 1670 + 1610, 560));
		entityManager.addEntity(new OrangeTree(handler, 1670 + 1640, 560));
		entityManager.addEntity(new OrangeTree2(handler, 1670 + 1610, 200));
		entityManager.addEntity(new OrangeTree2(handler, 1670 + 1550, 200));
		entityManager.addEntity(new OrangeTree2(handler, 1670 + 1650, 250));
		entityManager.addEntity(new OrangeTree2(handler, 1670 + 1650, 350));
		entityManager.addEntity(new OrangeTree2(handler, 1670 + 1610, 400));
		entityManager.addEntity(new OrangeTree2(handler, 1670 + 1550, 400));
		entityManager.addEntity(new Fruits(handler, 1670 + 1550, 350));
		entityManager.addEntity(new Fruits(handler, 1670 + 1610, 350));
		entityManager.addEntity(new Fruits(handler, 1670 + 1610, 300));
		entityManager.addEntity(new Fruits(handler, 1670 + 1550, 300));
		entityManager.addEntity(new RottenFruits(handler, 1670 + 1650, 80));

		// end of river part

		// town map//house part
		int i, j = 1672, scale = 32 / 3, ctr = 0;
		// bush
		entityManager.addEntity(new Bush(handler, 150 + 1670 + 1670 + 1670, 490));
		entityManager.addEntity(new Bush(handler, 150 + 1670 + 1670 + 1670, 550));
		entityManager.addEntity(new Bush(handler, 150 + 1670 + 1670 + 1670, 610));

		// deadtree
		entityManager.addEntity(new DeadTreeH(handler, 290 + 1670 + 1670 + 1670, 450));
		entityManager.addEntity(new DeadTreeH(handler, 355 + 1670 + 1670 + 1670, 450));
		entityManager.addEntity(new DeadTreeH(handler, 415 + 1670 + 1670 + 1680, 450));
		entityManager.addEntity(new DeadTreeH(handler, 415 + 1670 + 1670 + 1680, 490));
		entityManager.addEntity(new DeadTreeH(handler, 415 + 1670 + 1670 + 1680, 530));
		entityManager.addEntity(new Tree(handler, 415 + 1670 + 1670 + 1670, 560));
		entityManager.addEntity(new Fruits(handler, 315 + 1670 + 1670 + 1680, 540));
		entityManager.addEntity(new Fruits(handler, 315 + 1670 + 1670 + 1680, 540));
		entityManager.addEntity(new Fruits(handler, 360 + 1670 + 1670 + 1680, 540));
		entityManager.addEntity(new Fruits(handler, 315 + 1670 + 1670 + 1680, 620));
		entityManager.addEntity(new Fruits(handler, 360 + 1670 + 1670 + 1680, 620));

		// vine
		entityManager.addEntity(new House4(handler, 210 + 1630 + 1630 + 1630 + 150,180));

		// cotton
		entityManager.addEntity(new Cotton(handler, 220 + 1670 + 1670 + 1670, 40));
		entityManager.addEntity(new Cotton(handler, 280 + 1670 + 1670 + 1670, 40));
		entityManager.addEntity(new Cotton(handler, 330 + 1670 + 1670 + 1670, 40));
		entityManager.addEntity(new Cotton(handler, 380 + 1670 + 1670 + 1670, 40));

		// house
		entityManager.addEntity(new House(handler, 650 + 1570 + 1570 + 1570 + 273, 60));
		entityManager.addEntity(new Tree(handler, 380 + 1670 + 1670 + 1670 + 185, 60));
		entityManager.addEntity(new House2(handler, 400 + 1570 + 1570 + 1580, 60));

		// trees part
		entityManager.addEntity(new Tree(handler, 745 + 1600 + 1600 + 1600 + 200, 370));
		entityManager.addEntity(new Tree(handler, 660 + 1600 + 1600 + 1600 + 200, 370));
		entityManager.addEntity(new Tree(handler, 580 + 1600 + 1600 + 1600 + 200, 370));
		entityManager.addEntity(new Tree(handler, 580 + 1600 + 1600 + 1600 + 200, 500));
		entityManager.addEntity(new Tree(handler, 660 + 1600 + 1600 + 1600 + 200, 500));
		entityManager.addEntity(new Tree(handler, 745 + 1600 + 1600 + 1600 + 200, 500));

		// end of town part

		// forest part
		
		
		int movex = 3398;
		j = movex;
		for (i = -32; i < 594; i += 32, ctr++) { // left forest border
			if (ctr % 2 == 0) {
				entityManager.addEntity(new greenTree(handler, j, i, scale));
				
			} else {
				entityManager.addEntity(new greenTree(handler, j + 30, i, scale));
			}
		}

		entityManager.addEntity(new sign(handler, j + scale, i, -scale));

		for (i += 32; i < 832; i += 32, ctr++) { // trees under sign
			if (ctr % 2 == 0) {
				entityManager.addEntity(new greenTree(handler, j, i, scale));
			} else {
				entityManager.addEntity(new greenTree(handler, j + 30, i, scale));
			}
		}

		for (i = -32, j = movex; j < 5056; j += 32, ctr++) { // upper trees
			if (ctr % 2 == 0) {
				entityManager.addEntity(new greenTree(handler, j, i + 60, scale));
				entityManager.addEntity(new greenTree(handler, j, 800, scale));
				entityManager.addEntity(new greenTree(handler, j, 800 - 60, scale));
			} else {
				entityManager.addEntity(new greenTree(handler, j, i + 30, scale));
				entityManager.addEntity(new greenTree(handler, j, 800 - 30, scale));
			}
		}
		ctr = 0;
		j = 4976;
		for (i = 64; i < 293; i += 32, ctr++) { // right tree
			if (ctr % 2 == 0) {
				entityManager.addEntity(new greenTree(handler, j + 60, i, scale));
			} else {
				entityManager.addEntity(new greenTree(handler, j + 30, i, scale));
			}
		}
		entityManager.addEntity(new sign(handler, j + scale, i, -scale));

		for (i -= 4 * 64; i <= 293; i += 32, ctr++) {
			if (ctr % 2 == 0) {
				entityManager.addEntity(new greenTree(handler, j + 60, i, scale));
			} else {
				entityManager.addEntity(new greenTree(handler, j + 30, i, scale));
			}
		}

		ctr = 0;
		for (i = 400; i <= 722; i += 32, ctr++) {
			if (ctr % 2 == 0) {
				entityManager.addEntity(new greenTree(handler, j + 60, i, scale));
			} else {
				entityManager.addEntity(new greenTree(handler, j + 30, i, scale));
			}
		}

		ctr = 0;

		i = 3543 + 64 * 4;
		j = 96 + 32;
		for (int k = 0; k < 4; k++) {
			entityManager.addEntity(new stump(handler, i, j, -20));
			if (k % 2 == 0) {
				i += 32;
			}
		}

		i = 3543 + 64 * 4;
		j = 96 + 64;
		for (int k = 0; k < 4; k++) {
			entityManager.addEntity(new stump(handler, i, j, -20));
			if (k % 2 == 0) {
				i += 32;
			}
		}

		entityManager.addEntity(new puffyBush(handler, 3540 + 64 * 4, 200, -13));
	
		j = 64;
		i = 1800;
		entityManager.addEntity(new Man2(handler, 3900, 60));
		entityManager.addEntity(new rockPcs(handler, 3540,75,scale));
		
		j += 150;

		entityManager.addEntity(new puffyTree(handler, 3553 + 763, 300, scale * 10));
		entityManager.addEntity(new puffyTree(handler, 4709, 300, scale * 10));
		entityManager.addEntity(new puffyTree(handler, 4001, 300, scale * 10));
		entityManager.addEntity(new purpleFlower(handler, 3553 + 783, 450 - 20, -16));
		entityManager.addEntity(new purpleFlower(handler, 3553 + 773 + 32, 450, -16));
		entityManager.addEntity(new purpleFlower(handler, 3553 + 763 + 92, 450 - 10, -16));
		entityManager.addEntity(new purpleFlower(handler, 3553 + 763 + 92, 450 - 10, -16));

		entityManager.addEntity(new log4(handler, 4823, 122, scale / 2));
		entityManager.addEntity(new grassRock(handler, 4840, 588, scale / 3));
		entityManager.addEntity(new pebbles(handler, 4750, 588, scale / 2));
		entityManager.addEntity(new root(handler, 4880, 122, scale));
		entityManager.addEntity(new mushroom(handler, 4830, 640, 0));
		entityManager.addEntity(new hole(handler, 4750, 640, scale / 2));
		entityManager.addEntity(new hole(handler, 4814, 200, scale / 2));
		entityManager.addEntity(new pebbles(handler, 4880, 203, scale / 2));

		entityManager.addEntity(new mushroom(handler, 3553 + 263, 450 - 40, 0));
		entityManager.addEntity(new mushroom(handler, 3553 + 163 + 32, 350 - 40, 0));
		entityManager.addEntity(new mushroom(handler, 3553 + 863 + 64, 450 - 40, 0));
		entityManager.addEntity(new mushroom(handler, 3553 + 763 + 100, 550 - 40, 0));
		entityManager.addEntity(new mushroom(handler, 3553 + 763 - 100, 150 - 40, 0));
		entityManager.addEntity(new mushroom(handler, 3553 - 30, 250 - 40, -16));

		entityManager.addEntity(new greenTree(handler, 2297 + 50, 744, scale));

		entityManager.addEntity(new trunk(handler, 3620, 358, scale));
		entityManager.addEntity(new thinTree(handler, 3947 + 16, 588 + 96, scale));
		entityManager.addEntity(new thinTree(handler, 3947 + 36, 588 + 66, scale));
		entityManager.addEntity(new thinTree(handler, 3947 + 56, 588 + 106, scale));
		entityManager.addEntity(new thinTree(handler, 3947 + 86, 588 + 80, scale));
		entityManager.addEntity(new pebbles(handler, 3947 - 10, 588 + 90, -16));
		entityManager.addEntity(new pebbles(handler, 3947 - 10, 588 - 80, -16));
		entityManager.addEntity(new log4(handler, 3632, 170, 0));
		entityManager.addEntity(new shrub2(handler, 3625, 130));
		entityManager.addEntity(new shrub2(handler, 3512, 130));
		entityManager.addEntity(new root(handler, 2264, 710, scale));
		entityManager.addEntity(new root(handler, 1802, 383, scale));
		entityManager.addEntity(new pebbles(handler, 2276, 630, scale));
		entityManager.addEntity(new pebbles(handler, 1937, 275, scale));

		entityManager.addEntity(new grassly(handler, 4514, 113, 0));
		entityManager.addEntity(new grassly(handler, 4589, 113, 0));
		entityManager.addEntity(new grassly(handler, 4442, 113, 0));
		entityManager.addEntity(new yellowFlower(handler, 4547, 146, 0));
		entityManager.addEntity(new yellowFlower(handler, 4478, 146, 0));

		entityManager.addEntity(new mushroom(handler, 4167, 107, 0));
		entityManager.addEntity(new mushroom(handler, 4125, 107, 0));

		entityManager.addEntity(new purpleFlower(handler, 4475, 647, 0));
		entityManager.addEntity(new purpleFlower(handler, 4495 + 32, 647, 0));
		entityManager.addEntity(new purpleFlower(handler, 4515 + 64, 647, 0));

		entityManager.addEntity(new grassly(handler, 4247, 644, 0));
		entityManager.addEntity(new grassly(handler, 4199, 644, 0));
		entityManager.addEntity(new grassly(handler, 4145, 644, 0));

		entityManager.addEntity(new grassly(handler, 3629, 626, 0));
		entityManager.addEntity(new grassly(handler, 3677, 626, 0));
		entityManager.addEntity(new grassly(handler, 3719, 626, 0));
		entityManager.addEntity(new grassly(handler, 3767, 626, 0));

		// end of forest
		// --------------------------------- winter map
		// -------------------------------------------------

		// 4145
		// entrance trees
		entityManager.addEntity(new WinTree1(handler, 2630 + 1600 + 1600 + 170 + 20, 300));
		entityManager.addEntity(new WinTree1(handler, 2660 + 1600 + 1600 + 170 + 20, 300));
		entityManager.addEntity(new WinTree1(handler, 2690 + 1600 + 1600 + 170 + 20, 300));
		entityManager.addEntity(new WinTree1(handler, 2710 + 1600 + 1600 + 170 + 20, 300));
		entityManager.addEntity(new WinTree1(handler, 2740 + 1600 + 1600 + 170 + 20, 300));
		entityManager.addEntity(new WinTree1(handler, 2770 + 1600 + 1600 + 170 + 20, 300));
		entityManager.addEntity(new WinTree1(handler, 2800 + 1600 + 1600 + 170 + 20, 300));

		entityManager.addEntity(new Fruits(handler, 2710 + 1600 + 1600 + 170, 370));

		entityManager.addEntity(new WinTree1(handler, 2510 + 1600 + 1600 + 170, 400));
		entityManager.addEntity(new WinTree1(handler, 2540 + 1600 + 1600 + 170, 405));
		entityManager.addEntity(new WinTree1(handler, 2570 + 1600 + 1600 + 170, 400));
		entityManager.addEntity(new WinTree1(handler, 2600 + 1600 + 1600 + 170, 405));
		entityManager.addEntity(new WinTree1(handler, 2630 + 1600 + 1600 + 170, 400));
		entityManager.addEntity(new WinTree1(handler, 2630 + 20 + 1600 + 1600 + 170, 405));
		entityManager.addEntity(new WinTree1(handler, 2660 + 20 + 1600 + 1600 + 170, 400));
		entityManager.addEntity(new WinTree1(handler, 2690 + 20 + 1600 + 1600 + 170, 405));
		entityManager.addEntity(new WinTree1(handler, 2710 + 20 + 1600 + 1600 + 170, 400));
		entityManager.addEntity(new WinTree1(handler, 2740 + 20 + 1600 + 1600 + 170, 405));
		entityManager.addEntity(new WinTree1(handler, 2770 + 20 + 1600 + 1600 + 170, 400));
		entityManager.addEntity(new WinTree1(handler, 2800 + 20 + 1600 + 1600 + 170, 405));

		// upper right house
		entityManager.addEntity(new WinHouse1(handler, 3000 + 1600 + 1600 + 170, 100));
		entityManager.addEntity(new WinTree1(handler, 2950 + 1600 + 1600 + 170, 80));
		entityManager.addEntity(new WinTree1(handler, 3005 + 1600 + 1600 + 170, 80));
		entityManager.addEntity(new WinTree1(handler, 3070 + 1600 + 1600 + 170, 95));
		entityManager.addEntity(new WinTree1(handler, 2900 + 1600 + 1600 + 170, 100));
		entityManager.addEntity(new WinTree1(handler, 3210 + 1600 + 1600 + 170, 60));
		entityManager.addEntity(new Fruits(handler, 3010 + 1600 + 1600 + 170, 50));

		// entrance
		entityManager.addEntity(new SnowMan2(handler, 2490 + 1600 + 1600 + 170, 300));
		entityManager.addEntity(new WinTree4(handler, 2510 + 1600 + 1600 + 170, 220));
		entityManager.addEntity(new Fruits(handler, 2600 + 1600 + 1600 + 170, 100));

		entityManager.addEntity(new WinHouse2(handler, 2590 + 1600 + 1600 + 170, 230));
		entityManager.addEntity(new WinTree1(handler, 2620 + 1600 + 1600 + 170, 220));
		entityManager.addEntity(new WinTree1(handler, 2665 + 1600 + 1600 + 170, 225));

		// CENTER
		entityManager.addEntity(new SnowMan4(handler, 3000 + 1600 + 1600 + 170, 370));
		entityManager.addEntity(new WinTree3(handler, 3210 + 1600 + 1600 + 170, 350));

		// scatter
		entityManager.addEntity(new WinTree3(handler, 3000 + 1600 + 1600 + 170, 500));
		entityManager.addEntity(new WinTree3(handler, 2720 + 1600 + 1600 + 170, 115));
		entityManager.addEntity(new WinTree3(handler, 2650 + 1600 + 1600 + 170, 110));
		entityManager.addEntity(new WinTree3(handler, 2700 + 1600 + 1600 + 170, 100));

		entityManager.addEntity(new WinTree3(handler, 2700 + 1600 + 1600 + 170, 600));
		entityManager.addEntity(new WinTree3(handler, 2750 + 1600 + 1600 + 170, 620));
		entityManager.addEntity(new WinTree3(handler, 2600 + 1600 + 1600 + 170, 610));
		entityManager.addEntity(new WinTree1(handler, 2640 + 1600 + 1600 + 170, 595));
		entityManager.addEntity(new Fruits(handler, 2700 + 1600 + 1600 + 170, 670));

		entityManager.addEntity(new WinTree1(handler, 3200 + 1600 + 1600 + 170, 700));
		entityManager.addEntity(new WinTree1(handler, 3210 + 1600 + 1600 + 170, 640));
		entityManager.addEntity(new WinTree1(handler, 3010 + 1600 + 1600 + 170, 700));
		entityManager.addEntity(new SnowMan1(handler, 2910 + 1600 + 1600 + 170, 600));
		entityManager.addEntity(new Fruits(handler, 3110 + 1600 + 1600 + 170, 750));

		entityManager.addEntity(new WinTree4(handler, 3110 + 1600 + 1600 + 170, 200));
		entityManager.addEntity(new Fruits(handler, 3090 + 1600 + 1600 + 170, 250));
		
		entityManager.addEntity(new rockPcs(handler, 3110+1600+1600+160, 290, scale));

		loadMaps(in);

		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);

		 //entityManager.getPlayer().setX(2550);
		// entityManager.getPlayer().setY(310);
	}

	public void update() {
		itemManager.update();
		entityManager.update();
	}

	public void render(Graphics g) {
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH); // for
																								// the
																								// rendering
																								// be
																								// only
																								// at
																								// the
																								// part
																								// where
																								// the
																								// camera
																								// is
		int xEnd = (int) Math.min(width,
				(handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1); // far
																									// end
																									// tile
																									// from
																									// the
																									// user
																									// than
																									// see
		// plus one for it to render smoothly in the window / frame
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT); // the
																								// tile
																								// the
																								// user
																								// can
																								// see
																								// from
																								// the
																								// screen
		int yEnd = (int) Math.min(height,
				(handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);

		for (int y = yStart; y < yEnd; y++) {
			for (int x = xStart; x < xEnd; x++) {
				getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
						(int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		itemManager.update();
		//
		itemManager.render(g);
		// Entities
		entityManager.render(g);
	}

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height)
			return Tile.grassTile; // the game thinks he/ player is standing on
									// a grass tile even
		// though he is outside of the map

		Tile t = Tile.tiles[tiles[x][y]];
		if (t == null) {
			return Tile.dirtTile;
		}
		return t;
	}

	private void loadMaps(InputStream in) { // responsible for loading the map

		String file = Utils.loadFileAsString(in);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);

		tiles = new int[width][height];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}

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
